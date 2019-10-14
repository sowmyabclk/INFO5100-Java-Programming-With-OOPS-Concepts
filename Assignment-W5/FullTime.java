package AED.Assignment5;

public class FullTime extends Employee {

	public FullTime(String name, int paymentPerHour) {
		super(name, paymentPerHour);
	}

	@Override
	public int calculateSalary() {
		 return 8*this.getPaymentPerHour();
	}

	@Override
	public String toString() {
		return "FullTime Salary is "+calculateSalary();
	}

	
	

}
