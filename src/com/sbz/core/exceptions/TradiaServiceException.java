package com.sbz.core.exceptions;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

public class TradiaServiceException extends Exception {
  public TradiaServiceException() {
  }

  public String getMessage(){
    //meter mensaje en dictionary
    return ("Error can´t not initialize ");
  }

}
