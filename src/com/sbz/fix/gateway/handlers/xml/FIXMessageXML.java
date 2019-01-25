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

public class FIXMessageXML {

 private org.jdom.Element senderCompID = null;
 private org.jdom.Element targetCompID = null;
 private org.jdom.Element date = null;

  public FIXMessageXML() {
    senderCompID = new Element("senderCompID");
    targetCompID = new Element("targetCompID");
    date = new Element("date");
  }

 public Element getSenderCompID(){

    return this.senderCompID;

  }

  public Element getTargetCompID(){

    return this.targetCompID;

  }
  public Element getDate(){

    return this.date;

  }

}