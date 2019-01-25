package com.sbz.host.messages;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

public class HostAmendOrderRequest extends HostNewOrder{

  private String messageToTreat = null;
  private String m_amendOrderId = null;

  public HostAmendOrderRequest(String message) {
   this.messageToTreat = message;
   createOrder();
  }

  public void setAmendOrderId(String amendOrderId){

    this.m_amendOrderId = amendOrderId;
  }

  public String getAmendOrderId(){
    return this.m_amendOrderId;
  }

  public void createOrder(){
   super.setMessageType(messageToTreat.substring(0,2));
   super.setBrokerCode(messageToTreat.substring(2,10));
   this.setAmendOrderId(messageToTreat.substring(10,22));
   super.setOrderId(messageToTreat.substring(22,34));
   super.setBuySellIndex(messageToTreat.substring(34,35));
   super.setIsinCode(messageToTreat.substring(35,47));
   this.setCurrency(messageToTreat.substring(47,50));
   super.setQuantity(messageToTreat.substring(50,56));
   this.setOrderType(messageToTreat.substring(56,57));
   this.setPriceLimit(messageToTreat.substring(57,73));
   this.setTimeInForce(messageToTreat.substring(73,74));
   this.setDateLimit(messageToTreat.substring(74,91));
   this.setCurrencyLiq(messageToTreat.substring(91,94));
   this.setAccount(messageToTreat.substring(94,114));
   this.setInstructions(messageToTreat.substring(114,115));
   this.setProcessCode(messageToTreat.substring(115,116));
   super.setMarket(messageToTreat.substring(116,117));
   this.setText(messageToTreat.substring(118,119));


  }

}