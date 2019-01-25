package com.sbz.fix.gateway.adapters;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */


//import com.sbz.fix.adapter.Adapter;
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
import java.io.*;
import com.sbz.data.types.MessageMap;
import com.sbz.fix.adapter.FIXServerInterface;
import com.sbz.fix.connection.FIXConnection;
import com.sbz.fix.gateway.handlers.TXMainHandler;
import com.sbz.fix.gateway.handlers.RxMessageHandler;
import com.sbz.io.log.*;
import java.net.*;
import com.sbz.core.tibco.Adapter;
import java.util.*;
import com.sbz.core.patterns.builder.product.TibcoAdapterParametersProduct;

public class Adapter2Fix extends Adapter implements MEventListener,FIXServerInterface{

 private MInstance order = null;
private static final char DELIMITER = '^'; //de momento es el bueno
// private char DELIMITER;hay que hacerlo genérico a todas
 // Lee la clase que está en el repositorio.
 private MClassRegistry reg = null;
 private MComponentRegistry r = null;
 private MSubscriber sub= null;
 private MPublisher pubLog = null;
 private MPublisher pubHost = null;
 private String subscriberName = null;
 private String pubHostName = null;
 private com.sbz.fix.gateway.handlers.RxMessageHandler rxHandler = null;
 private String publisherLog = null;

 FIXConnection fix = null;

  public Adapter2Fix(MAppProperties p) {

  super(p);
  fix = new FIXConnection(this);
  }

   public Adapter2Fix(MAppProperties p,  TibcoAdapterParametersProduct adapterArgs) {

  super(p);

    fix = new FIXConnection(this,adapterArgs.getOthers());
   this.subscriberName = (String)adapterArgs.getSubscribers().get("subscriberHost");
   this.pubHostName = (String)adapterArgs.getPublishers().get("publisherResponse");
   publisherLog = (String)adapterArgs.getPublishers().get("publisherLog");
   rxHandler = new com.sbz.fix.gateway.handlers.RxMessageHandler(new Character(DELIMITER).toString());

  }

  /**
   * Inicializa la aplicacion.
   */
  public void onInitialization() throws MException {

    //-----------------------------------------------------------------
     reg = getClassRegistry();
    //Leo los componentes del repositorio.
    r = getComponentRegistry();
    sub = r.getSubscriber(subscriberName);


    if(!sub.isActivated()){
      sub.activate();
    }
    sub.addListener(this);
  try{

    pubLog=r.getPublisher(publisherLog);
    pubHost=r.getPublisher(pubHostName);
    }catch(Exception e){
      e.printStackTrace();
    }

    this.writeLog("Adapter2Fix iniciado",SBZProperties.INFO_LEVEL);


  }

   public void onTermination(){

           this.writeLog("Adapter2Fix: terminado adaptador", SBZProperties.WARNING_LEVEL);

  }

  public void onFIXMessage(String message){

     String enviar = rxHandler.messageToHandle(message);
     //traducir o no
     try{

     MTree msg = new MTree("msg");
     msg.append("orden",enviar);

     //traduccion inversa
     pubHost.send(msg);
//     pubLog.send(msg);
     }catch(Exception e){
      e.printStackTrace();
     }
  }
  private void writeLog(String message, String level){
    try{

     MTree msg = new MTree("msg");
     msg.append("message",message);
     msg.append("level", level);
     //traduccion inversa
     pubLog.send(msg);
     }catch(Exception e){
      e.printStackTrace();
     }

  }

  public void onEvent(MEvent e){

   System.out.println("Estoy en el escuchador de eventos de Cliente");
  String msgFormt = null;
      //Al recibir un evento debe distinguir si
      // es una excepcion  o es de entrada salida o de tiempo
      // es un mensaje de datos(MDataEvent):
      //       - saco los datos asociados a ese evento que corresponderán al
      //         resultado de la operacion pasada.
      //       -imprimo los datos EN PANTALLA del resultado de la operacion.
      if( e instanceof MExceptionEvent )
      {
               MException ex = ((MExceptionEvent )e).getException();
//               System.out.println( "Exception msg "+ex.getMessage() );
      }
      else if( e instanceof MDataEvent )
       {
          MTree msg = ((MDataEvent )e).getData();

          MNode n= (MNode)msg.getNode("orden");
      com.sbz.fix.gateway.handlers.TXMainHandler handler = new com.sbz.fix.gateway.handlers.TXMainHandler();
      msgFormt = handler.messageToHandle(n.getData().toString());

     }
       try{

       fix.send(msgFormt);
       this.writeLog("Mensaje enviado a broker: " + msgFormt, SBZProperties.INFO_LEVEL);
      }catch(Exception ex){
          ex.printStackTrace();
        }

  }




  public static void main(String[] args) {

 

  }
}