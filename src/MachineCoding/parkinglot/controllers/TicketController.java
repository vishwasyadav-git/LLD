package MachineCoding.parkinglot.controllers;

import MachineCoding.parkinglot.dtos.*;
import MachineCoding.parkinglot.models.Ticket;
import MachineCoding.parkinglot.services.TicketService;

public class TicketController {
    private TicketService ticketService;
    public TicketController(TicketService ticketService){
        this.ticketService=ticketService;
    }
    public IssueTicketResponseDto issueTicket(IssueTicketRequestDto requestDto){
        IssueTicketResponseDto responseDto=new IssueTicketResponseDto();
        try {
            Ticket ticket= ticketService.issueTicket(
                    requestDto.getVehicleNumber(),
                    requestDto.getOwnerName(),
                    requestDto.getGateId(),
                    requestDto.getOperatorId()
            );
            responseDto.setTicket(ticket);
            responseDto.setResponseStatus(ResponseStatus.SUCESS);
        }catch (Exception e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;

    }

    public DeleteTicketResponseDto deleteTicket(DeleteTicketRequestDto requestDto){
        return null;
    }
}
