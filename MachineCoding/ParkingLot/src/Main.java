import controllers.TicketController;
import dtos.IssueTicketRequest;
import dtos.IssueTicketResponse;
import models.VehicleType;
import repositories.GateRepository;
import repositories.ParkingLotRepository;
import repositories.TicketRepository;
import repositories.VehicleRepository;
import services.TicketService;
import strategies.RandomSpotAssignmentStrategy;
import strategies.SpotAssignmentStrategy;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        GateRepository gateRepository = new GateRepository();


        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TicketRepository ticketRepository = new TicketRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();

        SpotAssignmentStrategy spotAssignmentStrategy = new RandomSpotAssignmentStrategy(parkingLotRepository);

        TicketService ticketService = new TicketService(gateRepository, vehicleRepository, spotAssignmentStrategy, ticketRepository);

        TicketController ticketController = new TicketController(ticketService);

        IssueTicketResponse response = ticketController.issueTicket(IssueTicketRequest.builder()
                .gateId(1L).vehicleNumber("123").vehicleType(VehicleType.CAR).build());




    }
}