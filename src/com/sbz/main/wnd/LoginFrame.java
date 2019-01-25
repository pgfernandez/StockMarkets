package com.sbz.main.wnd;

import javax.swing.*;
import java.awt.*;


/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

public class LoginFrame extends JFrame {
  private JTextField jtUser;
  private JPasswordField jpwPass;
  private JLabel jlUser;
  private JLabel jlPass;
  private JButton jbVerify;

  public LoginFrame() {
    try {

      jtUser    = new JTextField();
      jpwPass   = new JPasswordField();
      jlUser    = new JLabel();
      jlPass    = new JLabel();
      jbVerify  = new JButton();
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  public static void main(String[] args) {
    LoginFrame loginFrame1 = new LoginFrame();
  }
  private void jbInit() throws Exception {

    this.setTitle("SBZ AUTHENTICATION PROCESS");
    jlPass.setText("PASSWORD:");
    jlPass.setBounds(new Rectangle(30, 69, 95, 24));
    jlUser.setText("USER ID:");
    jlUser.setBounds(new Rectangle(29, 38, 89, 25));
    jtUser.setBounds(new Rectangle(256, 53, 118, 23));
    this.getContentPane().setLayout(null);
    jtUser.setBounds(new Rectangle(127, 39, 116, 23));
    jbVerify.setBounds(new Rectangle(76, 108, 109, 29));
    jbVerify.setText("VERIFY");
    jpwPass.setBounds(new Rectangle(127, 69, 114, 23));
    this.getContentPane().add(jbVerify, null);
    this.getContentPane().add(jlPass, null);
    this.getContentPane().add(jlUser, null);
    this.getContentPane().add(jtUser, null);
    this.getContentPane().add(jpwPass, null);
    this.setSize(new Dimension(400, 199));
    this.setVisible(true);

  }
}