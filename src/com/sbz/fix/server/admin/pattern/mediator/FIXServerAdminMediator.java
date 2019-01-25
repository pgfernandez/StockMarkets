package com.sbz.fix.server.admin.pattern.mediator;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: Interfaz que representa al mediador en dicho patrón</p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */


public interface FIXServerAdminMediator {

  void pushMsgSent(String msg);
  void pushMsgReceived(String msg);
  void pushStatus(String status);
  //int sequenceReset();
  boolean startStop(boolean action);

}
