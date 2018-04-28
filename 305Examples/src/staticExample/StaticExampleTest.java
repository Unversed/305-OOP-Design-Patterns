package staticExample;

public class StaticExampleTest {
	public static void main (String [] args) {
		StaticExample SE1=new StaticExample ();
		System.out.println("\na1: " + SE1.geta());
		System.out.println("b: " + StaticExample.b);
		System.out.println("b1: " + SE1.b);

		StaticExample SE2=new StaticExample ();
		System.out.println("\na1: " + SE1.geta());
		System.out.println("a2: " + SE2.geta());		
		System.out.println("b: " + StaticExample.b);
		System.out.println("b1: " + SE1.b);
		System.out.println("b2: " + SE2.b);
		
		SE2.increment();
		System.out.println("\na1: " + SE1.geta());
		System.out.println("a2: " + SE2.geta());		
		System.out.println("b: " + StaticExample.b);
		System.out.println("b1: " + SE1.b);
		System.out.println("b2: " + SE2.b);	
		
		StaticExample.increment();
		System.out.println("\na1: " + SE1.geta());
		System.out.println("a2: " + SE2.geta());		
		System.out.println("b: " + StaticExample.b);
		System.out.println("b1: " + SE1.b);
		System.out.println("b2: " + SE2.b);		
		
		System.out.println("\nb: " + StaticExample.b);
		System.out.println("a1: " + SE1.geta());
		System.out.println("a2: " + SE2.geta());		
		System.out.println("b: " + StaticExample.b);
		System.out.println("b1: " + SE1.b);
		System.out.println("b2: " + SE2.b);		
	}

}
