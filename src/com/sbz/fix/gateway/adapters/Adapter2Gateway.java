package com.sbz.fix.gateway.adapters;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

import com.sbz.data.types.MessageMap;
import com.sbz.fix.adapter.HostConnectionInterface;
import com.sbz.parsing.XMLManager;
import com.sbz.util.SBZProperties;
import com.sbz.host.messages.HostNewOrder;
import com.tibco.sdk.*;
import com.tibco.sdk.events.*;
import com.tibco.sdk.metadata.*;
import com.tibco.sdk.internal.*;
import com.tibco.sdk.marshalling.*;
import com.tibco.sdk.events.*;
import com.tibco.tibrv.*;
import javax.jms.MessageListener;
import javax.jms.*;

import java.util.Enumeration;

import com.sbz.mq.SBZQueueFactory;
import com.sbz.fix.gateway.handlers.*;
import java.net.Socket;
import java.net.*;
import java.io.*;
import com.sbz.core.tibco.Adapter;
import com.sbz.core.patterns.builder.product.TibcoAdapterParametersProduct;

public class Adapter2Gateway extends Adapter implements MEventListener, MessageListener{

 private MInstance order = null;

 // Lee la clase que está en el repositorio.
 private MComponentRegistry r = null;
 private MClassRegistry reg = null;
 private MPublisher pub = null;
 private MPublisher pubMQ = null;
 private MPublisher pubLog = null;
 private MSubscriber sub = null;

 private QueueSender mySender = null;
 private QueueReceiver myReceiver = null;
 private QueueSession mySession = null;
 private com.sun.messaging.Queue myQueue = null;
 private TextMessage myTextMsg = null;

 private SBZQueueFactory qf = null;

 private String publisherOrders = null;
 private String pubOrdersSubject = null;
 private String publisherMQ = null;
 private String publisherLog = null;
 private String subscriberOrders = null;
 private String subOrdersSubject = null;

 private String url = null;
 private String initialContextFactory = null;
 private String mqConnectionFactory = null;
 private String queueOrders = null;
 private String queueExecutions = null;

   public Adapter2Gateway(MAppProperties p,  TibcoAdapterParametersProduct adapterArgs) {
    super(p);

    publisherOrders =(String)adapterArgs.getPublishers().get("publisherOrders");
    pubOrdersSubject = (String)adapterArgs.getOthers().get("pubOrdersSubject");
    publisherMQ = (String)adapterArgs.getPublishers().get("publisherMQ");
    publisherLog = (String)adapterArgs.getPublishers().get("publisherLog");
    subscriberOrders = (String)adapterArgs.getSubscribers().get("subscriberOrders");
    subOrdersSubject = (String)adapterArgs.getOthers().get("subOrdersSubject");
    queueOrders = (String)adapterArgs.getOthers().get("queueOrders");
    System.out.println("valor de queue: " + queueOrders);
    queueExecutions = (String)adapterArgs.getOthers().get("queueExecutions");
    MessageMap mqFactoryArgs = new MessageMap();
    mqFactoryArgs.addElement("url",adapterArgs.getOthers().get("url"));
    mqFactoryArgs.addElement("initialContextFactory",adapterArgs.getOthers().get("initialContextFactory"));
    mqFactoryArgs.addElement("mqConnectionFactory",adapterArgs.getOthers().get("mqConnectionFactory"));
    initializeSessionMQ(mqFactoryArgs);
  }



  private void muestraMetodo(Enumeration en){
    for (int i = 0; en.hasMoreElements(); i++){
      Object o = en.nextElement();
    }
  }


  /**
   * Inicializa la aplicacion.
   */
  public void onInitialization() throws MException {

     System.out.println("evento OnInitiali");
    //-----------------------------------------------------------------
    System.out.println("registro de clases");
    reg = this.getClassRegistry();

    //Leo los componentes del repositorio.
    r = getComponentRegistry();

    // Leo los publicadores y subscriptores de CLIENTE que están en el repositorio
    pub=r.getPublisher(publisherOrders);
    pubLog=r.getPublisher(publisherLog);

    sub= r.getSubscriber(subscriberOrders);
    try{
    if(!sub.isActivated()){
      sub.activate();
    }
    }catch(Exception exce){
      exce.printStackTrace();
    }
    sub.addListener(this);
  }


  private void initializeSessionMQ(MessageMap mqFactoryArgs){

    qf = new SBZQueueFactory(mqFactoryArgs);
    try {
    mySession = qf.getSession();

    myQueue = qf.getQueue(queueOrders);

    mySender = mySession.createSender(myQueue);
    myReceiver = mySession.createReceiver(myQueue);
    myReceiver.setMessageListener(this);

   }catch(Exception e){
      e.printStackTrace();
   }



  }

  public void onMessage(Message msg){

    try{
    if (msg instanceof TextMessage) {
      TextMessage txtMsg = (TextMessage) msg;
      System.out.println("Read Message: " + txtMsg.getText());
      translate(txtMsg.toString(),true);
    }
    }catch(Exception e){
      e.printStackTrace();
    }


  }


  private void translate(String message, boolean way)
  {
    //ver tipo y crear tipo,de momento neworders
    System.out.println("recibo mensaje de host: " + message);
     MTree msg = null;
     MInstance order = null;
    if (way){

     msg = new MTree("msg");
     try{
     msg.append("orden",message);
     }catch(Exception excp){
      excp.printStackTrace();
     }

   try {
      // Publicamos segun la operacion a realizar y al cliente dado.
        pub.setSubjectName(pubOrdersSubject);
      // manda el mensaje al subject praxis.operacion apropiado
      // y escucha los eventos.

      pub.send(msg);
      pubLog.send(msg);
    } catch (MException me) {
      System.out.println("Imposible publicar: "+me.getMessage());
    }
    // Se muestra en pantalla los datos publicados..
    System.out.println("Los datos publicados son: ");
    System.out.println(msg);

   }

  }

  public void onTermination(){



  }

  public void onEvent(MEvent e){
    System.out.println("Estoy en el escuchador de eventos de Cliente");

      //Al recibir un evento debe distinguir si
      // es una excepcion  o es de entrada salida o de tiempo
      // es un mensaje de datos(MDataEvent):
      //       - saco los datos asociados a ese evento que corresponderán al
      //         resultado de la operacion pasada.
      //       -imprimo los datos EN PANTALLA del resultado de la operacion.
      if( e instanceof MExceptionEvent )
      {
               MException ex = ((MExceptionEvent )e).getException();
               System.out.println( "Exception msg "+ex.getMessage() );
      }
      else if( e instanceof MDataEvent )
       {

          MTree msg = ((MDataEvent )e).getData();

          MNode n= (MNode)msg.getNode("msg");


          MTree arb=(MTree)n;
          System.out.println("El msj es:  " +msg);
          System.out.println("Los datos son: "+ n);
          if((((MDataEvent)e).getSubject()).equals(subOrdersSubject)){
            try{
            pubMQ = r.getPublisher(publisherMQ);
            pubMQ.send(msg);
            }catch(Exception exc){
              exc.printStackTrace();
            }
          }
        }

  }




}
