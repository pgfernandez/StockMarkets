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

public class FIXListenerExecution implements ActionListener{

  /**
   * Trata los mensajes.
   */
   private TreatMessage tm = null;

  /**
   * Contiene la ejecucion a enviar.
   */
   private String ejecucion = null;

  /**
   * Utlizado para poder enviar el mensaje.
   */
   private FIXServer s = null;

  /**
   * Constructor, crea un listener para la gestion de las ejecuciones.
   * @param tm Trata el mensaje.
   * @param s Servidor con el socket para el envio.
   */
  public FIXListenerExecution(TreatMessage tm, FIXServer s){

    this.tm = tm;
    this.s = s;
  }

  /**
   * Evento del timer con la accion a realizar. Envio de las ejecuciones.
   */
  public synchronized void actionPerformed(ActionEvent e){

    System.out.println("Activado el evento de enviar ejecuciones");
    ArrayList executions = tm.getEjecuciones();

    if (executions.size() > 0){
     for (int i = 0; i<executions.size() - 1 ; i++){
          ejecucion = (String)executions.get(i);
          //s.threadServer.enviaRespuesta(ejecucion,0);Prueba JB9
          s.getServer().enviaRespuesta(ejecucion,0);

          ejecucion = null;
    }
   }else{
    //no hay ejecuciones que enviar
    System.out.println("no hay ejecuciones que enviar");
    }
    executions = null;

  }

}
