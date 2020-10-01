package com.itp.services;

import java.io.IOException;
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

import com.itp.model.Supplier;
import com.itp.util.CommonConstants;
import com.itp.util.CommonUtilities;
import com.itp.util.DBConnection;
import com.itp.util.QueryUtilities;

/**
 * @author HP
 *
 */

public class SupplierServiceImpl implements ISupplierServices {


	/** Initialize logger */
	public static final Logger log = Logger.getLogger(SupplierServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;
	
	private static PreparedStatement preparedstatement;
	
	/* ADD SUPPLIER BEGIN*/
	
		public void addSupplier(Supplier supplier) {
			
		String supplierID = CommonUtilities.generateSupplierID(getSupplierIDs());

		try {

			connection = DBConnection.getDBConnection();

			preparedstatement = connection
					.prepareStatement(QueryUtilities.queryByID(CommonConstants.QUERY_ID_INSERT_SUPPLIER));
			connection.setAutoCommit(false);

			supplier.setSupplierID(supplierID);
			preparedstatement.setString(CommonConstants.COLUMN_INDEX_ONE, supplier.getSupplierID());
			preparedstatement.setString(CommonConstants.COLUMN_INDEX_TWO, supplier.getSupplierName());
			preparedstatement.setString(CommonConstants.COLUMN_INDEX_THREE, supplier.getContactNo());
			preparedstatement.setString(CommonConstants.COLUMN_INDEX_FOUR, supplier. getEmail());
			preparedstatement.setString(CommonConstants.COLUMN_INDEX_FIVE, supplier.getAddress());
			preparedstatement.setString(CommonConstants.COLUMN_INDEX_SIX, supplier.getProductId());
			preparedstatement.execute();
			connection.commit();


		} catch (SQLException | SAXException | ParserConfigurationException | ClassNotFoundException | IOException e) {
			System.out.println(e);
			System.out.println("Error");

		} finally {
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
	}/* ADD SUPPLIER END*/
	
public ArrayList<String> getSupplierIDs(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		/*
		 * List of employee IDs will be retrieved from EmployeeQuery.xml
		 */
		try {
			connection = DBConnection.getDBConnection();
			preparedstatement = connection
					.prepareStatement(QueryUtilities.queryByID(CommonConstants.QUERY_ID_GET_SUPPLIER_IDS));
			ResultSet resultSet = preparedstatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
			}
		} catch (SQLException | SAXException | IOException | ParserConfigurationException
				| ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
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
		return arrayList;
	}
	
/**
 * Employee details can be retrieved based on the provided employee ID
 * 
 * @param employeeID
 *            - Employee details are filtered based on the ID
 * 
 * @see #actionOnEmployee()
 */
@Override
public Supplier getSupplierByID(String supplierID) {

	return actionOnSupplier(supplierID).get(0);
}

/**
 * Get all list of employees
 * 
 * @return ArrayList<Employee> 
 * 						- Array of employee list will be return
 * 
 * @see #actionOnEmployee()
 */
@Override
public ArrayList<Supplier> getSuppliers() {
	
	return actionOnSupplier(null);
}

/**
 * This performs GET employee by ID and Display all employees
 * 
 * @param employeeID
 *            ID of the employee to remove or select from the list

 * @return ArrayList<Employee> Array of employee list will be return
 * 
 * @throws SQLException
 *             - Thrown when database access error occurs or this method is
 *             called on a closed connection
 * @throws ClassNotFoundException
 *             - Thrown when an application tries to load in a class through
 *             its string name using
 * @throws SAXException
 *             - Encapsulate a general SAX error or warning
 * @throws IOException
 *             - Exception produced by failed or interrupted I/O operations.
 * @throws ParserConfigurationException
 *             - Indicates a serious configuration error.
 * @throws NullPointerException
 *             - Service is not available
 * 
 * @see #getEmployees()
 * @see #getEmployeeByID(String)
 */
private ArrayList<Supplier> actionOnSupplier(String supplierID) {

	ArrayList<Supplier> supplierList = new ArrayList<Supplier>();
	try {
		connection = DBConnection.getDBConnection();
		/*
		 * Before fetching employee it checks whether employee ID is
		 * available
		 */
		if (supplierID != null && !supplierID.isEmpty()) {
			/*
			 * Get employee by ID query will be retrieved from
			 * EmployeeQuery.xml
			 */
			preparedstatement = connection
					.prepareStatement(QueryUtilities.queryByID(CommonConstants.QUERY_ID_GET_SUPPLIER_ID));
			preparedstatement.setString(CommonConstants.COLUMN_INDEX_ONE, supplierID);
		}
		/*
		 * If employee ID is not provided for get employee option it display
		 * all employees
		 */
		else {
			preparedstatement = connection
					.prepareStatement(QueryUtilities.queryByID(CommonConstants.QUERY_ID_ALL_SUPPLIERS));
		}
		ResultSet resultSet = preparedstatement.executeQuery();

		while (resultSet.next()) {
			Supplier supplier = new Supplier();
			supplier.setSupplierID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
			supplier.setSupplierName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
			supplier.setContactNo(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
			supplier.setEmail(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
			supplier.setAddress(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
			supplier.setProductId(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
			supplierList.add(supplier);
		}

	} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
		log.log(Level.SEVERE, e.getMessage());
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
	return supplierList;
}

/**
 * Get the updated employee
 * 
 * @param employeeID
 *            ID of the employee to remove or select from the list
 * 
 * @return return the Employee object
 * 
 */
@Override
public Supplier updateSupplier(String supplierID, Supplier supplier) {

	/*
	 * Before fetching employee it checks whether employee ID is available
	 */
	if (supplierID != null && !supplierID.isEmpty()) {
		/*
		 * Update employee query will be retrieved from EmployeeQuery.xml
		 */
		try {
			connection = DBConnection.getDBConnection();
			preparedstatement = connection
					.prepareStatement(QueryUtilities.queryByID(CommonConstants.QUERY_ID_UPDATE_SUPPLIER));
			preparedstatement.setString(CommonConstants.COLUMN_INDEX_ONE, supplier.getSupplierName());
			preparedstatement.setString(CommonConstants.COLUMN_INDEX_TWO, supplier.getContactNo());
			preparedstatement.setString(CommonConstants.COLUMN_INDEX_THREE, supplier.getEmail());
			preparedstatement.setString(CommonConstants.COLUMN_INDEX_FOUR, supplier.getAddress());
			preparedstatement.setString(CommonConstants.COLUMN_INDEX_FIVE, supplier.getProductId());
			preparedstatement.setString(CommonConstants.COLUMN_INDEX_SIX, supplier.getSupplierID());
			preparedstatement.executeUpdate();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException
				| ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end
			 * of transaction
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
	// Get the updated employee
	return null;
}

/**
 * This method delete an employee based on the provided ID
 * 
 * @param employeeID
 *            - Delete employee according to the filtered employee details
 * @throws SQLException
 *             - Thrown when database access error occurs or this method is
 *             called on a closed connection
 * @throws ClassNotFoundException
 *             - Thrown when an application tries to load in a class through
 *             its string name using
 * @throws SAXException
 *             - Encapsulate a general SAX error or warning
 * @throws IOException
 *             - Exception produced by failed or interrupted I/O operations.
 * @throws ParserConfigurationException
 *             - Indicates a serious configuration error.
 * @throws NullPointerException
 *             - Service is not available
 */
@Override
public void removeSupplier(String supplierID) {

	// Before deleting check whether employee ID is available
	if (supplierID != null && !supplierID.isEmpty()) {
		/*
		 * Remove employee query will be retrieved from EmployeeQuery.xml
		 */
		try {
			connection = DBConnection.getDBConnection();
			preparedstatement = connection
					.prepareStatement(QueryUtilities.queryByID(CommonConstants.QUERY_ID_REMOVE_SUPPLIER));
			preparedstatement.setString(CommonConstants.COLUMN_INDEX_ONE, supplierID);
			preparedstatement.executeUpdate();
		} catch (SQLException | SAXException | IOException | ParserConfigurationException
				| ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end
			 * of transaction
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

}
