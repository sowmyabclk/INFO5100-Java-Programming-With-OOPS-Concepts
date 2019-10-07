package AED.Assignment4;

public class TestCheckout {
	
	public static void main(String[] args) {
		Checkout checkout = new Checkout();
		
		checkout.enterItem(new Candy("Peanut Butter Fudge",2.25, 399));
		checkout.enterItem(new IceCream("Vanilla Ice Cream",105));
		checkout.enterItem(new Sundae("Choc.chip Ice Cream ",145,"Hot fudge",50));
		checkout.enterItem(new Cookie("Oat Meal Raisin Cookies",4,399));
		System.out.println("\nnumber of items : "+ checkout.numberOfItems());
		int cost = checkout.totalCost();
		int tax = checkout.totalTax();
		System.out.println("\nTotal Cost : "+cost);
		System.out.println("\nTotal tax : "+tax);
		System.out.println("\nCost + Tax : "+( cost + tax ) +"\n");
	System.out.print(checkout);
	checkout.clear();
	System.out.println("\n\n");
	checkout.enterItem(new IceCream("Strawberry Ice cream",145));
	checkout.enterItem(new Sundae("vanilla Ice Cream",105,"Caramel",50));
	checkout.enterItem(new Candy("Gummy worms",1.33,89));
	checkout.enterItem(new Cookie("Chocolate Chip Cookies",4,399));
	checkout.enterItem(new Candy("salt water taffee",1.5,209));
	checkout.enterItem(new Candy("Candy Corn",3.0, 109));
	System.out.println("\nnumber of items : "+ checkout.numberOfItems());
	int cost1 = checkout.totalCost();
	int tax1 = checkout.totalTax();
	System.out.println("\nTotal Cost : "+cost1);
	System.out.println("\nTotal tax : "+tax1);
	System.out.println("\nCost + Tax : "+( cost1 + tax1 ) +"\n");
	System.out.print(checkout);



	
		
	}

}
