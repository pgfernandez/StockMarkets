package com.sbz.fix.gateway.handlers;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */
import com.sbz.parsing.XMLManager;
import com.sbz.fix.gateway.dictionary.TagFIXTranslator;
import java.util.List;

public class RxMessageHandler {

  private TagFIXTranslator fixTranslator = null;
 // private XMLManager xmlManager = null;
/*  private List newOrderAcceptedTagList = null;
  private List newOrderRejectedTagList = null;
  private List logonAcceptedTagList = null;
  private List logonRejectedTagList = null;
  private List logoutTagList = null;
  private List cancelAcceptedTagList = null;
  private List cancelRejectedTagList = null;
  private List amendAcceptedTagList = null;
  private List amendRejectedTagList = null;
  private List conecctionTest         = null;
  private List fixRecognitionPattern = null;*/


  public RxMessageHandler(String delim) {
  // xmlManager = new XMLManager();//"F:\\Tradia\\cnf\\translations\\NewOrderConfirmation.xml");
 //  createTagLists();
   fixTranslator = new TagFIXTranslator(delim);//,fixRecognitionPattern);


   //hacer la lectura de los files de tal forma que no sea necesario
   //tocar codigo para nuevos mensajes.
   //en el de ida también, en plan tal tipo corresponde a tal xsl
   //y al revés igual, crear una tabla de conversiones
  }

 /* private void createTagLists(){
  // xmlManager.setFile("F:\\Tradia\\cnf\\translations\\NewOrderConfirmation.xml");
   //xmlManager.setElement("NewOrderConfirmation");
   fixRecognitionPattern = xmlManager.readAllByElement("F:\\Tradia\\cnf\\translations\\FixRecognitionPattern.xml","FixRecognitionPattern","tag");
   newOrderAcceptedTagList = xmlManager.readAllByElement("F:\\Tradia\\cnf\\translations\\NewOrderConfirmation.xml","NewOrderConfirmation","tag");
   cancelAcceptedTagList  = xmlManager.readAllByElement("F:\\Tradia\\cnf\\translations\\CancelOrderConfirmation.xml","CancelOrderConfirmation","tag");
   amendAcceptedTagList  = xmlManager.readAllByElement("F:\\Tradia\\cnf\\translations\\AmendOrderConfirmation.xml","AmendOrderConfirmation","tag");
  }*/
  public String messageToHandle(String fixMsg){

   //String tipoMensaje = fixTranslator.getMessageType(fixMsg);

//   String r = fixTranslator.translate(fixMsg, newOrderAcceptedTagList);
   String r = fixTranslator.translate(fixMsg);
   return r;
  }

  public static void main(String args[]){

   char del = '^';
   String fix = new String();
   fix = "11=Ves*" + del + "20=8888*" + del + "33=77777*" + del + "44=66666*"
          + del + "49=Si*" + del + "78=453489573" + del + "37=Molara!!!!!***" + del +
          "90=9845934757834" + del + "60=Esto*";
   RxMessageHandler r = new RxMessageHandler((new Character(del)).toString());
   String res = r.messageToHandle(fix);
   System.out.println("resultado de la traducción: " + res);


  }
}