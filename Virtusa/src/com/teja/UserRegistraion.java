package com.teja;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teja.dao.rDao;

/**
 * Servlet implementation class UserRegistraion
 */
@WebServlet("/UserRegistraion")
public class UserRegistraion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistraion() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uid = request.getParameter("username");
		String email = request.getParameter("emailid");
		String mbno = request.getParameter("phnno");
		String pass = request.getParameter("pwd");
		String address = request.getParameter("address");
		rDao dao  = new rDao();
//		System.out.println(uid+""+email+""+mbno+""+pass+""+address);
			try {
				if(dao.push(uid,email,mbno,pass,address)) {
					System.out.println("hi");
					response.sendRedirect("llgin.html");
				}
				else {
					response.sendRedirect("registration.html");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
