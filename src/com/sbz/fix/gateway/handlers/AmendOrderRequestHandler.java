package com.sbz.fix.gateway.handlers;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

import com.sbz.host.messages.HostAmendOrderRequest;
import com.sbz.fix.gateway.handlers.xml.AmendOrderRequestXML;
import org.jdom.*;
import org.jdom.output.XMLOutputter;
import java.io.FileOutputStream;



public class AmendOrderRequestHandler {

  private HostAmendOrderRequest amendOrderRequest = null;
  private AmendOrderRequestXML  amendOrderRequestXML   = null;

  public AmendOrderRequestHandler() {
   amendOrderRequestXML = new AmendOrderRequestXML();
  }

  public org.jdom.Document getFormattedMsg(String msg){

   amendOrderRequest = new HostAmendOrderRequest(msg);
   org.jdom.Element root = new org.jdom.Element("stock");

//   root.setAttribute("type","amendOrderRequest");

   root.addContent(amendOrderRequestXML.getBrokerCode().addContent(amendOrderRequest.getBrokerCode()));
   root.addContent(amendOrderRequestXML.getAmendOrderId().addContent(amendOrderRequest.getAmendOrderId()));
   root.addContent(amendOrderRequestXML.getOrderId().addContent(amendOrderRequest.getOrderId()));
   root.addContent(amendOrderRequestXML.getIsinCOde().addContent(amendOrderRequest.getIsinCode()));
   root.addContent(amendOrderRequestXML.getBuySellIndex().addContent(amendOrderRequest.getBuySellIndex()));
   root.addContent(amendOrderRequestXML.getMarket().addContent(amendOrderRequest.getMarket()));
   root.addContent(amendOrderRequestXML.getCurrency().addContent(amendOrderRequest.getCurrency()));
   root.addContent(amendOrderRequestXML.getCurrencySettl().addContent(amendOrderRequest.getCurrencyLiq()));
   root.addContent(amendOrderRequestXML.getQuantity().addContent(amendOrderRequest.getQuantity()));
   root.addContent(amendOrderRequestXML.getPriceLImit().addContent(amendOrderRequest.getPriceLimit()));
   root.addContent(amendOrderRequestXML.getTimeInForce().addContent(amendOrderRequest.getTimeInForce()));
   root.addContent(amendOrderRequestXML.getDateLimit().addContent(amendOrderRequest.getDateLimit()));
   root.addContent(amendOrderRequestXML.getText().addContent(amendOrderRequest.getText()));

   Document doc = new Document(root);

   try{

    XMLOutputter out=new XMLOutputter(" ",true);
    FileOutputStream file=new FileOutputStream("ejemplo4.xml");
    out.output(doc,file);
   }catch(Exception e){
    e.printStackTrace();
   }


   return doc;

  }

}