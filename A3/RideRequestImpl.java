package a3;

public class RideRequestImpl implements RideRequest {

	private Position client_p;
	private Position destination;
	private boolean request = false;

	/* Constructor to put values into arguments and go through edge cases
	 * Note:These RuntimeExceptions are similar to edge cases as they will
	 * check if one argument is empty.
	 * Output: values inside each argument
	 */
	public RideRequestImpl(Position clientPosition, Position destination) {


		if (clientPosition.equals(null)) {
			throw new RuntimeException("Expected runtime exception for null client position");
		}

		if(destination.equals(null)) {
			throw new RuntimeException("Expected runtime exception for null destintation position");
		}

		this.client_p = clientPosition;
		this.destination = destination;
	}

	/* Getter methods for arguments in the constructor.
	 * Note: Now other classes can access these methods without changing the actual
	 * code in this class.
	 * It is part of encapsulation.
	 */

	public Position getClientPosition() {
		return client_p;
	}


	public Position getDestination() {
		return destination;
	}


	public boolean getIsComplete() {

		return request;

	}

	/* Complete method to find when a request from a client has been completed yet.
	 * It checks i it has been completed and if it has not.
	 * If it has not been completed, it completes it and then moves the driver to the client and
	 * then to its destination.
	 * If it has been completed then nothing happens.
	 * Output: A completed Ride request.
	 */
	
	CompletedRide complete_one = null;
	// This variable is made outside so that it can be used throughout the class, if needed.

	public CompletedRide complete(Driver driver) {

		if(request == false) {
			request = true;

			CompletedRide complete_two = new CompletedRideImpl (new RideRequestImpl(client_p, destination), driver);

			driver.getVehicle().moveToPosition(client_p);

			driver.getVehicle().moveToPosition(destination);

			complete_one = complete_two;
		}
		return complete_one;

	}

	/* This is a getter method that gets the ride time based off of the 
	 * client's position and the destination.
	 * Output: total distance of the client from their destination.
	 */
	
	public int getRideTime() {

		return client_p.getManhattanDistanceTo(destination);


	}
}

