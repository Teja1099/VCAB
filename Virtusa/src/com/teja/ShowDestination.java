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
 * Servlet implementation class ShowDestination
 */
@WebServlet("/ShowDestination")
public class ShowDestination extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowDestination() {
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

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		out.print("<h1> Choose Appropriate Destination</h1><br>");
		out.print("<table><tr><th>place</th><th>Distance in km</th></tr>");
		double lat1=Double.parseDouble(session.getAttribute("lat").toString());
		double lng1=Double.parseDouble(session.getAttribute("lng").toString());
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/vcab","root","1234");
			PreparedStatement st=  con.prepareStatement("select dest,lat,longi from destination");
			
			ResultSet rs= st.executeQuery();
			  while(rs.next())
			  {
				  
				  double lat2=rs.getDouble("lat");
				  double lng2=rs.getDouble("longi");
				  out.print("<tr><td>");
				  out.print(rs.getString("dest"));
				  out.print("</td><td>");
				  int di=(int)distance(lat1,lat2,lng1,lng2);
				  out.print(di);
				  
				  out.print("</td></tr>");
				  
			  }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		out.print("</table>");
	}



}
