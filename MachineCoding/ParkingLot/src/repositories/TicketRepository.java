package repositories;

import models.Ticket;
import models.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TicketRepository {
    private Map<String, Ticket> db = new HashMap<>();


    public Optional<Ticket> findTicketById(String id) {
        if (db.containsKey(id)) {
            return Optional.of(db.get(id));
        }
        return Optional.empty();
    }

    public void save(Ticket ticket) {
        db.put(ticket.getNumber(), ticket);
    }

}
