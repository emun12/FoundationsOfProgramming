package a3;

public class PositionImpl implements Position {

	private int x;
	private int y;

	/* Constructor to input argument values into private variables
	 * These variables can now be used throughout the class.
	 */
	public PositionImpl(int x, int y) {
		this.x = x;
		this.y = y;
	}
	

	/* The next set of methods are getter methods that simply return the
	 * value of the arguments and now these methods can be accessed in other code
	 * without changing the actual code in this class.
	 */
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	
	/* This methods get the distance from two positions using the x and y coordinates.
	 * Note: This uses else if after if statements so that the x and y coordinates can be
	 * evaluated separately.
	 * They are created like this so that they will always be positive so you don't
	 * have to use the java.math.lang.abs function to get the absolute value of
	 * the total distance.
	 * Output:Total distance between two position objects.
	 */
	
	public int getManhattanDistanceTo(Position p) {

		int subtract_x = 0;

		int subtract_y = 0;

		int distance = 0;

		if (this.x >= p.getX()) {

			subtract_x = this.x - p.getX();

		}

		else if (this.x < p.getX()) {

			subtract_x = p.getX() - this.x;

		}

		if (this.y >= p.getY()) {

			subtract_y = this.y - p.getY();

		}

		else if (this.y < p.getY()) {

			subtract_y = p.getY() - this.y;

		}

		distance = subtract_x + subtract_y;

		return distance;

	}

}

