
/**
 * 
 */
package com.itp.services;

import java.util.ArrayList;

import com.itp.model.Leave;
import com.mysql.cj.util.LRUCache;


/**
 * @author Yuvin Nimnaka
 *
 */
public interface ILeaveServices {

	public void addLeave(Leave login);

	
	public Leave getLeaveByID(String empoyeeID);
	
	
	public ArrayList<Leave> getLeave();
	
	
	public Leave updateLeave(String leaveID, Leave leave);

	
	public void removeLeave(String leaveID);
}
