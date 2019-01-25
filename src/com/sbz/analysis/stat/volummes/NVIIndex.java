package com.sbz.analysis.stat.volummes;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

public class NVIIndex {

  final private int VOLUMME_UP        = 0;
  final private int VOLUMME_DOWN      = 1;
  final private double FIRST_NVI_CALC = 100.0;
  private double LastPrice;
  private double BeforeLastPrice;
  private double LastNVI;
  private double CurrentNVI;
  private int VolummeWay;

  public NVIIndex() {
  }

  private void CalcNVI()
  {
      CurrentNVI = ((LastPrice - BeforeLastPrice)/BeforeLastPrice) * 100 *
                    VolummeWay * LastNVI;
  }


}