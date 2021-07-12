package a3;

public class CompletedRideImpl implements CompletedRide {


	private RideRequest request;
	private Driver driver;
	public int a;

	/* Constructors to put values into private variables and runTimeExceptions to go 
	 * through null cases
	 * Note:The runTimeExceptions are similar to edge cases so that there will be an option
	 *  just in case something is empty/null.
	 */
	public CompletedRideImpl(RideRequest request, Driver driver) {


		if(request.equals(null)) {
			throw new RuntimeException("Expected runtime exception to be thrown for null vehicle");
		}
		if(driver.equals(null)) {
			throw new RuntimeException("Expected runtime exception to be thrown for null vehicle");
		}
		this.request = request;
		this.driver = driver;

		a = driver.getVehicle().getPosition().getManhattanDistanceTo(request.getClientPosition());
		// a variable is created here so that it stays the same throughout the class
	}


	/* Getter methods to access the values from the arguments of the object.
	 * Note: These getter methods can be used even in other classes so that 
	 * the code in this class is protected and unchanged from other classes.
	 * It is part of encapsulation.
	 */

	public RideRequest getRequest() {
		return request;
	}

	public Driver getDriver() {
		return driver;
	}	

	public int getWaitTime() {
		return a;
	}

	public int getTotalTime() {
		return this.getWaitTime() + request.getRideTime();
	}

	/* This gets the total cost of the ride itself. 
	 * Inputs: ride time, wait time
	 * Output: total cost of the ride
	 * Note: Can also combine these variables to get the cost in one line:
		return (.5 * r ) + ((.1) * driver.getVehicle().getPosition().getManhattanDistanceTo(request.getClientPosition()));

	 */

	public double getCost() {

		int req = request.getRideTime();
		// This calculates the ride time of the client's request. It will be used
		// in future methods

		int req2 = a;
		// This calculates the wait time which is created in the constructor

		double cost = ((req * 0.5) + (req2 * 0.1));

		return cost;
	}

/* Calculates the price of the ride based off of the wait time and ride time.
 * Input: wait time, ride time
 * Output: Total price of the ride
 * Note: Uses if statements to calculate how much the ride will cost
 * since the wait times determine how much the client will pay.
 */
	
	public double getPrice() {

		double price = 0.0;

		int req = request.getRideTime();
		// This gets the ride time of the client's request


		int compare = a;
		// This gets the wait time which is initialized in the constructor

		if (compare < 25) {
			return price = req * 2.5;
		}

		if (compare >= 25 && compare < 50) {

				return price = req * 2;
		}

		if (compare >= 50 && compare < 100) {
			
				return price = req;

		}

		if (compare >= 100) {

			return price = req * 0.5;

		}

		return price;

	}

	
	/* Calculates the profit of the completed ride.
	 * Input: ride time, wait time, cost
	 * Note: This method has the same code as getPrice() because I was not sure if
	 * a method could call another method inside the same class.
	 * 
	 */
	
	public double getProfit() {

		double price = 0.0;

		int req = request.getRideTime();

		int compare = a;

		if (compare < 25) {
			price = req * 2.5;
		}

		if (compare >= 25 && compare < 50) {

				price = req * 2;

		}

		if (compare >= 50 && compare < 100) {

				price = req;

		}

		if (compare >= 100) {
			price = req * 0.5;
		}

		int r_time = request.getRideTime();
		// This gets the ride time of the client's request

		int w_time = a;
		// This gets the wait time

		double cost = ((r_time * 0.5) + (w_time * 0.1));
		// Calculates the total cost using ride time and wait time

		return price - cost;

	}

}
