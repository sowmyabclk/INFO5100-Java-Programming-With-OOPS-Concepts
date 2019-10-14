package AED.Assignment5;

public class Contractor extends Employee {
	private int workingHours;
	int salary;

	public Contractor(String name, int paymentPerHour,int workingHours) {
		super(name, paymentPerHour);
		this.workingHours = workingHours;
	}

	@Override
	public int calculateSalary() {
		
		salary = this.workingHours * this.getPaymentPerHour();
		return salary;
	}
	@Override
	public String toString() {
		return "Contractor \n"+"Salary is: "+salary;
	}

}
