package com.itp.servlets.employee;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.itp.model.Employee;

/**
 * Servlet implementation class AddEmployeeServlet
 */
@WebServlet("/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployeeServlet() {
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
		response.setContentType("text/html");
		
		Employee employee = new Employee();
	
		
		try {
			
			ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
			List<FileItem> multiFiles = sf.parseRequest(request);
			
			for(FileItem f : multiFiles) {	
			    String name = "D:\\Github\\ITP_Project\\Factory-Management-System\\Project_Front-End\\Bakthi-Herbal-Lanka\\WebContent\\WEB-INF\\files" + "\\" + f.getName();
				f.write(new File(name));
				employee.setImg(name);
				System.out.println(name);
				break;
			}
			

			
		} catch (Exception e) {		
			e.printStackTrace();
		}
			
//		employee.setFname(request.getParameter("fname"));
//		employee.setLname(request.getParameter("lname"));
//		employee.setAddress(request.getParameter("address"));
//		employee.setEmail(request.getParameter("email"));
//		employee.setContactNo(Integer.parseInt(request.getParameter("contact")));
//		employee.setGender(request.getParameter("gender"));
//		employee.setUnit(request.getParameter("unit"));
//		employee.setDesignation(request.getParameter("designation"));
//		employee.setType(request.getParameter("empType"));
//		employee.setUsername(request.getParameter("username"));
	}

}
