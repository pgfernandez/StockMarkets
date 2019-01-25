package com.sbz.services;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

import com.sbz.parsing.XMLManager;
import com.sbz.core.patterns.builder.director.AdapterBuilderDirector;
import com.sbz.core.tibco.Adapter;
import java.util.*;

public class TradiaLogService extends TradiaService{
//  private String configurationFile = null;
  private AdapterBuilderDirector builder = null;

  public TradiaLogService() {
  }

  public void setConfigurationFile(String configurationFile) {
    this.configurationFile = configurationFile;

  }

  public void setServiceDescription(String serviceDescription){
  this.serviceDescription = serviceDescription;
}
public String getServiceDescription(){
  return this.serviceDescription;
}

public void setName(String name){
  this.name = name;
}
public String getName(){
  return this.name;
}

public void setServiceStatus(boolean newServiceStatus){
    this.serviceStatus = newServiceStatus;
  }
  public boolean getServiceStatus(){
    return this.serviceStatus;
  }


  public void startService(){
     builder = new AdapterBuilderDirector(this.configurationFile);
     XMLManager xmlManager = new XMLManager(this.configurationFile);
     Adapter a = null;
     try{
       a = (Adapter)builder.createAdapter("adapter2Log");
       a.start();
     }catch(Exception e){
       e.printStackTrace();
     }
  }
}
