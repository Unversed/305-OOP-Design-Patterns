package objectReference;

public class PersonTest {
	
	public static void main (String [] args) {
		Person person1=new Person();
		Person person2=new Person();
		
		person1.setfirstname("sara");
		person1.setlastname("Bahrami");
		
		System.out.println(person1.getfirstname() + "  "+ person1.getlastname());
		System.out.println(person2.getfirstname() + "  "+ person2.getlastname());
		
		person1.copyFirstNameTo(person2);
		
		System.out.println(person1.getfirstname() + "  "+ person1.getlastname());
		System.out.println(person2.getfirstname() + "  "+ person2.getlastname());
		
		System.out.println(person1);
		System.out.println(person2);
		person1=person2;
		System.out.println(person1);
		System.out.println(person2);
		
		System.out.println(person1.getfirstname() + "  "+ person1.getlastname());
		System.out.println(person2.getfirstname() + "  "+ person2.getlastname());
		
		/*System.out.println(person1);
		System.out.println(person2);
		
		person1.copyObjectTo(person2);
		System.out.println("-------------------------------------------");
		
		System.out.println(person1);
		System.out.println(person2);
		
		System.out.println(person1.getfirstname() + "  "+ person1.getlastname());
		System.out.println(person2.getfirstname() + "  "+ person2.getlastname());*/
		
		
		
	}

}
