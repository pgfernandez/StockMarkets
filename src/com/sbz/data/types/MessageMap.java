package com.sbz.data.types;

import java.util.HashMap;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

public class MessageMap extends HashMap implements SearchInterface{

  private Object requested = null;
  public MessageMap() {
  }

  public MessageMap(int initialCapacity, float loadFactor){

   super(initialCapacity, loadFactor);

  }

  public void addElement(Object key,Object element){
   this.put(key,element);
  }

  public Object findByPrimaryKey(String key){

   requested = this.get(key);
   return requested;
  }

}
