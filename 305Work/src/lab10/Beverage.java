package lab10;

public abstract class Beverage {

	public static final int TALL = 1;
	public static final int GRANDE = 2;
	public static final int VENTI = 3;
	public static final int UNKNOWN = 4;

	int size;
	String description = "Default Beverage";

	public String getDescription() {
		return description;
	}

	public int getSize() 
	{
		return size;
	}
	
	public void setSize(int size) 
	{
		if (size == Beverage.TALL) 
		{
			this.size = Beverage.TALL;
		} 
		else if (size == Beverage.GRANDE) 
		{
			this.size = Beverage.GRANDE;
		} 
		else if (size == Beverage.VENTI) 
		{
			this.size = Beverage.VENTI;
		} 
		else 
		{
			this.size = Beverage.UNKNOWN;
		}
	}
	

	public abstract double cost();
}
