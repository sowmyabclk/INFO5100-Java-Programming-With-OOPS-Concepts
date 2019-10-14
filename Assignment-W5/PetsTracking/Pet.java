package PetsTracking;

import java.util.Arrays;

public class Pet {

	private String name;
	private String ownerName;
	private String color;
	@Override
	public String toString() {
		return name+" owned by "+ownerName +"\n" +"Color : "+color +"\n"+"Sex: "+getSex();
	}

	protected String sexName;
	public static final int MALE = 0;
	public static final int FEMALE = 1;
	public static final int SPAYED = 2;
	public static final int NEUTERED = 3;
	
	protected  String[] sex = {"MALE","FEMALE","SPAYED","NEUTERED"};
	public Pet (String name, String ownerName, String color) {
		this.name = name;
		this.ownerName = ownerName;
		this.color = color;
	}
	String getPetName() {
		return name;
	}
	String getOwnerName() {
		return ownerName;
	}
	//get color method
	String getColor() {
		return color;
	}
	void setSex(int sexID) {
		switch(sexID) {
		case 0:{
			sexName = sex[0];
			break;
		}
	case 1:{
		sexName = sex[1];
		break;
	}
case 2:{
	sexName = sex[2];
	break;
}
case 3:
	sexName = sex[3];
	break;
	default:
		throw new IllegalArgumentException("sex does not exist for the value "+sexID);
}
	}
	String getSex() {
		return sexName;
		 
}
	
	public static void main(String[] args) {
		Pet p = new Pet("Spot","Mary","Black and White");
		p.setSex(3);
	//	System.out.println(p.getSex());
		System.out.println(p);
		
	}
}
