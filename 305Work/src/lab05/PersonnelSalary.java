package lab05;

import java.util.ArrayList;
import java.util.HashMap;

public class PersonnelSalary {
	private ArrayList<Employee> employees;
	// HashMap which holds employeeid and salary for each employee
	private HashMap<String, Double> salary;
	private double standardPaymentRate;
	private double extraHoursPaymentRate;
	private final float STANDARD_HOURS = 40;

	public PersonnelSalary(ArrayList<Employee> employees) {
		this.employees = employees;
		salary = new HashMap<String, Double>();
	}

	public PersonnelSalary() {
		salary = new HashMap<String, Double>();
	}

	public ArrayList<Employee> getemployees() {
		return employees;
	}

	public void setemployess(ArrayList<Employee> employees) {
		this.employees = employees;
	}

	public double getstandardPaymentRate() {
		return standardPaymentRate;
	}

	public void setstandardPaymentRate(double standardPaymentRate) {
		this.standardPaymentRate = standardPaymentRate;
	}

	public double getextraHoursPaymentRate() {
		return extraHoursPaymentRate;
	}

	public void setextraHoursPayment(double extraHoursPaymentRate) {
		this.extraHoursPaymentRate = extraHoursPaymentRate;
	}

	public HashMap<String, Double> getsalary() {
		for (Employee emp : employees) {
			if (emp.getHours() > 0)
				salary.put(emp.getEmployeeID(), salaryCalculation(emp.getHours()));
			else
				salary.put(emp.getEmployeeID(), 0.00);
		}
		return salary;

	}

	double salaryCalculation(float Hours) {
		double payment = 0;
		if (Hours > STANDARD_HOURS) {
			payment = STANDARD_HOURS * standardPaymentRate;
			payment += (Hours - STANDARD_HOURS) * extraHoursPaymentRate;
		} else
			payment = Hours * standardPaymentRate;
		return payment;
	}

	public String employeeInfoSalary() {
		StringBuilder str = new StringBuilder();
		for (Employee emp : employees) {
			str.append(emp.getEmployeeID() + " " + emp.getFirstName() + " " + emp.getLastName() + " " + emp.getHours()
					+ " " + salary.get(emp.getEmployeeID()));
			str.append("\n");
		}
		return str.toString();
	}

}
