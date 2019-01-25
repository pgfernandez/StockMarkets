package com.sbz.db.cache;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

import com.sbz.data.types.MessageMap;

 public class CacheSet {

 private MessageMap cache = new MessageMap();


  public CacheSet() {
  }


  public Object getResult(String type, String id){

   StringBuffer key = new StringBuffer();

   key.append(type).append("_").append(id);

   Object result = findByPrimaryKey(key.toString());

   if(result==null){ //not included within cache.

    //busqueda
    //cache.put(key, Object);

    return result;

   }
   else{
     return result;

   }

  }

  private Object findByPrimaryKey(String key){

   Object object = cache.get(key);

   return object;

  }



}