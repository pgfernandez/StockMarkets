package com.sbz.core.patterns.builder.product;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

public class MAppPropertiesProduct {

  private  String adapter = null;
  private  String version = null;
  private  String repository = null;
  private  String name = null;
  private  String tibComponent = null;

  public String getAdapter(){ return this.adapter; }
  public String getVersion(){ return this.version; }
  public String getName(){ return this.name;}
  public String getTibComponent(){ return this.tibComponent; }
  public String getRepository(){ return this.repository; }

  public void setAdapter(String adapter){this.adapter = adapter;}
  public void setVersion(String version){this.version = version;}
  public void setName(String name){this.name = name;}
  public void setTibComponent(String tibComponent){this.tibComponent = tibComponent;}
  public void setRepository(String repository){ this.repository = repository;}
}