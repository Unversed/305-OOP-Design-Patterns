package uberLite;

import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class Passenger.
 */
public class Passenger {
	
	/** The name. */
	String name;
	
	/** The balance. */
	double balance;
	
	/** The inital location. */
	Location initalLocation;
	
	/** The destination. */
	Location destination;
	
	/** The current. */
	RequestedTrip current;
	
	/**
	 * Instantiates a new passenger.
	 *
	 * @param name the name
	 * @param balance the balance
	 * @param location the location
	 * @param destination the destination
	 */
	Passenger(String name, double balance, Location location, Location destination){
		this.name = name;
		this.balance = balance;
		this.initalLocation = location;
		this.destination = destination;
		this.current = null;
		
	}
	
	/**
	 * Gets the passenger's balance.
	 *
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Sets the passenger's balance.
	 *
	 * @param balance the new balance
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public Location getLocation() {
		return initalLocation;
	}

	/**
	 * Sets the location.
	 *
	 * @param location the new location
	 */
	public void setLocation(Location location) {
		this.initalLocation = location;
	}

	/**
	 * Gets the destination.
	 *
	 * @return the destination
	 */
	public Location getDestination() {
		return destination;
	}

	/**
	 * Sets the destination.
	 *
	 * @param destination the new destination
	 */
	public void setDestination(Location destination) {
		this.destination = destination;
	}
	
	/**
	 * Request trip.
	 *
	 * @param map the map
	 */
	void requestTrip(UberMap map){
		RequestedTrip newTrip = new RequestedTrip(this, map);
		this.current = newTrip;
	}
	
	/**
	 * Rate.
	 *
	 * @param d the d
	 * @return the double
	 */
	double rate(Driver d) {
		Random random = new Random();
		double newRating = 1 + (5-1) * random.nextDouble();
		d.rateDriver(newRating);
		return newRating;
	}
	
}
