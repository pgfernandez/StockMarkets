package com.sbz.host.connection;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

//import com.sbz.fix.adapter.Adapter;
import com.sbz.fix.adapter.HostConnectionInterface;
import java.net.Socket;
import java.net.*;
import java.io.*;
import java.util.*;


public class HostClient{// extends Thread{

//    private ServerSocket SNASocket = null;
/*    private HashMap pool = new HashMap();
    private Adapter parent = null;
    private int port;
    private Socket sock = null;
    private BufferedReader entrada = null;
    private PrintWriter salida = null;
*/
//public class HostConnection extends Thread{// implements SNAEvent{

  public HostClient(HostConnectionInterface parent,int port) {
  /*   start();
     pool.put(new Integer(0),null);
     this.parent = parent;
     this.port = port;
     this.sock = new Socket("localhost",12000);*/
   }
/*   public void run(){
    try{

     System.out.println("servidor escuchando en el puerto 12000");


     while(true){
       try{
         entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
         salida = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
         String mensaje = null;
         mensaje = entrada.readLine();
         System.out.println("Cadena recuperada: " + mensaje);
         socket.close();
         ((Adapter)parent).onSNAMessage(mensaje);

        // System.out.println("despues de readline");

         // salida.write(mensaje);
        }catch(Exception e){
         e.printStackTrace();
    }

     }catch(Exception e){
      e.printStackTrace();
     }
   }

   /*public void onSNAMessage(String message){


   }*/

  /*class ConnectionHost extends Thread{

        Socket socket = null;//new Socket();
        private HostConnection con = null;

    public ConnectionHost(Socket socket,HostConnection con){
      System.out.println("creado socket");
        this.socket = socket;
        this.con = con;
        start();

     }

    public void run(){


    }


    }
  }
/*    public static void main(String args[]){
       // HostConnection c = new HostConnection(this);


    }*/
}

