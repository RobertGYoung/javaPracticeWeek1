package testing;

import java.sql.Connection;
import java.util.ArrayList;

import com.revature.connection.DatabaseConnection;
import com.revature.logic.UserLogic;
import com.revature.queries.CustomerQuery;
import com.revature.users.CustomerUser;

public class Driver {
public static void main(String[] args) {
	
	
		ArrayList<CustomerUser> listName=	com.revature.queries.CustomerQuery.selectFromCustomerTable("Select*from customers");
		
	for(CustomerUser each :listName) {
		System.out.println(each.getCustomerId());
	}
}
}
