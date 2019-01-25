package com.sbz.fix.gateway.handlers;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */


import com.sbz.parsing.xsl.XMLMessageTranslator;


public class TXMainHandler {

  private NewOrderHandler newHandler = null;
  private LogonRequestHandler logonHandler = null;
  private CancelOrderRequestHandler cancelRequestHandler = null;
  private AmendOrderRequestHandler amendRequestHandler = null;
  private XMLMessageTranslator messageTranslator = null;

  public TXMainHandler() {

    messageTranslator = new XMLMessageTranslator();
    initializeHandlers();

  }

  public String messageToHandle(String msg){

  //  System.out.println("msg en handler: " + msg.toString());
//    rvMsg = (TibrvMsg)msg.getData();
    System.out.println("msg recuperado: " + msg);
    String tipo = getMessageType(msg);
    String res = getTranslatedMsg(tipo, msg);

   return res;


  }

  private String getMessageType(String message){

    String key = message.substring(0,2);
    System.out.println("key recogido : " + key);

    return key;
  }

  private void initializeHandlers(){

   newHandler = new NewOrderHandler();
   logonHandler = new LogonRequestHandler();
   cancelRequestHandler = new CancelOrderRequestHandler();
   amendRequestHandler = new AmendOrderRequestHandler();

  }

  private String getTranslatedMsg(String tipo,String msg){

   org.jdom.Document res = null;
   String resultado = null;
   char DELIMITER = '^';

   String cabecera = null;
   String fin = "10=190" + DELIMITER;
   if (tipo.equals(MessageTypes.LOGON)){
    cabecera = "8=FIX.4.0"+DELIMITER+"9=60"+DELIMITER+"35=A"+DELIMITER;
    res = logonHandler.getFormattedMsg(msg);
    resultado = cabecera + (String)messageTranslator.translate(res,MessageTypes.LOGON) + fin;
     System.out.println("cadena recogida despues transformacion de Logon: " + resultado);

   }else if (tipo.equals(MessageTypes.NEW_ORDER)){
     cabecera = "8=FIX.4.0"+DELIMITER+"9=60"+DELIMITER+"35=D"+DELIMITER;
     res = newHandler.getFormattedMsg(msg);
     resultado = cabecera + (String)messageTranslator.translate(res,MessageTypes.NEW_ORDER) + fin;
     System.out.println("cadena recogida despues transformacion: " + resultado);

   }else if (tipo.equals(MessageTypes.CANCEL_ORDER)){
     cabecera = "8=FIX.4.0"+DELIMITER+"9=60"+DELIMITER+"35=F"+DELIMITER;
     res = cancelRequestHandler.getFormattedMsg(msg);
     resultado = cabecera + (String)messageTranslator.translate(res,MessageTypes.CANCEL_ORDER) + fin;
     System.out.println("cadena recogida despues transformacion: " + resultado);

   }else if (tipo.equals(MessageTypes.AMEND_ORDER)){
    cabecera = "8=FIX.4.0"+DELIMITER+"9=60"+DELIMITER+"35=G"+DELIMITER;
    res = amendRequestHandler.getFormattedMsg(msg);
    resultado = cabecera + (String)messageTranslator.translate(res,MessageTypes.AMEND_ORDER) + fin;
    //meter el valor de amendOrderRequest en valores o recogerlo de los types.
    System.out.println("cadena recogida despues transformacion: " + resultado);

   }


   return resultado;


  }


}