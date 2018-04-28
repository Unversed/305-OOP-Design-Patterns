package lab10;

public class Whip extends CondimentDecorator {
	Beverage beverage;

	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ", Whip";
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
