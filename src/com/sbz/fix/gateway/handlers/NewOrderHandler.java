package com.sbz.fix.gateway.handlers;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */



import com.sbz.host.messages.HostNewOrder;
import com.sbz.fix.gateway.handlers.xml.*;
import org.jdom.*;
import org.jdom.output.XMLOutputter;
import java.io.FileOutputStream;


public class NewOrderHandler{

//  private static final char DELIMITER = '\001';
//  private Java2XML transformer = null;
  private HostNewOrder newOrder = null;
  private NewOrderXML  newXML   = null;

  public NewOrderHandler() {

    newXML = new NewOrderXML();

   //this.transformer = transformer;


  }

  public org.jdom.Document getFormattedMsg(String msg){

   newOrder = new HostNewOrder(msg);
   org.jdom.Element root = new org.jdom.Element("stock");

//   root.setAttribute("type","newOrder");

   root.addContent(newXML.getBrokerCode().addContent(newOrder.getBrokerCode()));
   root.addContent(newXML.getOrderId().addContent(newOrder.getOrderId()));
   root.addContent(newXML.getIsinCOde().addContent(newOrder.getIsinCode()));
   root.addContent(newXML.getBuySellIndex().addContent(newOrder.getBuySellIndex()));
   root.addContent(newXML.getMarket().addContent(newOrder.getMarket()));
   root.addContent(newXML.getCurrency().addContent(newOrder.getCurrency()));
   root.addContent(newXML.getCurrencySettl().addContent(newOrder.getCurrencyLiq()));
   root.addContent(newXML.getQuantity().addContent(newOrder.getQuantity()));
   root.addContent(newXML.getPriceLImit().addContent(newOrder.getPriceLimit()));
   root.addContent(newXML.getTimeInForce().addContent(newOrder.getTimeInForce()));
   root.addContent(newXML.getDateLimit().addContent(newOrder.getDateLimit()));
   root.addContent(newXML.getText().addContent(newOrder.getText()));

   Document doc = new Document(root);

   try{

    XMLOutputter out=new XMLOutputter(" ",true);
    FileOutputStream file=new FileOutputStream("ejemplo.xml");
    out.output(doc,file);
   }catch(Exception e){
    e.printStackTrace();
   }

   //org.jdom.Element precio = new org.jdom.Element("price");

   //precio.addContent(newOrder.getPriceLimit());


/*   String test = "8=FIX.4.0"+DELIMITER+"9=60"+DELIMITER+"35=A"+DELIMITER
       + "49=SBZN"+DELIMITER+"56=GOLD"+DELIMITER+"34=1"+DELIMITER+"52=20000714-08:41:16"
       +DELIMITER +"98=0"+DELIMITER+"108=120"+DELIMITER+"10=190" + DELIMITER;*/

   return doc;

  }


}