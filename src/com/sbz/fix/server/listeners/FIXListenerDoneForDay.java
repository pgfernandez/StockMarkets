package com.sbz.fix.server.listeners;

/**
 * Title:        FIXServer
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:      Somebiz Networks
 * @author Pedro Garcia
 * @version 1.0
 */

import java.awt.event.*;
import java.util.*;
import com.sbz.fix.server.main.*;

public class FIXListenerDoneForDay implements ActionListener{

  /**
   * Trata los mensajes.
   */
  private TreatMessage tm = null;
  /**
   * Utlizado para poder enviar el mensaje.
   */
  private FIXServer s = null;
  /**
   * Contiene el DoneForDay a enviar.
   */
  private String doneFDay = null;

  /**
   * Constructor, crea un listener para la gestion de las ejecuciones
   * historicas enviadas al cliente FIX.
   * @param tm Trata el mensaje.
   * @param s Servidor con el socket para el envio.
   */
  public FIXListenerDoneForDay(TreatMessage tm, FIXServer s) {

    this.tm = tm;
    this.s = s;
  }

  /**
   * Evento del timer con la accion a realizar. Envio de los Done For Day.
   */
  public synchronized void actionPerformed(ActionEvent e){

   List doneForDay = tm.getDoneForDay();

     for (int i = 0; i<doneForDay.size() - 1 ; i++){
           doneFDay = (String)doneForDay.get(i);
           //s.threadServer.enviaRespuesta(doneFDay,0);PruebaJB9
           s.getServer().enviaRespuesta(doneFDay,0);
           doneFDay = null;
    }

  }
}
