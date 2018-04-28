package lab05;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmployeeTest {

	@Test
	public void testEmployee() {

		
		testGetFirstName();
		testGetLastName();
		testGetEmployeeID();
		testGetHours();
		
		testSetFirstName();
		testSetLastName();
		testSetEmployeeID();
		testSetHours();
	}

	@Test
	public void testSetFirstName() {
		String FirstName = "expectedFirst";
		String LastName = "expectedFirst";
		String EmployeeID = "expectedFirst";
		float Hours = 40;

		String NewFirstName = "expectedSecond";

		
		Employee expectedEmployee = new Employee(FirstName, LastName, EmployeeID, Hours);
		assertEquals(expectedEmployee.getFirstName(), FirstName);

		expectedEmployee.setFirstName(NewFirstName);
		assertEquals(expectedEmployee.getFirstName(), NewFirstName);
	}

	@Test
	public void testSetLastName() {
		String FirstName = "expectedFirst";
		String LastName = "expectedFirst";
		String EmployeeID = "expectedFirst";
		float Hours = 40;

		String NewLastName = "expectedSecond";
		
		Employee expectedEmployee = new Employee(FirstName, LastName, EmployeeID, Hours);
		
		assertEquals(expectedEmployee.getLastName(), LastName);

		expectedEmployee.setLastName(NewLastName);
		assertEquals(expectedEmployee.getLastName(), NewLastName);
	}

	@Test
	public void testSetEmployeeID() {
		
		String FirstName = "expectedFirst";
		String LastName = "expectedFirst";
		String EmployeeID = "expectedFirst";
		float Hours = 40;

		String NewEmployeeID = "expectedSecond";

		
		Employee expectedEmployee = new Employee(FirstName, LastName, EmployeeID, Hours);
		
		assertEquals(expectedEmployee.getEmployeeID(), EmployeeID);

		expectedEmployee.setEmployeeID(NewEmployeeID);
		assertEquals(expectedEmployee.getEmployeeID(), NewEmployeeID);
	}

	@Test
	public void testSetHours() {
		
		String FirstName = "expectedFirst";
		String LastName = "expectedFirst";
		String EmployeeID = "expectedFirst";
		float Hours = 40;

		float NewHours = 60;
		
		Employee expectedEmployee = new Employee(FirstName, LastName, EmployeeID, Hours);
		
		assertEquals(expectedEmployee.getHours(), Hours, 0.1);

		expectedEmployee.setHours(NewHours);
		assertEquals(expectedEmployee.getHours(), NewHours, 0.1);
	}

	@Test
	public void testGetFirstName() {
		
		String FirstName = "expectedFirst";
		String LastName = "expectedFirst";
		String EmployeeID = "expectedFirst";
		float Hours = 40;

		Employee expectedEmployee = new Employee(FirstName, LastName, EmployeeID, Hours);
		
		assertEquals(expectedEmployee.getFirstName(), FirstName);
	}

	@Test
	public void testGetLastName() {

		String FirstName = "expectedFirst";
		String LastName = "expectedFirst";
		String EmployeeID = "expectedFirst";
		float Hours = 40;

		Employee expectedEmployee = new Employee(FirstName, LastName, EmployeeID, Hours);

		assertEquals(expectedEmployee.getLastName(), LastName);
	}

	@Test
	public void testGetEmployeeID() {

		String FirstName = "expectedFirst";
		String LastName = "expectedFirst";
		String EmployeeID = "expectedFirst";
		float Hours = 40;

		Employee expectedEmployee = new Employee(FirstName, LastName, EmployeeID, Hours);

		assertEquals(expectedEmployee.getEmployeeID(), EmployeeID);
	}

	@Test
	public void testGetHours() {

		String FirstName = "expectedFirst";
		String LastName = "expectedFirst";
		String EmployeeID = "expectedFirst";
		float Hours = 40;

		Employee expectedEmployee = new Employee(FirstName, LastName, EmployeeID, Hours);

		assertEquals(expectedEmployee.getHours(), Hours, 0.1);
	}

}
