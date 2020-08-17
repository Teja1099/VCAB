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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CompleteRide
 */
@WebServlet("/CompleteRide")
public class CompleteRide extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompleteRide() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			HttpSession session = request.getSession();
			String driver = session.getAttribute("Driver").toString();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/vcab","root","1234");
			PreparedStatement st;
			
				try {
					st = con.prepareStatement("update driverStatus set status=? where email=?");
					st.setString(1, "free");
					st.setString(2, driver);
					st.executeUpdate();
				}catch(Exception e) {
					e.printStackTrace();
				}
				try {
					st = con.prepareStatement("update transaction set status=? where driver=?");
					st.setString(1, "done");
					st.setString(2, driver);
					st.executeUpdate();
				}catch(Exception e) {
					e.printStackTrace();
				}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("index.html");
	}


}
