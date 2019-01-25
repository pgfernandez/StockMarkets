package com.sbz.fix.server.admin.pattern.mediator;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

public class FIXServerAdminConcreteMediator implements FIXServerAdminMediator{
  public FIXServerAdminConcreteMediator() {
  }

  public void pushMsgSent(String msg){};
  public void pushMsgReceived(String msg){};
  public void pushStatus(String status){};
  public boolean startStop(boolean action){return false;};

}
