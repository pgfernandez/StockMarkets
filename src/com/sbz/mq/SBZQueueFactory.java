package com.sbz.mq;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

import javax.jms.*;
import com.sun.messaging.*;
import javax.naming.*;
import java.util.Hashtable;
import com.sbz.data.types.MessageMap;




public final class SBZQueueFactory {

  private javax.jms.QueueConnectionFactory myConFactory = null;
  private QueueConnection myCon = null;
  private QueueSession mySession = null;
  private com.sun.messaging.Queue myQueue = null;
  private Context ctx = null;

  private String url = null;
  private String initialContextFactory = null;
  private String mqConnectionFactory = null;

  public SBZQueueFactory(MessageMap args) {

    url = (String)args.get("url");
    initialContextFactory = (String)args.get("initialContextFactory");
    mqConnectionFactory = (String)args.get("mqConnectionFactory");
    initializeMQ();//String url

  }

   private void initializeMQ()//String url)
  {
   // String url = "file:///F:/repository/somebiz/Proyecto Carrera/mq";
//    String url = "file:///F:/Tradia/files/mq";
    Hashtable env = new Hashtable();


/*    env.put(ctx.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");
    env.put(ctx.PROVIDER_URL,url); */

  //  env.put(ctx.INITIAL_CONTEXT_FACTORY, initialContextFactory);
    env.put(ctx.PROVIDER_URL,url);

/*    Queue queue = (Queue)reservationMsg.getJMSReplyTo ();
     QueueConnectionFactory factory = (QueueConnectionFactory)
     jndiContext.lookup ("java:comp/env/jms/QueueFactory");
     QueueConnection connect = factory.createQueueConnection ();
     QueueSession session = connect.createQueueSession (false,0);*/






    try {
	  // Create the initial context.
	    ctx = new InitialContext(env);

//             myConFactory =  (javax.jms.QueueConnectionFactory) ctx.lookup("TradiaMQConnectionFactory");
             myConFactory =  (javax.jms.QueueConnectionFactory) ctx.lookup(mqConnectionFactory);
             myCon = myConFactory.createQueueConnection();
             mySession = myCon.createQueueSession(false,Session.AUTO_ACKNOWLEDGE);
             myCon.start();


             /*    Queue queue = (Queue)reservationMsg.getJMSReplyTo ();
     QueueConnectionFactory factory = (QueueConnectionFactory)
     jndiContext.lookup ("java:comp/env/jms/QueueFactory");
     QueueConnection connect = factory.createQueueConnection ();
     QueueSession session = connect.createQueueSession (false,0);*/




        } catch (Exception ne)  {
	    System.err.println("Failed to create InitialContext: " + ne);
	    ne.printStackTrace();
	    System.exit(-1);
        }

  }

  public javax.jms.QueueSession getSession()
  {

    return mySession;

  }

  public com.sun.messaging.Queue getQueue(String queue){
     try{
     return (com.sun.messaging.Queue) ctx.lookup(queue);
     }catch(Exception e){

      e.printStackTrace();
      return null;
     }

  }



}
