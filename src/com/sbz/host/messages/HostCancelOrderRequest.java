package com.sbz.host.messages;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

public class HostCancelOrderRequest extends HostOrder{

  private String m_messageToTreat = null;
  private String m_cancelOrderId = null;


  public HostCancelOrderRequest(String hostMessage) {

   m_messageToTreat = hostMessage;
   createOrder();
  }

  public void setCancelOrderId(String cancelOrderId){

    this.m_cancelOrderId = cancelOrderId;

  }

  public String getCancelOrderId(){

    return this.m_cancelOrderId;

  }

  public void createOrder(){

   super.setMessageType(m_messageToTreat.substring(0,2));
   super.setBrokerCode(m_messageToTreat.substring(2,10));
   this.setCancelOrderId(m_messageToTreat.substring(10,22));
   super.setOrderId(m_messageToTreat.substring(22,34));
   super.setBuySellIndex(m_messageToTreat.substring(34,35));
   super.setIsinCode(m_messageToTreat.substring(35,47));
   super.setQuantity(m_messageToTreat.substring(47,53));
   super.setMarket(m_messageToTreat.substring(53,54));
 }



}