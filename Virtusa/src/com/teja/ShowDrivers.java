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
 * Servlet implementation class ShowDrivers
 */
@WebServlet("/ShowDrivers")
public class ShowDrivers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowDrivers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out = response.getWriter();
		out.print("<h1> Display Of All The Drivers</h1><br>");
		out.print("<table><tr><th>User Name</th><th>Email Id</th></tr>");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/vcab","root","1234");
			PreparedStatement st=  con.prepareStatement("select fullname,email from users where role=?");
			st.setString(1, "User");
			ResultSet rs= st.executeQuery();
			  while(rs.next())
			  {
				  out.print("<tr><td>");
				  out.print(rs.getString(1));
				  out.print("</td><td>");
				  out.print(rs.getString(2));
				  out.print("</td></tr>");
			  }
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
