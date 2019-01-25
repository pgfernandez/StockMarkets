package com.sbz.host.messages;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

public class MessageClassFactory {

  public MessageClassFactory() {
  }

  public Class getMessageClass(String type){

   try{
    return Class.forName(type);
  }catch(Exception e){
   e.printStackTrace();
  }
   return null;
  }

  public Object newInstance(Class c){
   try{
   return c.newInstance();
   }catch(Exception e){
    e.printStackTrace();
   }
   return null;
  }


 /* public static void main(String args[]){


   MessageClassFactory m = new MessageClassFactory();

   Class test = m.getMessageClass("com.sbz.host.messages.HostNewOrder");
   System.out.println("clase instanciada: " + test.getName());


  }*/

}