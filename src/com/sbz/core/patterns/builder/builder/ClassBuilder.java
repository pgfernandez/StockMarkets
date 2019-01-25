package com.sbz.core.patterns.builder.builder;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */
import java.lang.reflect.*;
import java.util.*;
import com.sbz.core.patterns.builder.product.ClassProduct;


public class ClassBuilder {

  private Object argList[] = null;
  private Class paramtypes[] = null;
  private List param = null;
  private Object o = null;
  private ClassProduct classParameters = null;

  public ClassBuilder(ClassProduct classParameters) {
    this.classParameters = classParameters;
  }
private void startBuild(){
    o = new Object();
   try{
     int parametros = classParameters.getConstructorParamTypes().size();
     Class tibAdapter = Class.forName(classParameters.getClassName());


     HashMap parameters = classParameters.getConstructorParamTypes();

     List claves = new ArrayList();
     Iterator iter = parameters.keySet().iterator();
     List clavesAux = new ArrayList();
     while(iter.hasNext()){
       clavesAux.add((String)iter.next());
     }
     int indexAux = 0;
     for (int index = clavesAux.size() - 1; index >= 0 ; index--){
       claves.add(indexAux, clavesAux.get(index));
       indexAux++;
     }


     Class paramtypes[] = new Class[parametros];
     for (int i=0; i<parametros; i++){
       paramtypes[i] = (Class.forName((String)parameters.get(claves.get(i))));
     }

     Constructor cons = tibAdapter.getConstructor(paramtypes);
     Object argList[] = new Object[parametros];
     for (int j = 0; j<parametros;j++){
       argList[j] = param.get(j);
     }
     o = cons.newInstance(argList);
     cons = null;

   }catch(Exception e){
     e.printStackTrace();

   }


  }


  public void setupClass(List param){
    this.param = param;
        this.startBuild();
  }

  public Object getClassLoaded(){
    return this.o;

  }
}