package com.sbz.parsing;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

import com.sbz.util.SBZProperties;
import javax.xml.parsers.*;
import java.io.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.xml.sax.SAXException;
import org.w3c.dom.*;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import java.util.*;
import org.jdom.*;

public class XMLManager {

  private DocumentBuilderFactory docFactory = null;
  private DocumentBuilder docBuilder = null;
  private FileInputStream fis = null;
  private Document doc = null;
  private Element ele = null;
  private NodeList nodeList = null;

  //elementos para lectura por jdom
  private String fileName = null;
  private org.jdom.Document docReadAll = null;


  public XMLManager()
  {

  }

  public XMLManager(String file)
  {
     this.parseDocument(file);
  }

  public void parseDocument(String file){
    docFactory = DocumentBuilderFactory.newInstance();
    try
    {
      docBuilder = docFactory.newDocumentBuilder();
    }catch(ParserConfigurationException pce){
      pce.printStackTrace();
    }
    try
    {
      fis = new FileInputStream(file);
    }catch(FileNotFoundException fne){
      fne.printStackTrace();
    }

    try
    {
    doc = docBuilder.parse(fis);
    }catch(Exception e){
      e.printStackTrace();
    }
     ele = doc.getDocumentElement();


  }

  public void setFile(String file){
    fileName = file;
 //   this.docReadAll

  }

  public void setElement(String name)
  {

    nodeList = doc.getElementsByTagName(name);

  }

  public List readAllByElement(String file, String element, String valueField){
  this.parseDocument(file);
   List valores = new ArrayList();

   nodeList = doc.getElementsByTagName(element);
   int elementos = nodeList.getLength();
   NodeList hijos = nodeList.item(0).getChildNodes();
   for(int i = 0; i<hijos.getLength(); i++){
     if ((hijos.item(i).getNodeType()) == 1){
      valores.add(((Element)hijos.item(i)).getAttribute(valueField));
    }
   }

  return valores;
  }

  public HashMap readAll(String filename, String element, String valueField){
          this.parseDocument(filename);
          HashMap valores = new HashMap();

          nodeList = doc.getElementsByTagName(element);
          int elementos = nodeList.getLength();
    NodeList hijos = nodeList.item(0).getChildNodes();

   for(int i = 0; i<hijos.getLength(); i++){
     if ((hijos.item(i).getNodeType()) == 1){
      valores.put(((Element)hijos.item(i)).getNodeName(),((Element)hijos.item(i)).getAttribute(valueField));
   }

   }

  return valores;

  }

  public HashMap readAll(String element, String valueField){
         HashMap valores = new HashMap();
         nodeList = doc.getElementsByTagName(element);
         int elementos = nodeList.getLength();
   NodeList hijos = nodeList.item(0).getChildNodes();
  for(int i = 0; i<hijos.getLength(); i++){
    if ((hijos.item(i).getNodeType()) == 1){
        valores.put(((Element)hijos.item(i)).getNodeName(),((Element)hijos.item(i)).getAttribute(valueField));
    }



  }

 return valores;

 }

 public List readChildsNames(String father){
   List childs = new ArrayList();
    nodeList = doc.getElementsByTagName(father);
    for (int i = 0; i<nodeList.getLength(); i++){
         childs.add(i, nodeList.item(i).getNodeName());
    }

   return childs;
 }



  public List readEqualsByFatherElement(String fatherElement, String childsToFindName, String valueField){

    List ele = new ArrayList();
    nodeList = doc.getElementsByTagName(fatherElement);
    int elementos = nodeList.getLength();
    NodeList hijos = nodeList.item(0).getChildNodes();

    for(int i = 0; i<hijos.getLength(); i++){
      if ((hijos.item(i).getNodeType()) == 1){
        if (hijos.item(i).getNodeName().equals(childsToFindName)){
          ele.add( ( (Element) hijos.item(i)).getAttribute(valueField));
        }
     }
    }

   return ele;

  }

  public String getValue(String element){

    int items = nodeList.getLength();
    String value = null;
    ele = (Element)nodeList.item(0);
    NodeList values = ele.getElementsByTagName(element);
    Element requestedEle = (Element)values.item(0);
    value = requestedEle.getAttribute(SBZProperties.XML_VALUE_FIELD);

   return value;
  }

  public void setValue(String element, String value){



  }
  public static void main(String args[])
  {
    //StringBuffer path = new StringBuffer(System.getProperty("FIXCNF"));

/*    XMLManager x = new XMLManager("F:\\Tradia\\cnf\\translations\\NewOrderConfirmation.xml");
    x.readAllByElement("NewOrderConfirmation","tag");

    XMLManager man = new XMLManager(SBZProperties.CNF_FILE);
    man.setElement("adapter2Host");
    String value = man.getValue("logfile");
    String val = man.getValue("port");
    System.out.println("valor de logfile:" + value);
    System.out.println("valor de port:" + val);*/

    XMLManager x = new XMLManager();
    x.parseDocument("E:\\Tradia\\cnf\\FixGatewayConf.xml");
//    HashMap val = x.readAllByElement("adapter2Fix","value");
        List val = x.readEqualsByFatherElement("adapter2Fix","subscriberHost","value");

    //for (int i = 0; i<val.size(); i++){
 //   System.out.println("elemento recogido: " + val.keySet().toString());
   System.out.println("numero de elementos leidos: " + val.size());
   for (int i = 0; i<val.size(); i++){
    System.out.println("ejemplo de subscriberHost: " + (String)val.get(i));
    }
   /* String value = man.getValue("logfile");
    String val = man.getValue("port");
    System.out.println("valor de logfile:" + value);
    System.out.println("valor de port:" + val);*/



  }
}