package com.sbz.host.messages;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

public interface AccessorInterface { //throws atribute not found

  public String get(String attribute_name);

  public void set(String attribute_name, Object value);


}