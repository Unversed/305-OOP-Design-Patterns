package lab10;

public class Espresso extends Beverage {

	public Espresso(int size) {
		description = "Espresso";
		setSize(size);
	}

	public double cost() {

		double cost = 0.0;
		if (size == Beverage.TALL) {
			cost = 1.59;
		} else if (size == Beverage.GRANDE) {
			cost = 1.99;
		} else if (size == Beverage.VENTI) {
			cost = 2.89;
		}
		return cost;
	}
}
