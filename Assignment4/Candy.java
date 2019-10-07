package AED.Assignment4;

public class Candy extends DessertItem {
	String name;
	double weight;
	int price;

	public double getWeight() {
		return weight;
	}

	public int getPrice() {
		return price;
	}

	Candy(String name, double weight, int price) {
		super(name);
		this.weight = weight;
		this.price = price;
	}

	@Override
	public int getCost() {
		return (int) Math.round((this.weight * this.price));
	}

}
