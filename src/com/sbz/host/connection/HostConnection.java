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

public class HostConnection extends Thread{// implements SNAEvent{

    private ServerSocket SNASocket = null;
    private HashMap pool = new HashMap();
    private HostConnectionInterface parent = null;
    private int port;
    private ConnectionHost con = null;

  public HostConnection(HostConnectionInterface parent,int port) {
     start();
     pool.put(new Integer(0),null);
     this.parent = parent;
     this.port = port;
   }

   public void sendMessage(String message)
   {
      con.send(message);

   }

   public void run(){
    try{
     SNASocket = new ServerSocket(port);
     System.out.println("servidor escuchando en el puerto 12000");

    // while(true){
          //ConnectionHost con =
      con = new ConnectionHost(SNASocket.accept(),this);
      //pool.put(new Integer(pool.size() + 1), con);

     //}
     }catch(Exception e){
      e.printStackTrace();
     }
   }

   /*public void onSNAMessage(String message){


   }*/

  class ConnectionHost extends Thread{

        Socket socket = null;//new Socket();
        private BufferedReader entrada = null;
        private PrintWriter salida = null;
        private HostConnection con = null;

    public ConnectionHost(Socket socket,HostConnection con){
      System.out.println("creado socket");
        this.socket = socket;
        this.con = con;
        try{
        salida = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
        }catch(Exception e){
          e.printStackTrace();
        }
        start();

     }

     public void send(String message)
     {
       try{
       System.out.println("devuelto a host mensaje");
       salida.write(message);
       salida.flush();
       }catch(Exception e){
        e.printStackTrace();
       }
     }
    public void run(){
       while(true){//socket.isConnected()){
        try{
         entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
         String mensaje = null;
         mensaje = entrada.readLine();
         System.out.println("Cadena recuperada: " + mensaje);
         //socket.close();
         ((HostConnectionInterface)parent).onSNAMessage(mensaje);

        // System.out.println("despues de readline");

         // salida.write(mensaje);
          //salida.flush();


        }catch(Exception e){
         e.printStackTrace();
        }
       }

    }


    }
/*    public static void main(String args[]){
       // HostConnection c = new HostConnection(this);


    }*/
}

