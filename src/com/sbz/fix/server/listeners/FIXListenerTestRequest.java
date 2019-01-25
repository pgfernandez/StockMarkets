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

public class FIXListenerTestRequest implements ActionListener{

  /**
   * Trata los mensajes.
   */
  private TreatMessage tm = null;
  /**
   * Contiene el TestRequest a enviar.
   */
  private String testrequest = null;
  /**
   * Utlizado para poder enviar el mensaje.
   */
  private FIXServer s = null;

  /**
   * Constructor, crea un listener para la gestion del TestRequest.
   * @param tm Trata el mensaje.
   * @param s Servidor con el socket para el envio.
   */
  public FIXListenerTestRequest(TreatMessage tm, FIXServer fs) {

    this.tm = tm;
    this.s = fs;

  }

  /**
   * Evento del timer con la accion a realizar. Envio del test request.
   */
  public void actionPerformed(ActionEvent e){

    System.out.println("Activado el evento de enviar TestRequest");
    testrequest = tm.getTestRequest();
//    s.threadServer.enviaRespuesta(testrequest,0);PruebaJB9
    s.getServer().enviaRespuesta(testrequest,0);
  }

}
