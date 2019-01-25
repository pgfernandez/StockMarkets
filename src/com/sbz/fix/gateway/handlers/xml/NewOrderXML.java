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

public class NewOrderXML extends ApplicationXML{

  private org.jdom.Element currency      = null;
 // private org.jdom.Element quantity      = null;
  private org.jdom.Element priceLimit    = null;
  private org.jdom.Element orderType     = null;
  private org.jdom.Element timeInForce   = null;
  private org.jdom.Element dateLimit     = null;
  private org.jdom.Element currencySettl = null;
  private org.jdom.Element text          = null;

  public NewOrderXML() {

   currency      = new org.jdom.Element("currency");
   //quantity      = new org.jdom.Element("quantity");
   priceLimit    = new org.jdom.Element("priceLimit");
   orderType     = new org.jdom.Element("orderType");
   timeInForce   = new org.jdom.Element("timeInForce");
   dateLimit     = new org.jdom.Element("dateLimit");
   currencySettl = new org.jdom.Element("currencySettl");
   text          = new org.jdom.Element("text");

  }

  public Element getCurrency(){
   return this.currency;
  }

 /* public Element getQuantity(){
   return this.quantity;
  }*/

  public Element getPriceLImit(){
   return this.priceLimit;
  }

  public Element getTimeInForce(){
   return this.timeInForce;
  }

  public Element getOrderType(){
   return this.orderType;
  }

  public Element getDateLimit(){
   return this.dateLimit;
  }

  public Element getCurrencySettl(){
   return this.currencySettl;
  }
  public Element getText(){
   return this.text;
  }


}