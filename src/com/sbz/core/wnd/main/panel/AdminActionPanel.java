package com.sbz.core.wnd.main.panel;

import java.awt.*;
import javax.swing.*;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import com.sbz.core.wnd.main.beans.TradiaServiceBean;
import com.sbz.core.Tradia;
import com.sbz.core.wnd.main.swing.TradiaServicesTreeModel;
import java.awt.event.*;


/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

public class AdminActionPanel extends JPanel implements TreeSelectionListener{
  JToggleButton jTButton_Stop = new JToggleButton();
  JTree jTree_Services = null;
  JButton jbutton_StartTradia = new JButton();
  JTextField jtextf_Status = new JTextField();
  JPanel jPanel_StartStopButtons = new JPanel();
  JToggleButton jTButton_Start = new JToggleButton();
  private Tradia tradia = null;
  private TradiaServiceBean serviceBean = null;
  public AdminActionPanel(Tradia tradia) {
     this.tradia = tradia;
     jTree_Services = new JTree(this.loadTree());
    try {

      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    jbutton_StartTradia.setText("Start FIX Gateway");
    jbutton_StartTradia.addActionListener(new AdminActionPanel_jbutton_StartTradia_actionAdapter(this));
    jbutton_StartTradia.setBounds(new Rectangle(241, 114, 135, 24));
    jTree_Services.setBounds(new Rectangle(2, 3, 217, 214));
    jTButton_Stop.setActionCommand("jTB_Stop");
    jTButton_Stop.setBorder(BorderFactory.createLineBorder(Color.black));
    jTButton_Stop.setText("Stop");
    jTButton_Stop.setBounds(new Rectangle(9, 45, 80, 24));
    this.setLayout(null);
    jTree_Services.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
    jTree_Services.addTreeSelectionListener(this);
    jtextf_Status.setBounds(new Rectangle(257, 163, 106, 21));
    jPanel_StartStopButtons.setBorder(BorderFactory.createEtchedBorder());
    jPanel_StartStopButtons.setBounds(new Rectangle(252, 10, 107, 86));
    jPanel_StartStopButtons.setLayout(null);
    jTButton_Start.setBorder(BorderFactory.createLineBorder(Color.black));
    jTButton_Start.setActionCommand("jTB_Start");
    jTButton_Start.setText("Start");
    jTButton_Start.setEnabled(false);
    jTButton_Stop.setEnabled(false);
    jTButton_Start.setBounds(new Rectangle(9, 11, 80, 24));
    jTButton_Start.addActionListener(new AdminActionPanel_jTButton_Start_actionAdapter(this));
    jPanel_StartStopButtons.add(jTButton_Start, null);
    jPanel_StartStopButtons.add(jTButton_Stop, null);
    this.add(jbutton_StartTradia, null);
    this.add(jtextf_Status, null);
    this.add(jTree_Services, null);
    this.add(jPanel_StartStopButtons, null);
  }

  public void valueChanged(TreeSelectionEvent e) {
   System.out.println("he entrado en el evento de tree");
    DefaultMutableTreeNode node = (DefaultMutableTreeNode)
        jTree_Services.getLastSelectedPathComponent();

    if (node == null)return;


    if (node.isLeaf()) {
      serviceBean = (TradiaServiceBean) node.getUserObject();
      System.out.println("he entrado en nodo seleccionado");
      boolean serviceStatus;
      serviceStatus = serviceBean.getServiceStatus();
       System.out.println("valor de short en ActionPanel: " + serviceBean.getShortServiceName());
      System.out.println("el estado del servicio es: " + serviceBean.getServiceStatus());
      if (serviceStatus) { //service running
        jTButton_Start.setEnabled(false);
        jTButton_Stop.setEnabled(true);
      }else{
        jTButton_Start.setEnabled(true);
        jTButton_Stop.setEnabled(false);
      }
    }
  }

  private TradiaServicesTreeModel loadTree(){
   TradiaServicesTreeModel treeModel = new TradiaServicesTreeModel(tradia.getAvailableServices());
   return treeModel;
 }

  void jTButton_Start_actionPerformed(ActionEvent e) {
    String estado;

     estado = tradia.startTradiaService(serviceBean.getShortServiceName());

  }

  void jbutton_StartTradia_actionPerformed(ActionEvent e) {
    tradia.startServices();
  }

}

class AdminActionPanel_jTButton_Start_actionAdapter implements java.awt.event.ActionListener {
  AdminActionPanel adaptee;

  AdminActionPanel_jTButton_Start_actionAdapter(AdminActionPanel adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jTButton_Start_actionPerformed(e);
  }
}

class AdminActionPanel_jbutton_StartTradia_actionAdapter implements java.awt.event.ActionListener {
  AdminActionPanel adaptee;

  AdminActionPanel_jbutton_StartTradia_actionAdapter(AdminActionPanel adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jbutton_StartTradia_actionPerformed(e);
  }
}
