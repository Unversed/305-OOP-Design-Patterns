package uberLite;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class UberMap.
 *
 * @author liaml
 */
public class UberMap {

	/** The x low bound. */
	int xLowBound;
	
	/** The y low bound. */
	int yLowBound;
	
	/** The x high bound. */
	int xHighBound;
	
	/** The y high bound. */
	int yHighBound;
	
	/** The fare rate. */
	double fareRate;
	
	/** The passengers list. */
	LinkedList<Passenger> passengers;
	
	/** The passengers awaiting pickup. */
	LinkedList<Passenger> passengersAwaitingPickup;
	
	/** The passengers already delivered. */
	LinkedList<Passenger> passengersDelivered;
	
	/** The drivers list. */
	LinkedList<Driver> drivers;
	
	/** The trips taken. */
	LinkedList<TripLog> tripsTaken;
	
	/** The inactive drivers. */
	private int inactiveDriversCount;
	
	/** The active. */
	LinkedList<RequestedTrip> active = new LinkedList<>();
	
	/** The map. */
	char[][] map;

	/**
	 * Instantiates a new uber map.
	 *
	 * @param xLowBound the x low bound
	 * @param yLowBound the y low bound
	 * @param xHighBound the x high bound
	 * @param yHighBound the y high bound
	 * @param fareRate the fare rate
	 */
	public UberMap(int xLowBound, int yLowBound, int xHighBound, int yHighBound, double fareRate) {
		this.xLowBound = xLowBound;
		this.yLowBound = yLowBound;
		this.xHighBound = xHighBound;
		this.yHighBound = yHighBound;
		this.fareRate = fareRate;

		initializeGrid();
		this.tripsTaken = new LinkedList<TripLog>();
	}

	/**
	 * Gets the x low bound.
	 *
	 * @return the x low bound
	 */
	public int getxLowBound() {
		return xLowBound;
	}

	/**
	 * Sets the x low bound.
	 *
	 * @param xLowBound the new x low bound
	 */
	public void setxLowBound(int xLowBound) {
		this.xLowBound = xLowBound;
	}

	/**
	 * Gets the y low bound.
	 *
	 * @return the y low bound
	 */
	public int getyLowBound() {
		return yLowBound;
	}

	/**
	 * Sets the y low bound.
	 *
	 * @param yLowBound the new y low bound
	 */
	public void setyLowBound(int yLowBound) {
		this.yLowBound = yLowBound;
	}

	/**
	 * Gets the x high bound.
	 *
	 * @return the x high bound
	 */
	public int getxHighBound() {
		return xHighBound;
	}

	/**
	 * Sets the x high bound.
	 *
	 * @param xHighBound the new x high bound
	 */
	public void setxHighBound(int xHighBound) {
		this.xHighBound = xHighBound;
	}

	/**
	 * Gets the y high bound.
	 *
	 * @return the y high bound
	 */
	public int getyHighBound() {
		return yHighBound;
	}

	/**
	 * Sets the y high bound.
	 *
	 * @param yHighBound the new y high bound
	 */
	public void setyHighBound(int yHighBound) {
		this.yHighBound = yHighBound;
	}

	/**
	 * Gets the inactive drivers.
	 *
	 * @return the inactive drivers
	 */
	public int getInactiveDrivers() {
		return inactiveDriversCount;
	}

	/**
	 * Sets the inactive drivers.
	 *
	 * @param inactiveDrivers the new inactive drivers
	 */
	public void setInactiveDrivers(int inactiveDrivers) {
		this.inactiveDriversCount = inactiveDrivers;
	}

	/**
	 * Initialize grid.
	 */
	private void initializeGrid() {
		char[][] map = new char[xHighBound][yHighBound];
		for(int i = this.xLowBound; i < this.xHighBound; i++)
			for(int j = this.yLowBound; j < this.yHighBound; j++)
				map[i][j] = ' ';

		this.map = map;
	}

