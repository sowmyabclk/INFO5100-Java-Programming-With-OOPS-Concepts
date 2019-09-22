package Assignments_AED;

/**
 * Submit it on or before 22nd September 2019 , 12:00 pm
 */
public class Assignment2 {

	/*
	 * This method should return the sum of salaries of employees having salary
	 * greater than 5000 Note: Employee array is passed, not employee
	 */

	static double totalSalary = 0;

	public static double salaryGreaterThanFiveThousand(Employee[] employees) {
		try {
		for (int i = 0; i < employees.length; i++) {
			if (employees[i].getSalary() > 5000) {
				totalSalary = (totalSalary + employees[i].getSalary());
			}

		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(totalSalary);
		return totalSalary;
	}

	/*
	 * This method should print either "Fizz", "Buzz" or "FizzBuzz" "Fizz" - if id
	 * of employee is divisible by 3 "Buzz" - if id of employee is divisible by 5
	 * "FizzBuzz" - if id of employee is divisible by both 3 and 5
	 */
	public static void fizzBuzz(Employee employee) {
		if (employee.getId() % 3 == 0 && employee.getId() % 5 == 0)
			System.out.println("FizzBuzz");
		else if (employee.getId() % 3 == 0)
			System.out.println("Fizz");
		else if (employee.getId() % 5 == 0)
			System.out.println("Buzz");
		else
			System.out.println("number not divisible by either 3 or 5");

	}

	/*
	 * This method should calculate tax for an employee in dollars If salary of
	 * employee is less than or equal to 2500, tax should be 10% If salary of
	 * employee is greater than 2500 but less than or equal to 5000, tax should be
	 * 25% If salary of employee is greater than 5000, tax should be 35%
	 */
	public static double calculateTax(Employee employee) {
		double tax = 0;
		
		if (employee.getSalary() <= 2500) 
			tax = (10* (employee.getSalary()))/100;
		 else if (employee.getSalary() > 2500 && employee.getSalary() <= 5000) 
			tax = (25 * (employee.getSalary()))/100;
		else if (employee.getSalary() > 5000)
			tax = (35 * (employee.getSalary()))/100;
		System.out.println(tax);

		return tax;
	}

	/*
	 * We are given two employee objects. Implement this method to swap salaries of
	 * employees
	 */
	public static void swap(Employee firstEmployee, Employee secondEmployee) {
		System.out.println("first salary " + firstEmployee.getSalary());
		System.out.println("Second salary " + secondEmployee.getSalary());
		double firstEmpSalary = firstEmployee.getSalary();
		firstEmployee.setSalary(secondEmployee.getSalary());
		secondEmployee.setSalary(firstEmpSalary);
		System.out.println("first salary after " + firstEmployee.getSalary());
		System.out.println("Second salary after " + secondEmployee.getSalary());

	}

	/*
	 * Return number of employees whose age is greater than 50 Note: Employee array
	 * is passed, not employee
	 */
	public static int employeesAgeGreaterThan50(Employee[] employees) {
		int count = 0;
		for (int i = 0; i < employees.length; i++) {
			if (employees[i].getAge() > 50) {
				count = count + 1;
			}
		}
		System.out.println(count);
		return count;
	}

	/*
	 * Implement this method to reverse firstName of employee. Ex. Before:
	 * employee.getFirstName() -> "John" After : employee.getFirstName() -> "nhoJ"
	 */
	public static void reverseFirstName(Employee employee) {
		String str = employee.getFirstName();
		String revStr = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			Character ch = str.charAt(i);
			revStr = revStr + ch;
		}
		employee.setFirstName(revStr);
		System.out.println(employee.getFirstName());
	}
	
	

	/*
	 * Print "true" if employee's first name contain one or more digits Print
	 * "false" if employee's first name doesn't contain any digit Ex:
	 * employee.getFirstName() -> "ha8l" == true employee.getFirstName() -> "hail"
	 * == false
	 */
	public static void isContainDigit(Employee employee) {
		String firstName = employee.getFirstName();
		System.out.println(firstName);
		String regex = ".*[0-9]+.*";
		if (firstName.matches(regex))
			System.out.println("true");
		else {
			System.out.println("false");
		}
	}

	/*
	 * Write a method to raise an employee's salary to three times of his/her
	 * original salary. Eg: original salary was 1000/month. After using this method,
	 * the salary is 3000/month. DO NOT change the input in this method. Try to add
	 * a new method in Employee class: public void raiseSalary(double byPercent)
	 * Call this new method.
	 */
	public static void tripleSalary(Employee employee) {
		// raise by 300% = 300*1/100;
		employee.raiseSalary(300 / 100);
	}

	// Additional question for extra credit
	/*
	 * Implement this method to convert String[] to employees array. Ex: String[]
	 * employees = new String[]{"1,John,24,7500", "2,Hail,28,7899.90"}; This String
	 * array of length 2 contains 2 employees in form of string, where id = 1
	 * firstName=John age=24 salary=7500 convert each string to employee object.
	 * Hint: Use String methods. Refer :
	 * https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
	 */
	public static Employee[] createEmployees(String[] employeesStr) {
		// System.out.println(employeesStr.length);
		Employee[] employees = new Employee[employeesStr.length];
		for (int i = 0; i < employees.length; i++) {
			{
				int id = Integer.parseInt(employeesStr[i].split(",")[0]);
				String firstName = (employeesStr[i].split(",")[1]);
				int age = Integer.parseInt(employeesStr[i].split(",")[2]);
				double salary = Double.parseDouble(employeesStr[i].split(",")[3]);
				Employee e1 = new Employee(id, firstName, age, salary);
				employees[i] = e1;
				System.out.println("Details of the employee " + e1.toString());


			}
		}

		return employees;
	}

	public static void main(String[] args) {

		Employee e1 = new Employee(15, "1john", 51, 2800);
		Employee e2 = new Employee(102, "Smith", 100, 5000);
		Employee e3 = new Employee(103, "Mary", 25, 5003);
		Employee[] emp = { e1, e2, e3 };

		 salaryGreaterThanFiveThousand(emp);
		 fizzBuzz(e1);
		 calculateTax(e1);
		 swap(e1,e2);
		 employeesAgeGreaterThan50(emp);
		 reverseFirstName(e2);
		 tripleSalary(e2);
		isContainDigit(e1);
		String[] employees = new String[] { "1,John,24,7500", "2,Hail,28,7899.90"};
		createEmployees(employees);
	}

}
