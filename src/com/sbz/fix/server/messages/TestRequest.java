package com.sbz.fix.server.messages;

/**
 * Title:        FIXServer
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:      Somebiz Networks
 * @author Pedro Garcia
 * @version 1.0
 */

public class TestRequest extends FIXMessage{

  /**
   * TestReuest para la peticion de estado del cliente FIX.
   */
  private String testrequest = null;

  /**
   * Constructor, construye el TestRequest con el numero de secuencia actualizado.
   * @param secuencia Numero de secuencia.
   */
  public TestRequest(int secuencia) {

    char DELIMITER = this.getDelimiter();

    testrequest = this.getEncabezado() + "1" + DELIMITER + "49=INET" + DELIMITER +
                 "56=Caixa" + DELIMITER + "52=20011218-12:23:45" + DELIMITER +
                 "112=2-20008876-09:34:32" + DELIMITER + "34=" + secuencia +
                 DELIMITER;

  }

  /**
   * Constructor, construye el TestRequest.
   */
 public TestRequest() {

    char DELIMITER = this.getDelimiter();

    testrequest = this.getEncabezado() + "1" + DELIMITER + "49=INET" + DELIMITER
 +
                 "56=Caixa" + DELIMITER + "52=20011218-12:23:45" + DELIMITER +
                 "112=2-20008876-09:34:32" + DELIMITER;

  }

  /**
   * Devuelve el TestRequest construido.
   * @return String TestRequest construido.
   */
  public String dameTestRequest(){

   return testrequest;

  }
}
