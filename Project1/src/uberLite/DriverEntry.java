package uberLite;

// TODO: Auto-generated Javadoc
/**
 * The Class DriverEntry.
 */
public class DriverEntry implements Comparable<DriverEntry>{

	/** The d. */
	Driver d;
	
	/** The distance key. */
	Double distanceKey;
	
	/**
	 * Instantiates a new driver entry.
	 *
	 * @param d the d
	 * @param distance the distance
	 */
	public DriverEntry(Driver d, Double distance) {
		
		this.d = d;
		this.distanceKey = distance;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(DriverEntry o) {
		
		int check = this.distanceKey.compareTo(o.distanceKey);

		if(check != 0) {
			return check;
		} else {
			return this.d.rating.compareTo(o.d.rating);
		}
	}


}
