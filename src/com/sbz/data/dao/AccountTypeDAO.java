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
public class AccountTypeDAO {

  private int account_type_id;
  private String description;

  void setAccountTypeId(int account_type_id){
    this.account_type_id = account_type_id;
  }

  public int getAccountTypeId(){
    return this.account_type_id;
  }

  void setDescription(String description){
    this.description = description;
  }

  public String getDescription(){
    return this.description;
  }

  public String toString(){
    return null;
  }

  public AccountTypeDAO() {

  }
}
