package com.itp.services;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.itp.model.Supplier;
import com.itp.model.rawMaterial;


public interface IRawMaterialServices {

	public static final Logger log = Logger.getLogger(IRawMaterialServices.class.getName());

	/**
	 * Add raw materials for raw material table
	 * @param raw material
	 */
	public void addRawMaterial(rawMaterial raw_material);

	/**
	 * Get a particular raw material
	 * 
	 * @param rawMaterialID
	 * @return rawMaterial
	 */
   public rawMaterial getRawMaterialByID(String rawMaterialID);
	
	/**
	 * Get all list of raw materials
	 * 
	 * @return ArrayList<rawMaterial>
	 */
   public ArrayList<rawMaterial> getRawMaterilas();
   
   public ArrayList<String> getRawMaterialIDs();
   
   /**
	 * Update existing raw materials
	 * @param rMaterialID
	 * @param rmaterial
	 * 
	 * @return
	 */
	public rawMaterial updateRawMaterial(String rMaterialID, rawMaterial rmaterial);

public void removeRawMaterial(String rawMaterialID);


}
