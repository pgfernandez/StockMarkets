package com.sbz.fix.server.messages;

/**
 * Title:        FIXServer
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:      Somebiz Networks
 * @author Pedro Garcia
 * @version 1.0
 */

public class Logon extends FIXMessage{

  /**
   * Logon para responder al cliente FIX.
   */
  private String mensaje = null;

  /**
   * Constructor, construye el Logon con el numero de secuencia actualizado.
   * @param secuencia Numero de secuencia.
   */
  public Logon(int secuencia) {

  char DELIMITER = this.getDelimiter();

  mensaje = this.getEncabezado() + "A" + DELIMITER + "49=INET" + DELIMITER +
              "56=Caixa" + DELIMITER + "52=20011218-12:23:45" + DELIMITER +
              "98=0" + DELIMITER + "108=120" + DELIMITER + "34=" +
              secuencia + DELIMITER;

  }

  /**
   * Constructor, construye el Logon.
   */
  public Logon() {

  char DELIMITER = this.getDelimiter();

  mensaje = this.getEncabezado() + "A" + DELIMITER + "49=INET" + DELIMITER +
              "56=Caixa" + DELIMITER + "52=20011218-12:23:45" + DELIMITER +
              "98=0" + DELIMITER + "108=120" + DELIMITER;

  }

  /**
   * Devuelve el Logon construido.
   * @return String Logon construido.
   */
  public String getLogon(){

   return mensaje;
  }
}
