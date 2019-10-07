package AED.Assignment4;

public class Cookie extends DessertItem{
int number;
int pricePerDozen;
int cookieCost;

public int getNumber() {
	return number;
}

public int getPricePerDozen() {
	return pricePerDozen;
}


public Cookie(String name,int number,int pricePerDozen) {
	super(name);
	this.number = number;
	this.pricePerDozen = pricePerDozen;
}
	@Override
	public int getCost() {
		
		return cookieCost = (pricePerDozen *number)/12;
	}
	
	

}
