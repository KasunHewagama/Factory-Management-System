package com.itp.servlets.supplier;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itp.model.Supplier;
import com.itp.services.ISupplierServices;
import com.itp.services.SupplierServiceImpl;

/**
 * Servlet implementation class GetSupplierServlet
 */

public class GetSupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSupplierServlet() {
        super();
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
		
		response.setContentType("text/html");
		
		String supplierId = (String) request.getAttribute("supplierId");
		ISupplierServices iSupplierServices = new SupplierServiceImpl();
		Supplier supplier = iSupplierServices.getSupplierByID(supplierId);
	
		request.setAttribute("supplier", supplier);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/supplierList.jsp");
		dispatcher.forward(request, response);
	}

}
