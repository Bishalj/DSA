package systemdesign.lld;

abstract class ParkingLotSpace{
	public int getParkingNumber() {
		return parkingNumber;
	}

	public void setParkingNumber(int parkingNumber) {
		this.parkingNumber = parkingNumber;
	}

	public int getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}

	public VehicleDetails getVehicleDetails() {
		return vehicleDetails;
	}

	public void setVehicleDetails(VehicleDetails vehicleDetails) {
		this.vehicleDetails = vehicleDetails;
	}

	public boolean isEmpty() {
		return isEmpty;
	}

	public void setEmpty(boolean empty) {
		isEmpty = empty;
	}

	int parkingNumber;
	int floorNumber;
	VehicleDetails vehicleDetails;
	boolean isEmpty = true;

	public ParkingLotSpace(int parkingNumber, int floorNumber) {
		this.parkingNumber = parkingNumber;
		this.floorNumber = floorNumber;
	}

	public ParkingLotSpace parkVehicle(VehicleDetails vehicleDetails){
		this.vehicleDetails = vehicleDetails;
		isEmpty = false;
		return this;
	}

	public void removeVehicle(){
		this.vehicleDetails = null;
		isEmpty = true;
	}
	
	abstract int price();
}


class TwoWheelerParkingSpace extends ParkingLotSpace{

	public TwoWheelerParkingSpace(int parkingNumber, int floorNumber){
		super(parkingNumber, floorNumber);
	}

	@Override
	int price() {
		return 50;
	}
}

class FourWheelerParkingSpace extends ParkingLotSpace{

	public FourWheelerParkingSpace(int parkingNumber, int floorNumber){
		super(parkingNumber, floorNumber);
	}

	@Override
	int price() {
		return 100;
	}
}


class CommercialWheelerParkingSpace extends ParkingLotSpace{

	public CommercialWheelerParkingSpace(int parkingNumber, int floorNumber){
		super(parkingNumber, floorNumber);
	}

	@Override
	int price() {
		return 200;
	}
}