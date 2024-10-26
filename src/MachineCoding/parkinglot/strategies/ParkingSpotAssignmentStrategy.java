package MachineCoding.parkinglot.strategies;

import MachineCoding.parkinglot.models.ParkingFloor;
import MachineCoding.parkinglot.models.ParkingLot;
import MachineCoding.parkinglot.models.ParkingSpot;
import MachineCoding.parkinglot.models.Vehicle;

public interface ParkingSpotAssignmentStrategy {
    ParkingSpot assignParkingSpot(ParkingLot parkingLot,Vehicle vehicle);
}
