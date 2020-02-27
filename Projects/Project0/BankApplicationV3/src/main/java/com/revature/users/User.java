package com.revature.users;

import java.util.ArrayList;
import java.util.List;


public abstract class User  {

	String userName;
	int id;

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

	
	
}
