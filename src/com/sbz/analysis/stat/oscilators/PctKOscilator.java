package com.sbz.analysis.stat.oscilators;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

public class PctKOscilator {

  private double CurrentPctK;
  private double LastPctK;
  private double LastPrice;
  private double LowestDayPrice;
  private double HighestDayPrice;

  public PctKOscilator() {
  }

  private void CalcPctK()
  {
    CurrentPctK = ((LastPrice - LowestDayPrice) /
                  (HighestDayPrice - LowestDayPrice)) * 100;

  }
}