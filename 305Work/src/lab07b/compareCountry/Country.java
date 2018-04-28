package lab07b.compareCountry;

public class Country implements Comparable<Country>{

	String name;
	int area; 
	
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

}
