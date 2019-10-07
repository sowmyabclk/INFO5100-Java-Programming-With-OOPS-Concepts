package AED.Assignment4;

public class Sundae extends IceCream {
	String toppingName;
	int toppingPrice;
	int topCost;
	
	public String getToppingName() {
		return toppingName;
	}

	
	public int getToppingPrice() {
		return toppingPrice;
	}

	

	

	public Sundae(String iceCreamName, int iceCreamCost,String toppingName,int toppingPrice) {
		super(iceCreamName, iceCreamCost);
		this.toppingName = toppingName;
		this.toppingPrice = toppingPrice;
		// TODO Auto-generated constructor stub
	}

	public int getCost() {
		topCost = super.getCost() + toppingPrice;
		return topCost;
	}
	
}
