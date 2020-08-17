package com.teja;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teja.dao.driverLocDao;

/**
 * Servlet implementation class driverLoc
 */
@WebServlet("/driverLoc")
public class driverLoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public driverLoc() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		double lat = Double.parseDouble(request.getParameter("latitude"));
		double lng = Double.parseDouble(request.getParameter("longitude"));
		HttpSession session =request.getSession();
		String email= (session.getAttribute("Driver")).toString();
		System.out.println(lat+" hi"+lng);
		driverLocDao dao = new driverLocDao();
		
		try {
			if(dao.push(email,lat,lng)) {
				
				response.sendRedirect("driver.html");
			}
			else {
				response.sendRedirect("driverLoc.html");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
