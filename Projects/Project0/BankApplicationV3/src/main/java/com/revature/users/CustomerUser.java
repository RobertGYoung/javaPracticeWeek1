package com.revature.users;

import com.revature.logic.UserLogic;

public class CustomerUser extends User{
	
	

	String userName;

	String name;
	int customerId;
	boolean isApproved;
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	
	public boolean getIsApproved() {
		return isApproved;
	}
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	// end getter setters
public CustomerUser() {
	
}
	

	public CustomerUser(String userName) {     // passed username parameter from user portal, sets username, id using static counter iteration, balance and adds to a customerList
		this.setUserName(userName);

	}

	public CustomerUser(int customerId, boolean isApproved, String userName) {
		super();
		this.customerId = customerId;
		this.isApproved = isApproved;
		this.userName = userName;
	}

}
