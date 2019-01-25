package com.sbz.fix.server.messages;

/**
 * Title:        FIXServer
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:      Somebiz Networks
 * @author Pedro Garcia
 * @version 1.0
 */

import com.sbz.fix.server.messages.FIXMessage;

public class CancelOrder extends FIXMessage{

  /**
   * Cancelacion para la peticion de cancelacion recibida.
   */
  private String cancelacionOrden = null;

  /**
   * Constructor, construye la confirmacion de la cancelacion de orden recibida
   * con el numero de secuencia actualizado.
   * @param secuencia Numero de secuencia.
   * @param orden Numero de orden a confirmar.
   */
  public CancelOrder(int secuencia, String orden) {

  char DELIMITER = this.getDelimiter();

  cancelacionOrden = this.getEncabezado() + "8" + DELIMITER + "49=INET" + DELIMITER + "56=Caixa" + DELIMITER + "57=IMO" + DELIMITER +
               "52=20020108-12:23:45" + DELIMITER + "37=1320011204"
               + DELIMITER + "17=411204" + DELIMITER + "20=0" + DELIMITER +
               "39=4" + DELIMITER + "63=0" + DELIMITER + "55=DE0005494272"
               + DELIMITER + "48=DE0005494272" + DELIMITER + "22=2" + DELIMITER +
               "54=1" + DELIMITER +"38=800" + DELIMITER + "40=2" + DELIMITER +
               "44=15.67" + DELIMITER + "15=EUR" + DELIMITER + "59=0" + DELIMITER +
               "18=1" + DELIMITER + "32=0" + DELIMITER + "31=0" + DELIMITER +
               "14=650" + DELIMITER + "6=0" + DELIMITER + "75=20011204"
               + DELIMITER + "60=20011204-06:00:28" + DELIMITER + "34=" + secuencia +
                  DELIMITER + this.getTagNumOrden() + "=" + orden + DELIMITER;

  }

  /**
   * Constructor, construye la confirmacion de la cancelacion de orden recibida.
   * @param orden Numero de orden a confirmar.
   */
 public CancelOrder(String orden) {

  char DELIMITER = this.getDelimiter();

  cancelacionOrden = this.getEncabezado() + "8" + DELIMITER + "49=INET" + DELIMITER +
               "56=Caixa" + DELIMITER + "57=IMO" + DELIMITER +
               "52=20020108-12:23:45" + DELIMITER + "37=1320011204"
               + DELIMITER + "17=411204" + DELIMITER + "20=0" + DELIMITER +
               "39=4" + DELIMITER + "63=0" + DELIMITER + "55=DE0005494272"
               + DELIMITER + "48=DE0005494272" + DELIMITER + "22=2" + DELIMITER
               + "54=1" + DELIMITER +"38=800" + DELIMITER + "40=2" + DELIMITER +
               "44=15.67" + DELIMITER + "15=EUR" + DELIMITER + "59=0" + DELIMITER +
               "18=1" + DELIMITER + "32=0" + DELIMITER + "31=0" + DELIMITER +
               "14=650" + DELIMITER + "6=0" + DELIMITER + "75=20011204"
               + DELIMITER + "60=20011204-06:00:28" + DELIMITER +
                  this.getTagNumOrden() + "=" + orden + DELIMITER;

  }

 /**
   * Devuelve la cancelacion construida.
   * @return String Cancelacion construida.
   */
  public String getCancelOrder(){

  return cancelacionOrden;

  }

}
