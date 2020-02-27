package com.revature.day03.serialize;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; 

public class EmployeeRead {
	

public static void main(String[] args) throws IOException, ClassNotFoundException {
	FileInputStream fis=new FileInputStream("emp.txt");
	ObjectInputStream ois=new ObjectInputStream(fis);

	

		

	ArrayList<Object> employeeList=(ArrayList<Object>) ois.readObject();

	
	System.out.println("Employee Details "+employeeList);

}}
