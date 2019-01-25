package com.sbz.io;

import java.io.*;

//
// Clase para leer lineas de un fichero de texto
//

public class ReadFile {

  private File f;
  private FileReader fich;
  private BufferedReader fichero;
  private String namefile;

  /**
   * Lee linea por linea un fichero de texto pasado como parametro.
   * @param the_name Nombre de fichero a leer.
   */
  public ReadFile(String the_name)
  {
    this.namefile = the_name;
    try { f = new File(namefile); }
    catch (NullPointerException e)
    {
      System.out.println("No se puede crear una instancia de un fichero nulo");
      System.exit(1);
    }
    try
    {
      fich = new FileReader(f);
      fichero = new BufferedReader(fich);
    }
    catch (FileNotFoundException e2)
    {
      System.out.println("No se encuentra el fichero");
    }
  }

  /**
   * Lee una linea del fichero en un String. Devuelve null si llega
   * al final del fichero o error.
   */
  public String getline()
  {
    String out=null;

    if (f.isFile())
    {
      try
      {
        // Lee una linea
        out = fichero.readLine();

      }
      catch (IOException e)
      {
        System.out.println("Error leyendo del fichero: "+namefile);
      }
    }
    else
    {
      System.out.println("La instancia creada no es de un fichero normal. Puede que sea un directorio");
    }

    return out;
  }

}// leerFichero
