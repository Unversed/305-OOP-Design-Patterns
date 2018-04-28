package uberLite;

import java.io.PrintStream;

// TODO: Auto-generated Javadoc
/**
 * The Class TripLog.
 */
public class TripLog {


	/** The fare. */
	double fare;
	
	/** The start. */
	Location start;
	
	/** The end. */
	Location end;
	
	/** The passenger. */
	String passenger;
	
	/** The driver. */
	String driver;
	
	/** The passenger balance. */
	double passengerBalance;
	
	/** The driver balance. */
	double driverBalance;
	
	/** The passenger rating. */
	double passengerRating;
	
	/** The driver rating. */
	double driverRating;
	
	/** The successful. */
	boolean successful;

	/**
	 * Instantiates a new trip log.
	 */
	public TripLog() {
		this.fare = 0.0;
		this.passengerBalance = 0.0;
		this.driverBalance = 0.0;
		this.driverBalance = 0.0;
		this.passengerRating = 0.0;
		this.successful = false;
	}

	/**
	 * Prints the trip.
	 *
	 * @param out the out
	 */
	void printTrip(PrintStream out){

		if(!successful) {
			out.println(passenger + ", insufficient funds, "
					+ "\nnot taken from start location (" + 
					start.xPosition + ", " + start.yPosition + ")"+
					" to end location (" + end.xPosition + ", " + end.yPosition + ")"+
					"\nThe fare was " + String.format( "%.2f", fare) +
					"\nTheir balance was " + passengerBalance);

		} else {
			out.println(passenger + ", sufficient funds," +
					"\nwas taken from start location (" + 
					start.xPosition + ", " + start.yPosition + ")"+
					" to end location (" + end.xPosition + ", " + end.yPosition + ")"+	
					"\nFor a fare of " + String.format( "%.2f", fare) +
					"\nTheir new balance is " + String.format( "%.2f", passengerBalance) +
					"\nTheir driver's new balance is " + String.format( "%.2f", driverBalance) +
					"\nTheir rating is " + String.format( "%.2f", passengerRating) +
					"\nTheir driver's new rating is " + String.format( "%.2f", driverRating));
		}
		out.println();
	}
	
	/**
	 * Log acceptance.
	 *
	 * @param e the e
	 */
	public void logAcceptance(DriverEntry e) {
		System.out.println("Accepted: " + e.d.name + " has accepted your ride request.");
		driver=e.d.name;
		driverRating = e.d.rating;
	}
	
	/**
	 * Log transaction.
	 *
	 * @param fare the fare
	 */
	public void logTransaction(double fare) {
		System.out.println("Transaction: Your fare is $" + String.format( "%.2f", fare));
		this.fare = fare; 
	} 
	
	/**
	 * Log transit.
	 *
	 * @param e the e
	 */
	public void logTransit(DriverEntry e) {
		double waitTime = e.distanceKey;
		System.out.print("Estimated wait: " + Math.round(waitTime) + " minutes. ");
		System.out.println("Watch out for "+ e.d.carTitle);
		
		this.successful = true;
		
	}
	
	/**
	 * Log arrival.
	 */
	public void logArrival() {
		System.out.println("Arrival: " + driver + " arrived at pick-up location.");
	}
}