package lab05;

import java.util.ArrayList;
//import java.util.HashMap;

public class PersonnelTestDrive {
	public static void main(String args[]) {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		// HashMap<String, Double> salary = new HashMap <String, Double> ();
		gettingEmployeeInfo(employees);
		PersonnelSalary personnelsalary = new PersonnelSalary(employees);
		personnelsalary.setstandardPaymentRate(15.00);
		personnelsalary.setextraHoursPayment(20.00);
		// salary=personnelsalary.getsalary();
		personnelsalary.getsalary();
		System.out.println(personnelsalary.employeeInfoSalary());
	}

	public static void gettingEmployeeInfo(ArrayList<Employee> employees) {
		employees.add(new Employee("Max", "Amini", "21347", 45));
		employees.add(new Employee("Judi", "Foster", "21348", 40));
		employees.add(new Employee("Mel", "Gibson", "21349", 60));
		employees.add(new Employee("Tom", "Hardy", "21350", 38));
	}

}
