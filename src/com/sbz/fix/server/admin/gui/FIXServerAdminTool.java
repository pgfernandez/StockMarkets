package com.sbz.fix.server.admin.gui;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

import javax.swing.*;
import java.awt.*;
import com.sbz.fix.server.main.FIXServer;
import com.sbz.fix.server.admin.pattern.mediator.*;
import java.awt.event.*;

public class FIXServerAdminTool extends JFrame{
  JLabel jLEstadoLabel = new JLabel();
  JLabel jLServerStatus = new JLabel();
  JToggleButton jTB_Parar = new JToggleButton();
  JToggleButton jTB_Arrancar = new JToggleButton();
  JTextArea jTA_InMsg = new JTextArea();

  private FIXServerAdminConcreteMediator mediator = null;
  private FIXServer fixServer = null;

  public FIXServerAdminTool() {

    mediator = new FIXServerAdminConcreteMediator();

    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }


  public static void main(String[] args) {
    FIXServerAdminTool FIXServerAdminTool1 = new FIXServerAdminTool();
  }
  private void jbInit() throws Exception {
    jLEstadoLabel.setText("Server Status:");
    jLEstadoLabel.setBounds(new Rectangle(18, 64, 92, 29));
    this.getContentPane().setLayout(null);
    this.setSize(1024,768);
    jLServerStatus.setText("");
    jLServerStatus.setBounds(new Rectangle(128, 63, 109, 32));
    jTB_Parar.setText("Stop Server");
    jTB_Parar.setBounds(new Rectangle(46, 127, 119, 35));
    jTB_Parar.addActionListener(new FIXServerAdminTool_jTB_Parar_actionAdapter(this));
    jTB_Arrancar.setText("Start Server");
    jTB_Arrancar.setBounds(new Rectangle(175, 127, 119, 36));
    jTB_Arrancar.addActionListener(new FIXServerAdminTool_jTB_Arrancar_actionAdapter(this));
    jTA_InMsg.setBounds(new Rectangle(33, 223, 452, 88));
    this.getContentPane().add(jLEstadoLabel, null);
    this.getContentPane().add(jTB_Parar, null);
    this.getContentPane().add(jTB_Arrancar, null);
    this.getContentPane().add(jTA_InMsg, null);
    this.getContentPane().add(jLServerStatus, null);
    this.setVisible(true);

  }

  void jTB_Parar_actionPerformed(ActionEvent e) {
   jTB_Arrancar.setSelected(false);
   fixServer = null;
  jTA_InMsg.setText("FIX Server Parado");
  }

  void jTB_Arrancar_actionPerformed(ActionEvent e) {
    jTB_Parar.setSelected(false);
    if (fixServer==null){
      fixServer = new FIXServer(mediator);
      boolean estado = fixServer.arranca();
      if(estado){
        jTA_InMsg.setText("FIX Server Arrancado");
      }
    }

  }


}

class FIXServerAdminTool_jTB_Parar_actionAdapter implements java.awt.event.ActionListener {
  FIXServerAdminTool adaptee;

  FIXServerAdminTool_jTB_Parar_actionAdapter(FIXServerAdminTool adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jTB_Parar_actionPerformed(e);
  }
}

class FIXServerAdminTool_jTB_Arrancar_actionAdapter implements java.awt.event.ActionListener {
  FIXServerAdminTool adaptee;

  FIXServerAdminTool_jTB_Arrancar_actionAdapter(FIXServerAdminTool adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jTB_Arrancar_actionPerformed(e);
  }
}
