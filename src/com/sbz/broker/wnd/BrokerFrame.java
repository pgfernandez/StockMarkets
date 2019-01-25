package com.sbz.broker.wnd;

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

 public class BrokerFrame extends JFrame {
  JMenuBar jmMenu = new JMenuBar();
  JTabbedPane jtpOperations = new JTabbedPane();
  JScrollPane jspLog = new JScrollPane();
  JTable jtLogMessages = new JTable();
  JMenu jmiArchive = new JMenu();
  JMenu jMenu2 = new JMenu();
  JMenu jMenu3 = new JMenu();
  JMenu jMenu4 = new JMenu();
  JMenu jMenu5 = new JMenu();
  JPanel jpNews = new JPanel();

  public BrokerFrame() {
  try{
   jbInit();
  }catch(Exception e){

  }
  }

  private void jbInit()
  {
    this.setSize(new Dimension(1024,768));
    this.setVisible(true);
    this.getContentPane().setLayout(null);
    jtpOperations.setBounds(new Rectangle(17, 19, 345, 293));
    jtpOperations.addTab("Buy/Sell",null);
    jtpOperations.addTab("Historic",null);
    jspLog.setBounds(new Rectangle(4, 668, 1017, 95));
    jmiArchive.setText("Archive");
    jMenu2.setText("Operations");
    jMenu3.setText("News");
    jMenu4.setText("Markets");
    jMenu5.setText("Help");
    jpNews.setBorder(BorderFactory.createLineBorder(Color.black));
    jpNews.setBounds(new Rectangle(18, 323, 341, 234));
    jpNews.setLayout(null);
    this.getContentPane().add(jtpOperations, null);
    this.getContentPane().add(jspLog, null);
    this.getContentPane().add(jpNews, null);
    jspLog.getViewport().add(jtLogMessages, null);
    jmMenu.add(jmiArchive);
    jmMenu.add(jMenu2);
    jmMenu.add(jMenu3);
    jmMenu.add(jMenu4);
    jmMenu.add(jMenu5);

  }
  public static void main(String args[])
  {
    BrokerFrame bFrame = new BrokerFrame();
  }

}