package lab08.comparatorCountry;

import java.util.Comparator;

public class Country implements Comparator<Country>, Comparable<Country>{

	String name;
	int area; 
	
	Country() {
	}
	
	public Country(String name, int area) {
		this.name = name;
		this.area = area;
	}
	
	public String getName() {
		return name;
	}
	
	public int getArea() {
		return area;
	}
	
	@Override
	public int compareTo(Country compareCountry) {
		int compareQuantity = compareCountry.getArea();
		return this.area - compareQuantity;
		
	}

	@Override
	public int compare(Country country1, Country country2) {
		return country1.name.compareTo(country2.name);
		
	}

}