	/**
	 * Read map file.
	 *
	 * @param mapFile the map file
	 * @return the uber map
	 */
	public static UberMap readMapFile(File mapFile){
		int xLowBound, yLowBound, xHighBound, yHighBound, 
		driverCount, passengerCount;

		double fareRate;


		Scanner scanner = null;
		try {

			scanner = new Scanner(mapFile);


			if(scanner.hasNextInt())
				xLowBound = scanner.nextInt();
			else
				throw new InputMismatchException();

			if(scanner.hasNextInt())
				yLowBound = scanner.nextInt();
			else
				throw new InputMismatchException();

			if(scanner.hasNextInt())
				xHighBound = scanner.nextInt();
			else
				throw new InputMismatchException();

			if(scanner.hasNextInt())
				yHighBound = scanner.nextInt();
			else
				throw new InputMismatchException();

			if(scanner.hasNextInt())
				driverCount = scanner.nextInt();
			else
				throw new InputMismatchException();

			if(scanner.hasNextInt())
				passengerCount = scanner.nextInt();
			else
				throw new InputMismatchException();

			if(scanner.hasNextDouble())
				fareRate = scanner.nextDouble();
			else
				throw new InputMismatchException();

			UberMap map = new UberMap( xLowBound, yLowBound, xHighBound, yHighBound, fareRate);
			map.initializeMap(passengerCount, driverCount, scanner);

			if(scanner != null) {
				scanner.close();
			}
			return map;
		} catch (IOException | InputMismatchException e) {
			e.printStackTrace();
			System.exit(0);
		} finally {
			if(scanner != null) {
				scanner.close();
			}
		}
		return null;
	}

	/**
	 * Initialize passengers list.
	 *
	 * @param passengerCount the passenger count
	 * @param scanner the scanner
	 * @throws InputMismatchException the input mismatch exception
	 */
	private void initializePassengers(int passengerCount, Scanner scanner) throws InputMismatchException {

		LinkedList<Passenger> passengers = new LinkedList<Passenger>();
		Location initialLocation, requestedLocation;
		int xPosition, yPosition;
		double initialPassengerBalance;
		String name = null;

		for(int i = 0; i < passengerCount; i++) {

			name = "Passenger"+i;

			if(scanner.hasNextDouble())
				initialPassengerBalance = scanner.nextDouble();
			else
				throw new InputMismatchException();

			if(scanner.hasNextInt())
				xPosition = scanner.nextInt();
			else
				throw new InputMismatchException();

			if(scanner.hasNextInt())
				yPosition = scanner.nextInt();
			else
				throw new InputMismatchException();

			if((xPosition < xLowBound || xPosition > xHighBound) ||
					(yPosition < yLowBound || yPosition > yHighBound)) {
				System.out.println(name + " initial location out of bounds");
				throw new InputMismatchException();
			}

			initialLocation = new Location(xPosition, yPosition);

			if(scanner.hasNextInt())
				xPosition = scanner.nextInt();
			else
				throw new InputMismatchException();

			if(scanner.hasNextInt())
				yPosition = scanner.nextInt();
			else
				throw new InputMismatchException();

			if((xPosition < xLowBound || xPosition > xHighBound) ||
					(yPosition < yLowBound || yPosition > yHighBound)) {
				System.out.println(name + " destination out of bounds");
				throw new InputMismatchException();
			}

			requestedLocation = new Location(xPosition, yPosition);

			Passenger p = new Passenger(name, initialPassengerBalance, 
					initialLocation, requestedLocation);
			passengers.add(p);
		}

		this.passengers = passengers;
		this.passengersAwaitingPickup = new LinkedList<Passenger>();
		this.passengersDelivered = new LinkedList<Passenger>();

	}

	/**
	 * Initialize drivers list.
	 *
	 * @param driverCount the driver count
	 * @param scanner the scanner
	 * @throws InputMismatchException the input mismatch exception
	 */
	private void initializeDrivers(int driverCount, Scanner scanner) throws InputMismatchException {

		int xPosition, yPosition, timesRated;
		Location initialLocation;
		double initialDriverBalance, initialDriverRating;
		String name;
		LinkedList<Driver> drivers = new LinkedList<Driver>();


		for(int i = 0; i < driverCount; i++) {

			name = "Driver"+i;

			if(scanner.hasNextDouble())
				initialDriverBalance = scanner.nextDouble();
			else
				throw new InputMismatchException();


			if(scanner.hasNextInt())
				xPosition = scanner.nextInt();
			else
				throw new InputMismatchException();

			if(scanner.hasNextInt())
				yPosition = scanner.nextInt();
			else
				throw new InputMismatchException();

			if((xPosition < xLowBound || xPosition > xHighBound) ||
					(yPosition < yLowBound || yPosition > yHighBound)) {
				System.out.println(name + " initial location out of bounds");
				throw new InputMismatchException();
			}

			initialLocation = new Location(xPosition, yPosition);


			if(scanner.hasNextDouble())
				initialDriverRating = scanner.nextDouble();
			else
				throw new InputMismatchException();

			if(scanner.hasNextInt())
				timesRated = scanner.nextInt();
			else
				throw new InputMismatchException();

			Driver d = new Driver(name, "Car"+i, initialDriverBalance, initialLocation, initialDriverRating, timesRated);
			drivers.add(d);
		}
		this.drivers=drivers;
		this.setInactiveDrivers(driverCount);
	}	

