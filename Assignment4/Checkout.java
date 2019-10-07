package AED.Assignment4;

import java.util.Vector;

public class Checkout {
	
	//public final int  receiptWidth = 0;
//	public String receipt = " ";
	
    Vector<DessertItem> v = new Vector<DessertItem>();

	public Checkout() {

	}

	public int numberOfItems() {
		
		return v.size();
	}
	
	public void enterItem(DessertItem item) {
		v.add(item);
	}
	
	public void clear() {
		v.clear();
		this.totalCost =0;
		this.totalTax =0;
	}
	
	int totalCost = 0;
	public int totalCost() {
		for(int i=0;i<numberOfItems();i++) {
			totalCost = totalCost + v.get(i).getCost();
		}
		return totalCost;
		
	}
	
	int totalTax =0;
	public int totalTax() {
	 return (int) Math.round(this.totalCost*(DessertShop.tax/100));

		
	}
	
	
public String toString() {
	String receipt = "";
	receipt+=" "+DessertShop.nameOfStore + "\n"+"----------------"+"\n";
	
	for(int i =0;i<numberOfItems();i++) {
		String name = v.get(i).getName();
		if(name.length()>DessertShop.itemSize)
			name = name.substring(0, DessertShop.itemSize);
			
		String cw = (DessertShop.cents2dollarsAndCents(v.get(i).getCost()));
		if(cw.length() > DessertShop.costWidth)
			cw = cw.substring(0, DessertShop.costWidth);
		String item = v.get(i).getClass().getSimpleName();
		switch(item) {
		case "IceCream":{
			receipt+=name + cw +"\n";
		}
		break;
		case "Sundae":{
			receipt+= ((Sundae)(v.get(i))).getToppingName()+ " Sundae with\n";
			receipt+=name + cw +"\n" ;
		}
		break;
		case "Candy":{
			receipt+=((Candy)(v.get(i))).getWeight() +" lbs @"+
		DessertShop.cents2dollarsAndCents(((Candy)(v.get(i))).getPrice())+" /lb."+"\n";
			
			receipt+=name + cw +"\n" ;
		}
		break;
		case "Cookie":{
			receipt+=((Cookie)(v.get(i))).getNumber() + " @"+
					DessertShop.cents2dollarsAndCents(((Cookie)(v.get(i))).getPricePerDozen())+" /dz"+"\n";
			
			receipt+=name + cw +"\n" ;
		}
		break;
			
		}
		
	}
	receipt+="\nTax "+DessertShop.cents2dollarsAndCents(this.totalTax());
	receipt+="\nTotal Cost "+DessertShop.cents2dollarsAndCents((this.totalCost+ this.totalTax()));
	return receipt;
	
	
}
	
	
	
	
}
