package com.revature.day02;

public class StudentDetails{
	public static void main(String[] args){
	String name=args[1];

	if (args.length>2){
		int ctr=0;
		for(String s : args){
			
			if(ctr>=2){
			name=name+" "+s;
			}
			ctr++;
			
		}
	}

		Student s1 = new Student();
		s1.input(Integer.parseInt(args[0]),name);
		s1.display();
	}
}

class Student{
int id;
String name;

void input(int id, String name){
	this.id=id;
	this.name=name;
}
void display(){
	System.out.println("Student name: "+name+"\nID: "+id);
}
}




