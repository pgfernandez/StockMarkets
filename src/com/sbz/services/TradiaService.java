package com.sbz.services;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

import com.sbz.core.exceptions.TradiaServiceException;

public abstract class TradiaService {

  protected String configurationFile = null;
  protected String serviceDescription = null;
  protected String name = null;

  protected boolean serviceStatus;

  public void startService() throws TradiaServiceException{}
  public void setName(String name){}
  public String getName(){ return name;}
  public void setConfigurationFile(String configurationFile) {}
  public void setServiceDescription(String serviceDescription) {}
  public String getServiceDescription(){return serviceDescription;}
  public void setServiceStatus(boolean newServiceStatus){}
  public boolean getServiceStatus(){return serviceStatus;}
}
