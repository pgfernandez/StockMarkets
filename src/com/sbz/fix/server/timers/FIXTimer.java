package com.sbz.fix.server.timers;

/**
 * Title:        FIXServer
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:      Somebiz Networks
 * @author Pedro Garcia
 * @version 1.0
 */
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionListener;

public class FIXTimer {

   /**
    * Variable que va a contener el Timer.
    */
    public Timer theTimer = null;


   /**
    * Listener que va a contener la acci�n del timer.
    */
    public ActionListener listener = null;

   /**
    * Variable que va a contener el periodo de retardo del timer.
    */
    public long theDelay= 0;

   /**
    * Constructor. Crea un timer a partir de un actionListener y un tiempo de retardo
    * @param delay Tiempo de retardo del listener.
    * @param action Listener que va a definir la acci&oacute;n del timer.
    */


  public FIXTimer(long delay, ActionListener ac) {
    	// Se crea un Timer java sin ejecucion como demonio.
    	theTimer= new Timer();
        listener= ac;
    	theDelay=delay;
  }
    /**
     * Metodo que va a arrancar un timer.
     */
    synchronized public void start() {
    	theTimer.scheduleAtFixedRate(new FIXTimerTask(listener),0,theDelay);
    }

    /**
     * M&eacute;todo que resetea un timer.
     */
    synchronized public void restart() {
        stop();
     	theTimer= new Timer();
        start();
    }

    /**
     * M&eacute;todo que para un timer.
     */
    synchronized public void stop() {
    	theTimer.cancel();
    }

}
