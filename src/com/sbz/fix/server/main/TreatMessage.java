package com.sbz.fix.server.main;

/**
 * Title:        FIXServer
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:      Somebiz Networks
 * @author Pedro Garcia
 * @version 1.0
 */

import java.util.*;
import java.io.*;
import com.sbz.io.*;
import com.sbz.fix.server.messages.*;

public class TreatMessage{

/**
 * Contiene los parametros de un mensaje FIX.
 */
private static FIXMessage fixMessage = null;

/**
 * Caracter que delimita los campos de un mensaje FIX.
 */
private static char DELIMITER;

/**
 * Contiene la cadena final de un mensaje FIX.
 */
private static String FIN = null;


/**
 * Contiene el tag que identifica el numero de orden.Devuelto por FIXMessage.
 */
private static String TAG_NUMERO_ORDEN = null;

/**
 * Contiene el tag que identifica el tipo de orden.Devuelto por FIXMessage.
 */
private static String TAG_TIPO_ORDEN = null;

/**
 * Contiene el tag que identifica el numero de mensaje inicial de peticion de reenvio
 * por parte del cliente.(Resend Request).Devuelto por FIXMessage.
 */
private static String TAG_NUMERO_INICIO = null;

/**
 * Contiene el tag que identifica el numero de mensaje final de peticion de reenvio
 * por parte del cliente.(Resend Request).Devuelto por FIXMessage.
 */
private static String TAG_NUMERO_REENVIO = null;

/**
 * Contiene el tag que identifica el numero de secuencia.
 */
private static String NUM_SECUENCIA = null;

/**
 * Contiene el tag que identifica el numero de cancelacion.
 */
private static String TAG_NUMERO_CANCELACION = null;

/**
 * Contiene el valor del numero de secuencia.
 */
private static int numeroSecuencia;
/**
 * Lista en la que se almacenan las ejecuciones de ordenes recibidas.
 */
private static ArrayList ejecuciones;
/**
 * Lista en la que se almacenan el historico de las ordenes ejecutadas
 * durante el dia.
 */
private static ArrayList doneForDay;
/**
 * Path donde se almacena el fichero de secuencias.
 */
private static String seqPath = null;
/**
 * Realiza las operaciones de escritura sobre el fichero de secuencias.
 */
private static toFile seqfile = null;

/**
 * Separador de directorios del sistema operativo. "/" UNIX, "\" Windows.
 */
private String separador = null;

/**
 * Necesario para el envio de los mensajes FIX.
 */
private FIXServer fixServer = null;
/**
 * Objeto utilizado para bloquear el acceso a un metodo.
 */
private Object lok=new Object();

/**
 * Constructor de la clase TreatMessage.
 * @param secuencia Numero de secuencia por el que se empieza la conversacion FIX.
 * @param path Path donde se encuentra el fichero de secuencias.
 */
public TreatMessage(int secuencia,String path, FIXServer f){
    fixServer = f;
    fixMessage = new FIXMessage();
    DELIMITER = fixMessage.getDelimiter();
    FIN = fixMessage.getFin();
    NUM_SECUENCIA = fixMessage.getTagNumeroSecuencia();
    TAG_NUMERO_CANCELACION = fixMessage.getTagNumeroCancelacion();
    TAG_NUMERO_INICIO = fixMessage.getTagNumeroInicio();
    TAG_NUMERO_REENVIO = fixMessage.getTagNumeroFinal();
    TAG_TIPO_ORDEN = fixMessage.getTagTipoOrden();
    TAG_NUMERO_ORDEN = fixMessage.getTagNumOrden();
    ejecuciones = new ArrayList();
    doneForDay = new ArrayList();
    seqPath = path;
    this.numeroSecuencia = secuencia;
  }

/**
 * Trata el mensaje que llega del cliente para generar la respuesta. Analizando
 * primero el tipo de mensaje recibido.
 * @param msg Mensaje FIX.
 * @return String Respuesta FIX construida.
 */
  public String treatMessage(String msg){
    String tipoOrden = null;
    String respuesta = null;
    tipoOrden = this.analizaTag(TAG_TIPO_ORDEN, msg);
    System.out.println("tipo orden en tratmessage: " + tipoOrden);
    respuesta = this.construyeRespuesta(tipoOrden, msg);
    System.out.print("respuesta construida: "+ respuesta);

    return respuesta;
  }

