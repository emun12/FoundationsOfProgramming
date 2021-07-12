package a3;

public class VehicleImpl implements Vehicle {

	private String make_name;
	private String model_name;
	private String plate_name;
	private Position position_object;
	private int mileage;

/* Constructor used to put values into the arguments and 
 * check if there are any null arguments which are similar to edge case scenarios.
 */
	
	public VehicleImpl(String make, String model, String plate, Position position) {
		
		if (make.equals(null)) {
			throw new RuntimeException ("Expected runtime exception for null make");
		}
		if (model.equals(null)) {
			throw new RuntimeException ("Expected runtime exception for null model");
		}
		if (plate.equals(null)) {
			throw new RuntimeException ("Expected runtime exception for null plate");
		}
		if (position.equals(null)) {
			throw new RuntimeException ("Expected runtime exception for null initial position");
		}
		
		
		this.make_name = make;
		this.model_name = model;
		this.plate_name = plate;
		this.position_object = position;

	}

	/* A series of getter methods that will allow you to access these methods
	 * in other classes through encapsulation.
	 * This protects the code in this class.
	 */
	
	public String getMake() {
		return make_name;
	}

	public String getModel() {
		return model_name;
	}

	public String getPlate() {
		return plate_name;
	}

	public int getMileage() {
		return mileage;
	}

	public Position getPosition() {
		return position_object;
	}

	/* This calculates the mileage based off of the total distance from the getManhattanDistanceTo
	 * method.
	 * It also updates the position of the object to be the positon of the argument.
	 */
	
	public void moveToPosition(Position p) {
		this.mileage = this.mileage + this.position_object.getManhattanDistanceTo(p);
		this.position_object = p;

	}


}