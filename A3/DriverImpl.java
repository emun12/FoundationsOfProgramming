package a3;

public class DriverImpl implements Driver {

	private String first_name;
	private String last_name;
	private int id_number;
	private Vehicle car;

	/* Constructor used to put values into the arguments and go through
	 * possible edge cases if there are null values.
	 */
	
	public DriverImpl(String first, String last, int id, Vehicle vehicle) {
		// edge cases for ExceptionsTest
		if (first.equals(null)) {
			throw new RuntimeException("Expected runtime exception to be thrown for null first name");
		}
		if (last.equals(null)) {
			throw new RuntimeException("Expected runtime exception to be thrown for null last name");
		}
		if(vehicle.equals(null)) {
			throw new RuntimeException("Expected runtime exception to be thrown for null vehicle");
			// car.equals(null)
		}
		
		
		this.first_name = first;
		this.last_name = last;
		this.id_number = id;
		this.car = vehicle;
	}
	
	
	/* A series of getter methods that will allow you to access these methods
	 * even in other classes through the concept of encapsulation
	 */
	
	public String getFirstName() {
		return first_name;
	}
	
	public String getLastName() {
		return last_name;
	}
	
	public String getFullName() {
		return first_name + " " + last_name;
	}
	
	public int getID() {
		return id_number;
	}
	
	public Vehicle getVehicle() {
		return car;
	}
	
	/* This is a setter method and it sets the value in the constructor into the object in
	 * the argument.
	 * There needs to be a RuntimEexception here as well just in case it is empty.
	 */
	
	public void setVehicle(Vehicle v) {
		if(v.equals(null)) {
			throw new RuntimeException("Expected runtime exception to be thrown for null vehicle");
		}
	
		this.car = v;
		
	}



}