package com.sbz.host.messages;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

import java.util.Hashtable;



public class MessageTypeTable{

   private Hashtable hostEquivalences = null;
   private Hashtable repositoryEquivalences = null;

   public MessageTypeTable(){
    initializeHost();
    initializeRepository();
   }

   public String getValue(String key){

      Object o = hostEquivalences.get(key);

      String value = (String)o;

      return value;


   }

   private void initializeHost(){

     hostEquivalences = new Hashtable();

     hostEquivalences.put("A ", "HostNewOrder");
     hostEquivalences.put("B ", "HostCancelOrderRequest");
     hostEquivalences.put("M ", "HostAmendOrderRequest");
     hostEquivalences.put("CA", "HostNewOrderConfirmation");
     hostEquivalences.put("CB", "HostCancelOrderConfirmaction");
     hostEquivalences.put("CM", "HostAmendOrderConfirmation");
     hostEquivalences.put("E ", "HostExecutionReport");
     hostEquivalences.put("X ", "ConnectionTest");

   }

   private void initializeRepository(){

    /*repositoryEquivalences = new Hashtable();

    repositoryEquivalences.put("A ",)*/

   }



}