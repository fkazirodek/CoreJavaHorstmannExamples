package c03ex01_02;

import java.util.Arrays;
import java.util.Comparator;

public class Employee_Main {

	public static void main(String[] args) {
		Employee[] empls = new Employee[5];
		Employee e = new Employee("Manager");
		empls[0] = new Employee("Piotr", 3500);
		empls[1] = new Employee("Ola", 2500);
		empls[2] = new Employee("Krzysiek", 3000);
		empls[3] = new Employee("Kasia", 4500);
		empls[4] = new Employee("Basia", 3000);	
		
		Arrays.sort(empls, Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName));
		//Arrays.sort(empls, Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName).reversed());
		System.out.println(Arrays.toString(empls));
		System.out.println("average salary = " + e.average(empls));
		System.out.println("Best paid " + e.largest(empls));
	}
}
