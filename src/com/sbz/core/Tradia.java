package com.sbz.core;


import com.sbz.fix.gateway.adapters.Adapter2Fix;
import com.sbz.fix.gateway.adapters.Adapter2Gateway;
import com.sbz.mq.adapters.Adapter2MQ;
import com.sbz.io.log.adapters.Adapter2Log;
import com.sbz.core.patterns.builder.director.AdapterBuilderDirector;
import com.sbz.services.TradiaLogService;
import com.sbz.parsing.XMLManager;
import com.sbz.util.SBZProperties;
import java.util.*;
import com.sbz.services.*;
import com.sbz.core.wnd.main.beans.TradiaServiceBean;
import com.sbz.core.exceptions.TradiaServiceException;

/**
 *
 * <p>Title: Tradia FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */
public class Tradia {

  private TradiaLogService logService = null;
  private XMLManager xmlManager = null;
  private final static String SERVICES = "services";
  private boolean instanceCreator = false;
  private HashMap services = null;
  private HashMap configuracion = null;
  private List componentes = null;
  private Object service[];
  private TradiaServiceBean tradiaServices = null;
  private ArrayList tradiaSvcs = null;

  public Tradia(boolean sourceCreator) {

   xmlManager = new XMLManager(SBZProperties.TRADIA_CNF_FILE);
   instanceCreator = sourceCreator;
   this.loadConfiguration();
  }


  private void loadConfiguration(){

     List servicios = xmlManager.readChildsNames(this.SERVICES);
     String servicio = null;
     HashMap tradiaServices = null;
     for (int i=0; i < servicios.size(); i++){
       servicio = (String) servicios.get(i);
       tradiaServices = xmlManager.readAll(servicio, "value");
     }

     List claves = new ArrayList();
     Iterator iter = tradiaServices.keySet().iterator();

     while(iter.hasNext()){
       claves.add((String)iter.next());
     }

     //lista de servicios disponibles
     //poder arrancarlos uno a uno a través del Admin
     //o todos, según desde dónde se haya instanciado la clase.
     tradiaSvcs = new ArrayList();
     TradiaServiceBean beanTemp = null;


   for (int j=0;j<claves.size();j++){

     componentes = xmlManager.readChildsNames((String)claves.get(j));
     String servicioComponente = null;
     services = new HashMap();
     configuracion = new HashMap();
     service = new Object[componentes.size()];
//     System.out.println("tamaño de componentes: " + componentes.size());
     for (int i=0; i < componentes.size(); i++){
       servicioComponente = (String)componentes.get(i);
       configuracion = xmlManager.readAll(servicioComponente,"value");
       try{


      String name =  ((String)configuracion.get("name"));
      String desc = ((String)configuracion.get("desc"));
      String className = ((String)configuracion.get("class"));
      service[i] = (TradiaService)Class.forName(className).newInstance();
      ((TradiaService)service[i]).setServiceDescription(name);
      ((TradiaService)service[i]).setConfigurationFile((String)configuracion.get("configFile"));
      ((TradiaService)service[i]).setServiceDescription(desc);
      beanTemp = new TradiaServiceBean(name, desc);
      beanTemp.setShortServiceName(className);
      System.out.println("short recogido: " + beanTemp.getShortServiceName());
      tradiaSvcs.add(beanTemp);
      //beanTemp = null;
      //System.out.println("valores: " + beanTemp.getName() + " :: " + beanTemp.getServiceDescription());
      services.put(servicioComponente,(TradiaService)service[i]);
       }catch(Exception e){
         e.printStackTrace();
       }
     }
   }
  }

  public void startServices(){
    Object serv[] = new Object[services.size()];
     for(int k=0;k<services.size();k++){
       serv[k] = (TradiaService)services.get((String)componentes.get(k));
       try{
         ( (TradiaService) serv[k]).startService();
       }catch(TradiaServiceException t){
         t.getMessage();
       }
   /*    if ((TradiaService)serv[k] instanceof TradiaLogService){
         System.out.println("TRADIALOGSERVICE ARRANCADO");
       }else{
         System.out.println("TRADIASERVICE ARRANCADO: " + ((TradiaService)serv[k]).getClass().getName());
       }*/
     }
  }

  public String startTradiaService(String service){
    Object serv[] = new Object[services.size()];
    String estado = null;
  for(int k=0;k<services.size();k++){
   serv[k] = (TradiaService)services.get((String)componentes.get(k));
   System.out.println("servicio a arrancar: " + service + ":: instancia actual: " + ((TradiaService)serv[k]).getClass().getName());
   if (service.equals(((TradiaService)serv[k]).getClass().getName())){
     try{
       ( (TradiaService) serv[k]).startService();
       estado = service + " started";
     }catch(TradiaServiceException t){
       estado = t.getMessage() + service;
     }
     System.out.println(service + " ARRANCADO");
   }
 }
   return estado;
  }

  public ArrayList getAvailableServices(){
    return tradiaSvcs;
  }

  public static void main(String args[]){
   Tradia tradia = new Tradia(false);
   tradia.startServices();
  }
}
