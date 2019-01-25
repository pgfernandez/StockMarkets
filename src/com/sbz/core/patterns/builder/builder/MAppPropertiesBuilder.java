package com.sbz.core.patterns.builder.builder;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

import com.sbz.core.patterns.builder.product.TibcoAdapterParametersProduct;
import com.sbz.core.patterns.builder.product.MAppPropertiesProduct;
import com.tibco.sdk.MAppProperties;
import java.util.HashMap;

public class MAppPropertiesBuilder {

	MAppProperties map = null;
	MAppPropertiesProduct mappProduct = null;

  public MAppPropertiesBuilder() {

  }

 /* public void buildMappProperties(TibcoAdapterParametersProduct adapterParameters){
    try{
    map = new MAppProperties(adapterParameters.getAdapter, adapterParameters.getVersion,
                             adapterParameters.getTibComponent, adapterParameters.getRepository,
                             new String args[]);
    }catch(Exception e){
    	 e.printToStackTrace();
    }

  }*/


  public void buildMappProperties(HashMap mappProperties){

    mappProduct = new com.sbz.core.patterns.builder.product.MAppPropertiesProduct();
    mappProduct.setAdapter((String)mappProperties.get("adapter"));
    mappProduct.setVersion((String)mappProperties.get("version"));
    mappProduct.setName((String)mappProperties.get("name"));
    mappProduct.setTibComponent((String)mappProperties.get("tibComponent"));
    mappProduct.setRepository((String)mappProperties.get("repository"));

    System.out.println("valor del parámetro: " + mappProduct.getAdapter());
    System.out.println("valor del parámetro: " + mappProduct.getVersion());
    System.out.println("valor del parámetro: " + mappProduct.getName());
    System.out.println("valor del parámetro: " + mappProduct.getTibComponent());
    System.out.println("valor del parámetro: " + mappProduct.getRepository());
    try{
      String args[] = null;
    map = new MAppProperties(mappProduct.getAdapter(), mappProduct.getVersion(),mappProduct.getName(), mappProduct.getTibComponent(), mappProduct.getRepository(),args);


    }catch(Exception e){
    	 e.printStackTrace();
    }

  }


  public MAppProperties getMappProperties(){
   return map;
  }

}