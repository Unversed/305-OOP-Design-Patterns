package lab10;

public class DarkRoast extends Beverage {

	
	public DarkRoast(int size) {
		description = "Dark Roast Coffee";
		setSize(size);
	}
	
	public double cost() {

		double cost = 0;
		if (size == Beverage.TALL) {
			cost = 0.89;
		} else if (size == Beverage.GRANDE) {
			cost = 0.99;
		} else if (size == Beverage.VENTI) {
			cost = 1.29;
		}
		return cost;
	}
}
