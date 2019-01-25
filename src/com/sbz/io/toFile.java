package com.sbz.io;

import java.io.*;
import java.util.*;

// Clase para escribir strings en un fichero

public class toFile {

//Variables utilizadas para indicar el tipo de mensaje que se va a escribir en el log
  private final String INFO = " - I: ";
  private final String WARNING = " - W: ";
  private final String ERROR = " - E: ";

  private FileWriter the_file;
  private String fileName=null;

  /**
   * Constructor. Crea un fichero para escritura con el nombre recibido
   * tipo indica si es de tipo DBG,LOG(true), o de secuencias (false)
   */
  public toFile(String the_name, boolean tipo) throws IOException
  {
     this.fileName=the_name;

     try { the_file = new FileWriter(fileName,true); }
     catch (IOException e)
     {
       System.out.println("Error creando el fichero "+fileName);
       e.printStackTrace();
       System.exit(1);
     }

    if (tipo == true){
     // Escribo la cabecera en log y dbg
     this.printHeader();
    }else{
    //fichero de secuencias
    }
  }

  /**
   * Escribe el string en el fichero log o dbg.
   */
  public void print(String cadena) //throws IOException
  {
    Date fecha = new Date();
    String la_fecha = fecha.toString();

    try
    {
      the_file.write(fecha+": "+cadena+"\n");
      the_file.flush();
    }
    catch (IOException e)
    {
      System.out.println("Error escribiendo en el fichero "+fileName+" la cadena "+cadena);
      e.printStackTrace();
      System.exit(1);
    }
  }

  /**
   * Escribe el string en el fichero de secuencias.
   */
  public void print(int secuencia){

   try
   {
     the_file.write(secuencia);
     the_file.flush();
  }catch (IOException e)
    {
      System.out.println("Error escribiendo en el fichero "+fileName+" la secuencia "+secuencia);
      e.printStackTrace();
      System.exit(1);
    }


  }

  /**
   * Escribe el mensaje de cabecera.
   */
  private void printHeader()
  {
    try
    {
      the_file.write(INFO+"===========================\n");
      the_file.write(INFO+"| FIXServer\n");
      the_file.write(INFO+"| (c) RDSS 2002\n");
      the_file.write(INFO+"===========================\n");
      the_file.flush();
    }
    catch (IOException e)
    {
      System.out.println("Error escribiendo en el fichero "+this.fileName);
      e.printStackTrace();
      System.exit(1);
    }
  }

  /**
   * Cierra el fichero.
   */
  public void closeFile() throws IOException
  {
    try { the_file.close(); }
    catch (IOException e)
    {
      System.out.println("Error cerrando el fichero");
      e.printStackTrace();
      System.exit(1);
    }
  }

}
