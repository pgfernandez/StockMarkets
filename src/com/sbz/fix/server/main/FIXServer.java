package com.sbz.fix.server.main;

import java.net.*;
import java.io.*;
import java.util.*;
import com.sbz.parsing.XMLManager;
import com.sbz.fix.server.timers.*;
import com.sbz.io.*;
import com.sbz.fix.server.messages.FIXMessage;
import com.sbz.fix.server.listeners.*;
import com.sbz.fix.server.admin.pattern.mediator.FIXServerAdminMediator;


/**
 * Title:        FIXServer
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:      Reuters DSS
 * @author
 * @version 1.0
 */

public class FIXServer {

 /**
  * Bloquea el acceso al socket para el envio de los mensajes FIX.
  */
 static Object lock1 = new Object();

 /**
    * Variable que va a contener el Timer que lanzara la peticion de ejecuciones
    * de las ordenes confirmadas.
    */
 public static FIXTimer timerExecution = null;
  /**
    * Variable que va a contener el Timer que lanzara el envio de hearbeats para
    * mantener viva la conexion con la pasarela.
    */
 public static FIXTimer timerHeartBeat = null;

  /**
    * Variable que va a contener el Timer que lanzara el test de conexion con
    * la pasarela.
    */
 private static FIXTimer timerTestRequest = null;
// private static FIXTimer timerDoneForDay = null;

  /**
    * Variable que va a contener el intervalo en segundos para el envio
    * de heartbeats.
    */
 private static int heartBeatInterval;

 /**
    * Variable que va a contener el intervalo en segundos para el envio
    * de la peticion de test de conexion.
    */
 private static int testRequestInterval;

 /**
    * Variable que va a contener el intervalo en segundos para el envio
    * de las ejecuciones de ordenes recibidas.
    */
 private static int executionInterval;

  /**
    * Variable que indica el tipo de mensaje a escribir en el fichero de log.
    * INFO es de informacion.
    */
  private static final String INFO = " - I: ";

    /**
    * Variable que indica el tipo de mensaje a escribir en el fichero de log.
    * WARNING es de aviso.
    */
  private static final String WARNING = " - W: ";

    /**
    * Variable que indica el tipo de mensaje a escribir en el fichero de log.
    * ERROR es de error.
    */
  private static final String ERROR = " - E: ";

    /**
    * Contiene el tamano del buffer de lectura y escritura.
    */
  private static final int SSIZE = 1024;

    /**
    * Contiene el caracter ASCII para la separacion de tags del
    * protocolo FIX.
    */
  private static final char DELIMITER = '^';

    /**
    * Servidor que realiza las funciones de broker.
    */
  private static Servidor simpleSocket = null;

    /**
    * Variable que contiene el puerto de conexion con la pasarela.
    */
  private static int simpleSocketPort;

  /**
  * Stream de lectura para el socket.
  */
  private static BufferedReader insimplesocket;

  /**
  * Stream de escritura para el socket normal.
  */
  private static PrintStream outsimplesocket;

  /**
  * Stream de lectura para el thread socket.
  */
  private static BufferedReader inclient;

  /**
  * Stream de escritura para el thread socket.
  */
  private static PrintStream outclient;

  /**
  * Socket mediante el cual se realizaran las comunicaciones con la pasarela.
  */
  private static Socket s;

  /**
  * Thread del socket servidor normal.
  */
  private static threadServer socketServer = null;

  /**
  * Fichero de log donde se almacenan los registros de las actuaciones del
  * servidor.
  */
  private static toFile logfile = null;

  /**
  * Fichero de debug donde se almacenan los registros de las actuaciones del
  * servidor, para mayor utilidad para el mantenimiento del propio servidor.
  */
  private static toFile dbgfile = null;

  /**
  * Fichero de configuracion donde se almacenan los parametros necesarios para
  * la inicializacion del servidor.
  */
  private static String cnfpath = null;

  /**
  * Indica la conexion de la pasarela al servidor.
  */
  private static boolean AdapterConnected = false;

  /**
  * Path del sistema donde se encuentra el fichero de log y debug.
  */
  private static String logdbgpath = null;

  /**
  * Path del sistema donde se encuentra el fichero de secuencias.
  */
  private static String seqpath = null;

  /**
  * Realiza el tratamiento de los mensajes recibidos de la pasarela.
  */
  private static TreatMessage tm = null;

  /**
   * Controla si se ha enviado el Logon.
   */
  private static boolean enviadoLogon = true;

