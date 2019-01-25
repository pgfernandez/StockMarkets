package com.sbz.fix.server.timers;

/**
 * Title:        FIXServer
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:      Reuters DSS
 * @author Pedro Garcia
 * @version 1.0
 */

import java.util.TimerTask;
import java.util.Date;
import java.util.Calendar;
import java.awt.event.ActionListener;


public class FIXTimerTask extends TimerTask{
   /**
    * Variable que va a contener el listener que describe la acci&oacute;n.
    */
   private ActionListener listener;

   /**
    * Constructor. Crea una instancia de TimerTask.
    * @param action Listener que define la acci&oacute;n.
    */

  public FIXTimerTask(ActionListener action){
      super();
      listener= action;
  }
    /**
    * M&eacute;todo que ejecuta la acci&oacute;n.
    */
    public void run(){
        listener.actionPerformed(null);
    }


}