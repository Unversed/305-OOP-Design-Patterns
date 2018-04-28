package lab05;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

public class PersonnelSalaryTest {

	@Test
	public void testNegativeHours() {
		PersonnelSalary personnelsalary = new PersonnelSalary();
		assertEquals("Negative hours should be handled as zero", personnelsalary.salaryCalculation(-12), 0, 0.001);
	}

	@Ignore
	public void testsalaryMap() {
		PersonnelSalary personnelsalary = new PersonnelSalary();
		personnelsalary.salaryCalculation(120);
		assertNotNull(personnelsalary.getsalary());
		assertEquals(personnelsalary.getsalary().size(), 1);
	}

	@Test
	public void testsalaryCalculationStandardHours() {
		PersonnelSalary personnelsalary = new PersonnelSalary();
		personnelsalary.setstandardPaymentRate(12.20);
		assertEquals(personnelsalary.salaryCalculation(35), 427, 0.001);
	}

	@Test
	public void testsalaryCalculationExtraHours() {
		PersonnelSalary personnelsalary = new PersonnelSalary();
		personnelsalary.setstandardPaymentRate(12.20);
		personnelsalary.setextraHoursPayment(25.0);
		assertEquals(personnelsalary.salaryCalculation(45), 613, 0.001);
	}

	@Test
	public void testsalaryMapImrpoved() {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("Max", "Amini", "21347", 45));
		PersonnelSalary personnelsalary = new PersonnelSalary(employees);
		personnelsalary.salaryCalculation(employees.get(0).getHours());
		assertNotNull(personnelsalary.getsalary());
		assertEquals(personnelsalary.getsalary().size(), 1);
	}
}
