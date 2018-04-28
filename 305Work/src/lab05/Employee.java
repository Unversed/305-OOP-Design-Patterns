package lab05;

public class Employee {
	private String FirstName;
	private String LastName;
	private String EmployeeID;
	private float Hours;

	public Employee(String FirstName, String LastName, String EmployeeID, float Hours) {
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.EmployeeID = EmployeeID;
		this.Hours = Hours;

	}

	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}

	public void setLastName(String LastName) {
		this.LastName = LastName;
	}

	public void setEmployeeID(String EmployeeID) {
		this.EmployeeID = EmployeeID;
	}

	public void setHours(float Hours) {
		this.Hours = Hours;
	}

	public String getFirstName() {
		return FirstName;
	}

	public String getLastName() {
		return LastName;
	}

	public String getEmployeeID() {
		return EmployeeID;
	}

	public float getHours() {
		return Hours;
	}

}