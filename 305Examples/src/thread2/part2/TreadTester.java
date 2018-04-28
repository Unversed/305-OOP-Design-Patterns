package thread2.part2;

public class TreadTester {
	public static void main (String[] args) {
		Class1 obj=new Class1 ();
		Runnable r1=new GreetingProducer ("Hello, World", obj, 156);
		Runnable r2=new GreetingProducer ("Goodbye, World", obj, 20);
		Runnable r3=new GreetingProducer ("Goodbye, World", obj, 30);
		
		Thread t1 = new Thread (r1);
		Thread t2 = new Thread (r2);
		Thread t3 = new Thread (r2);
		
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println("obj.getcounter() " +obj.getcounter());
		
	}
	

}
