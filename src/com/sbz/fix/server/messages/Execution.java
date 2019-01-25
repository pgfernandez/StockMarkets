package com.sbz.fix.server.messages;

/**
 * Title:        FIXServer
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:      Somebiz Networks
 * @author Pedro Garcia
 * @version 1.0
 */

public class Execution extends FIXMessage{
  /**
   * Ejecucion de la orden confirmada.
   */
  private String ejecucion = null;

  /**
   * Constructor, construye la ejecucion de la orden recibida.
   * @param orden Numero de orden a ejecutar.
   */
  public Execution(String numOrden){

  char DELIMITER = this.getDelimiter();

   ejecucion = this.getEncabezado() + "8" + DELIMITER + "49=INET" + DELIMITER +
               "56=Caixa" + DELIMITER + "52=20011218-12:23:45"
               + DELIMITER + "37=13200112044568"
               + DELIMITER + "17=511204548" + DELIMITER +
               "20=0" + DELIMITER + "39=2" +  DELIMITER +
               "55=DE0005494272" + DELIMITER + "48=DE0005494272" + DELIMITER +
               "22=2" + DELIMITER + "54=1" + DELIMITER + "38=800"
                + DELIMITER  + "59=0" + DELIMITER + "32=123456" + DELIMITER + "31=0.0"
                + DELIMITER + "30=L" + DELIMITER + "14=0" + DELIMITER
                + "6=0" + DELIMITER +  "60=20011204-06:00:28" + DELIMITER +
                this.getTagNumOrden() + "=" + numOrden + DELIMITER;
  }

  /**
   * Devuelve la ejecucion construida sin numero de secuencia.
   * @return String Ejecucion construida.
   */
  public String getExecution(){

  return ejecucion;

  }
}