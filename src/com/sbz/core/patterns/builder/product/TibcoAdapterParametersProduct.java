package com.sbz.core.patterns.builder.product;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

import com.sbz.parsing.XMLManager;
import java.util.*;

public class TibcoAdapterParametersProduct {

  private  String logFile = null;

  private HashMap mappParameters = new HashMap();
  private  HashMap publishers = null;
  private  HashMap subscribers = null;
  private  HashMap others = null;
  private  List publishersList = null;
  private List subscribersList = null;
  private HashMap constructorTypes = null;

  public String getLogFile(){ return this.logFile; }
  public HashMap getPublishers(){ return this.publishers; }
  public HashMap getSubscribers(){ return this.subscribers; }
  public HashMap getOthers(){ return this.others; }

  public void addMAppParameter(String clave, String parameter){
  	 mappParameters.put(clave,parameter);
  }

  public void addSubscribers(List subs){
    this.subscribersList = subs;
  }
  public void addPublishers(List pubs){
    this.publishersList = pubs;
  }

   public void addSubscribers(HashMap subs){
    this.subscribers = subs;
  }
  public void addPublishers(HashMap pubs){
    this.publishers = pubs;
  }

  public void addConstructorTypes(HashMap cons){
    this.constructorTypes = cons;
  }


  public void addPublisher(String key, String publisher){
    this.publishers.put(key,publisher);
  }

  public void addSubscriber(String key, String subscriber){
    this.subscribers.put(key,subscriber);
  }

  public void addOther(String key, String parameter){
    this.others.put(key,parameter);
  }

  public void addOthers(HashMap others){
    this.others = others;
  }


  public void setLogFile(String logfile){this.logFile = logfile; }

  public HashMap getMAppParameters(){
 		return this.mappParameters;
 	}

  public HashMap getConstructorTypes(){
    return this.constructorTypes;

  }

 }