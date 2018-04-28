package lab10;

public class StarbuzzCoffee {
 
	public static void main(String args[]) {
		

		Beverage Espresso1 = new Espresso(Beverage.TALL);
		System.out.println(Espresso1.getDescription() 
				+ " $" + Espresso1.cost());
		Beverage Espresso2 = new Espresso(Beverage.GRANDE);
		System.out.println(Espresso2.getDescription() 
				+ " $" + Espresso2.cost());
		Beverage Espresso3 = new Espresso(Beverage.VENTI);
		System.out.println(Espresso3.getDescription() 
				+ " $" + Espresso3.cost());
		

		Beverage DarkRoast0 = new DarkRoast(Beverage.GRANDE);
		System.out.println(DarkRoast0.getDescription() 
				+ " $" + DarkRoast0.cost());
		
		Beverage DarkRoast = new DarkRoast(Beverage.GRANDE);
		DarkRoast = new Mocha(DarkRoast);
		System.out.println(DarkRoast.getDescription() 
				+ " $" + DarkRoast.cost());
		
		Beverage DarkRoast1 = new DarkRoast(Beverage.GRANDE);
		DarkRoast1 = new Mocha(DarkRoast1);
		DarkRoast1 = new Whip(DarkRoast1);
		System.out.println(DarkRoast1.getDescription() 
				+ " $" + DarkRoast1.cost());
		
		Beverage DarkRoast2 = new DarkRoast(Beverage.GRANDE);
		DarkRoast2 = new Mocha(DarkRoast2);
		DarkRoast2 = new Whip(DarkRoast2);
		DarkRoast2 = new Whip(DarkRoast2);
		System.out.println(DarkRoast2.getDescription() 
				+ " $" + DarkRoast2.cost());
		
		Beverage DarkRoast3 = new DarkRoast(Beverage.VENTI);
		DarkRoast3 = new Mocha(DarkRoast3);
		DarkRoast3 = new Whip(DarkRoast3);
		System.out.println(DarkRoast3.getDescription() 
				+ " $" + DarkRoast3.cost());

	}
}
