package lab10;

public class Milk extends CondimentDecorator {
	Beverage beverage;

	public Milk(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ", Steamed Milk";
	}
	
	public int getSize() 
	{
		return beverage.getSize();
	}

	public double cost() {

		if (beverage.getSize() == Beverage.TALL) {
			return beverage.cost() + .05;
		} else if (beverage.getSize() == Beverage.GRANDE) {
			return beverage.cost() + .10;
		} else if (beverage.getSize() == Beverage.VENTI) {
			return beverage.cost() + .15;
		} else {
			return beverage.cost() + .05;
		}
	}
}
