/**
 * Employee is a class with attributes first name, last name, manager, salary, and age.
 * Date: Sept. 9, 2016
 * @author yzhan265
 *
 */
public class Employee {
	private String fname; //first name of student
	private String lname; //last name of student
	private String manager; // Supervisor’s name
	private float salary; //Empoyee’s salary
	private int age; // Employee's age
	
	// empty constructor
	public Employee(){
		
	}
	
	// constructor
	public Employee(String fname, String lname, String Manager, float Salary, int age){
		this.fname = fname;
		this.lname = lname;
		this.manager = Manager;
		this.salary = Salary;
		this.age = age;
	}
	
	// fname accessor
	public String getFname() {
		return fname;
	}
	
	// fname mutator
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	// lname accessor
	public String getLname() {
		return lname;
	}
	
	// lname mutator
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	// manager accessor
	public String getManager() {
		return manager;
	}
	
	// manager mutator
	public void setManager(String manager) {
		manager = manager;
	}
	
	// salary accessor
	public Float getSalary() {
		return salary;
	}
	
	// salary mutator
	public void setSalary(Float salary) {
		salary = salary;
	}
	
	// age accessor
	public int getAge() {
		return age;
	}
	
	// age mutator
	public void setAge(int age) {
		this.age = age;
	}
	
	// toString
	public String toString(){
		return "First Name:" +fname+"\tLast Name:"+lname+"\tManager:"+manager+"\tSalary:"+salary+"\tAge:"+age;
	}
	
}
