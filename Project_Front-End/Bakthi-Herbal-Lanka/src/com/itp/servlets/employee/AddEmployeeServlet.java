package com.itp.servlets.employee;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.omg.CORBA.Request;

import com.itp.model.Employee;
import com.itp.model.Login;
import com.itp.services.EmployeeServiceImpl;
import com.itp.services.IEmployeeServices;
import com.itp.services.ILoginServices;
import com.itp.services.LoginServicesImpl;

/**
 * Servlet implementation class AddEmployeeServlet
 */
@MultipartConfig
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

		ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
		List<FileItem> formItem = null;
		
		Employee e = new Employee();
		Login l = new Login();
		
//			List<FileItem> multiFiles = sf.parseRequest(request);
		
//		try {
////			
//			
//			for(FileItem f : multiFiles) {	
//			    String name = "D:\\Github\\ITP_Project\\Factory-Management-System\\Project_Front-End\\Bakthi-Herbal-Lanka\\WebContent\\WEB-INF\\files" + "\\" + f.getName();
//				f.write(new File(name));
////				employee.setImg(name);
////				login.setImg(name);
//				System.out.println(name);
//				break;
//			}
//			
//
//			
//		} catch (Exception e) {		
//			e.printStackTrace();
//		}
		try {
			formItem = sf.parseRequest(request);
			
		} catch (FileUploadException exception) {
			exception.printStackTrace();
		}
		
	
		
		for(FileItem item : formItem) {
			
			String textInput = item.getFieldName();
			System.out.println(textInput);
			if(textInput.equals("empID")) {
				System.out.println(item.getString());
				e.setEmployeeID(item.getString());
				
			}
			else if(textInput.equals("image")) {
				

				try {
					System.out.println("asasd");
						
					    String name = "D:\\Github\\ITP_Project\\Factory-Management-System\\Project_Front-End\\Bakthi-Herbal-Lanka\\WebContent\\images\\imagefiles" + "\\" + item.getName();
						item.write(new File(name));
						e.setImg(item.getName());
						l.setImg(item.getName());
						System.out.println(item.getName());
						
					}
			

					
				 catch (Exception exception) {		
					exception.printStackTrace();
				}
			}
			else if(textInput.equals("fname")) {
				e.setFname(item.getString());
				l.setFname(item.getString());
			}
			else if(textInput.equals("lname")) {
				e.setLname(item.getString());
				l.setLname(item.getString());
			}
			else if(textInput.equals("gender")) {
				e.setGender(item.getString());
			}
			else if(textInput.equals("email")) {
				e.setEmail(item.getString());
			}
			else if(textInput.equals("contact")) {
				e.setContactNo(Integer.parseInt(item.getString()));
			}
			else if(textInput.equals("address")) {
				e.setAddress(item.getString());
			}
			else if(textInput.equals("unit")) {
				e.setUnit(item.getString());
			}
			else if(textInput.equals("designation")) {
				e.setDesignation(item.getString());
				l.setDesignation(item.getString());
			}
			else if(textInput.equals("username")){
				l.setUsername(item.getString());
			}
			else if(textInput.equals("createPwrd")) {
				l.setPassword(item.getString());
			}
			else if(textInput.equals("confirmPwrd")) {
				
			}
		}
	
		
	
		IEmployeeServices iEmployeeServices = new EmployeeServiceImpl();
		iEmployeeServices.addEmployee(e);

	
		ILoginServices iLoginServices = new LoginServicesImpl();
		iLoginServices.addLogin(l);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/EmployeeList.jsp");
		dispatcher.forward(request, response);
		
		
		
		
	}

}
