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
 * Servlet implementation class transaction
 */
@WebServlet("/transaction")
public class transaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public transaction() {
        super();
        // TODO Auto-generated constructor stub
    }

    public static double distance(double lat1, 
            double lat2, double lon1, 
                         double lon2) 
    { 

		// The math module contains a function 
		// named toRadians which converts from 
		// degrees to radians. 
		lon1 = Math.toRadians(lon1); 
		lon2 = Math.toRadians(lon2); 
		lat1 = Math.toRadians(lat1); 
		lat2 = Math.toRadians(lat2); 
	
		// Haversine formula  
		double dlon = lon2 - lon1;  
		double dlat = lat2 - lat1; 
		double a = Math.pow(Math.sin(dlat / 2), 2) 
		        + Math.cos(lat1) * Math.cos(lat2) 
		        * Math.pow(Math.sin(dlon / 2),2); 
		     
		double c = 2 * Math.asin(Math.sqrt(a)); 
		
		// Radius of earth in kilometers. Use 3956  
		// for miles 
		double r = 6371; 
		
		// calculate the result 
		return(c * r); 
    }  

	 
	 

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String destination=request.getParameter("destination");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		double lat1=Double.parseDouble(session.getAttribute("lat").toString());
		double lng1=Double.parseDouble(session.getAttribute("lng").toString());
		int di=0;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/vcab","root","1234");
			PreparedStatement st;
			PreparedStatement sql;
			st=con.prepareStatement("select dest,lat,longi,hike from destination where dest=?");
			st.setString(1, destination);
			ResultSet rs= st.executeQuery();
			  while(rs.next())
			  {
				  System.out.println(rs.getDouble("lat")+" "+rs.getDouble("longi"));
				  double lat2=rs.getDouble("lat");
				  double lng2=rs.getDouble("longi");
				  di=(int)distance(lat1,lat2,lng1,lng2);
//				  di=rs.getInt(columnIndex)
				  di=rs.getInt("hike")*di;
				  session.setAttribute("totprice", di);
				  System.out.println(Integer.parseInt(session.getAttribute("totprice").toString())+"km1");
			  }
			  String driver=session.getAttribute("driverName").toString();
				try {
					st = con.prepareStatement("update driverStatus set status=? where email=?");
					st.setString(1, "busy");
					st.setString(2, driver);
					st.executeUpdate();
				}catch(Exception e) {
					e.printStackTrace();
				}
				try {
					st = con.prepareStatement("select username,phnno from drivers where emailid=?");
					st.setString(1, driver);
					rs=st.executeQuery();
					if(rs.next()) {
						session.setAttribute("driverNick", rs.getString("username"));
						session.setAttribute("driverPhn", rs.getString("phnno"));
					}
				}catch(Exception e) {
					e.printStackTrace();
				}	
				String user=session.getAttribute("User").toString();
				try {
					sql = con.prepareStatement("insert into transaction values(?,?,?,?,?)");
					sql.setString(1, user);
					sql.setString(2, driver);
					sql.setString(3, destination);
					sql.setInt(4, di);
					sql.setString(5, "active");
					
					sql.execute();
				}catch(Exception e) {
					e.printStackTrace();
					
				}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("nick"+session.getAttribute("driverNick").toString());
		response.sendRedirect("transaction.jsp");
	}



}
