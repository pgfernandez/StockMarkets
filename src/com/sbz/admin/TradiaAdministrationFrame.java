package com.sbz.admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

public class TradiaAdministrationFrame extends JFrame {
  JButton jbArrancaServidor = new JButton();
  JTextField jtf_estado = new JTextField();

  public TradiaAdministrationFrame() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  public static void main(String[] args) {
    TradiaAdministrationFrame tradiaAdministrationFrame = new TradiaAdministrationFrame();
  }
  private void jbInit() throws Exception {
    jbArrancaServidor.setBounds(new Rectangle(44, 68, 124, 25));
    jbArrancaServidor.setText("Arrancar Servidor");
    jbArrancaServidor.addActionListener(new TradiaAdministrationFrame_jbArrancaServidor_actionAdapter(this));
    this.getContentPane().setLayout(null);
    jtf_estado.setText("");
    jtf_estado.setBounds(new Rectangle(181, 68, 142, 25));
    this.getContentPane().add(jbArrancaServidor, null);
    this.getContentPane().add(jtf_estado, null);
    this.show();
  }

  void jbArrancaServidor_actionPerformed(ActionEvent e) {
   /* com.sbz.fix.server.main.FIXServer f = new com.sbz.fix.server.main.FIXServer();
    boolean estado = f.arranca();
    if(estado){
      jtf_estado.setText("servidor arrancado");

  }else{
       jtf_estado.setText("el servidor no pudo arrancar");
  }*/
}
}
class TradiaAdministrationFrame_jbArrancaServidor_actionAdapter implements java.awt.event.ActionListener {
  TradiaAdministrationFrame adaptee;

  TradiaAdministrationFrame_jbArrancaServidor_actionAdapter(TradiaAdministrationFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jbArrancaServidor_actionPerformed(e);
  }
}
