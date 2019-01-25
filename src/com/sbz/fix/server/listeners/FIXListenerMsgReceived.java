package com.sbz.fix.server.listeners;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

import java.awt.event.*;
import com.sbz.fix.server.admin.pattern.mediator.FIXServerAdminConcreteMediator;
public class FIXListenerMsgReceived implements ActionListener{
  private FIXServerAdminConcreteMediator mediator = null;

  public FIXListenerMsgReceived() {
    mediator = new FIXServerAdminConcreteMediator();
  }

  public void actionPerformed(ActionEvent e){
   //  mediator.pushMsgReceived();
  }
}
