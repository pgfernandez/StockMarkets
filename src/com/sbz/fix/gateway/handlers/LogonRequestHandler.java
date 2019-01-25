package com.sbz.fix.gateway.handlers;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

import com.sbz.host.messages.HostLogonRequest;
import com.sbz.fix.gateway.handlers.xml.LogonRequestXML;
import org.jdom.*;
import org.jdom.output.XMLOutputter;
import java.io.FileOutputStream;


public class LogonRequestHandler extends Handler{

  private HostLogonRequest hostLogon = null;
  private LogonRequestXML logonXML = null;

  public LogonRequestHandler() {
   logonXML = new LogonRequestXML();
  }

  public org.jdom.Document getFormattedMsg(String msg){

   System.out.println("*********Mensaje recibido en handler: " + msg + "*************");

   super.root = new Element("logon");
   hostLogon = new HostLogonRequest(msg);

   root.addContent(logonXML.getHeartBeatInterval().addContent(hostLogon.getHeartBeatInterval()));
   System.out.println("**********valor de heartBeat: " + hostLogon.getHeartBeatInterval());
   root.addContent(logonXML.getDate().addContent(hostLogon.getDate()));
   root.addContent(logonXML.getSenderCompID().addContent(hostLogon.getSenderCompID()));
   root.addContent(logonXML.getTargetCompID().addContent(hostLogon.getTargetCompID()));
   root.addContent(logonXML.getEncryptMethod().addContent(hostLogon.getEncryptMethod()));
   System.out.println("**********valor de eMethod: " + hostLogon.getEncryptMethod());



   super.doc = new Document(root);
 System.out.println("********Mensaje XML antes de xsl: " + doc.toString() + "********");
   try{

    XMLOutputter out=new XMLOutputter(" ",true);
    FileOutputStream file=new FileOutputStream("ejemplo2.xml");
    out.output(doc,file);
   }catch(Exception e){
    e.printStackTrace();
   }

   return doc;
  }

}