
package com.revature.day03.serialize;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeWrite {
public static void main(String[] args) throws IOException {
	FileOutputStream fos=new FileOutputStream("emp.txt");
	ObjectOutputStream oos=new ObjectOutputStream(fos);
	
	ArrayList<Employee> employeeList = new ArrayList<Employee>();
	String name;
	String department;
	double salary;
	String response;
	Scanner input = new Scanner(System.in);

	//employeeList.add(new Employee("Rob","Gardener", 5000) );
	//oos.writeObject(employeeList);
	
	for(int i =0;i<2;i++) {
		
		System.out.println("Add Employee System, press enter to continue");
		input.nextLine();
		System.out.print("Name:");
		name=input.nextLine();
		System.out.print("Deparment:");
		department=input.nextLine();
		System.out.print("Salary:");
		salary=input.nextInt();
		

		employeeList.add(new Employee(name, department, salary));
	
		
		System.out.println("Employee added");
		
		}
	System.out.println(employeeList);
	System.out.println("Done");
	oos.writeObject(employeeList);
	oos.close();
	System.exit(0);
		
	}
}	


