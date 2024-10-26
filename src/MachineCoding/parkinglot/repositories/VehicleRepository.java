package MachineCoding.parkinglot.repositories;

import MachineCoding.parkinglot.models.Vehicle;

import java.util.Optional;

public class VehicleRepository {

//Output vehicle object will have id present
    public Vehicle save(Vehicle vehicle){
        return null;
    }

    public Optional<Vehicle> findByVehicleId(Long Id){
        return Optional.empty();
    }

    public Optional<Vehicle> findByVehicleNumber(String  vehicleNumber){
        return Optional.empty();
    }
}
