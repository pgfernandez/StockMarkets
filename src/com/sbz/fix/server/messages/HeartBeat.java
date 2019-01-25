package com.sbz.fix.server.messages;

/**
 * Title:        FIXServer
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:      Somebiz Networks
 * @author Pedro Garcia
 * @version 1.0
 */

public class HeartBeat extends FIXMessage{

  /**
   * HeartBeat a devolver al cliente FIX.
   */
  private String heartbeat = null;

  /**
   * Constructor, construye el HeartBeat con el numero de secuencia actualizado.
   * @param secuencia Numero de secuencia.
   */
  public HeartBeat(int secuencia) {

  char DELIMITER = this.getDelimiter();

  heartbeat = this.getEncabezado() + "0" + DELIMITER + "49=INET" + DELIMITER +
                 "56=Caixa" + DELIMITER + "52=20011218-12:23:45" + DELIMITER +
                 "34=" + secuencia + DELIMITER;
  }

 /**
  * Constructor, construye el HeartBeat.
  */
 public HeartBeat() {

  char DELIMITER = this.getDelimiter();

  heartbeat = this.getEncabezado() + "0" + DELIMITER + "49=INET" + DELIMITER +
                 "56=Caixa" + DELIMITER + "52=20011218-12:23:45" + DELIMITER;
  }

  /**
   * Devuelve el HeartBeat construido.
   * @return String HeartBeat construido.
   */
  public String dameHeartBeat(){

   return heartbeat;

  }


}
