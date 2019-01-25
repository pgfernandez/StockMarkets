package com.sbz.mq.adapters;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

import javax.jms.*;
import com.sbz.core.tibco.Adapter;

import com.sbz.data.types.*;
import com.sbz.fix.adapter.*;
import com.sbz.exception.*;
import com.sbz.host.connection.*;
import com.sbz.mq.*;
import com.sbz.parsing.*;
import com.sbz.util.*;
import com.tibco.sdk.*;
import com.tibco.sdk.events.*;
import com.tibco.sdk.metadata.*;
import com.sbz.core.patterns.builder.product.TibcoAdapterParametersProduct;


public class Adapter2MQ extends Adapter implements MEventListener, HostConnectionInterface{

  private HostConnection hostCon = null;
  private MClassRegistry reg = null;
  private MComponentRegistry r = null;
  private MSubscriber sub= null;
  private MPublisher pubLog = null;
  private QueueSession mySession = null;
  private com.sun.messaging.Queue myQueue = null;
  private QueueSender mySender = null;
  private QueueReceiver myQueueReceiver = null;
  private TextMessage myTextMsg = null;
  private SBZQueueFactory qf = null;

  private String subscriberHost = null;
  private String publisherLog = null;
  private String url = null;
  private String initialContextFactory = null;
  private String mqConnectionFactory = null;
  private String queueOrders = null;
  private String queueExecutions = null;

   public Adapter2MQ(MAppProperties p,TibcoAdapterParametersProduct adapterArgs){
     super(p);

     Integer portAux = new Integer((String)adapterArgs.getOthers().get("port"));
     int port = portAux.intValue();
     hostCon = new HostConnection(this,port);
     subscriberHost = (String)adapterArgs.getSubscribers().get("subscriberHost");
     publisherLog = (String)adapterArgs.getPublishers().get("publisherLog");
    queueOrders = (String)adapterArgs.getOthers().get("queueOrders");
    queueExecutions = (String)adapterArgs.getOthers().get("queueExecutions");
    MessageMap mqFactoryArgs = new MessageMap();
    mqFactoryArgs.addElement("url",adapterArgs.getOthers().get("url"));
    mqFactoryArgs.addElement("initialContextFactory",adapterArgs.getOthers().get("initialContextFactory"));
    mqFactoryArgs.addElement("mqConnectionFactory",adapterArgs.getOthers().get("mqConnectionFactory"));
    initializeSessionMQ(mqFactoryArgs);
   }

  private void initializeSessionMQ(MessageMap mqConArgs){

    qf = new SBZQueueFactory(mqConArgs);
    try {
    mySession = qf.getSession();

    myQueue = qf.getQueue(queueOrders);

    mySender = mySession.createSender(myQueue);

   }catch(Exception e){
      e.printStackTrace();
  }
  }

  /**
   * Inicializa la aplicacion.
   */
  public void onInitialization() throws MException {

   reg = getClassRegistry();
    //Leo los componentes del repositorio.
    r = getComponentRegistry();
    sub = r.getSubscriber(subscriberHost);
    pubLog = r.getPublisher(publisherLog);
    if(!sub.isActivated()){
      sub.activate();
    }
    sub.addListener(this);
  }

  public void onSNAMessage(String message){
    try{
    myTextMsg = mySession.createTextMessage();
    myTextMsg.setText(message);
    mySender.send(myTextMsg);
    }catch(Exception e){
     e.printStackTrace();
    }

  }


   public void onTermination(){



  }

  public void onEvent(MEvent e){

//   System.out.println("Estoy en el escuchador de eventos de Cliente");

      //Al recibir un evento debe distinguir si
      // es una excepcion  o es de entrada salida o de tiempo
      // es un mensaje de datos(MDataEvent):
      //       - saco los datos asociados a ese evento que corresponderán al
      //         resultado de la operacion pasada.
      //       -imprimo los datos EN PANTALLA del resultado de la operacion.
      if( e instanceof MExceptionEvent )
      {
               MException ex = ((MExceptionEvent )e).getException();
      }
      else if( e instanceof MDataEvent )
       {
          MTree msg = ((MDataEvent )e).getData();
          MNode n= (MNode)msg.getNode("orden");
         try{
         }catch(Exception ex){

           ex.printStackTrace();
         }
          hostCon.sendMessage(n.getData().toString());
       }

  }

/

}