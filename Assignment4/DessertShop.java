package AED.Assignment4;

public class DessertShop {
	
	public final static String nameOfStore = "M & M Dessert Shop";
	public final static  double tax = 6.5;
	public final static int itemSize = 30;
	public final static int  costWidth = 10;
	
	public String getNameOfStore() {
		return nameOfStore;
	}

	

	public int getitemSize() {
		return itemSize;
	}

	

	public int getcostWidth() {
		return costWidth;
	}

	

	public double getTax() {
		return tax;
	}

	
	
	public static String cents2dollarsAndCents(int cents) {
		String cd = " ";
		/*
		 * if(cents<0) { s+="-"; cents*=-1; }
		 */
		int dollars = cents/100;
		cents = cents %100;
		if(dollars > 0)
			cd+=dollars;
		cd+=".";
		if(cents<10)
			cd+="0";
		cd+=cents;
		return cd;
		
		}
	

}
