package PetsTracking;

import java.time.LocalDate;

public class Cat extends Pet implements Boardable {

	private String hairLength;
	private	LocalDate boardingStartDate;
	private LocalDate boardingEndDate;

	public Cat(String name, String ownerName, String color,String hairLength) {
		super(name, ownerName, color);
		this.hairLength = hairLength;
		// TODO Auto-generated constructor stub
	}
	
	public String getHairLength() {
		return this.hairLength;
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
	 if(isEqualsStartDate || isEqualsEndDate) {
			System.out.println("the boarding date " +LocalDate.of(year, month, day)+" either equal to start date or end date "+boardingStartDate +" "+boardingEndDate);
			return true;
	 }
		
			else if(isBoardingBefore || isBoardingAfter) {
			System.out.println("the boarding date " +LocalDate.of(year, month, day)+" does not exist between "+boardingStartDate +" and "+boardingEndDate);
			return false;
		}
		
		else {
			System.out.println("the boarding date "+LocalDate.of(year, month, day) + " exist between "+boardingStartDate +" "+boardingEndDate);
			return true;

		}
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName().toUpperCase()+":"+"\n"+ super.toString()+"\n"+"Hair:"+this.hairLength ;
	}
public static void main(String[] args) {
	Cat c = new Cat("Tom","Bob","Black","SHORT");
	c.setSex(0);
	c.setBoardEnd(12,01,2018);
	c.setBoardStart(01, 01, 2018);
	System.out.println("Valid for boarding: "+c.boarding(12, 01, 2016));
	System.out.println(c);
}
}
