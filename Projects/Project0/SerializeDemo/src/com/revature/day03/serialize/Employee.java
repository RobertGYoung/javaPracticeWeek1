package com.revature.day03.serialize;
import java.io.Serializable;

public class Employee implements Serializable{
private String name;
private String dept;
private double sal;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDept() {
	return dept;
}
public void setDept(String dept) {
	this.dept = dept;
}
public double getSal() {
	return sal;
}
public void setSal(double sal) {
	this.sal = sal;
}
public Employee(String name, String dept, double sal) {
	super();
	this.name = name;
	this.dept = dept;
	this.sal = sal;
}
@Override
public String toString() {
	return "Employee [name=" + name + ", dept=" + dept + ", sal=" + sal + "]";
}
}