  /**
   * Analiza el tipo de mensaje recibido y construye la respuesta seg�n este.
   * @param tipo Tipo de mensaje recibido indicado por el tag 35.
   * @param msg Mensaje recibido.
   * @return String Respuesta FIX construida.
   */
  private String construyeRespuesta(String tipo, String msg){

  String respuesta = null;
  String numeroOrden = null;
  Integer numeroReenvio;
  int seqAux = 0;

   //LOGON
   if (tipo.equals("A")) {
    Logon logon = new Logon();
    seqAux = 0;
    respuesta = logon.getLogon();

    //NUEVA ORDEN
   }else if(tipo.equals("D")){

     numeroOrden = this.analizaTag(TAG_NUMERO_ORDEN, msg);
     NewOrderConfirmation newOrder = new NewOrderConfirmation(numeroOrden);
     seqAux = 0;
     respuesta = newOrder.getNewOrderConfirmation();
     System.out.println("cadena a devolver,que tiene?: " + respuesta);
     //guardo una ejecucion por cada confirmacion de nueva orden que realice.
     this.guardaEjecucion(numeroOrden);

    //CANCELACION DE ORDEN
   }else if (tipo.equals("F")){

    numeroOrden = this.analizaTag(TAG_NUMERO_CANCELACION, msg);
    CancelOrder cancelOrder = new CancelOrder(numeroOrden);
    seqAux = 0;
    respuesta = cancelOrder.getCancelOrder();

    //MODIFICACION DE ORDEN
   }else if (tipo.equals("G")){

    numeroOrden = this.analizaTag(TAG_NUMERO_ORDEN, msg);
    ChangeOrder changeOrder = new ChangeOrder(numeroOrden);
    seqAux = 0;
    respuesta = changeOrder.getChangeOrder();

    //RESEND REQUEST
    }else if (tipo.equals("2")){

      String auxInit = null;
      String auxFin = null;
      int inicio;
      int fin;
      boolean primero = true;
      auxInit = this.analizaTag(TAG_NUMERO_INICIO, msg);
      auxFin = this.analizaTag(TAG_NUMERO_REENVIO, msg);
      inicio = new Integer(auxInit).intValue();
      fin = new Integer(auxFin).intValue();

        //reenvia en un mensaje la cantidad de mensajes que nos
        //hayan pedido de reenvio.

      for (int i = inicio; i == fin; i ++){

        HeartBeat vacio = new HeartBeat();
        seqAux = i;
        if (primero){
         respuesta = vacio.dameHeartBeat();
         primero = false;
        }else{
         respuesta = respuesta + vacio.dameHeartBeat();
        }
        //fixServer.threadServer.enviaRespuesta(respuesta,seqAux);
        fixServer.getServer().enviaRespuesta(respuesta,seqAux);

      }
     //LOGOUT
   }else if (tipo.equals("5")){

    Logout logout = new Logout();
    seqAux = 0;
    respuesta = logout.getLogout();

   //REJECT CON PETICION DE LOGOUT
   }else if(tipo.equals("3")){

    Logout logout = new Logout();
    seqAux = 0;
    respuesta = logout.getLogout();

  }else if(tipo.equals("0")){
      HeartBeat vacio = new HeartBeat();
      seqAux = 0;
      respuesta = vacio.dameHeartBeat();
  }

  if (respuesta == null){
      HeartBeat vacio = new HeartBeat();
      seqAux = 0;
      respuesta = vacio.dameHeartBeat();
  }

  //enviar por socket la respuesta
  if (seqAux == 0)
    // fixServer.threadServer.enviaRespuesta(respuesta,seqAux);Probando con JB9
              fixServer.getServer().enviaRespuesta(respuesta,seqAux);

  if (tipo.equals("A")) {
    fixServer.timerHeartBeat.start();
    fixServer.timerExecution.start();
  }

  if (tipo.equals("D")) //guardo una ejecucion por cada confirmacion de nueva orden que realice.
     this.guardaEjecucion(numeroOrden);

  return respuesta;
  }


