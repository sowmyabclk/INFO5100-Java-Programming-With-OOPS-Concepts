package AED.Assignment4;

public class IceCream extends DessertItem{

	int cost;
	
	public IceCream() {
		this("",0);
	}
	
	public IceCream(String name,int cost) {
		super(name);
		this.cost = cost;
	}
	@Override
	public int getCost() {
		
		return cost;
	}

}
