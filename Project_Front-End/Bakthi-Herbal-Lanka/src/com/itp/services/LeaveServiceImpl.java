
/**
 * 
 */
package com.itp.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;

import com.itp.model.Leave;

/**
 * @author Yuvin Nimnaka
 *
 */
public class LeaveServiceImpl implements ILeaveServices{

	public static final Logger log = Logger.getLogger(LeaveServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;

	private static PreparedStatement preparedstatement;
	
	
	@Override
	public void addLeave(Leave login) {
		
		
	}

	@Override
	public Leave getLeaveByID(String empoyeeID) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public ArrayList<Leave> getLeave() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public Leave updateLeave(String leaveID, Leave leave) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void removeLeave(String leaveID) {
		// TODO Auto-generated method stub
		
	}

	
}
