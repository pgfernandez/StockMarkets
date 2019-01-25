package com.sbz.core.tibco;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

import com.tibco.sdk.MApp;
import com.tibco.sdk.MAppProperties;
import com.tibco.sdk.MException;

public class Adapter extends MApp{

  public Adapter(MAppProperties m){super(m);}
  public void onTermination() throws MException{}
  public void onInitialization() throws MException{}
  private void writeLog(String message){}
}
