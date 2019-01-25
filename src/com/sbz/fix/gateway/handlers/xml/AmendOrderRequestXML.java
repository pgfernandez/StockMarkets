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

public class AmendOrderRequestXML extends NewOrderXML{

  private Element amendOrderId = null;

  public AmendOrderRequestXML() {
   amendOrderId = new Element("amendOrderId");
  }

  public Element getAmendOrderId(){
   return this.amendOrderId;
  }


}