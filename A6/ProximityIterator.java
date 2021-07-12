package a6;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ProximityIterator implements Iterator<Driver> {

//	private Iterable<Driver> driver_pool;
	private Position client_p;
	private int prox;
	
	private Driver match_prox;
	private Iterator<Driver> iter;

	
	
	public ProximityIterator(Iterable<Driver> driver_pool, Position client_position, int proximity_limit) {
		
		
		if(driver_pool == null) {
			throw new IllegalArgumentException("empty");
		} 
		
		if(client_position == null) {
			throw new IllegalArgumentException("empty");
		}
		
		// these exceptions get ride of the NullPositionConstructorException and
		// NullPoolTHrowsConstructorException
		
		this.match_prox = null;
		
		this.iter = driver_pool.iterator();
		// creates an iterator for all of the driver objects in the collection 
		
		this.client_p = client_position;
		this.prox = proximity_limit;
	
		// These follow the concept of encapsulation
	}

	
	
	public boolean hasNext() {
		if(match_prox != null ) {
			return true;
			// this checks if you already found the next appropriate driver
			// if there is already a driver, then you can return true
		} else {
			while(iter.hasNext()) {
				Driver next_d = iter.next();
				// This finds the next available driver and checks if
				// it is in the proper distance 
				// if it is in the proper distance, then it makes that driver 
				// the new driver and now it returns true since there is
				// a driver now.
				if(next_d.getVehicle().getPosition().getManhattanDistanceTo(client_p) <= prox) {
					match_prox = next_d;
					return true;
				}
			}
			
		}
		return false;
		// returns false if there are no drivers that match 
		// the criteria of being in the proper distance
		
	}
	
	public Driver next() {
		if(!this.hasNext()) {
			throw new NoSuchElementException();
		}
		// if there is no driver that matches this criteria as
		// specified in the hasNext() method, then it creates
		// an Exception object.
		
		
		Driver next_d = match_prox;
		// This makes the next eligible driver the new driver.
		
		match_prox = null;
		
		// resets the next driver field to null so you can return a new driver
		// instead of the same driver
		return next_d;
		
	}
	
	public void remove() {
		throw new NoSuchElementException("No Element");
		
	}
// This method is a part of the iterable interface
	
	

}
