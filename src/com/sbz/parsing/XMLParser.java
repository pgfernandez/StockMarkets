package com.sbz.parsing;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */


import org.xml.sax.*;

import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import java.io.*;

public class XMLParser extends HandlerBase {

      static private Writer  out;

  public XMLParser(){

  }

  public XMLParser(File xmlFile) {



  }

   //===========================================================
  // SAX DocumentHandler methods
 //===========================================================

    public void startDocument ()
    throws SAXException
    {
        emit ("<?xml version='1.0' encoding='ISO-8859-1'?>");
        nl();
    }

    public void endDocument ()
    throws SAXException
    {
        try {
            nl();
            out.flush ();
        } catch (IOException e) {
            throw new SAXException ("I/O error", e);
        }
    }

    public void startElement (String name, AttributeList attrs)
    throws SAXException
    {
        emit ("<"+name);
        if (attrs != null) {
            for (int i = 0; i < attrs.getLength (); i++) {
                emit (" ");
                emit (attrs.getName(i)+"=\""+attrs.getValue (i)+"\"");
            }
        }
        emit (">");
    }

    public void endElement (String name)
    throws SAXException
    {
        emit ("</"+name+">");
    }

    public void characters (char buf [], int offset, int len)
    throws SAXException
    {
        String s = new String(buf, offset, len);
        emit (s);
    }

    //===========================================================
    // Helpers ...
    //===========================================================

    // Wrap I/O exceptions in SAX exceptions, to
    // suit handler signature requirements
    private void emit (String s)
    throws SAXException
    {
        try {
            out.write (s);
            out.flush ();
        } catch (IOException e) {
            throw new SAXException ("I/O error", e);
        }
    }

    // Start a new line
    private void nl ()
    throws SAXException
    {
        String lineEnd =  System.getProperty("line.separator");
        try {
            out.write (lineEnd);
        } catch (IOException e) {
            throw new SAXException ("I/O error", e);
        }
    }

 public static void main(String args[]){

 // XMLParser x = new XMLParser(new File("FixGatewayConf.xml"));


   String fichero = "FixGatewayConf.xml";
      System.out.println("empieza x aki");
   File file = new File(fichero);
      System.out.println("sigue x aki");
   SAXParserFactory factory = SAXParserFactory.newInstance();

   try {

   System.out.println("pasa x aki");
   SAXParser saxParser = factory.newSAXParser();
   System.out.println("y x aki");
   saxParser.parse(file, new XMLParser());
   System.out.println("pasa x aki???");
   }catch(Throwable e){

    e.printStackTrace();

   }


 }


}