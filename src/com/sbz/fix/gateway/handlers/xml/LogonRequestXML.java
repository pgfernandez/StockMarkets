package com.sbz.fix.gateway.handlers.xml;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

import org.jdom.Element;

public class LogonRequestXML extends FIXMessageXML{

  private org.jdom.Element heartBeatInterval = null;
  private org.jdom.Element encryptMethod = null;

  public LogonRequestXML() {
   heartBeatInterval = new Element("heartBeatInterval");
   encryptMethod = new Element("encryptMethod");
  }

  public Element getHeartBeatInterval(){

    return this.heartBeatInterval;

  }

  public Element getEncryptMethod(){

   return this.encryptMethod;

  }


}