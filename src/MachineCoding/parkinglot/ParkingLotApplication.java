package MachineCoding.parkinglot;

import MachineCoding.parkinglot.controllers.TicketController;
import MachineCoding.parkinglot.dtos.IssueTicketRequestDto;
import MachineCoding.parkinglot.dtos.IssueTicketResponseDto;
import MachineCoding.parkinglot.factories.ParkingSpotAssignmentStrategyFactory;
import MachineCoding.parkinglot.models.ParkingSpotStrategyType;
import MachineCoding.parkinglot.models.Ticket;
import MachineCoding.parkinglot.repositories.GateRepository;
import MachineCoding.parkinglot.repositories.VehicleRepository;
import MachineCoding.parkinglot.services.TicketService;
import MachineCoding.parkinglot.strategies.ParkingSpotAssignmentStrategy;

public class ParkingLotApplication {
    public static void main(String[] args) {
        GateRepository gateRepository=new GateRepository();
        VehicleRepository vehicleRepository=new VehicleRepository();
        ParkingSpotAssignmentStrategy parkingSpotAssignmentStrategy=
                ParkingSpotAssignmentStrategyFactory.getParkingLotStrategy(ParkingSpotStrategyType.NEAREST);
        TicketService ticketService=new TicketService(gateRepository,
                vehicleRepository,
                parkingSpotAssignmentStrategy);
        TicketController ticketController=new TicketController(ticketService);

        IssueTicketRequestDto requestDto=new IssueTicketRequestDto();
        requestDto.setGateId(123L);
        requestDto.setOperatorId(345L);
        requestDto.setOwnerName("Vish");
        requestDto.setVehicleNumber("HR 02 K 1111");

        IssueTicketResponseDto responseDto= ticketController.issueTicket(requestDto);
        Ticket ticket=responseDto.getTicket();
    }
}