  /**
   * Separador de directorios del sistema operativo. "/" UNIX, "\" Windows.
   */
  private static String separador = null;

  /**
   * FIXMessage para la creacion de un mensaje FIX.
   */
  private static FIXMessage fixMessage = null;

  /**
   * Mediador para las comunicaciones a la herramienta de administración
   */
  private static FIXServerAdminMediator mediator = null;

  private boolean estado = false;

  private static final String FIN = "10=190" + DELIMITER;

  /**
    * Constructor. Crea el Servidor FIX para la simulacion de un broker bajo
    * protocolo FIX (Finnancial Information Exchange)
    */
  public FIXServer(FIXServerAdminMediator mediator) {

/*    this.logdbgpath = System.getProperty("PIKLOG");
    this.cnfpath = System.getProperty("PIKCNF");
    this.seqpath = System.getProperty("PIKSEQ");*/
    this.logdbgpath = "E:\\somebiz\\Proyecto Carrera\\testServer";
    this.cnfpath = "E:\\somebiz\\Proyecto Carrera\\testServer";
    this.seqpath = "E:\\somebiz\\Proyecto Carrera\\testServer";

    separador = System.getProperty("file.separator");
    fixMessage = new FIXMessage();

   // Crea/abre el fichero de log
   try{
   logfile = new toFile(this.logdbgpath + separador + "FIXServer.log", true);
   }catch(IOException e){}

   // Crea/abre el fichero de dbg
   try{
   dbgfile = new toFile(this.logdbgpath + separador + "FIXServer.dbg", true);
   }catch(IOException e){}

   //leer el ficehro de configuracion
   this.getConfig();

   this.mediator = mediator;
   //tm = new TreatMessage(this.getSecuencia(),seqpath);


  }

 /* public boolean getServerStatus(){


  }*/

  public boolean arranca(){
    try{
      this.startThreads();
    }catch(Exception e){
      return false;
    }
    return true;

  }
  /**
    * Lanza los threads y espera a que acaben.
    */
  public void startThreads() throws Exception
  {
    // Lanza el thread del servidor que escuchara los clientes FIX
    socketServer = new threadServer();
    try
    {
      socketServer.start();
    }
    catch(IllegalThreadStateException e)
    {
      dbgfile.print("Error lanzando el thread servidor. Ya estaba lanzado");
      try { ends(); } catch (IOException fatal) {}
    }

    tm = new TreatMessage(getSecuencia(),seqpath,this);

    timerExecution = new FIXTimer(executionInterval, new FIXListenerExecution(tm, this));
    timerHeartBeat = new FIXTimer(heartBeatInterval, new FIXListenerHeartBeat(tm, this));
   // timerTestRequest = new FIXTimer(testRequestInterval, new FIXListenerTestRequest(tm, simpleSocket));
   // timerDoneForDay = new FIXTimer(100000, new FIXListenerDoneForDay(tm, simpleSocket));


  }// startThreads

  public threadServer getServer(){

  return this.socketServer;
}



  /**
    * Destruye los sockets.
    */
  private static void destroySockets() throws IOException
  {
    simpleSocket.destruyeSocket();
    try { s.close(); }
    catch (IOException e)
    {
      dbgfile.print("Error cerrando el Socket");
      dbgfile.print(e.getMessage());
      try { ends(); } catch (IOException fatal) {}
    }
  }


  /**
    * Cierra los ficheros de log y debug abiertos en la finalización del
    * servidor.
    */
  private static void ends() throws IOException
  {
    dbgfile.print("Adaptador terminando");
    logfile.print(INFO+"Adaptador terminando");

    //guardarSecuencia();

    logfile.closeFile();
    dbgfile.closeFile();
    //seqfile.closeFile();


    System.exit(1);
  }

          /**
           * Clase que gestiona el hilo donde va a correr el servidor.
           */
          public static class threadServer extends Thread
	  {
	    public threadServer()
	    {
	      super();
	    }

	    public void stopServer()
	    {
		   socketServer = null;
	    }

  /**
   * Escribe en el socket el mensaje de respuesta.
   * @param mensaje Mensaje FIX de respuesta a lo recibido del cliente.
   */
  public static void enviaRespuesta(String mensaje,int seq){

   synchronized (lock1)
   {
   if (seq==0)
     seq=tm.actualizaSecuencia();

     mensaje = mensaje + fixMessage.getTagNumeroSecuencia() + seq +
               fixMessage.getDelimiter() + fixMessage.getFin();
    simpleSocket.escribeSocket(mensaje);
    dbgfile.print("Voy a mandar a Adapter: " + mensaje);
   }

  }

