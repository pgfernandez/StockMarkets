package com.sbz.fix.gateway.dictionary;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

import com.sbz.parsing.XMLManager;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class TagFIXTranslator {

  private static String DELIMITER;
//  private List fixRecognitionPattern = null;
  private XMLManager xmlManager = null;
  private List newOrderAcceptedTagList = null;
  private List newOrderRejectedTagList = null;
  private List logonAcceptedTagList = null;
  private List logonRejectedTagList = null;
  private List logoutTagList = null;
  private List cancelAcceptedTagList = null;
  private List cancelRejectedTagList = null;
  private List amendAcceptedTagList = null;
  private List amendRejectedTagList = null;
  private List conecctionTest         = null;
  private List fixRecognitionPattern = null;


  public TagFIXTranslator(String delimiter) {
    this.DELIMITER = delimiter;
    xmlManager = new XMLManager();
    this.createTagLists();
  }

   private void createTagLists(){
  // xmlManager.setFile("F:\\Tradia\\cnf\\translations\\NewOrderConfirmation.xml");
   //xmlManager.setElement("NewOrderConfirmation");

   fixRecognitionPattern = xmlManager.readAllByElement("F:\\Tradia\\cnf\\translations\\FixRecognitionPattern.xml","FixRecognitionPattern","tag");
   logonAcceptedTagList = xmlManager.readAllByElement("F:\\Tradia\\cnf\\translations\\BrokerLogon.xml","BrokerLogon","tag");
   newOrderAcceptedTagList = xmlManager.readAllByElement("F:\\Tradia\\cnf\\translations\\NewOrderConfirmation.xml","NewOrderConfirmation","tag");
   cancelAcceptedTagList  = xmlManager.readAllByElement("F:\\Tradia\\cnf\\translations\\CancelOrderConfirmation.xml","CancelOrderConfirmation","tag");
   amendAcceptedTagList  = xmlManager.readAllByElement("F:\\Tradia\\cnf\\translations\\AmendOrderConfirmation.xml","AmendOrderConfirmation","tag");
  /* for (int i = 0; i<l.size(); i++){
   System.out.println("****valores de la lista: " + l.get(i) + "\n");
   }*/


  }

  /**
   * Analiza cualquier Tag FIX pasado como parametro y devuelve su valor.
   * @param tag Tag FIX a buscar.
   * @param msg Mensaje FIX recibido.
   * @return String Valor del tag analizado.
   */
  private String analizaTag(String tag, String msg){

/*  Character del = new Character(DELIMITER);
  String delim = new String(del.toString());*/
//  StringTokenizer st = new StringTokenizer(msg, delim);
  StringTokenizer st = new StringTokenizer(msg, DELIMITER);
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

  public String translate(String fixMsg){//, List tagList){
   StringBuffer resultado = new StringBuffer();
   Object[] tipos = this.getMessageType(fixMsg);
   String tipo = (String)tipos[0];
   if (tipos[1]!=null){
    ListIterator listIter = ((List)tipos[1]).listIterator();//tagList.listIterator();
   //   Iterator iterMap = conversionMap.entrySet().iterator();

   resultado.append(tipo);
   String valor = "";
   while ( listIter.hasNext()){
/*    Map.Entry e = (Map.Entry)iterMap.next();
    valor = this.analizaTag(e.getKey(), fixMsg);*/
    valor = this.analizaTag((String)listIter.next(), fixMsg);
    resultado.append(valor);
    }

   }else{
    resultado.append(tipo);
   }

   return resultado.toString();

  }//fin metodo

  private Object[] getMessageType(String fixMsg){
//   Iterator iterMap = conversionMap.entrySet().iterator();
   String resultado = null;
   String type = null;
   String status = null;
   List tagList = null;
   type = this.analizaTag((String)fixRecognitionPattern.get(0), fixMsg);
    if (type.equals("A")){
     resultado = "OBConexion con ";
     tagList = logonAcceptedTagList;
      System.out.println("LOGON ACEPTADO");
    }else if(type.equals("0")){
      resultado = "RECIBIDO HEARTBEAT";
      tagList = null;
    }else if(type.equals("8")){//execution report
      System.out.println("TIPO DE MENSAJE ENCONTRADO EXECUTION REPORT");
      status = this.analizaTag((String)fixRecognitionPattern.get(1), fixMsg);
     if (status.equals("0")){//new confirmation
       resultado = "CA";
       tagList = newOrderAcceptedTagList;
       System.out.println("ES UNA CONFIRMACION DE ORDEN");
     }else if(status.equals("1")){//order partially filled
      resultado = "EP";
     }else if(status.equals("2")){//order filled
      resultado = "ET";
     }else if(status.equals("3")){

     }else if(status.equals("4")){

     }else if(status.equals("5")){//order replaced
      resultado = "CM";
      tagList = amendAcceptedTagList;
      System.out.println("ES UNA CONFIRMACION DE ORDEN");
     }else if(status.equals("6")){//pending
      resultado = "OP";
    }

   }else if(type.equals("9")){//order rejected
     resultado = "RE";

   }else{//unknown type
     resultado = "XX";

   }
    Object[] elementos = new Object[2];//null;
    elementos[0] = resultado;
    elementos[1] = tagList;
    return elementos;
  }

 /* public static void main(String args[]){
   char del = '^';
   String fix = new String();
   fix = "11=999999*" + del + "22=8888*" + del + "33=77777*" + del + "44=66666*";
   String s[] = {"11","44","33","22"};
   List l = Arrays.asList(s);
   TagFIXTranslator t = new TagFIXTranslator((new Character(del)).toString());
   String r = t.translate(fix,l);

   System.out.println("****** resultado de la traduccion: " + r);



  }*/

}
