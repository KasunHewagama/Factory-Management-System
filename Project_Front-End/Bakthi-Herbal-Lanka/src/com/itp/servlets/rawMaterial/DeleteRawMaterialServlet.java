package com.itp.servlets.rawMaterial;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itp.services.IRawMaterialServices;
import com.itp.services.RawMaterialServiceImpl;

/**
 * Servlet implementation class DeleteRawMaterialServlet
 */
@WebServlet("/DeleteRawMaterialServlet")
public class DeleteRawMaterialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteRawMaterialServlet() {
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
		
		String rawMaterialID = request.getParameter("deleteText");
		System.out.println(rawMaterialID);
		
		IRawMaterialServices iRawMaterialService = new RawMaterialServiceImpl();
		iRawMaterialService.removeRawMaterial(rawMaterialID);
	
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/rawMaterialList.jsp");
		dispatcher.forward(request, response);
	}

}
