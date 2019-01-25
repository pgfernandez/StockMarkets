package com.sbz.data.dao.hibernate;

/**
 * <p>Title: FIX Engine</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2002</p>
 *
 * <p>Company: Somebiz Networks</p>
 *
 * @author Pedro Garcia
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import com.sbz.data.dao.*;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.cfg.Configuration;
import net.sf.hibernate.tool.hbm2ddl.SchemaExport;



public class TestHibernate {

  private SessionFactory _sessions;
  public void configure() throws HibernateException {
    _sessions = new Configuration()
        .addClass(AccountDAO.class)
        .buildSessionFactory();
  }

  /*public void exportTables() throws HibernateException {
    Configuration cfg = new Configuration()
        .addClass(AccountDAO.class);
        new SchemaExport(cfg).create(true, true);
}*/

      public AccountDAO createAccount(int id) throws HibernateException {
        AccountDAO account = new AccountDAO();
        account.setAccountId(id);
        account.setAccountTypeId(1);
        account.setDateOpened(new java.util.Date());
        account.setDateClosed(new java.util.Date());
        account.setFreeBalance(2000.98);
        account.setLockBalance(289.56);
        account.setInterestrate(2.45);


        Session session = _sessions.openSession();
        Transaction tx = null;
        try {
          tx = session.beginTransaction();
          session.save(account);
          tx.commit();
        }
        catch (HibernateException he) {
          if (tx!=null) tx.rollback();
          throw he;
        }
        finally {
          session.close();
        }
        return account;
}


  public TestHibernate() {
  }

  public static void main(String args[]){
    TestHibernate test = new TestHibernate();
    try{
       test.configure();
       test.createAccount(1);
    }catch(Exception e){
      e.printStackTrace();
    }
  }
}
