package com.sbz.host.messages;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

public class HostLogonRequest extends HostMessage{


  /**
   * Indica cada cuanto tiempo hay que chequear
   * la conexion con el broker.
   */
  protected String heartBeatInterval = null;

  /**
   * Indica el m&eacute;todo de encriptaci&oacute;n
   * que se requiere para la comunicaci&oacute;n.
   */
  protected String encryptMethod = null;


  /**
   * Constructor de la clase Logon.
   * @param hostMessage El mensaje de logon a tratar
   */
  public HostLogonRequest(String hostMessage) {

    messageToTreat = hostMessage;
    createNewOrder();

  }

  public void setHeartBeatInterval(String interval){

    heartBeatInterval = interval;

  }

  public String getHeartBeatInterval(){

    return heartBeatInterval;
  }

  public void setEncryptMethod(String method){

    encryptMethod = method;

  }

  public String getEncryptMethod(){

    return encryptMethod;
  }

  protected void createNewOrder(){

   super.serMessageType(messageToTreat.substring(0,2));
   this.setHeartBeatInterval(messageToTreat.substring(2,5));
   super.setSenderCompID(messageToTreat.substring(5,10));
   super.setDate(messageToTreat.substring(10,27));
   super.setTargetCompID(messageToTreat.substring(27,31));
   this.setEncryptMethod(messageToTreat.substring(31,32));

  }



}