package com.sbz.db.ejb;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */



import javax.ejb.EJBHome;
//import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;
import java.rmi.RemoteException;

public interface DBManagerHomeRemote extends EJBHome {


  public DBManagerRemote create() throws CreateException, RemoteException;


}