package com.sbz.fix.gateway.handlers;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */
import com.sbz.host.messages.HostCancelOrderRequest;
import com.sbz.fix.gateway.handlers.xml.CancelOrderRequestXML;
import org.jdom.*;
import org.jdom.output.XMLOutputter;
import java.io.FileOutputStream;


public class CancelOrderRequestHandler {

  private HostCancelOrderRequest cancelOrderRequest = null;
  private CancelOrderRequestXML  cancelOrderRequestXML   = null;


  public CancelOrderRequestHandler() {
   cancelOrderRequestXML = new CancelOrderRequestXML();
  }

  public org.jdom.Document getFormattedMsg(String msg){

   cancelOrderRequest = new HostCancelOrderRequest(msg);
   org.jdom.Element root = new org.jdom.Element("stock");

//   root.setAttribute("type","cancelOrderRequest");

   root.addContent(cancelOrderRequestXML.getBrokerCode().addContent(cancelOrderRequest.getBrokerCode()));
   root.addContent(cancelOrderRequestXML.getOrderCancelId().addContent(cancelOrderRequest.getCancelOrderId()));
   root.addContent(cancelOrderRequestXML.getOrderId().addContent(cancelOrderRequest.getOrderId()));
   root.addContent(cancelOrderRequestXML.getIsinCOde().addContent(cancelOrderRequest.getIsinCode()));
   root.addContent(cancelOrderRequestXML.getBuySellIndex().addContent(cancelOrderRequest.getBuySellIndex()));
   root.addContent(cancelOrderRequestXML.getMarket().addContent(cancelOrderRequest.getMarket()));
   root.addContent(cancelOrderRequestXML.getQuantity().addContent(cancelOrderRequest.getQuantity()));


   Document doc = new Document(root);

   try{

    XMLOutputter out=new XMLOutputter(" ",true);
    FileOutputStream file=new FileOutputStream("ejemplo3.xml");
    out.output(doc,file);
   }catch(Exception e){
    e.printStackTrace();
   }

    return doc;

  }


}