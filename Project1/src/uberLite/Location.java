package uberLite;

// TODO: Auto-generated Javadoc
/**
 * The Class Location.
 */
public class Location {

	/** The x position. */
	int xPosition;
	
	/** The y position. */
	int yPosition;
	
	/**
	 * Instantiates a new location.
	 *
	 * @param xPostion the x postion
	 * @param yPostion the y postion
	 */
	public Location(int xPostion, int yPostion){
		this.xPosition = xPostion;
		this.yPosition = yPostion;
	}
	
	/**
	 * Gets the x position.
	 *
	 * @return the x position
	 */
	int getXPosition(){
		return this.xPosition;
	}
	
	/**
	 * Gets the y position.
	 *
	 * @return the y position
	 */
	int getYPosition(){
		return this.yPosition;
	}
	
	/**
	 * Sets the x position.
	 *
	 * @param newX the new x position
	 */
	void setXPosition(int newX){
		this.xPosition = newX;
	}
	
	/**
	 * Sets the y position.
	 *
	 * @param newY the new y position
	 */
	void setYPosition(int newY){
		this.xPosition = newY;
	}
	
	/**
	 * Distance.
	 *
	 * @param other the other
	 * @return the double
	 */
	double distance(Location other) {
		return Math.sqrt(
				Math.pow((other.xPosition - this.xPosition), 2) + 
				Math.pow((other.yPosition - this.yPosition), 2));
	}
	
	/**
	 * Equals.
	 *
	 * @param o the o
	 * @return true, if successful
	 */
	boolean equals(Location o){
		return (this.xPosition == o.xPosition && this.yPosition == o.yPosition);
	}
	
	/**
	 * Move.
	 *
	 * @param destination the destination
	 * @return true, if successful
	 */
	boolean move(Location destination) {
		
		if(this.xPosition < destination.xPosition )
			this.xPosition+=1;
		else if(this.xPosition > destination.xPosition )
			this.xPosition-=1;
		
		if(this.yPosition < destination.yPosition )
			this.yPosition+=1;
		else if(this.yPosition > destination.yPosition )
			this.yPosition-=1;
		
		
		return (this.xPosition == destination.xPosition && this.yPosition == destination.yPosition);
		
	}
}
