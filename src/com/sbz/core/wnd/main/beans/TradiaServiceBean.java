package com.sbz.core.wnd.main.beans;

import com.sbz.services.TradiaService;

public class TradiaServiceBean extends TradiaService{

  private String shortServiceName = null;

  public TradiaServiceBean(){

  }

  public TradiaServiceBean(String name, String desc){
    this.name = name;
    this.serviceDescription = desc;
  }

  public String toString(){
    return this.name;
  }
  public void setServiceStatus(boolean newServiceStatus){
    this.serviceStatus = newServiceStatus;
  }
  public boolean getServiceStatus(){
    return this.serviceStatus;
  }

  public void setShortServiceName(String shortServiceName){
    this.shortServiceName = shortServiceName;
  }
  public String getShortServiceName(){
    return this.shortServiceName;
  }


}
