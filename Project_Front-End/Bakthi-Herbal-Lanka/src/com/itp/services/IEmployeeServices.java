
/**
 * 
 */
package com.itp.services;

import java.util.ArrayList;

import com.itp.model.Employee;



/**
 * @author Yuvin Nimnaka
 *
 */
public interface IEmployeeServices {

	public void addEmployee(Employee employee);

	/**
	 * Get a particular Employee
	
	 */
	public Employee getEmployeeByID(String empoyeeID);
	
	/**
	 * Get all list of employees
	
	 */
	public ArrayList<Employee> getEmployees();
	
	/**
	 * Update existing employee
	 
	 */
	public Employee updateEmployee(String employeeID, Employee employee);

	/**
	 * Remove existing employee
	 * 
	 */
	public void removeEmployee(String employeeID);
	
	public ArrayList<String> getEmployeeIDs();
	
}
