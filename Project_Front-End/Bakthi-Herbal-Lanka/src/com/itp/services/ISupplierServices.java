/**
 * 
 */
package com.itp.services;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.itp.model.Supplier;

/**
 * @author HP
 *
 */
public interface ISupplierServices {

	public static final Logger log = Logger.getLogger(ISupplierServices.class.getName());

	/**
	 * Add suppliers for supplier table
	 * @param supplier
	 */
	public void addSupplier(Supplier supplier);

	/**
	 * Get a particular Supplier
	 * 
	 * @param supplierID
	 * @return Supplier
	 */
	public Supplier getSupplierByID(String supplierID);
	
	/**
	 * Get all list of employees
	 * 
	 * @return ArrayList<Employee>
	 */
	public ArrayList<Supplier> getSuppliers();
	
	/**
	 * Update existing employee
	 * @param employeeID
	 * @param employee
	 * 
	 * @return
	 */
	public Supplier updateSupplier(String supplierID, Supplier supplier);

	/**
	 * Remove existing employee
	 * 
	 * @param employeeID
	 */
	public void removeSupplier(String supplierID);
	
	 public ArrayList<String> getSupplierIDs();
	
}
