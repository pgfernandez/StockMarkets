package com.sbz.db.ejb.test;

import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import com.sbz.db.ejb.*;
/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

public class MarketsServletTest extends HttpServlet {

//  private DBManagerRemote db = null;

  public MarketsServletTest() throws NamingException
  {

  /*	Context ctx = new InitialContext();
	DBManagerHomeRemote home = (DBManagerHomeRemote) PortableRemoteObject.narrow(ctx.lookup("DBManager"),
									   DBManagerHomeRemote.class);
	try {
	    this.db = home.create();
	} catch (Exception e) { }*/
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
//         this.db.executeInsert("INSERT INTO )
        out.println("<html>");
        out.println("<head>");
        /*out.println("<title>Hola</title>");
        out.println("</head>");*/
        out.println("<body bgcolor=\"white\">");
   //     int status = this.db.executeInsert("INSERT INTO MARKETS VALUES('SBZ','Somebiz Electronic Exchange')");
/*        out.println("<h1> HelloWorldEJB Dice: </h1>");
	     out.println(this.hw.hi());*/
        out.println("<b>Registro insertado: Somebiz Electronic Exchange</b>");
        out.println("</body>");
        out.println("</html>");
    }



}