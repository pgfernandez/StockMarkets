package com.sbz.broker.wnd;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;


/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

public class OrderAdminFrame extends JFrame {
  JTabbedPane tabbedPanel = new JTabbedPane();
  JPanel operationPanel = new JPanel();
  TitledBorder titledBorder1;

  public OrderAdminFrame() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  public static void main(String[] args) {
    OrderAdminFrame orderAdminFrame1 = new OrderAdminFrame();
    orderAdminFrame1.setVisible(true);
  }
  private void jbInit() throws Exception {
    titledBorder1 = new TitledBorder("");
    this.getContentPane().setLayout(null);
    tabbedPanel.setBounds(new Rectangle(10, 19, 149, 424));
    operationPanel.setBackground(SystemColor.textHighlight);
    operationPanel.setBorder(titledBorder1);
    operationPanel.setBounds(new Rectangle(162, 20, 315, 426));
    this.getContentPane().add(tabbedPanel, null);
    this.getContentPane().add(operationPanel, null);
    this.setSize(1024,768);
  }
}