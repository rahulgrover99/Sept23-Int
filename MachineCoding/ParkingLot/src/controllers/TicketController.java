package controllers;

import dtos.IssueTicketRequest;
import dtos.IssueTicketResponse;
import models.Ticket;
import services.TicketService;

public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public IssueTicketResponse issueTicket(IssueTicketRequest request) {
//        Ticket ticket = ticketService.issueTicket();
        return new IssueTicketResponse();
    }

}
