package v2;
/**
 * THIS CLASS CONTAINS: POJO of a customer account and constructor overloading used 
 * to authenticate the existence of an existing user
 * 
 * Password validation was not implemented nor considered and was not on the initial
 * prompt- so that'll cost extra ;)
 */
import java.util.ArrayList;
import java.util.List;

public class CustomerAccount extends Account {
	
	
	String name;
	int customerId;
	boolean isApproved;

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

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	// end getter setters

	public CustomerAccount() {    //user defined default constructor
		
	}

	public CustomerAccount(String userName) {     // passed username parameter from user portal, sets username, id using static counter iteration, balance and adds to a customerList
		this.setUserName(userName);

	}

}
