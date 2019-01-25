package com.sbz.core.patterns.builder.product;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */
import java.util.*;
public class ClassProduct {

  private HashMap constructorTypes = null;
  private String className = null;

  public void setConstructorTypes(HashMap cons){
    this.constructorTypes = cons;
  }
  public void setClassName(String name){
    this.className = name;
  }
  public HashMap getConstructorParamTypes(){
    return this.constructorTypes;
  }
  public String getClassName(){
    return this.className;
  }
}