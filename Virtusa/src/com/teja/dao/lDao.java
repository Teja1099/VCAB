package com.teja.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

public class lDao {
	
	 public static double  check(double lat1,
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
	
	
	public String leastdist(double lat,double lng) {
		double min=1000000;
		double diff;
		String driverName="";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/vcab","root","1234");
			PreparedStatement st=  con.prepareStatement("select lat,longi,email from driverStatus where status=?");
			st.setString(1, "free");
			ResultSet rs= st.executeQuery();
			while(rs.next()) {
				//diff=check(lat,lng,Double.parseDouble(rs.getFloat("lat")),Double.parseDouble(rs.getFloat("longi"));
				diff=check(lat,lng,rs.getDouble("lat"),rs.getDouble("longi"));
				if(min>=diff) {
					min=diff;
					driverName=rs.getString("email");
					//System.out.println(rs.getString("rname"));
					
				}
				//System.out.println("diff:"+diff);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return driverName;
	}
}
