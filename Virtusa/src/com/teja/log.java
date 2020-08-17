package com.teja;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
import com.teja.dao.loginDao;


/**
 * Servlet implementation class log
 */
@WebServlet("/log")
public class log extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String u = request.getParameter("emailid");
		String p = request.getParameter("pwd");
		System.out.println(p);
		loginDao dao=new loginDao();
		
		 try
		 {
			 String userValidate = dao.check(u,p);
			 System.out.println(userValidate);
		  if(userValidate.equals("Admin_Role"))
		  {
		   System.out.println("Admin's Home");

		   HttpSession session = request.getSession(); //Creating a session
		   session.setAttribute("Admin", u); //setting session attribute
		   request.setAttribute("userName", u);

		   response.sendRedirect("admin.html");
		  }
		  else if(userValidate.equals("Driver_Role"))
		  {
		   System.out.println("Driver's Home");

		   HttpSession session = request.getSession();
		   session.setAttribute("Driver", u);
		   request.setAttribute("userName", u);

		   response.sendRedirect("driverLoc.html");
		  }
		  else if(userValidate.equals("User_Role"))
		  {
		   System.out.println("User's Home");

		   HttpSession session = request.getSession();
		   session.setMaxInactiveInterval(10*60);
		   session.setAttribute("User", u);
		   request.setAttribute("userName", u);

		   response.sendRedirect("loc.html");		  }
		  else
		  {
			  response.sendRedirect("llgin.html");		  }
		 }
		 catch (IOException e1)
		 {
		  e1.printStackTrace();
		 }
		 catch (Exception e2)
		 {
		  e2.printStackTrace();
		 }

	}

}
