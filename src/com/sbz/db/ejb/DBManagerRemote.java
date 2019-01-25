package com.sbz.db.ejb;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

import javax.ejb.EJBObject;
//import javax.ejb.EJBLocalObject;
import java.rmi.RemoteException;


public interface DBManagerRemote extends EJBObject {

  public int executeInsert(String query) throws RemoteException;

}