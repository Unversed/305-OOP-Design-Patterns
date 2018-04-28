package singleton;

public class ChocolateBoilerSingleton {
	private boolean empty;
	private boolean boiled;
	private static ChocolateBoilerSingleton uniqueinstance; 
	
	private ChocolateBoilerSingleton () {
		empty=true;
		boiled=false;
	}
	
	public static  ChocolateBoilerSingleton getInstance () {
		if (uniqueinstance==null) {
			System.out.println("object creation");
			uniqueinstance= new ChocolateBoilerSingleton ();
		}
		
		return uniqueinstance;
			
	}
	
	
	public  synchronized void fill () {
		if (isEmpty ()) {
			System.out.println("fill  " + this.toString());
			empty=false;
			boiled=false;
		}
	}
	
	public synchronized void boil() {
		if (!isEmpty() && !isBoiled()) {
			System.out.println("boil  " + this.toString());
			boiled=true;
		}
	}
	
	public synchronized void drain () {
		if (!isEmpty() && isBoiled()) {
			System.out.println("drain  " + this.toString());
			empty=true;
		}
	}
	

	
	
	public boolean isEmpty () {
		return empty;
	}
	
	public boolean isBoiled () {
		return boiled;
	}
	

}

