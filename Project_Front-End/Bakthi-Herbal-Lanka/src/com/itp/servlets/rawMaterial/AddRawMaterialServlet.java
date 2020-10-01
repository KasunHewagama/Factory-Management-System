package com.itp.servlets.rawMaterial;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itp.model.rawMaterial;
import com.itp.services.IRawMaterialServices;
import com.itp.services.RawMaterialServiceImpl;


/**
 * Servlet implementation class AddRawMaterialServlet
 */
@WebServlet("/AddRawMaterialServlet")
public class AddRawMaterialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRawMaterialServlet() {
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
		
		rawMaterial rm = new rawMaterial();
		
		rm.setRawMaterialName(request.getParameter("rName"));
		rm.setRawMaterialDes(request.getParameter("rawDes"));
		rm.setStoreID(request.getParameter("storeID"));
		rm.setUnitPrice(Double.parseDouble(request.getParameter("unitPrice")));
		rm.setStatus(request.getParameter("status"));
	
		IRawMaterialServices iRawMaterialServices = new RawMaterialServiceImpl();
		iRawMaterialServices.addRawMaterial(rm);
		
		request.setAttribute("rawMaterial", rm);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/rawMaterialList.jsp");
		dispatcher.forward(request, response);
	}

}
