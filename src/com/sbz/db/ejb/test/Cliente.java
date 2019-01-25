package com.sbz.db.ejb.test;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

import com.sbz.db.ejb.DBManagerHomeRemote;
import com.sbz.db.ejb.DBManagerRemote;

import javax.naming.InitialContext;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import java.rmi.RemoteException;
//import com.sun.jndi.ldap.LdapCtxFactory;

import java.util.Hashtable;


public class Cliente {


  public static void main(String[] args) throws Exception {

    //Context ctx = null;
    //Hashtable env = new Hashtable();

//    env.put(Context.INITIAL_CONTEXT_FACTORY,  "com.sun.jndi.ldap.LdapCtxFactory");
    /*try{
    env.put(Context.INITIAL_CONTEXT_FACTORY,  "com.sun.jndi.url.ldap.ldapURLContextFactory");
*/
   // env.put(Context.PROVIDER_URL, "obelix");
     // env.put(Context.INITIAL_CONTEXT_FACTORY,  "org.jnp.interfaces.NamingContextFactory");


    //ctx = new InitialContext();//env);

/*   }catch(Exception e){
     e.printStackTrace();

   }*/
  // ctx = getInitialContext(env);

  /*  Context myEnv = (Context)initial.lookup("java:comp/env");

    Object obj = ctx.lookup("ejb/DBManagerHomeRemote");*/
    Object obj = null;
    try{
    //obj = ctx.lookup("java:comp/env/ejb/DBManager");
  //  obj = ctx.lookup("DBManagerEJB");
  Context jndiContext = getInitialContext();
   obj = jndiContext.lookup("DBManagerDB");

    }catch(Exception ex){
     ex.printStackTrace();
     }

//       Object obj = ctx.lookup("DBManager");

  // DBManagerHomeRemote home = (DBManagerHomeRemote)ctx.lookup("java:comp/env/ejb/DBManager");
 //DBManagerHomeRemote home = (DBManagerHomeRemote)ctx.lookup("DBManager");
    DBManagerHomeRemote home = (DBManagerHomeRemote)
    PortableRemoteObject.narrow(obj,DBManagerHomeRemote.class);



    StringBuffer stmt = new StringBuffer();

    stmt.append("INSERT INTO CURRENCIES (currency_id, currency_name) VALUES ('EUR','Euro')");

    try{
    DBManagerRemote remote = home.create();

    int rows = remote.executeInsert(stmt.toString());
    System.out.println("registros insertados: " + rows);
    }catch(Exception exc){
      exc.printStackTrace();
    }




  }


  public static Context getInitialContext() throws NamingException{

    return new InitialContext();

  }

}
