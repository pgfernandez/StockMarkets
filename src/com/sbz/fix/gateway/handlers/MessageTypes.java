package com.sbz.fix.gateway.handlers;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

//Sirve para buscar el tipo de handler para
//manejar la petición de envío.
//Nota: para la traducción implementarlo en las
//hojas de estilo.
public final class MessageTypes {

  public static String NEW_ORDER = "A ";
  public static String CANCEL_ORDER = "B ";
  public static String AMEND_ORDER = "M ";
  public static String LOGON = "LN";
 // private static String FIX_LOGON
  public static String LOGOUT = "LT";


}