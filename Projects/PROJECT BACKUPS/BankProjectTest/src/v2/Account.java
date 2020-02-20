package v2;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {
	String userName;
	int id;
	static int counter=-1;
	public boolean isAdmin=false;
	static List<CustomerAccount> customerList = new ArrayList<CustomerAccount>();


	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Account() {
		counter++;
		
	}
	
	
	
	
}