  /**
   * Analiza cualquier Tag FIX pasado como parametro y devuelve su valor.
   * @param tag Tag FIX a buscar.
   * @param msg Mensaje FIX recibido.
   * @return String Valor del tag analizado.
   */
  private String analizaTag(String tag, String msg){

  Character del = new Character(DELIMITER);
  String delim = new String(del.toString());
  StringTokenizer st = new StringTokenizer(msg, delim);
  String valor = "";

  while(st.hasMoreTokens()){

  StringTokenizer st2 = new StringTokenizer(st.nextToken(), "=");

  if (st2.nextToken().equals(tag)){
       valor = st2.nextToken();
       return valor;
   }
   st2 = null;
   }
  return valor;
  }

  /**
   * Genera y guarda las ejecuciones de las ordenes recibidas y guarda y genera
   * las ejecuciones historicas producidas durante la sesion FIX.
   * @param numOrden Numero de la orden para la que se genera la ejecucion.
   */
  private void guardaEjecucion(String numOrden){

   String ejecucion = null;
   String dfd = null;

   Execution ejec = new Execution(numOrden);
   DoneForDay doneFDay = new DoneForDay(numOrden);

   ejecucion = ejec.getExecution();
   dfd = doneFDay.getDoneForDay();

   ejecuciones.add(ejecucion);
   doneForDay.add(dfd);

 }

  /**
   * Devuelve las ejecuciones almacenadas hasta ese momento para su envio al
   * cliente FIX.
   * @return ArrayList Lista con las ejecuciones alamacenadas.
   */
  public ArrayList getEjecuciones(){

   ArrayList ejecucionesAux;

        ejecucionesAux = new ArrayList(ejecuciones);
        ejecuciones.clear();

    return ejecucionesAux;
  }

  /**
   * Crea un HeartBeat.
   * @return String HeartBeat generado.
   */
  public String getHeartBeat(){

     String hBeat = null;

     HeartBeat heartbeat = new HeartBeat();

     hBeat = heartbeat.dameHeartBeat();

    return hBeat;

  }

  /**
   * Crea un TestRequest.
   * @return String TestRequest generado.
   */
  public String getTestRequest(){

   String tRequest = null;

   TestRequest testrequest = new TestRequest();

   tRequest = testrequest.dameTestRequest();

   return tRequest;
  }

  /**
   * Devuelve las ejecuciones historicas del dia para su envio al
   * cliente FIX.
   * @return ArrayList Lista con las ejecuciones "done for day".
   */
  public ArrayList getDoneForDay(){

   ArrayList doneForDayAux = null;

        doneForDayAux = new ArrayList(doneForDay);

        doneForDay.clear();

    return doneForDayAux;
  }



 /**
  * Actualiza y mantiene el numero de secuencia para el envio de los mensajes FIX.
  * @return int Numero de secuencia actualizado.
  */
 public int actualizaSecuencia(){

    numeroSecuencia = numeroSecuencia + 1;

   return numeroSecuencia;
  }

 /**
  * Guarda en caso de finalizacion de la conversacion FIX (Logout), el numero
  * de secuencia en el fichero de secuencias, para cuando se reinicie la
  * conversacion mantener la secuencia actualizada.
  * @param path Path donde se almacena el fichero de secuencias.
  */
 public void guardaSecuencia(String path){

    //******************************
    //  guarda numero de secuencia
    //******************************

   separador = System.getProperty("file.separator");

   try{
    seqfile = new toFile(seqPath+separador+"FIXServer.seq", false);
   }catch(IOException e){}

   seqfile.print("#NumeroSecuencia");
   seqfile.print(this.numeroSecuencia);



  }

}
