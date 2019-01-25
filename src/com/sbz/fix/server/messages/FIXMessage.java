package com.sbz.fix.server.messages;

/**
 * Title:        FIXServer
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:      Reuters DSS
 * @author Pedro Garcia
 * @version 1.0
 */

public class FIXMessage {

/**
 * Caracter que delimita los campos del mensaje FIX.
 */
  private static final char DELIMITER = '^';

 /**
  * Cadena que constituye el incio de un mensaje FIX.
  */
  private static final String ENCABEZADO = "8=FIX.4.0" + DELIMITER + "9=60" + DELIMITER + "35=";

/**
 * Cadena que constituye el fin de un mensaje FIX.
 */
  private static final String FIN = "10=190" + DELIMITER;

/**
 * Tag fin de mensaje FIX.
 */
 private static final String TAG_FIN = "10=";

/**
 * Tag que identifica el numero de orden.
 */
  private static final String TAG_NUM_ORDEN = "11";

/**
 * Tag que identifica el tipo de orden.
 */
 private static final String TAG_TIPO_ORDEN = "35";
/**
 * Tag que identifica el numero de cancelacion.
 */
 private static final String TAG_NUMERO_CANCELACION = "41";
/**
 * Tag que identifica el numero de mensaje inicial de peticion de reenvio
 * por parte del cliente.(Resend Request).
 */
 private static final String TAG_NUMERO_INICIO = "7";
/**
 * Tag que identifica el numero de mensaje final de peticion de reenvio
 * por parte del cliente.(Resend Request).
 */
 private static final String TAG_NUMERO_REENVIO = "16";
/**
 * Tag que identifica el numero de secuencia.
 */
 private static final String NUM_SECUENCIA = "34=";

  /**
   * Constructor de FIXMessage.
   */
public FIXMessage() {

  }

  /**
   * Devuelve el delimter.
   */
  public char getDelimiter(){
   return DELIMITER;
  }

  /**
   * Devuelve el encabezado.
   */
  public String getEncabezado(){
    return ENCABEZADO;
  }

  /**
   * Devuelve el fin.
   */
  public String getFin(){
    return FIN;
  }

 /**
   * Devuelve el tag que identifica el numero de orden.
   */
  public String getTagNumOrden(){

   return TAG_NUM_ORDEN;
  }

 /**
   * Devuelve el tag que identifica el tipo de orden.
   */
  public String getTagTipoOrden(){

   return TAG_TIPO_ORDEN;

  }

  /**
   * Devuelve el tag que identifica el numero de cancelacion.
   */
  public String getTagNumeroCancelacion(){

  return TAG_NUMERO_CANCELACION;

  }

   /**
   * Devuelve el tag que identifica el numero secuencia a partir el cual
   * hay que realizar un reenvio.
   */
  public String getTagNumeroInicio(){

   return TAG_NUMERO_INICIO;

  }

   /**
   * Devuelve el tag que identifica el numero ultimo de secuencia de la peticion
   * de reenvio.
   */
  public String getTagNumeroFinal(){

   return TAG_NUMERO_REENVIO;
  }

   /**
   * Devuelve el tag que identifica el numero de secuencia.
   */
  public String getTagNumeroSecuencia(){

   return NUM_SECUENCIA;
  }

  /**
   * Devuelve el tag que identifica fin de mensaje.
   */
   public String getTagFin(){

    return TAG_FIN;

   }
}