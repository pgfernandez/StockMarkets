package com.sbz.fix.gateway.handlers;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

import com.tibco.sdk.*;
import com.tibco.sdk.metadata.*;
import com.tibco.sdk.internal.*;
import com.tibco.sdk.marshalling.*;
import com.sbz.host.messages.*;
import java.util.Enumeration;
import java.util.ArrayList;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Field;


public class TxMessageHandler {

  private MApp app = null;
  private MClassRegistry regClass = null;
  private MInstance order = null;
  private MessageTypeTable types = null;

  private final String MESSAGE_PACKAGE = "com.sbz.host.messages.";
  private MessageClassFactory classFactory = null;
  private Class messageOrder = null;
  //private HostOrder messageOrder = null;
  private final Class[] parameterTypes = {String.class};
  private String type = null;

  private NewOrderHandler newHandler = null;
 // private CancelRequestOrderHandler cancelHandler = null;
 // private ReplaceRequestOrderHandler replaceHandler = null;

  public TxMessageHandler(MApp app){//MClassRegistry regClass) {
   // this.regClass = regClass;
    this.app = app;
    regClass = app.getClassRegistry();
    classFactory = new MessageClassFactory();
    types = new MessageTypeTable();
    initializeHandlers();
  }

  private String getMessageType(String message){

    String key = message.substring(0,2);
    System.out.println("key recogido : " + key);

   // String type = types.getValue(key);

    return key;
  }

  private void initializeHandlers(){

      newHandler = new NewOrderHandler();
   //   cancelHandler = new CancelRequestOrderHandler();
     // replaceHandler = new ReplaceRequestOrderHandler();



  }


  public MInstance getMessageInstance(String message){

   System.out.println("recibo mensaje de host: " + message);

   type = this.getMessageType(message);
   MInstance order = null;

   if (type.equals("A ")){

    //order = newHandler.getOrderBuilt(type, message);

   }

  /* String orderClassName = types.getValue(type);

   System.out.println("Mensaje de tipo :" + orderClassName );
   String repoClassName = null;
   Object hostClass = null;

   try{

    messageOrder = classFactory.getMessageClass(MESSAGE_PACKAGE + orderClassName);
    Constructor newConstructor = messageOrder.getConstructor( parameterTypes );
    Object[] initArgs = { message };
    hostClass = newConstructor.newInstance(initArgs);
    System.out.println("clase instanciada es: " + hostClass.getClass().getName());


  }catch(Exception e){
    e.printStackTrace();
  }

   MProperties prop = app.getProperties();

   String rootPath = app.getAppParameters().getAppName() + "/";
  try{
   int count = prop.getCount(rootPath + "equivalences");

   System.out.println("numero de elementos encontrados: " + count);

   String basePath = rootPath + "equivalences/";

   repoClassName = (String)prop.get(basePath + type);
   System.out.println("cogido el elemento: " + repoClassName + " equivalente a: " + type);

  }catch(Exception ex){
   ex.printStackTrace();

  }


   try {
    order = regClass.getDataFactory().newInstance("/tibco/public/class/ae/" + repoClassName);

    MMetaDescription meta = order.getClassDescription();
    //Enumeration enum = order.getClassDescription().getPropertyNames();
    //order.get
    Method[] f = hostClass.getClass().getMethods();
    for (int i = 0; i<f.length; i++){

      System.out.println("metodo de host: " + f[i].getName());

    }


//    Enumeration enum = meta.getProperties();

    /*for(; enum.hasMoreElements();){
      String o = (String)enum.nextElement();
      System.out.println("extended property: " + o);

    }*/
//    Field[] hostAtributes = hostClass.getClass().getDeclaredFields();
//    Enumeration repoAtributes = order.getClassDescription().getClassRegistry().addAssociationDescription();//.getClass().getDeclaredFields();
   // System.out.println("atributos de host: " + hostAtributes.length + " de repo: " + repoAtributes.length);
   /* Method[] methods = null;
     for (;  repoAtributes.hasMoreElements();){
       String atribute = (String)repoAtributes.nextElement();//[i].getName();
       System.out.println("atribute: " + atribute);

      /* StringBuffer method = new StringBuffer();
       method.append("get");
       method.append(atribute.substring(0,1).toLowerCase());
       method.append(atribute.substring(1,atribute.length()));
//       method.append(repoAtributes[i].getName());
       System.out.println("voy a buscar el metodo: "+ method.toString());
       Method met = hostClass.getClass().getMethod(method.toString(),null);
       if (met!=null){
         System.out.println("metodo encontrado: " + met.getName());
         methods[i] = met;
       }*/

     //}

    /*order.set("messageType",new String(newOrder.getMessageType()));
    order.set("brokerCode",new String(newOrder.getBrokerCode()));
    order.set("isinCode",new String(newOrder.getIsinCode()));
    order.set("account",new String(newOrder.getAccount()));

    System.out.println("valores recogidos");
    System.out.println("-----------------");
    System.out.println("tipo mensaje: " + order.get("messageType"));
    System.out.println("brokerCode: " + order.get("brokerCode"));
    System.out.println("isinCode: " + order.get("isinCode"));
    System.out.println("account: " + order.get("account"));
    }catch(Exception e){
      e.printStackTrace();
    }

    MTree msg = null;
     //convierto la MInstance a MTree para mandarlo a través de la red.
    try{
    msg= order.serialize();*/
  /*  }catch(Exception exc){
      exc.printStackTrace();
    }
//   return msg;
   return null;*/

   return order;
  }




}