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
public class BrokerDealsDAO {

  private int broker_deal_id;
  private int broker_id;
  private int amount;
  private String side;
  private String cleared;

  void setBrokerDealId(int broker_deal_id){
    this.broker_deal_id = broker_deal_id;
  }

  public int getBrokerDealId(){
    return this.broker_deal_id;
  }

  void setBrokerId(int broker_id){
    this.broker_id = broker_id;
  }

  public int getBrokerId(){
    return this.broker_id;
  }

  void setAmount(int amount){
    this.amount = amount;
  }

  public int getAmount(){
    return this.amount;
  }

  void setSide(String side){
    this.side = side;
  }

  public String getSide(){
    return this.side;
  }

  void setCleared(String cleared){
    this.cleared = cleared;
  }

  public String getCleared(){
    return this.cleared;
  }

  public String toString(){
    return null;
  }

  public BrokerDealsDAO() {
  }
}
