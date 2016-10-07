import java.util.ArrayList;
import java.util.Arrays;

/**
 * EmployeeArrayList test class.
 * Date: Sept. 9, 2016
 * @author yzhan265
 *
 */

public class EmployeeArrayList {
	public static void main(String[] args){
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("Addam", "Addleman", "Ace", (float) 5000, 25));
		employees.add(new Employee("Bobby", "Beaman", "Ace", (float) 2000, 21));
		employees.add(new Employee("Cathy", "Chandler", "Brain", (float) 3000, 22));
		employees.add(new Employee("Diana", "Dukkkke", "Ace", (float) 4000, 23));
		employees.add(new Employee("Elaine", "Easton", "Ace", (float) 6000, 24));
		
		for (Employee element: employees){
			System.out.println(element.toString());
		}
		
		printAverageSalary(employees, 21,23);
		
	}
	
	/**
	 * calculates and prints the average salary of the individuals within the given age range inclusive.
	 * @param input
	 * @param lowerAge
	 * @param upperAge
	 */
	public static void printAverageSalary(ArrayList<Employee> input, int lowerAge, int upperAge){
		System.out.println("Here are the employees between the ages of "+lowerAge
				+" and "+upperAge+" inclusive.");
		
		int numberEmployees = 0; // keeps track of the number of employees within the age range.
		float totalSalary = (float)0; // keeps track of their aggregate salary.
		
		// for each employee, if they are between the age range, add their salary to the aggregate
		// and add one to numberEmployees
		for (Employee element: input){
			if (element.getAge() >= lowerAge && element.getAge()<= upperAge){
				System.out.println(element.getFname()+" "+ element.getLname()+" is "
						+element.getAge()+" with salary "+element.getSalary());
				numberEmployees++;
				totalSalary = totalSalary + element.getSalary();	
			}
		}
		
		double average = totalSalary/numberEmployees;
		
		// prints their average.
		System.out.println("The average of the salaries is "+ average);
	}

}

/*
 * OUTPUT
 * 
 * First Name:Addam	Last Name:Addleman	Manager:Ace	Salary:5000.0	Age:25
First Name:Bobby	Last Name:Beaman	Manager:Ace	Salary:2000.0	Age:21
First Name:Cathy	Last Name:Chandler	Manager:Brain	Salary:3000.0	Age:22
First Name:Diana	Last Name:Dukkkke	Manager:Ace	Salary:4000.0	Age:23
First Name:Elaine	Last Name:Easton	Manager:Ace	Salary:6000.0	Age:24
Here are the employees between the ages of 21 and 23 inclusive.
*/
