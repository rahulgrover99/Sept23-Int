package controllers;

import dtos.IssueTicketRequest;
import dtos.IssueTicketResponse;
import exceptions.GateNotFoundException;
import models.Ticket;
import models.VehicleType;
import services.TicketService;

public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public IssueTicketResponse issueTicket(IssueTicketRequest request) {

        Ticket ticket = null;
        try {
            ticket = ticketService.issueTicket(
                    request.getVehicleNumber(),
                    request.getVehicleType(),
                    request.getGateId());
        } catch (GateNotFoundException e) {
            return IssueTicketResponse.builder().statusCode(400).message("BAD REQUEST").build();
        }

        return IssueTicketResponse.builder()
                .ticketId(ticket.getNumber())
                .floorNumber(ticket.getParkingSpot().getParkingFloor().getFloorNumber())
                .entryTime(ticket.getEntryTime())
                .vehicleNumber(ticket.getVehicle().getVehicleNumber())
                .gateNumber(ticket.getGeneratedAt().getGateNumber())
                .build();
    }

}
