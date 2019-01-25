package com.sbz.fix.server.admin.web;

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
import com.sbz.fix.server.admin.pattern.mediator.FIXServerAdminConcreteMediator;
import com.sbz.fix.server.main.FIXServer;
import java.io.*;

public class FIXServerAdminServlet extends HttpServlet{

  private FIXServerAdminConcreteMediator mediator = null;
  private FIXServer fixServer = null;

  public FIXServerAdminServlet() {

    mediator = new FIXServerAdminConcreteMediator();
//    fixServer = new FIXServer(mediator);

  }

  public void doGet(HttpServletRequest request,
                     HttpServletResponse response)
       throws IOException, ServletException
   {
    // PrintWriter out = response.getWriter();

    String param = request.getParameter("estado");
    if (param!=null){

      if (fixServer!=null){
       //responder activo
       response.sendRedirect("arrancado.html");
      }else{
        response.sendRedirect("parado.html");
        //arrancar
      }



    }


   }


}
