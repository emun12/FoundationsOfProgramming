package a3;

public class ShortestWaitDispatcher implements Dispatcher {
	
	public ShortestWaitDispatcher() {

	}



	public Driver chooseDriver(Driver[] availableDrivers, RideRequest request) {

		double current = availableDrivers[0].getVehicle().getPosition().getManhattanDistanceTo(request.getClientPosition());
	//	double holder = 0;
		int current_index = 0;

		for(int i=0; i<availableDrivers.length; i++) {
	
			
			if(availableDrivers[i].getVehicle().getPosition().getManhattanDistanceTo(request.getClientPosition()) < current) {
				current = availableDrivers[i].getVehicle().getPosition().getManhattanDistanceTo(request.getClientPosition());
				current_index = i;
			}
			

		}

		return availableDrivers[current_index];
	}



}
