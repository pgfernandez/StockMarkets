package com.sbz.fix.gateway.handlers;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

import org.jdom.Document;

public abstract class Handler {

 protected org.jdom.Element root = null;
 protected org.jdom.Document doc = null;

 public abstract org.jdom.Document getFormattedMsg(String msg);

}