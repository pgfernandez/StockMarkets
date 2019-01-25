package com.sbz.analysis.stat.oscilators;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

public class RSIOscilator {

  private double CurrentRSI;
  private double LastRSI;
  private int AverageUp;
  private int AverageDown;

  public RSIOscilator() {
  }

  private void CalcRSI()
  {
    CurrentRSI = 100 - ((100) / (1 + (AverageUp / AverageDown)));
  }
}