	/**
	 * Initialize map.
	 *
	 * @param passengerCount the passenger count
	 * @param driverCount the driver count
	 * @param scanner the scanner
	 * @throws InputMismatchException the input mismatch exception
	 */
	public void initializeMap(int passengerCount, int driverCount, Scanner scanner) throws InputMismatchException {

		this.initializePassengers(passengerCount, scanner);

		this.initializeDrivers(driverCount, scanner);

		return;
	}

	/**
	 * Operate.
	 */
	void operate(){

		while(passengers.size() > 0 || active.size() > 0) {
			while((inactiveDriversCount > 0) && (passengers.size() > 0)) {
				Passenger p = passengers.getFirst();
				passengers.remove(p);
				passengersAwaitingPickup.add(p);
				p.requestTrip(this);
			}

			while( (inactiveDriversCount == 0 || passengers.size() == 0) && active.size() > 0 ) {

				RequestedTrip r = active.getFirst();
				active.remove(r);

				if(r.selectedDriver.location.move(r.currentDestination)) { //either change destination or remove from list
					if(r.selectedDriver.location.equals(r.requestingPassenger.initalLocation)) {
						r.trip.logArrival();
						passengersAwaitingPickup.remove(r.requestingPassenger);
						r.currentDestination = r.requestingPassenger.destination;
						active.add(r);

					}
					if(r.selectedDriver.location.equals(r.requestingPassenger.destination)) {
						r.selectedDriver.occupied = false;
						r.trip.passengerRating = r.requestingPassenger.rate(r.selectedDriver);
						r.trip.driverRating = r.selectedDriver.rating;
						passengersDelivered.add(r.requestingPassenger);
						inactiveDriversCount++;
						//TODO: add passenger to Trip Log for final Position
					}
				} else {
					active.add(r);
				}
			}

		}
	}

	/**
	 * Update map.
	 *
	 * @param m the m
	 */
	private void updateMap(char[][] m) {

		for(Passenger p: passengers) {
			m[p.initalLocation.xPosition][p.initalLocation.yPosition] = 'p';
		}

		for(Passenger p: passengersAwaitingPickup) {
			m[p.initalLocation.xPosition][p.initalLocation.yPosition] = 'P';
		}

		for(Passenger p: passengersDelivered) {
			m[p.destination.xPosition][p.destination.yPosition] = 'X';
		}

		for(Driver d: drivers) {
			m[d.location.xPosition][d.location.yPosition] = 'D';
		}
	}

	/**
	 * Prints the map.
	 *
	 * @param out the out
	 */
	public void printMap(PrintStream out) {

		updateMap(map);

		for(int i = this.xLowBound; i < this.xHighBound; i++) {
			for(int j = this.yLowBound; j < this.yHighBound; j++) {
				out.print(map[i][j]);
			}
			out.println();
		}
	}

	/**
	 * Finalize map.
	 *
	 * @param outputFile the output file
	 */
	public void finalizeMap(FileOutputStream outputFile) {

		PrintStream out = new PrintStream(outputFile);
		int transactions = 0;

		out.println("Number of trips: " + tripsTaken.size());

		for(TripLog t : tripsTaken) {
			if (t.successful) {
				transactions++;
			}
		}
		out.println("Number of transactions: " + transactions);

		for(Passenger p : passengersDelivered) {
			out.println(p.name + " balance: " + 
					String.format( "%.2f", p.balance));
		}
		for(Driver d : drivers) {
			out.println(d.name + " balance: " + 
					String.format( "%.2f", d.balance));
		}
		for(Driver d : drivers) {
			out.println(d.name + " rating: " +
					String.format( "%.2f", d.rating));
		}

		printMap(out);
		out.close();
	}

	/**
	 * Finalize log.
	 *
	 * @param logFile the log file
	 */
	public void finalizeLog(FileOutputStream logFile) {

		PrintStream out = new PrintStream(logFile);

		for(TripLog t : tripsTaken) {
			t.printTrip(out);
		}

		out.close();


	}
}


