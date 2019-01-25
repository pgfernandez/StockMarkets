package com.sbz.fix.server.messages;

/**
 * Title:        FIXServer
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:      Reuters DSS
 * @author Pedro Garcia
 * @version 1.0
 */

public class Logout extends FIXMessage{

  /**
   * Logout para responder al cliente FIX.
   */
  private String logout = null;

 /**
   * Constructor, construye el Logout con el numero de secuencia actualizado.
   * @param secuencia Numero de secuencia.
   */
  public Logout(int secuencia){

     char DELIMITER = this.getDelimiter();

     logout = this.getEncabezado() + "5" + DELIMITER + "49=INET" + DELIMITER +
                 "56=Caixa" + DELIMITER + "52=20011218-12:23:45" + DELIMITER +
                  "58=Adios" + DELIMITER + "34=" + secuencia + DELIMITER;
  }

  /**
   * Constructor, construye el Logout.
   */
  public Logout(){

     char DELIMITER = this.getDelimiter();

     logout = this.getEncabezado() + "5" + DELIMITER + "49=INET" + DELIMITER +
                 "56=Caixa" + DELIMITER + "52=20011218-12:23:45" + DELIMITER +
                  "58=Adios" + DELIMITER;
  }

  /**
   * Devuelve el Logout construido.
   * @return String Logout construido.
   */
  public String getLogout(){

  return logout;
  }

}
