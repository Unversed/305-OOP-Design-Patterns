package lab08.comparatorCountry;

import java.util.Arrays;

public class CountryTestDrive {

	public static void main(String args[]) {
		
		Country[] countries = new Country[5];

		Country c1 = new Country("C1", 1);
		Country c2 = new Country("C2", 10);
		Country c3 = new Country("C3", 12);
		Country c4 = new Country("C4", 5);
		Country c5 = new Country("C5", 7);

		countries[0] = c1;
		countries[1] = c2;
		countries[2] = c3;
		countries[3] = c4;
		countries[4] = c5;

		Arrays.sort(countries, new Country());

		int i = 0;
		for(Country c: countries) {
			System.out.println("countries" + ++i + " : " + c.getName() + ", Area: " + c.getArea());
		}
	}
}
