package objectReference;

public class Person {
	
	private String lastname;
	private String firstname;
	
	public Person () {
		this.lastname="defaultlastname";
		this.firstname="defaultfirstname";
	}
	
	public String getlastname () {
		return this.lastname;
	}
	
	public void setlastname (String lastname) {
		this.lastname=lastname;
	}
	
	public String getfirstname() {
		return this.firstname;
	}
	
	public void setfirstname (String firstname) {
		this.firstname=firstname;
	}
	
	public void copyFirstNameTo (Person other) {
		other.firstname=this.firstname;
	}
	
	public void copyObjectTo (Person other) {
		other=this;
		System.out.println("inside function " + other.getfirstname() + "   "+other.getlastname());
	}
    
}
