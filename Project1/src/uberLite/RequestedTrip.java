package uberLite;

import java.util.Arrays;
import java.util.PriorityQueue;

// TODO: Auto-generated Javadoc
/**
 * The Class RequestedTrip.
 */
public class RequestedTrip {

	/** The requesting passenger. */
	Passenger requestingPassenger;
	
	/** The current destination. */
	Location currentDestination;
	
	/** The map. */
	UberMap map;
	
	/** The accepted. */
	boolean accepted;
	
	/** The fare. */
	double fare;
	
	/** The driver priority. */
	PriorityQueue<DriverEntry> driverPriority;
	
	/** The selected driver. */
	Driver selectedDriver;
	
	/** The timer. */
	int timer;
	
	/** The trip. */
	TripLog trip;


	/**
	 * Instantiates a new requested trip.
	 *
	 * @param p the p
	 * @param map the map
	 */
	RequestedTrip(Passenger p, UberMap map) {
		this.requestingPassenger = p;
		this.currentDestination = p.initalLocation;
		this.map=map;
		this.accepted=false;
		this.trip = new TripLog();
		
		generatePriorityQueue();
		requestDriver();
		
		trip.passenger = p.name;
		trip.passengerBalance = p.balance;
		trip.driverBalance = selectedDriver.balance;
		trip.start = p.initalLocation;
		trip.end = p.destination;
		
		map.tripsTaken.add(this.trip);

	}

	/**
	 * Generate priority queue.
	 */
	void generatePriorityQueue() {

		PriorityQueue<DriverEntry> drivers = new PriorityQueue<DriverEntry>();
		
		for(Driver d: this.map.drivers) {
			if(!d.occupied) {
				drivers.add(new DriverEntry(d, requestingPassenger.initalLocation.distance(d.location)));
			}
		}
		Arrays.sort(drivers.toArray());
		
		this.driverPriority = drivers;
	}

	/**
	 * Request driver.
	 */
	private void requestDriver() {
		
		map.passengers.remove(requestingPassenger);
		
		for(DriverEntry e: driverPriority) {
			e = this.driverPriority.poll();
			if(e.d.occupied == false) { //drive accepted passenger

				trip.logAcceptance(e);
				this.selectedDriver = e.d;
				//Compute fare

				if(calculateTransaction(e)) {				

					trip.logTransit(e);//driver is on the way

					e.d.occupied = true;
					e.d.trip = this;
					this.accepted = true;

					map.setInactiveDrivers(map.getInactiveDrivers() - 1);
					map.active.add(this);
					
					return;
				} else {
					return;
				}
			}
		}

		//NO drivers available, notify Passenger, cancel trip, remove from map
		return;		
	}

	/**
	 * Calculate transaction.
	 *
	 * @param e the e
	 * @return true, if successful
	 */
	private boolean calculateTransaction(DriverEntry e) {
		double fare = (e.distanceKey + requestingPassenger.destination.distance(requestingPassenger.initalLocation))*this.map.fareRate;

		trip.logTransaction(fare);

		if(requestingPassenger.balance < fare) {
			System.out.println("\t" + requestingPassenger.name + " insufficient funds. Request Cancled ");
			return false;
		}

		System.out.println("\t" + requestingPassenger.name + " has sufficient funds.");

		requestingPassenger.balance -= fare;
		trip.passengerBalance = requestingPassenger.balance;
		e.d.balance += (fare *.8);
		trip.driverBalance = e.d.balance;
		this.timer = (int) Math.round(fare);
		return true;
	}
}
