package com.sbz.core.wnd;

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

public class TradiaWindow extends JFrame {
  JMenuBar menuBar = new JMenuBar();
  JTabbedPane tabbedPane = new JTabbedPane();
  JMenu jMenu1 = new JMenu();
  JMenu jMenu2 = new JMenu();
  JMenuItem jMenuItem1 = new JMenuItem();

  public TradiaWindow() throws HeadlessException {
    try {
      jbInit();
      menuBar.add(new JMenu("Archive"));
      this.getContentPane().add(menuBar);

     // this.getContentPane().add(tabbedPane);
      this.setSize(new Dimension(1024,768));
      this.show();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }






  public static void main(String[] args) throws HeadlessException {
    TradiaWindow tradiaWindow1 = new TradiaWindow();
  }
  private void jbInit() throws Exception {
    this.getContentPane().setLayout(null);
    tabbedPane.setBounds(new Rectangle(0, 0, 527, 454));
    jMenu2.setText("Archive");
    jMenuItem1.setText("Exit");
    this.getContentPane().add(tabbedPane, null);
    menuBar.add(jMenu2);
    menuBar.add(jMenu1);
    jMenu2.add(jMenuItem1);
  }

}