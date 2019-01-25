package com.sbz.db.ejb;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

import javax.ejb.SessionBean;
import java.rmi.RemoteException;

import javax.ejb.SessionContext;
import javax.ejb.EJBException;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import java.sql.Connection;
import java.sql.Statement;
import javax.sql.DataSource;
import java.sql.SQLException;


public class DBManagerBean implements SessionBean{

  protected SessionContext context;
  private InitialContext initContext = null;
  private Connection conDB = null;

  public void ejbCreate(){
   try{
    initContext = new InitialContext();
    conDB = getConnection();


   }catch(NamingException ne){
    ne.printStackTrace();

   }catch(SQLException sqle){
    sqle.printStackTrace();
   }


  }

  private Connection getConnection() throws SQLException{

    //String dsName = "java:comp/env/jdbc/tradiaDB";
    //String dsName = "java:comp/env/jdbc/Tradia";
    String dsName = "MySqlDS";
    try{
      //Object obj = initContext.lookup(dsName);
      //System.out.println("tipo de objeto: " + obj.toString());
      DataSource ds = (DataSource)initContext.lookup(dsName);

      Connection con = ds.getConnection();
      //Connection con = null;
      return con;

    }catch(Exception e){

      e.printStackTrace();

    }

    return null;



  }


  public int executeInsert(String query){


    try{
      Statement st = conDB.createStatement();

      int rows = st.executeUpdate(query);

      return rows;
    }catch(SQLException sqle){
      sqle.printStackTrace();
    }
    return 0;

  }

  public void ejbActivate(){
    System.out.println("DBManager-----Activated");

  }
  public void ejbPassivate(){
     System.out.println("DBManager-----Passivated");
  }
  public void ejbRemove(){
     System.out.println("DBManager-----Removed");
  }
  public void setSessionContext(SessionContext ctx){}






}
