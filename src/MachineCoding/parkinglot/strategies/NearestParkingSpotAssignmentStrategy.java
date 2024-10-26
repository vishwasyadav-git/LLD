package MachineCoding.parkinglot.strategies;

import MachineCoding.parkinglot.models.ParkingLot;
import MachineCoding.parkinglot.models.ParkingSpot;
import MachineCoding.parkinglot.models.Vehicle;

public class NearestParkingSpotAssignmentStrategy implements ParkingSpotAssignmentStrategy{
    @Override
    public ParkingSpot assignParkingSpot(ParkingLot parkingLot, Vehicle vehicle) {
        return new ParkingSpot();
    }
}
