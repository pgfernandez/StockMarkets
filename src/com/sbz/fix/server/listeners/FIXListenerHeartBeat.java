package com.sbz.fix.server.listeners;

/**
 * Title:        FIXServer
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:      Reuters DSS
 * @author Pedro Garcia
 * @version 1.0
 */

import java.awt.event.*;
import com.sbz.fix.server.main.*;

public class FIXListenerHeartBeat implements ActionListener{


  /**
   * Trata los mensajes.
   */
  private TreatMessage tm = null;

  /**
   * Contiene el HeartBeat a enviar.
   */
  private String heartbeat = null;
  /**
   * Utlizado para poder enviar el mensaje.
   */
  private FIXServer s = null;

  /**
   * Constructor, crea un listener para la gestion de los HeartBeats.
   * @param tm Trata el mensaje.
   * @param s Servidor con el socket para el envio.
   */
  public FIXListenerHeartBeat(TreatMessage tm, FIXServer fs) {

    this.tm = tm;
    this.s = fs;

  }

  /**
   * Evento del timer con la accion a realizar. Envio de los HeartBeats.
   */
  public synchronized void actionPerformed(ActionEvent e){

    System.out.println("Activado el evento de enviar heartbeat");
    heartbeat = tm.getHeartBeat();
//    s.threadServer.enviaRespuesta(heartbeat,0);PruebaJB9
    s.getServer().enviaRespuesta(heartbeat,0);

  }
}
