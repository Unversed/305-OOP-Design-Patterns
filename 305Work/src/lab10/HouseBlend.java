package lab10;

public class HouseBlend extends Beverage {
	
	public HouseBlend(int size) {
		description = "House Blend Coffee";
		setSize(size);
	}

	public double cost() {

		double cost = 0;
		if (size == Beverage.TALL) {
			cost = 0.69;
		} else if (size == Beverage.GRANDE) {
			cost = 0.89;
		} else if (size == Beverage.VENTI) {
			cost = 1.09;
		}
		return cost;
	}
}
