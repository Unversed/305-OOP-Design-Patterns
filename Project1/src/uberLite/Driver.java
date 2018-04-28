package uberLite;

// TODO: Auto-generated Javadoc
/**
 * The Class Driver.
 */
public class Driver {
	
	/** The name. */
	String name;
	
	/** The car title. */
	String carTitle;
	
	/** The balance. */
	double balance;
	
	/** The location. */
	Location location;
	
	/** The occupied. */
	boolean occupied;
	
	/** The rating. */
	Double rating;
	
	/** The times rated. */
	int timesRated;
	
	/** The trip. */
	RequestedTrip trip;
	
	
	
	/**
	 * Instantiates a new driver.
	 *
	 * @param name the name
	 * @param title the title
	 * @param startingBalance the starting balance
	 * @param initialLocation the initial location
	 * @param initialDriverRating the initial driver rating
	 * @param timesRated the times rated
	 */
	public Driver(String name, String title, double startingBalance, Location initialLocation, double initialDriverRating, int timesRated) {
		this.name = name;
		this.balance = startingBalance;
		this.carTitle = title;
		this.location = initialLocation;
		this.occupied = false;
		this.rating = initialDriverRating;
		this.timesRated = timesRated;
	}

	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * Sets the location.
	 *
	 * @param location the new location
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * Gets the occupied.
	 *
	 * @return the occupied
	 */
	boolean getOccupied(){
		return this.occupied;
	}
	
	/**
	 * Sets the occupied.
	 *
	 * @param newOccupied the new occupied
	 */
	void setOccupied(boolean newOccupied){
		this.occupied = newOccupied;
	}
	
	/**
	 * Rate driver.
	 *
	 * @param newRating the new rating
	 */
	void rateDriver(double newRating){
		double temp = this.rating * this.timesRated++;
		this.rating = (temp + newRating) / timesRated;
	}

}
