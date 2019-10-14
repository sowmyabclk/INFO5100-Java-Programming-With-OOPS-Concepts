package AED.Assignment5;

public class FullTime extends Employee {
	int salary;

	public FullTime(String name, int paymentPerHour) {
		super(name, paymentPerHour);
	}

	@Override
	public int calculateSalary() {
		 salary = 8*this.getPaymentPerHour();
		return salary;
	}

	@Override
	public String toString() {
		return "Full time Employee"+"\n"+"Salary is: "+salary;
	}
	

}
