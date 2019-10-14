package PetsTracking;

import java.time.LocalDate;

public class Dog extends Pet implements Boardable {
	
	private String size;
	private	LocalDate boardingStartDate;
	private LocalDate boardingEndDate;

	public Dog(String name, String ownerName, String color,String size) {
		super(name, ownerName, color);
		this.size = size;
		// TODO Auto-generated constructor stub
	}
	
	public String getSize() {
		return this.size;
	}

	@Override
	public void setBoardStart(int month, int day, int year) {
		boardingStartDate = LocalDate.of(year, month, day);
		System.out.println("The boarding start date is "+boardingStartDate);
	}

	@Override
	public void setBoardEnd(int month, int day, int year) {
		boardingEndDate = LocalDate.of(year, month, day);
		System.out.println("The boarding end date is "+boardingEndDate);

	}

	@Override
	public boolean boarding(int month, int day, int year) {
		System.out.println("boarding date is "+LocalDate.of(year, month, day));
		boolean isBoardingBefore = LocalDate.of(year, month, day).isBefore(boardingStartDate);
		boolean isBoardingAfter = LocalDate.of(year, month, day).isAfter(boardingEndDate);
		boolean isEqualsEndDate = boardingEndDate.isEqual( LocalDate.of(year, month, day));
		boolean isEqualsStartDate = boardingStartDate.isEqual( LocalDate.of(year, month, day));
		if(isBoardingBefore || isBoardingAfter) {
			System.out.println("the boarding date " +LocalDate.of(year, month, day)+" does not exist between "+boardingStartDate +" and "+boardingEndDate);
			return false;
		}
		else if(isEqualsStartDate || isEqualsEndDate) {
			System.out.println("the boarding date " +LocalDate.of(year, month, day)+" either equal to start date or end date "+boardingStartDate +" "+boardingEndDate);
			return true;
		}
		else {
			System.out.println("the boarding date is "+LocalDate.of(year, month, day) + " exist between "+boardingStartDate +" "+boardingEndDate);
			return true;

		}
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName().toUpperCase()+":"+"\n"+ super.toString()+"\n"+"Hair: "+this.size ;
	}
public static void main(String[] args) {
	Dog d = new Dog("Spot","Susan","white","medium");
	d.setSex(2);
	d.setBoardEnd(12,01,2018);
	d.setBoardStart(01, 01, 2018);
	System.out.println("Valid for boarding: "+d.boarding(12, 01, 2018));
	System.out.println(d);
}

}
