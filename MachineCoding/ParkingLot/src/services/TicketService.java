package services;

import exceptions.GateNotFoundException;
import models.*;
import repositories.GateRepository;
import repositories.TicketRepository;
import repositories.VehicleRepository;
import strategies.RandomSpotAssignmentStrategy;
import strategies.SpotAssignmentStrategy;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;

public class TicketService {


    private final GateRepository gateRepository;
    private final VehicleRepository vehicleRepository;
    private final SpotAssignmentStrategy spotAssignmentStrategy;

    public TicketService(GateRepository gateRepository, VehicleRepository vehicleRepository, SpotAssignmentStrategy spotAssignmentStrategy, TicketRepository ticketRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
        this.ticketRepository = ticketRepository;
    }

    private final TicketRepository ticketRepository;

    public Ticket issueTicket(String vehicleNumber, VehicleType vehicleType, Long gateId) throws GateNotFoundException {

        // Query the database to get the objects using the ID.

        Ticket ticket = new Ticket();

        Optional<Gate> gateOptional = gateRepository.findGateById(gateId);

//        if (gateOptional.isEmpty()) {
//            throw new GateNotFoundException();
//        }
//
//        Gate gate = gateOptional.get();


        Gate gate = gateOptional.orElseThrow(GateNotFoundException::new);

        Vehicle savedVehicle;

        Optional<Vehicle> vehicleOptional = vehicleRepository.findVehicleById(vehicleNumber);

        if (vehicleOptional.isEmpty()) {
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setVehicleType(vehicleType);
            savedVehicle = vehicle;
        } else {
            savedVehicle = vehicleOptional.get();
        }

        ticket.setGeneratedAt(gate);
        ticket.setVehicle(savedVehicle);
        ticket.setEntryTime(new Date());
        ticket.setGeneratedBy(gate.getCurrentOperator());
        ticket.setNumber(String.valueOf(Instant.now().getEpochSecond()));
//        ticket.setParkingSpot();


        ParkingSpot parkingSpot = spotAssignmentStrategy.getSpot(1L, gate, vehicleType);

        parkingSpot.setVehicle(savedVehicle);
        parkingSpot.setParkingSpotStatus(ParkingSpotStatus.OCCUPIED);

        // Parking spot repository and save this

        ticket.setParkingSpot(parkingSpot);


        ticketRepository.save(ticket);


        return ticket;


        // Save the ticket object and vehicle number in the DB. -> Repository.


        // 1. Create a ticket object.
        // 2. Select a spot for the vehicle.
        // 3. Return the object;

    }

}
