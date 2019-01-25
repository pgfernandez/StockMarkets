package com.sbz.web.admin;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.sbz.fix.server.main.FIXServer;

public class TradiaAdministratorServlet extends HttpServlet {

  FIXServer fix = null;

  public TradiaAdministratorServlet() {
  }

  public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
  /*    fix = new FIXServer();

       boolean estado = fix.arranca();

       response.setContentType("text/html");
       PrintWriter out = response.getWriter();
//         this.db.executeInsert("INSERT INTO )
       out.println("<html>");
       out.println("<head>");
       /*out.println("<title>Hola</title>");
       out.println("</head>");*/
  /*     out.println("<body bgcolor=\"white\">");*/
  //     int status = this.db.executeInsert("INSERT INTO MARKETS VALUES('SBZ','Somebiz Electronic Exchange')");
/*        out.println("<h1> HelloWorldEJB Dice: </h1>");
            out.println(this.hw.hi());*/

/*       if(estado){
         out.println("<b>SERVIDOR ARRANCADO CORRECTAMENTE</b>");
       }else{
         out.println("<b>NO SE PUDO ARRANCAR LA PASARELA</b>");
       }

       out.println("</body>");
       out.println("</html>");*/

    }

}