   /**
   * Crea e inicializa el socket del servidor.
   * @param dbgfile Fichero de debug para el registro de las acciones del
   * servidor mas detallado.
   * @param logfile Fichero de log para monitorizacion simple del servidor.
   */
   public synchronized void startNormalSocket(toFile dbgfile, toFile logfile)
    {
      simpleSocket = new Servidor(simpleSocketPort,insimplesocket,outsimplesocket,dbgfile,logfile);
      simpleSocket.creaSocket();
      simpleSocket.iniSocket();
      AdapterConnected = true;

    }

 /**
  * Comprueba si es fin de mensaje FIX.
  */
 private static boolean isMsgEnd(String msg, int p)
{
   boolean ret=false;

    int pos = p + 7;

   if (pos < msg.length())
   {

      char aux='a';
      try
      {
         aux = msg.charAt(pos);
      }catch (Exception e)
       {
            System.out.println("Excepcion: " + e.toString());
       }
      ret = ((pos < msg.length()) && (aux == DELIMITER));
   }
   else
      ret=false;

   return ret;
}

   /**
    * Metodo que realiza la lectura del socket a la espera de mensajes del cliente.
    */

   public synchronized void readNormalSocket()
   {
     //cadena leida del socket
     String inputS=null;

     //mensaje de vuelta a la pasarela
     String respuesta = null;

     // variable utilizada para saber si el threadServer se ha parado o no
     Thread thisThread = socketServer.currentThread();

     //mensaje leido del socket
     String fixImage=null;

     //mensaje que queda por completar para su posterior tratamiento
     String fullmsg = new String("");

     //lista de mensajes a enviar
     ArrayList listImages;

     //mensaje de vuelta a la pasarela
     respuesta = new String();
     String auxRespuesta = new String();

     listImages = new ArrayList();

      // Bucle de lectura constante del socket.
      while (((inputS = simpleSocket.leeSocket()) != null) && (socketServer == thisThread))   ///////////////////////////TIMEOUT
      {

         fixImage = new String(inputS);

         //notificación a la herramienta de administración
       //  mediator.pushMsgReceived(fixImage);

         logfile.print(INFO+"Mensaje recibido desde el Adapter:");
         logfile.print(INFO+fixImage);
         dbgfile.print("Mensaje recibido desde el Adapter:");
         dbgfile.print(fixImage);

          //**********************************************************
          //* analizar el String que se recibe
          //**********************************************************

         fullmsg = fullmsg.concat(fixImage);

         int p = -1, posFinal = 0, len = 0;
         String msg = null;
         String msgEnd = fixMessage.getDelimiter() + fixMessage.getTagFin();

         do
         {
             p = fullmsg.indexOf(msgEnd);
             while ( (-1 != p) && (!isMsgEnd(fullmsg, p) ))
                p = fullmsg.indexOf (msgEnd, p+msgEnd.length());
             if ( -1 != p)
             {
                posFinal = p + 7;
                msg =  fullmsg.substring(0, posFinal);
                listImages.add(msg);
                fullmsg = fullmsg.substring(posFinal+1);
             }
         } while ( (-1 != p) && (fullmsg.length() > 0));

         System.out.println("fin de mensaje,encontrado delimitador de fin,numero de msg es ");



            if(!listImages.isEmpty())
            {
               System.out.println("la lista de msg no esta vacia");
               //enviamos por el socket la respuesta de todos los mensajes completos recibidos
               for(int contador=0; contador < listImages.size(); contador++)
               {
                  respuesta = "";
                  auxRespuesta = "";

                  try {
                    auxRespuesta = listImages.get(contador).toString();
                  } catch(IndexOutOfBoundsException e) {
                    System.out.println("El indice es: " + contador);
                  }

                  if (!auxRespuesta.equals(""))
                  {
                     System.out.println("he sacado de la lista el msg: " + auxRespuesta);
                     respuesta = tm.treatMessage(auxRespuesta);
                     simpleSocket.escribeSocket(respuesta);
         //            mediator.pushMsgSent(respuesta);
                     logfile.print(INFO+"El mensaje recibido del Adapter fue enviado por el socket");
                     dbgfile.print("El mensaje recibido del Adapter fue enviado por el socket");
                  }
               }//for
               listImages.clear();
            }//if comprobar lista de  mensajes

       } //while lectura socket
    }

