package com.sbz.io.log;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

import java.util.logging.*;

public class SBZLog {

  private FileHandler fileHandler = null;
  private Logger logger = null;
  public SBZLog() {
    try{
    fileHandler = new FileHandler("e:\\SbzLog.xml");
    fileHandler.setFormatter(new XMLFormatter());
    }catch(Exception e){
      e.printStackTrace();
    }
    logger = Logger.getAnonymousLogger();
    logger.addHandler(fileHandler);

  }
  public void writeLog(String message, Level level)
  {
    logger.log(level,message);
  }
  public static void main(String args[])
  {
    SBZLog sbzLog = new SBZLog();
    for (int i = 0; i < 34861; i++)
    {
      sbzLog.writeLog("esto es una prueba" + i,Level.INFO);
    }
  }

}