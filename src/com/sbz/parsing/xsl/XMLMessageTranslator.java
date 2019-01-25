package com.sbz.parsing.xsl;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

import java.io.*;
import javax.xml.transform.*;
import com.sbz.data.types.MessageMap;
import com.sbz.fix.gateway.handlers.MessageTypes;

public class XMLMessageTranslator {

  private MessageMap styleSheets = null;
  private TransformerFactory transFactory = null;
  private Transformer transFIXPlain = null;
  private Transformer transLogon = null;
  private Transformer transNewOrder = null;
  private Transformer transCancelOrderRequest = null;
  private Transformer transAmendOrderRequest = null;
  private Transformer transFIXML    = null;
  private OutputStream resultado;


  public XMLMessageTranslator() {

    //styleSheets = new MessageMap();
    transFactory = TransformerFactory.newInstance();

    try{
/*      transFIXPlain = transFactory.newTransformer(new javax.xml.transform.stream.StreamSource(
          "FIXPlain.xsl"));*/

     transLogon = transFactory.newTransformer(new javax.xml.transform.stream.StreamSource(
          "LogonRequest.xsl"));
     transNewOrder = transFactory.newTransformer(new javax.xml.transform.stream.StreamSource(
          "NewOrder.xsl"));
     transCancelOrderRequest = transFactory.newTransformer(new javax.xml.transform.stream.StreamSource(
          "CancelOrderRequest.xsl"));
     transAmendOrderRequest = transFactory.newTransformer(new javax.xml.transform.stream.StreamSource(
          "AmendOrderRequest.xsl"));


      /*styleSheets.addElement("logon", transLogon);
      styleSheets.addElement("new", transNewOrder);*/

    }catch(Exception e){

      e.printStackTrace();
    }
    //translate();


  }

  public Object translate(org.jdom.Document document, String type){

//    OutputStream respuesta;
    javax.xml.transform.stream.StreamResult res = new javax.xml.transform.
        stream.StreamResult(new ByteArrayOutputStream());

    try {

     if(type.equals(MessageTypes.LOGON)){
      transLogon.transform(new org.jdom.transform.JDOMSource(document),
                      res);
      resultado = res.getOutputStream();
      System.out.println("valor de salida: " + resultado.toString());


     }else if(type.equals(MessageTypes.NEW_ORDER)){
//      transFIXPlain.transform();
      /*transFIXPlain.transform(new org.jdom.transform.JDOMSource(document),
                      res);*/
      transNewOrder.transform(new org.jdom.transform.JDOMSource(document),
                      res);
      resultado = res.getOutputStream();
      System.out.println("valor de salida: " + resultado.toString());

      }else if(type.equals(MessageTypes.CANCEL_ORDER)){

       transCancelOrderRequest.transform(new org.jdom.transform.JDOMSource(document),
                      res);
       resultado = res.getOutputStream();
       System.out.println("valor de salida: " + resultado.toString());
      }else if(type.equals(MessageTypes.AMEND_ORDER)){

       transAmendOrderRequest.transform(new org.jdom.transform.JDOMSource(document),
                      res);
       resultado = res.getOutputStream();
       System.out.println("valor de salida: " + resultado.toString());
     }
    }catch (Exception e){
      e.printStackTrace();
    }

    return resultado.toString();
  }
  public static void main(String args[]){

   XMLMessageTranslator mt = new XMLMessageTranslator();


  }

}