    /**
     * Lanza el thread del servidor.
     */
    public synchronized void run()
    {
      // Crea e inicia un socket normal para comunicar con el AdapterGS
      startNormalSocket(dbgfile, logfile);
      readNormalSocket();
      logfile.print(WARNING+"No se obtienen mensajes del Adapter");
    }

  }// threadServer

  /**
   * Lee el fichero de configuracion para establecer el valor de los parametros
   * necesarios para el funcionamiento del servidor.
   */
  private void getConfig()
	  {
	    String linea = null;

	    ReadFile conf = new ReadFile(this.cnfpath+"/FIXServer.cnf");

	    linea = conf.getline();
	    if (linea.equals("#ConnectionPort") == true)
	    {
	      Integer aux1 = new Integer(conf.getline());
              this.simpleSocketPort = aux1.intValue();
	      linea = conf.getline();
	      if (linea.equals("#HeartBeatInterval") == true)
	      {
                Integer aux2 = new Integer(conf.getline());
                this.heartBeatInterval = aux2.intValue() * 1000; //milisegundos
	        linea = conf.getline();
	        if (linea.equals("#TestRequestInterval") == true)
	        {
                  Integer aux3 = new Integer(conf.getline());
                  this.testRequestInterval = aux3.intValue() * 1000;
		  linea = conf.getline();
		  if (linea.equals("#ExecutionInterval") == true)
		  {
                    Integer aux4 = new Integer(conf.getline());
		    this.executionInterval = aux4.intValue() * 1000;
		    linea = conf.getline();
        	  }
                   else
		   {
		      dbgfile.print("No se pudo leer el intervalo de execution en el fichero de configuracion");
		      logfile.print(ERROR+"No se pudo leer el intervalo de execution en el fichero de configuracion");
		      try { ends(); } catch (IOException e1) {}
		   }
	          }//#ExecutionInterval
	          else
	          {
	            dbgfile.print("No se pudo leer el intervalo de testrequest en el fichero de configuracion");
		    logfile.print(ERROR+"No se pudo leer el intervalo de testrequest en el fichero de configuracion");
		    try { ends(); } catch (IOException e1) {}
	          }
	        }//#TestRequestInterval
	        else
	        {
		  dbgfile.print("No se pudo leer el intervalo de heartbeat en el fichero de configuracion");
		  logfile.print(ERROR+"No se pudo leer el intervalo de heartbeat en el fichero de configuracion");
		  try { ends(); } catch (IOException e1) {}
	        }
	      }//#HeartBeatInterval

            else
	    {
	      dbgfile.print("No se pudo leer el puerto de conexion en el fichero de configuracion");
	      logfile.print(ERROR+"No se pudo leer el puerto de conexion en el fichero de configuracion");
	      try { ends(); } catch (IOException e1) {}
            }//#ConnectionPort
	  }// getConfig

  /**
   * Recoge el numero de secuencia almacenado en el fichero de secuencias
   * para comenzar la conversacion FIX con el numero adecuado.
   */
  private static int getSecuencia(){

   int secuencia = 0;

    String linea = null;

    ReadFile seq = new ReadFile(seqpath + separador +"/FIXServer.seq");

    linea = seq.getline();

    if (linea.equals("#NumeroSecuencia") == true)
    {
      Integer aux1 = new Integer(seq.getline());
      secuencia = aux1.intValue();
    }else{
      dbgfile.print("No se pudo leer el numero de secuencia en el fichero de secuencias");
      logfile.print(ERROR+"No se pudo leer el numero de secuencia en el fichero de secuencias");
      try { ends(); } catch (IOException e1) {}
     }

   return secuencia;
  }





 /*public static void main(String args[]) throws IOException {

    FIXServer fs = null;
    try{
     fs = new FIXServer();
    }catch(Exception e){
    dbgfile.print(e.getMessage());
    ends();
    }

    System.out.println("*****************************************");
    System.out.println("*                                       *");
    System.out.println("*   FIXSERVER. SOMEBIZ NETWORKS 2003    *");
    System.out.println("*                                       *");
    System.out.println("*****************************************");
    System.out.println("");
    System.out.println("Lanzando........");

    //arranco los hilos de ejecucion del servidor
   try{
    fs.startThreads();
   }catch(Exception e){

     e.printStackTrace();
   }
    System.out.println("Arrancado");

  }*/
}
