package AED.Assignment5;

public class EmployeeDriverClass {

	public static void main(String[] args) {
	Employee e1 = new FullTime("John", 500);
	e1.calculateSalary();
	System.out.println(e1);
	Employee e2 = new Contractor("b", 400, 4);
	e2.calculateSalary();
	System.out.println(e2);
	}	
		
}
