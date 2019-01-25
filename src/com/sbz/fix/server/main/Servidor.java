package com.sbz.fix.server.main;

/**
 * Title:        FIXServer
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:      Reuters DSS
 * @author Pedro Garcia
 * @version 1.0
 */

import java.net.*;
import java.io.*;
import com.sbz.io.toFile;

public class Servidor{

 /**
  * Variable utilizada para indicar el tipo de mensaje que se va a
  * escribir en el log, tipo Informacion.
  */
 private final String INFO = " - I: ";
 /**
  * Variable utilizada para indicar el tipo de mensaje que se va a
  * escribir en el log, tipo Warning.
  */
 private final String WARNING = " - W: ";
 /**
  * Variable utilizada para indicar el tipo de mensaje que se va a
  * escribir en el log, tipo Error.
  */
 private final String ERROR = " - E: ";

 /**
  * Socket del servidor.
  */
 private ServerSocket s = null;

 /**
  * Socket para comunicarse con el cliente.
  */
 private Socket clientSocket = null;

 /**
  * Tamanio del buffer del socket
  */
 private int SSIZE = 1024;

 /**
  * Puerto por el que escucho.
  */
 private int port;

 /**
  * Stream de lectura del socket.
  */
 private DataInputStream aux;

 /**
  * Stream de escritura del socket.
  */
 private PrintStream out;

 /**
  * Reader del buffer del socket.
  */
 private BufferedReader in;

 /**
  * Ficheros de log y dbg.
  */
 private toFile dbgfile;
 private toFile logfile;

 /**
  * Constructor del servidor que envia y recibe los mensajes a traves del socket.
  * @param the_port Puerto.
  * @param the_in Lector de entrada.
  * @param the_out Stream de escritura.
  * @param the_dbgfile Fichero de debug.
  * @param the_logfile Fichero de log.
  */
 public Servidor(int the_port,BufferedReader the_in,PrintStream the_out,toFile the_dbgfile,toFile the_logfile)
 {
   this.port = the_port;
   this.in = the_in;
   this.out = the_out;
   this.dbgfile = the_dbgfile;
   this.logfile = the_logfile;
 }

 /**
  * Crea el socket para la comunicacion con el cliente FIX.
  */
 public void creaSocket()
 {
    try
    {
      s = new ServerSocket(port);
    }
    catch (Exception e)
    {
      dbgfile.print("El server socket normal no pudo conectarse al port "+port);
      dbgfile.print(e.getMessage());
      try
      {
        dbgfile.closeFile();
        logfile.closeFile();
      }
      catch (IOException ioe) {}
      System.exit(1);
    }

    logfile.print(INFO + "Server socket normal creado. Esperando conexion del cliente...");
    try
    {
      clientSocket = s.accept();
    }
    catch (IOException e)
    {
      dbgfile.print("Fallo aceptando conexion del cliente en el port: "+port);
      dbgfile.print(e.getMessage());
      try
      {
        dbgfile.closeFile();
        logfile.closeFile();
      }
      catch (IOException ioe) {}
      System.exit(1);
    }
 }

 /**
  * Inicializa los streams del socket.
  */
 public void iniSocket()
 {
   try
   {
     aux = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));
     in = new BufferedReader(new InputStreamReader(aux));
     out = new PrintStream(new BufferedOutputStream(clientSocket.getOutputStream(),SSIZE),false);
   }
   catch (IOException e)
   {
     dbgfile.print("Error inicializando el server socket normal");
     dbgfile.print(e.getMessage());
     try
     {
       dbgfile.closeFile();
       logfile.closeFile();
     }
     catch (IOException ioe) {}
     System.exit(1);
   }
 }

 /**
  * Devuelve un String leido del socket (como mucho "SSIZE" caracteres). Si
  * no habia datos para leer, devuelve un String nulo.
  * @return String Devuelve lo leido.
  */
 public String leeSocket()
 {
    String out=null;
    int leidos;
    char [] cadena = new char[SSIZE];

    try
    {
     leidos=in.read(cadena,0,SSIZE);
     // Convierte a String la cadena de caracteres leida
     if (leidos!=-1)
     {
       out=new String(cadena);
       out=out.substring(0,leidos);
     }
    }
    catch (IOException e)
    {
     dbgfile.print("Error al leer del server socket normal");
     dbgfile.print(e.getMessage());
     try
     {
       dbgfile.closeFile();
       logfile.closeFile();
     }
     catch (IOException ioe) {}
     System.exit(-1);
    }
    return out;
 }

 /**
  * Escribe en el socket el mensaje de salida FIX.
  */
 public void escribeSocket(String data)
 {

   try{
   out.print(data + '\n');
   System.out.println("devuelto confirmacion: " + data);
   out.flush();
   }catch(Exception e){
   System.out.println("Excepcion en print: " + e.getMessage());
   e.printStackTrace();
   }

 }

 /**
  * Destruye los sockets
  */
 public void destruyeSocket()
 {
   try
   {
      s.close();
      clientSocket.close();
   }
   catch (IOException e)
   {
      dbgfile.print("Error al cerrar el server socket normal");
      dbgfile.print(e.getMessage());
      try
      {
        dbgfile.closeFile();
        logfile.closeFile();
      }
      catch (IOException ioe) {}
      System.exit(1);
   }
 }

}