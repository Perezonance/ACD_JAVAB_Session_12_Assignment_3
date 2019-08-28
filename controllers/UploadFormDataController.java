package controllers;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBConnection;
import db.DBUtility;

/**
 * Servlet implementation class UploadFormDataController
 */
@WebServlet("/UploadFormDataController")
public class UploadFormDataController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UploadFormDataController() {
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
		String first = request.getParameter("first");
		String last = request.getParameter("last");
		String dpt = request.getParameter("dpt");
		String sal = request.getParameter("salary");
		
		response.setContentType("text/html");
		
		String query = "INSERT INTO `employeedb`.`employees` (employee_first_name, employee_last_name, employee_department, "
				+ "employee_salary) VALUES ('" + first + "', '" + last + "', '" + dpt + "', '" + sal +"');";
	
		File f = new File("app.properties");
		Connection con = DBConnection.connect(f);
		
		if(DBUtility.insertData(query, con)) {
			response.getWriter().append(
					"<meta http-equiv='refresh' content='3;URL=RequestDBController'><p style='color:red;'>Employee saved successfully</p>");
		}else {
			response.getWriter().append(
					"<meta http-equiv='refresh' content='3;URL=RequestDBController'><p style='color:red;'>Employee saved unsuccessfully</p>");
		}
	}
}
