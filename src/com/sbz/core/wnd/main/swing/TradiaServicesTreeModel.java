package com.sbz.core.wnd.main.swing;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import com.sbz.services.TradiaService;
import com.sbz.core.wnd.main.beans.TradiaServiceBean;
import java.util.ArrayList;


public class TradiaServicesTreeModel extends DefaultMutableTreeNode{

  private static final String topNode = "Tradia Available Services";
  private ArrayList nodes = null;
  private DefaultMutableTreeNode childNodes = null;
  private TradiaServiceBean serviceBean = new TradiaServiceBean();

  public TradiaServicesTreeModel(ArrayList nodes) {
    super(topNode);
    this.nodes = nodes;
    this.loadNodes();
  }

  private void loadNodes(){

    for (int i = 0; i < nodes.size(); i++){
      serviceBean = (TradiaServiceBean)nodes.get(i);
//      childNodes = new DefaultMutableTreeNode(new TradiaServiceBean(((TradiaService)nodes.get(i)).getName(), ((TradiaService)nodes.get(i)).getServiceDescription()));
      childNodes = new DefaultMutableTreeNode(serviceBean);
      this.add(childNodes);
    }
  }



}
