package com.sbz.io.log.adapters;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */
import java.util.logging.Level;
import com.sbz.io.log.SBZLog;
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
import com.sbz.core.tibco.Adapter;
import com.sbz.data.types.MessageMap;
import java.util.*;
import com.sbz.core.patterns.builder.product.TibcoAdapterParametersProduct;
import com.sbz.util.SBZProperties;




public class Adapter2Log extends Adapter implements MEventListener{

  private MClassRegistry reg = null;
  private MComponentRegistry r = null;
  private MSubscriber sub= null;
  private SBZLog sbzLog = null;
  private String subLog = null;

    public Adapter2Log(MAppProperties p, TibcoAdapterParametersProduct adapterArgs) {

    super(p);
     subLog = (String)adapterArgs.getSubscribers().get("subscriberLog");
     sbzLog = new SBZLog();
     this.writeLog("Adapter2Log creado", SBZProperties.INFO_LEVEL);
  }

  private void writeLog(String message, String levelMessage){
    Level level = null;
    if(levelMessage.equals(SBZProperties.INFO_LEVEL)){
      level = Level.INFO;
    }else if(levelMessage.equals(SBZProperties.WARNING_LEVEL)){
       level = Level.WARNING;
    }else if(levelMessage.equals(SBZProperties.ERROR_LEVEL)){
      level = Level.SEVERE;
    }else{
      level = Level.OFF;
    }
    this.sbzLog.writeLog(message,level);
  }
  /**
   * Inicializa la aplicacion.
   */
  public void onInitialization() throws MException {

    //-----------------------------------------------------------------
    this.writeLog("Adapter2Log iniciando", SBZProperties.INFO_LEVEL);
    reg = getClassRegistry();
    //Leo los componentes del repositorio.
    r = getComponentRegistry();

    sub = r.getSubscriber(subLog);
    if(!sub.isActivated()){
      sub.activate();
    }
        this.writeLog("Adapter2Log: añadiendo subscriber (" + subLog + ")", SBZProperties.INFO_LEVEL);
    sub.addListener(this);
  }

   public void onTermination(){
          this.writeLog("Adapter2Log: terminado adaptador", SBZProperties.WARNING_LEVEL);


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
               System.out.println( "Exception msg "+ex.getMessage() );
      }
      else if( e instanceof MDataEvent )
       {
         try{
         MTree msg = ((MDataEvent )e).getData();

          MNode n= (MNode)msg.getNode("message");
          MNode l = (MNode)msg.getNode("level");
//          MTree arb=(MTree)n;
          System.out.println("antes de escribir en log:LEVEL:** "  + (String)l.getData());
          System.out.println("antes de escribir en log:MSG:** "  + (String)n.getData());


          this.writeLog(n.getData().toString(), l.getData().toString());
          n = null;
          l = null;
         }catch(Exception ex){
           ex.printStackTrace();
         }
        }




  }




  public static void main(String[] args) {

  /*  XMLManager xmlManager = new XMLManager(SBZProperties.ADAPTERS_CNF_FILE);
    xmlManager.setElement("adapter2Log");
    String adapter = xmlManager.getValue("tibAdapter");
    String version = xmlManager.getValue("version");
    String repository = xmlManager.getValue("repository");
    String name = xmlManager.getValue("name");
    String tibComponent = xmlManager.getValue("tibComponent");
    try {

      MAppProperties prop= new MAppProperties(
      adapter,
      version,
      name,
      tibComponent,
      repository,
      args
    );

         System.out.println("info : " + prop.getAppInfo());
    //Crea y arranca el adaptador
    Adapter2Log adapter2Log = new Adapter2Log(prop);
    adapter2Log.start();

  } catch (Exception e) {
    e.printStackTrace();
  }
*/


  }

}