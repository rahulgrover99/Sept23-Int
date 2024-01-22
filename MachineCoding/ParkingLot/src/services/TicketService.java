package services;

import models.Gate;
import models.Ticket;
import models.VehicleType;
import repositories.GateRepository;

import java.util.Optional;

public class TicketService {

    public TicketService(GateRepository gateRepository) {
        this.gateRepository = gateRepository;
    }

    private final GateRepository gateRepository;


    public Ticket issueTicket(String vehicleNumber, VehicleType vehicleType, Long gateId) {

        // Query the database to get the objects using the ID.


        Optional<Gate> gateOptional = gateRepository.findGateById(gateId);

        // Save the ticket object and vehicle number in the DB. -> Repository.


        // 1. Create a ticket object.
        // 2. Select a spot for the vehicle.
        // 3. Return the object;

        return null;
    }

}
