package MachineCoding.parkinglot.models;

import java.util.List;

public class ParkingLot extends  BaseModel{
    private List<ParkingFloor> parkingFloors;
    private List<Gate> gates;
    private List<VehicleType> supportedVehicleTypes;
    private ParkingLotStatus parkingLotstatus;
}
