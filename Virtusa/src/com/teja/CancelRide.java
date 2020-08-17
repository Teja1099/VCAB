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
 * Servlet implementation class CancelRide
 */
@WebServlet("/CancelRide")
public class CancelRide extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelRide() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/vcab","root","1234");
			PreparedStatement st;
			PreparedStatement sql;
			String user=session.getAttribute("User").toString();
			String driver="";
			try {
				st = con.prepareStatement("select driver from transaction where passenger=?");
				st.setString(1, user);	
				ResultSet rs=st.executeQuery();
				if(rs.next()) {
					driver=rs.getString("driver");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}	
			try {
				sql = con.prepareStatement("delete from transaction where passenger=?");
				sql.setString(1, user);			
				sql.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
				
			}
			  
				try {
					st = con.prepareStatement("update driverStatus set status=? where email=?");
					st.setString(1, "free");
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
