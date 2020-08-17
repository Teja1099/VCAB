package com.teja;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemoveDriver
 */
@WebServlet("/RemoveDriver")
public class RemoveDriver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveDriver() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("driverid");
		PrintWriter out = response.getWriter();
		out.print("<h1>Driver Removed Successfully</h1><br>");
		out.print("<table><tr><th>User Name</th><th>Email Id</th></tr>");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/vcab","root","1234");
			PreparedStatement st=  con.prepareStatement("select fullname,email from users where email=?");
			st.setString(1, id);
			ResultSet rs= st.executeQuery();
			  while(rs.next())
			  {
				  out.print("<tr><td>");
				  out.print(rs.getString(1));
				  out.print("</td><td>");
				  out.print(rs.getString(2));
				  out.print("</td></tr>");
			  }
			  PreparedStatement del=  con.prepareStatement("delete from users where email=?");
			  del.setString(1, id);
			  del.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		out.print("</table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
