package systemdesign.lld;

import java.util.List;

abstract public class ParkingLotManager {

	private List<ParkingLotSpace> parkingLotSpaces;

	ParkingLotManager(List<ParkingLotSpace> parkingLotSpaces){
		this.parkingLotSpaces = parkingLotSpaces;
	}

	public void addParkingLot(ParkingLotSpace parkingLotSpace){
		parkingLotSpaces.add(parkingLotSpace);
	}


	public void removeParkingLot(ParkingLotSpace parkingLotSpace){
		parkingLotSpaces.remove(parkingLotSpace);
	}

	public ParkingLotSpace getParkingLot(ParkingStrategy parkingStrategy){
		return null;
	}

	public ParkingLotSpace parkVehicle(ParkingLotSpace parkingLotSpace, VehicleDetails vehicleDetails){
		return parkingLotSpaces.stream().filter(data -> data.parkingNumber == parkingLotSpace.parkingNumber).findAny().get().parkVehicle(vehicleDetails);
	}

	public void removeVehicle(ParkingLotSpace parkingLotSpace){
		parkingLotSpaces.stream().filter(data -> data.parkingNumber == parkingLotSpace.parkingNumber).findAny().get().removeVehicle();
	}
}

class TwoWheelerManager extends ParkingLotManager{

	TwoWheelerManager(List<ParkingLotSpace> parkingLotSpaces) {
		super(parkingLotSpaces);
	}
}

class FourWheelerManager extends ParkingLotManager {
	FourWheelerManager(List<ParkingLotSpace> parkingLotSpaces) {
		super(parkingLotSpaces);
	}
}

	enum ParkingStrategy{
	NEAREST,
	NEAREST_TO_ELEVATOR
}