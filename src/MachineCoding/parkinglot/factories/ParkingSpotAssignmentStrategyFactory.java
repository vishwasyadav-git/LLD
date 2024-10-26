package MachineCoding.parkinglot.factories;

import MachineCoding.parkinglot.models.ParkingSpotStrategyType;
import MachineCoding.parkinglot.strategies.NearestParkingSpotAssignmentStrategy;
import MachineCoding.parkinglot.strategies.ParkingSpotAssignmentStrategy;

public class ParkingSpotAssignmentStrategyFactory {
    public  static ParkingSpotAssignmentStrategy getParkingLotStrategy(ParkingSpotStrategyType parkingSpotStrategyType){
        if(parkingSpotStrategyType.equals(ParkingSpotStrategyType.NEAREST)){
            return  new NearestParkingSpotAssignmentStrategy();
        }
        return null;
    }
}
