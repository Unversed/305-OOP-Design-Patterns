package lab10;

public class Decaf extends Beverage {
	
	public Decaf(int size) {
		description = "Decaf Coffee";
		setSize(size);
	}

	public double cost() {

		double cost = 0;
		if (size == Beverage.TALL) {
			cost = 0.99;
		} else if (size == Beverage.GRANDE) {
			cost = 1.09;
		} else if (size == Beverage.VENTI) {
			cost = 1.19;
		}
		return cost;
	}
}
