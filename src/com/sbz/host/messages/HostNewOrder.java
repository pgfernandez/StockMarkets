package com.sbz.host.messages;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

import java.util.Date;

public class HostNewOrder extends HostOrder {

  private String messageToTreat = null;
  private String m_account = null;
  private String m_currency = null;
  private String m_origHostOrderId = null;
  private String m_dateLimit = null;
  private String m_priceLimit = null;
  private String m_orderType = null;
 // private String m_quantity = null;
  private String m_processCode = null;
  private String m_currencyLiq = null;
  private String m_timeInForce = null;
  private String m_instructions = null;
  private String m_text = null;

  public HostNewOrder(){
  }

  public HostNewOrder(String hostMessage) {
   messageToTreat = hostMessage;
   createNewOrder();
  }

  public String get(String attributte_name){

    if (attributte_name.equals("brokerCode")){
     return super.getBrokerCode();
    }
    return "hola";
  }

  public void setAccount(String account)
  {
    m_account = account;
  }
  public void setCurrency(String currency)
  {
    m_currency = currency;
  }
  public void setOrigHostOrderId(String origHostOrderId)
  {
    m_origHostOrderId = origHostOrderId;
  }
  public void setDateLimit(String dateLimit)
  {
    m_dateLimit = dateLimit;
  }
  public void setPriceLimit(String priceLimit)
  {
    m_priceLimit = priceLimit;
  }
  public void setOrderType(String orderType)
  {
    m_orderType = orderType;
  }
  /*public void setQuantity(String quantity)
  {
    m_quantity = quantity;
  }*/
  public void setCurrencyLiq(String currencyLiq)
  {
    m_currencyLiq = currencyLiq;
  }
  public void setText(String text)
  {
    m_text = text;
  }
  public void setInstructions(String instructions)
  {
    m_instructions = instructions;
  }
  public void setTimeInForce(String timeInForce)
  {
    m_timeInForce = timeInForce;
  }
  public void setProcessCode(String processCode)
  {
    m_processCode = processCode;
  }
  public String getAccount()
  {
    return m_account;
  }
  public String getCurrency()
  {
    return m_currency;
  }
  public String getOrigHostOrderId()
  {
    return m_origHostOrderId;
  }
  public String getDateLimit()
  {
    return m_dateLimit;
  }
  public String getPriceLimit()
  {
    return m_priceLimit;
  }
  public String getOrderType()
  {
    return m_orderType;
  }
/*  public String getQuantity()
  {
    return m_quantity;
  }*/
  public String getCurrencyLiq()
  {
    return m_currencyLiq;
  }
  public String getText()
  {
    return m_text;
  }
  public String getInstructions()
  {
    return m_instructions;
  }
  public String getTimeInForce()
  {
    return m_timeInForce;
  }
  public String getProcessCode()
  {
    return m_processCode;
  }

  private void createNewOrder()
  {
   super.setMessageType(messageToTreat.substring(0,2));
   super.setBrokerCode(messageToTreat.substring(2,10));
   super.setOrderId(messageToTreat.substring(10,22));
   super.setBuySellIndex(messageToTreat.substring(22,23));
   super.setIsinCode(messageToTreat.substring(23,35));
   this.setCurrency(messageToTreat.substring(35,38));
   super.setQuantity(messageToTreat.substring(38,54));
   this.setOrderType(messageToTreat.substring(54,55));
   this.setPriceLimit(messageToTreat.substring(55,71));
   this.setTimeInForce(messageToTreat.substring(71,72));
   this.setDateLimit(messageToTreat.substring(72,89));
   this.setCurrencyLiq(messageToTreat.substring(89,92));
   this.setAccount(messageToTreat.substring(92,112));
   this.setInstructions(messageToTreat.substring(112,113));
   this.setProcessCode(messageToTreat.substring(113,114));
   super.setMarket(messageToTreat.substring(114,115));
   this.setText(messageToTreat.substring(115,116));
  }



}