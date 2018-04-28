package lab10;

public class Soy extends CondimentDecorator {
	Beverage beverage;

	public Soy(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ", Soy";
	}

	public int getSize() 
	{
		return beverage.getSize();
	}
	
	public double cost() {

		if (beverage.getSize() == Beverage.TALL) {
			return beverage.cost() + .10;
		} else if (beverage.getSize() == Beverage.GRANDE) {
			return beverage.cost() + .15;
		} else if (beverage.getSize() == Beverage.VENTI) {
			return beverage.cost() + .20;
		} else {
			return beverage.cost() + .10;
		}
	}
}
