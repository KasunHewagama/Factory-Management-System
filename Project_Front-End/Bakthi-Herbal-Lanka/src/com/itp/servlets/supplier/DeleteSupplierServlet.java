package com.itp.servlets.supplier;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itp.services.ISupplierServices;
import com.itp.services.SupplierServiceImpl;

/**
 * Servlet implementation class DeleteSupplierServlet
 */
@WebServlet("/DeleteSupplierServlet")
public class DeleteSupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSupplierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Delete servlet");
		
		String supplierID = request.getParameter("deleteText");
		System.out.println(supplierID);
		
		ISupplierServices iSupplierService = new SupplierServiceImpl();
		iSupplierService.removeSupplier(supplierID);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/supplierList.jsp");
		dispatcher.forward(request, response);
	}

}
