package MachineCoding.parkinglot.services;

import MachineCoding.parkinglot.exceptions.GateNotFoundException;
import MachineCoding.parkinglot.models.Gate;
import MachineCoding.parkinglot.models.ParkingLot;
import MachineCoding.parkinglot.models.Ticket;
import MachineCoding.parkinglot.models.Vehicle;
import MachineCoding.parkinglot.repositories.GateRepository;
import MachineCoding.parkinglot.repositories.VehicleRepository;
import MachineCoding.parkinglot.strategies.ParkingSpotAssignmentStrategy;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingSpotAssignmentStrategy parkingSpotAssignmentStrategy;
    public TicketService(GateRepository gateRepository,VehicleRepository vehicleRepository,ParkingSpotAssignmentStrategy parkingSpotAssignmentStrategy){
        this.gateRepository=gateRepository;
        this.vehicleRepository=vehicleRepository;
        this.parkingSpotAssignmentStrategy=parkingSpotAssignmentStrategy;
    }
     public Ticket issueTicket(  String vehicleNumber,
                                 String ownerName,
                                 Long gateId,
                                 Long operatorId) throws GateNotFoundException {

         Ticket ticket= new Ticket();
         ticket.setEntryTime(new Date());

         //get the gate object
         Optional<Gate> optionalGate= gateRepository.findById(gateId);
         if(optionalGate.isEmpty()){
             throw new GateNotFoundException("Invalid Gate");
         }
         Gate gate=optionalGate.get();
          ticket.setGate(gate);
          ticket.setOperator(gate.getOperator());

          Optional<Vehicle> optionalVehicle=vehicleRepository.findByVehicleNumber(vehicleNumber);
          Vehicle vehicle=null;
          if(optionalVehicle.isEmpty()){
              //vehicle is not present in DB
              //create a New Vehicle and save in DB
              vehicle = new Vehicle();
              vehicle.setNumber(vehicleNumber);
              vehicle.setOwnerName(ownerName);
              vehicle =vehicleRepository.save(vehicle);

          }else {
              vehicle=optionalVehicle.get();
          }
         ticket.setVehicle(vehicle);
         ParkingLot parkingLot= gate.getParkingLot();
          ticket.setParkingSpot(parkingSpotAssignmentStrategy.assignParkingSpot(parkingLot,vehicle));


         return ticket;
     }
}
