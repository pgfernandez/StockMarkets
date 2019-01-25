package com.sbz.core.patterns.builder.builder;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

//import com.sbz.core.patterns.builder.product.MAppPropertiesProduct;
import com.tibco.sdk.MAppProperties;
import com.sbz.core.patterns.builder.product.TibcoAdapterParametersProduct;
import com.sbz.core.patterns.builder.product.ClassProduct;
import com.sbz.core.tibco.Adapter;
import java.lang.reflect.*;
import com.sbz.core.patterns.builder.builder.ClassBuilder;
import java.util.*;

public class TibcoAdapterBuilder {
  Adapter a = null;
  ClassBuilder classBuilder = null;

  public TibcoAdapterBuilder() {

  }
  public void buildAdapter(String adapterClass, MAppProperties m, TibcoAdapterParametersProduct ap, ClassProduct classParameters){

  classBuilder = new ClassBuilder(classParameters);
  List param = new ArrayList();

  param.add(m);
  param.add(ap);
  classBuilder.setupClass(param);
  a = (Adapter)classBuilder.getClassLoaded();

  }

  public Adapter getAdapterBuilt(){

    return a;
  }


}