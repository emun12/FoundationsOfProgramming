package a6;

import java.util.Iterator;

public class ExpandingProximityIterator implements Iterator<Driver>{

	private Iterator<Driver> iter;
	private Position client_position;
	private int expansion_step;

	public ExpandingProximityIterator(Iterable<Driver> driver_pool, Position client_position, int expansion_step) {
		this.expansion_step = expansion_step;
		this.client_position = client_position;
		this.iter = driver_pool.iterator();
	}


	public boolean hasNext() {

		int times_called = 0;

		while(iter.hasNext()) {
			Driver next_d = iter.next();
			// This finds the next available driver and checks if
			// it is in the proper distance 
			// if it is in the proper distance, then it makes that driver 
			// the new driver and now it returns true since there is
			// a driver now.
			if(next_d.getVehicle().getPosition().getManhattanDistanceTo(client_p) <= 1) {
				match_prox = next_d;
				return true;
			}
		}


		return false;
	}


	public Driver next() {

	}
}
