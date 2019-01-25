package com.sbz.data.dao;

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

import java.util.Date;

public class AccountDAO {

  private int account_id;
  private int account_type_id;
  private double free_balance;
  private double lock_balance;
  private double interest_rate;
  private Date date_opened;
  private Date date_closed;

  public void setAccountId(int account_id){
    this.account_id = account_id;
  }

  public int getAccountId(){
    return this.account_id;
  }

  public void setAccountTypeId(int account_type_id){
    this.account_type_id = account_type_id;
  }

  public int getAccountTypeId(){
    return this.account_type_id;
  }

  public void setFreeBalance(double free_balance){
    this.free_balance = free_balance;
  }

  public double getFreeBalance(){
    return this.free_balance;
  }

  public void setLockBalance(double lock_balance){
    this.lock_balance = lock_balance;
  }

  public double getLockBalance(){
    return this.lock_balance;
  }

  public void setInterestrate(double interest_rate){
    this.interest_rate = interest_rate;
  }

  public double getInterestRate(){
    return this.interest_rate;
  }

  public void setDateOpened(Date date_opened){
    this.date_opened = date_opened;
  }

  public Date getDateOpened(){
    return this.date_opened;
  }

  public void setDateClosed(Date date_closed){
    this.date_closed = date_closed;
  }

  public Date getDateClosed(){
    return this.date_closed;
  }

  public String toString(){
    return null;
  }

  public AccountDAO() {

  }
}
