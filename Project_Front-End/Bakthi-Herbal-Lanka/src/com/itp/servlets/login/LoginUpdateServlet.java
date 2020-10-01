package com.itp.servlets.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itp.model.Login;
import com.itp.services.ILoginServices;
import com.itp.services.LoginServicesImpl;

/**
 * Servlet implementation class LoginUpdateServlet
 */
@WebServlet("/LoginUpdateServlet")
public class LoginUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String uname = request.getParameter("uName");
		String password = request.getParameter("pWrd");
		String lid = request.getParameter("lId");
		
		Login login = new Login();
		login.setLoginID(lid);
		login.setUsername(uname);
		login.setPassword(password);
		
		ILoginServices iLoginServices = new LoginServicesImpl();
		iLoginServices.updateLogin(lid, login);
		System.out.println(uname);
		System.out.println(password);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/LoginCreds.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
