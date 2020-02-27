package v2;
/**
 * 
 * THIS CLASS IS a super class of Customer Account, probably a useless use of an abstract class
 * since I decided to make administration accounts based solely on passwords. 
 */
import java.util.ArrayList;
import java.util.List;

public abstract class Account {
	String userName;
	int id;
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
	
		
	}
	
	
	
	
}
