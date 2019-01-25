package com.sbz.analysis.stat.indicator;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

public class Momentum {

  private double CurrentMomentum;
  private double LastMomentum;
  private double LastPrice;
  private double FiveDaysPrice;

  public Momentum() {
  }

  private void CalcMomentum()
  {
    CurrentMomentum = LastPrice - FiveDaysPrice;
  }

}