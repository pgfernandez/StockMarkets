package com.sbz.analysis.stat.oscilators;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

public class WilliamsOscilator {

  private double CurrentPctR;
  private double LastPctR;
  private double LastPrice;
  private double LowestPeriodPrice;
  private double HighestPeriodPrice;

  public WilliamsOscilator() {
  }

   private void CalcPctK()
  {
    CurrentPctR = 100 * ((HighestPeriodPrice - LastPrice) /
                  (HighestPeriodPrice - LowestPeriodPrice));
  }
}