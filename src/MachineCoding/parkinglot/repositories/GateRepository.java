package MachineCoding.parkinglot.repositories;

import MachineCoding.parkinglot.models.Gate;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class GateRepository {
    //Gate table
    private HashMap<Long,Gate> gates=new HashMap<>();
    //CRUD operation on gate table
    public Optional<Gate> findById(Long id){
        return  Optional.of(gates.get(id));
    }
}
