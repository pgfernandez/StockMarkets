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
import com.sbz.core.patterns.builder.product.ClassProduct;
import com.sbz.parsing.XMLManager;
import java.util.*;

public class TibcoAdapterParametersBuilder {

  private TibcoAdapterParametersProduct adapterParameters = null;
  private ClassProduct classProduct = null;
  private String adapterName = null;
  private String configFile = null;

  public TibcoAdapterParametersBuilder() {
  }

  public void setConfigFile(String configFile){
   this.configFile = configFile;
  }

  public void buildAdapterParameters(String adapter, XMLManager xmlManager){

    adapterParameters = new TibcoAdapterParametersProduct();
    classProduct = new ClassProduct();
    adapterName = adapter;
    HashMap parameters = xmlManager.readAll(configFile, adapter, "value");

    HashMap constructor = xmlManager.readAll("class", "value");

    classProduct.setConstructorTypes(constructor);
    classProduct.setClassName((String)parameters.get("class"));
    parameters.remove("class");
    adapterParameters.setLogFile((String)parameters.get("logfile"));
    parameters.remove("logfile");
    adapterParameters.addMAppParameter("adapter",(String)parameters.get("tibAdapter"));
    parameters.remove("adapter");
    adapterParameters.addMAppParameter("version",(String)parameters.get("version"));
    parameters.remove("version");
    adapterParameters.addMAppParameter("tibComponent",(String)parameters.get("tibComponent"));
    parameters.remove("tibComponent");
    adapterParameters.addMAppParameter("name",(String)parameters.get("name"));
    parameters.remove("name");
    adapterParameters.addMAppParameter("repository",(String)parameters.get("repository"));
    parameters.remove("repository");


    HashMap subscribers = new HashMap();
    subscribers = this.getSubsPubs("subscriber", parameters);
    adapterParameters.addSubscribers(subscribers);

    HashMap publishers = new HashMap();
    publishers = this.getSubsPubs("publisher", parameters);
    adapterParameters.addPublishers(publishers);

    if(parameters.size() > 0){
    	adapterParameters.addOthers(parameters);
    }
  }

  private HashMap getSubsPubs(String componentName, HashMap valores){

          List claves = new ArrayList();
          Iterator iter = valores.keySet().iterator();

          while(iter.hasNext()){
            claves.add((String)iter.next());
          }

 	  HashMap resultado = new HashMap();
 	  String claveActual = null;
 	  for (int i = 0; i < claves.size(); i++){
             claveActual = (String) claves.get(i);
             if (claveActual.startsWith(componentName)) {
               resultado.put(claveActual, valores.get( (String) claves.get(i)));
               valores.remove(claveActual);
               claveActual = null;
             }
           }
 	  return resultado;
  }
  public TibcoAdapterParametersProduct getAdapterParameters(){
    return this.adapterParameters;
  }
  public ClassProduct getClassParameters(){
    return this.classProduct;
  }
}