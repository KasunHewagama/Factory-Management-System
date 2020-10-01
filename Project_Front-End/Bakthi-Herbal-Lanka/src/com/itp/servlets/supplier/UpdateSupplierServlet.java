package com.itp.servlets.supplier;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itp.model.Supplier;
import com.itp.services.ISupplierServices;
import com.itp.services.SupplierServiceImpl;

/**
 * Servlet implementation class UpdateSupplierServlet
 */
@WebServlet("/UpdateSupplierServlet")
public class UpdateSupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSupplierServlet() {
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
		
		response.setContentType("text/html");
		
		Supplier supplier = new Supplier();
		
		System.out.println("hello");
		String sid = request.getParameter("SupID");
		System.out.println(sid);
		String supname =request.getParameter("supName");
		String suptelNo = request.getParameter("telNo");
		System.out.println(suptelNo);
		String supemail = request.getParameter("email");
		String supaddress = request.getParameter("address");
		String pid = request.getParameter("proId");
		
		supplier.setSupplierName(supname);
		supplier.setSupplierID(sid);
		
		supplier.setContactNo(suptelNo);
		supplier.setAddress(supaddress);
		supplier.setEmail(supemail);
		supplier.setProductId(pid);
		
		ISupplierServices iSupplierServices = new SupplierServiceImpl();
		iSupplierServices.updateSupplier(sid, supplier);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/supplierList.jsp");
		dispatcher.forward(request, response);
	}

}
