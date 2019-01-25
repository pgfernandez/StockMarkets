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

 public class ApplicationXML extends FIXMessageXML{

  private org.jdom.Element brokerCode   = null;
  private org.jdom.Element orderId      = null;
  private org.jdom.Element isinCode     = null;
  private org.jdom.Element buySellIndex = null;
  private org.jdom.Element market       = null;
  private org.jdom.Element quantity     = null;

  public ApplicationXML() {

   brokerCode   = new org.jdom.Element("broker");
   orderId      = new org.jdom.Element("orderId");
   isinCode     = new org.jdom.Element("isin");
   buySellIndex = new org.jdom.Element("buySellIndex");
   market       = new org.jdom.Element("market");
   quantity     = new org.jdom.Element("quantity");

  }

  public Element getBrokerCode(){
   return this.brokerCode;
  }

  public Element getOrderId(){
   return this.orderId;
  }

  public Element getIsinCOde(){
   return this.isinCode;
  }

  public Element getBuySellIndex(){
   return this.buySellIndex;
  }

  public Element getMarket(){
   return this.market;
  }

  public Element getQuantity(){
    return this.quantity;
  }

}