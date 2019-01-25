package com.sbz.fix.server.messages;

/**
 * Title:        FIXServer
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:      Reuters DSS
 * @author Pedro Garcia
 * @version 1.0
 */

public class DoneForDay extends FIXMessage{
 /**
  * Done for day para un ejecucion enviada.
  */
 private String doneForDay = null;

 /**
  * Constructor, construye la ejecucion historica (Done for Day) de la orden ejecutada.
  * @param orden Numero de orden ejecutada.
  */
  public DoneForDay(String orden) {

  char DELIMITER = this.getDelimiter();

   doneForDay = this.getEncabezado() + "8" + DELIMITER + "49=INET" + DELIMITER +
                 "56=Caixa" + DELIMITER + "57=IMO" + DELIMITER +
                 "52=20011218-12:23:45" + DELIMITER + "37=1320011204"
                 + DELIMITER + "17=511204" + DELIMITER + "34=12" + DELIMITER +
                 "20=0" + DELIMITER + "39=3" + DELIMITER + "63=0" + DELIMITER +
                 "55=DE0005494272" + DELIMITER + "48=DE0005494272" + DELIMITER +
                 "22=2" + DELIMITER + "54=2" + DELIMITER + "38=800"
                 + DELIMITER + "40=1" + DELIMITER + "15=EUR" + DELIMITER +
                 "59=0" + DELIMITER + "18=1" + DELIMITER + "32=0" + DELIMITER +
                 DELIMITER + "31=0" +  DELIMITER + "14=0" + DELIMITER + "6=0"
                 + DELIMITER + "75=20011204" + DELIMITER + "60=20011204-06:00:28"
                 + DELIMITER + this.getTagNumOrden() + "=" + orden + DELIMITER;

  }

  /**
   * Devuelve el "done for day" construido sin numero de secuencia.
   * @return String Done for Day construido.
   */
  public String getDoneForDay(){

   return doneForDay;

  }




}