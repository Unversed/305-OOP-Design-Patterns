package lab10;

public class Mocha extends CondimentDecorator {
	Beverage beverage;
 
	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}
 
	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}
	
	public int getSize() 
	{
		return beverage.getSize();
	}
 
	public double cost() {

		if (beverage.getSize() == Beverage.TALL) {
			return beverage.cost() + .15;
		} else if (beverage.getSize() == Beverage.GRANDE) {
			return beverage.cost() + .20;
		} else if (beverage.getSize() == Beverage.VENTI) {
			return beverage.cost() + .25;
		} else {
			return beverage.cost() + .15;
		}
	}
}
