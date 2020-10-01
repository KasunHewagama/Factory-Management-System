
/**
 * 
 */
package com.itp.services;

import java.io.IOException;
import java.rmi.activation.ActivationGroupDesc.CommandEnvironment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.itp.model.Employee;
import com.itp.util.CommonConstants;
import com.itp.util.CommonUtilities;
import com.itp.util.DBConnection;
import com.itp.util.QueryUtilities;

/**
 * @author Yuvin Nimnaka
 *
 */
public class EmployeeServiceImpl implements IEmployeeServices {

	public static final Logger log = Logger.getLogger(EmployeeServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;

	private static PreparedStatement preparedstatement;

	@Override
	public void addEmployee(Employee employee) {

//		String employeeID = CommonUtilities.generateEmployeeID(getEmployeeIDs());

		try {

			connection = DBConnection.getDBConnection();

			preparedstatement = connection
					.prepareStatement(QueryUtilities.queryByID(CommonConstants.QUERY_ID_INSERT_EMPLOYEE));
			connection.setAutoCommit(false);

			// get employee ids
//			employee.setEmployeeID(employeeID);
			
			preparedstatement.setString(CommonConstants.COLUMN_INDEX_ONE, employee.getEmployeeID());
			preparedstatement.setString(CommonConstants.COLUMN_INDEX_TWO, employee.getImg());
			preparedstatement.setString(CommonConstants.COLUMN_INDEX_THREE, employee.getFname());
			preparedstatement.setString(CommonConstants.COLUMN_INDEX_FOUR, employee.getLname());
			preparedstatement.setString(CommonConstants.COLUMN_INDEX_FIVE, employee.getGender());
			preparedstatement.setString(CommonConstants.COLUMN_INDEX_SIX, employee.getEmail());
			preparedstatement.setInt(CommonConstants.COLUMN_INDEX_SEVEN, employee.getContactNo());
			preparedstatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, employee.getAddress());
			preparedstatement.setString(CommonConstants.COLUMN_INDEX_NINE, employee.getUnit());
			preparedstatement.setString(CommonConstants.COLUMN_INDEX_TEN, employee.getDesignation());
			preparedstatement.setString(CommonConstants.COLUMN_INDEX_ELEVEN, employee.getType());

			preparedstatement.execute();
			connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (preparedstatement != null) {
					preparedstatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
	}

	@Override
	public Employee getEmployeeByID(String empoyeeID) {

		return null;
	}

	@Override
	public ArrayList<Employee> getEmployees() {

		
		return actionOnEmployee(null);
	}

	@Override
	public Employee updateEmployee(String employeeID, Employee employee) {

		return null;
	}

	@Override
	public void removeEmployee(String employeeID) {

		if (employeeID != null && !employeeID.isEmpty()) {

			try {
				connection = DBConnection.getDBConnection();
				preparedstatement = connection
						.prepareStatement(QueryUtilities.queryByID(CommonConstants.QUERY_ID_REMOVE_EMPLOYEE));
				preparedstatement.setString(CommonConstants.COLUMN_INDEX_ONE, employeeID);
				preparedstatement.executeUpdate();

			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());

			} finally {
				/*
				 * Close prepared statement and database connectivity at the end of transaction
				 */
				try {
					if (preparedstatement != null) {
						preparedstatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.itp.services.IEmployeeServices#getEmployeeIDs()
	 */

	public ArrayList<String> getEmployeeIDs() {

		ArrayList<String> idList = new ArrayList<String>();
		try {

			connection = DBConnection.getDBConnection();
			preparedstatement = connection
					.prepareStatement(QueryUtilities.queryByID(CommonConstants.QUERY_ID_GET_EMPLOYEE_IDS));
			ResultSet resultSet = preparedstatement.executeQuery();

			while (resultSet.next()) {
				idList.add(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (preparedstatement != null) {
					preparedstatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return idList;
	}
	
	private ArrayList<Employee> actionOnEmployee(String employeeID){
		
	
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		
		try {
			connection = DBConnection.getDBConnection();
			
			
			if(employeeID != null && !employeeID.isEmpty()) {
				
				preparedstatement = connection.prepareStatement(QueryUtilities.queryByID(CommonConstants.QUERY_ID_GET_EMPLOYEE_ID));
				preparedstatement.setString(CommonConstants.COLUMN_INDEX_ONE, employeeID);
				
				
			}
			
			else {
				
				preparedstatement = connection.prepareStatement(QueryUtilities.queryByID(CommonConstants.QUERY_ID_ALL_EMPLOYEES));
				
			}
			
			ResultSet resultSet = preparedstatement.executeQuery();
			
			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setEmployeeID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				employee.setImg(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				employee.setFname(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				employee.setLname(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				employee.setGender(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				employee.setEmail(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				employee.setContactNo(resultSet.getInt(CommonConstants.COLUMN_INDEX_SEVEN));
				employee.setAddress(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
				employee.setUnit(resultSet.getString(CommonConstants.COLUMN_INDEX_NINE));
				employee.setDesignation(resultSet.getString(CommonConstants.COLUMN_INDEX_TEN));
				employee.setType(resultSet.getString(CommonConstants.COLUMN_INDEX_ELEVEN));
				employeeList.add(employee);
			}
			
		}catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
			System.out.println("Get Employee Exception");
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedstatement != null) {
					preparedstatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		
		return employeeList;
	}

}
