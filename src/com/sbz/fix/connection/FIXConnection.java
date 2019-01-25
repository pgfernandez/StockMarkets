package com.sbz.fix.connection;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

import com.sbz.data.types.MessageMap;
import java.net.Socket;
import java.net.*;
import java.io.*;
import java.util.*;
import com.sbz.fix.adapter.FIXServerInterface;


public class FIXConnection extends Thread{
        Socket socket = null;
        private BufferedReader entrada = null;
        private PrintWriter salida = null;
        private FIXServerInterface in = null;
         boolean estado = true;
         private static final char DELIMITER = '\001';

    public FIXConnection(FIXServerInterface inter){
        this.in = inter;
        try{
        socket = new Socket("localhost",11000);
        salida = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
        entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }catch(Exception e){
          e.printStackTrace();
        }
        start();

     }
      public FIXConnection(FIXServerInterface inter,HashMap fixConParameters){
        this.in = inter;
        try{

       String host = (String)fixConParameters.get("host");
       Integer portAux = new Integer((String)fixConParameters.get("port"));
        int port = portAux.intValue();
        socket = new Socket(host,port);
        salida = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
        entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }catch(Exception e){
          e.printStackTrace();
        }
        start();

      }

     public void send(String message)
     {
       try{
       System.out.println("enviado a server mensaje");
       salida.write(message);
       System.out.println("enviado mensaje : " + message);
       salida.flush();
       }catch(Exception e){
        e.printStackTrace();
       }
     }
    public void run(){
       System.out.println("activado el run de connection");

//       while(estado){
       /* String mensaje = null;
        try{
        while( (mensaje = entrada.readLine()) != null){
         if(!mensaje.equals("")){
          ((FIXServerInterface)in).onFIXMessage(mensaje);
          System.out.println("mensaje recibido en fixserver: "  + mensaje);
         }
        }
        }catch(Exception e){
         e.printStackTrace();
        }*/

         while(true){
              System.out.println("dentro de while");
              String mensaje = null;
        try{
         System.out.println("antes de leer entrada");


         mensaje = entrada.readLine();
         }catch(Exception e){
         e.printStackTrace();
//         estado = false;
        }
         System.out.println("Cadena recuperada: " + mensaje);
         //socket.close();
         if(!mensaje.equals("")){
          ((FIXServerInterface)in).onFIXMessage(mensaje);
         }
        // System.out.println("despues de readline");

         // salida.write(mensaje);
          //salida.flush();

       }
       //System.out.println("me salgo del while,estado vale: " + estado);

    }

    /*public static void main(String args[]){

     FIXConnection f = new FIXConnection();
     for (int i = 10; i < 30; i++){
      f.send("8=FIX.4.0"+DELIMITER+"9=60"+DELIMITER+"35=A"+DELIMITER+"41=10000"+DELIMITER
       +"49=SBZN"+DELIMITER+"56=GOLD"+DELIMITER+"34=1"+DELIMITER+"52=20000714-08:41:16"
       +DELIMITER +"98=0"+DELIMITER+"108=120"+DELIMITER+"10=190" + DELIMITER);
     }


    }*/

}