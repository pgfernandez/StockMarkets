package com.sbz.core.wnd.main;

import javax.swing.*;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import java.awt.*;
import com.sbz.core.Tradia;
import java.awt.event.*;
import javax.swing.border.*;
import com.sbz.core.wnd.main.swing.TradiaServicesTreeModel;
import com.sbz.core.wnd.main.panel.AdminActionPanel;
/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

public class TradiaGatewayAdminTool extends JFrame {
  JTabbedPane jtabbedOptions = new JTabbedPane();
//  JPanel jpanelAction = new JPanel();
  private AdminActionPanel jpanelAction = null;
  JPanel jpanelGraphics = new JPanel();
  private Tradia tradia = null;
  TitledBorder titledBorder1;
  TitledBorder titledBorder2;

  public TradiaGatewayAdminTool() {
    try {
      tradia = new Tradia(true);
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    jpanelAction = new AdminActionPanel(tradia);
    titledBorder1 = new TitledBorder("");
    titledBorder2 = new TitledBorder("");
    this.setTitle("Tradia FIX Gateway Administrator");
    this.getContentPane().setLayout(null);
    jtabbedOptions.setTabPlacement(JTabbedPane.LEFT);
    jtabbedOptions.setDoubleBuffered(true);
    jtabbedOptions.setBounds(new Rectangle(33, 30, 889, 474));

    jtabbedOptions.add(jpanelGraphics, "Graphic");
    jtabbedOptions.add(jpanelAction, "Management");
    this.getContentPane().add(jtabbedOptions, null);
    this.setSize(new Dimension(1024,768));
    jtabbedOptions.setSelectedIndex(0);
    jtabbedOptions.setSelectedComponent(jpanelAction);

    this.show();



  }



  public static void main(String[] args) {
    TradiaGatewayAdminTool tradiaGatewayAdminTool = new TradiaGatewayAdminTool();
  }

}

