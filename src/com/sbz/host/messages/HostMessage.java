package com.sbz.host.messages;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

 import java.util.Hashtable;

public class HostMessage {

 /**
  * Representa el tipo de mensaje enviado por el Host.
  */
 protected String m_messageType = null;

 /**
  * Representa el mensaje a tratar para su env&iacute;o al
  * broker a trav&eacute;s de la pasarela
  */
 protected String messageToTreat = null;

  /**
   * Indica la fecha en la que se produce el env&iacute;o del mensaje.
   */
  protected String m_date = null;

  /**
   * Indica que entidad de inversi&oacute;n est&aacute
   * realizando la comunicaci&oacute;n.
   */
  protected String m_senderCompID = null;
  /**
   * Representa el broker destiantario con el cual se va a mantener
   * la sesi&oacute;n.
   */
  protected String m_targetCompID = null;


  public HostMessage() {
  }

  /**
   * M&eacute; que se puede sobreescribir por cualquier clase que herede
   * de HostMessage.
   */
  protected void createNewOrder() {}

  public void serMessageType(String type){

    m_messageType = type;

  }

  public String getMessageType(){

    return m_messageType;

  }

  public void setDate(String date){

    m_date = date;

  }

  public String getDate(){

    return m_date;

  }

    public void setSenderCompID(String sender){

    m_senderCompID = sender;

  }

  public String getSenderCompID(){

    return m_senderCompID;

  }
  public void setTargetCompID(String target){

    m_targetCompID = target;

  }

  public String getTargetCompID(){

    return m_targetCompID;

  }


}