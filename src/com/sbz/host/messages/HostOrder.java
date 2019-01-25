package com.sbz.host.messages;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */


import java.lang.reflect.Field;

public class HostOrder implements AccessorInterface{

  private Field messageType = null;

  private String m_messageType = null;
  private String m_brokerCode = null;
  private String m_orderId = null;
  private String m_isinCode = null;
  private String m_buySellIndex = null;
  private String m_market = null;
  private String m_quantity = null;

  public HostOrder() {
  }

  public String get(String attribute_name){


    return null;
  }

  public void set(String attribute_name, Object value){


  }


  public void setMessageType(String messageType)
  {
    m_messageType = messageType;
  }
  public void setBrokerCode(String brokerCode)
  {
    m_brokerCode = brokerCode;
  }
  public void setOrderId(String orderId)
  {
    m_orderId = orderId;
  }
  public void setIsinCode(String isinCode)
  {
    m_isinCode = isinCode;
  }
  public void setBuySellIndex(String buySellIndex)
  {
    m_buySellIndex = buySellIndex;
  }
  public void setMarket(String market)
  {
    m_market = market;
  }
  public String getMessageType()
  {
    return m_messageType;
  }
  public String getBrokerCode()
  {
    return m_brokerCode;
  }
  public String getOrderId()
  {
    return m_orderId;
  }
  public String getIsinCode()
  {
    return m_isinCode;
  }
  public String getBuySellIndex()
  {
    return m_buySellIndex;
  }
  public String getMarket()
  {
    return m_market;
  }
  public void setQuantity(String quantity){
    this.m_quantity = quantity;
  }
  public String getQuantity(){
    return this.m_quantity;
  }


}