package strategies;

import models.Gate;
import models.ParkingSpot;
import models.VehicleType;

public interface SpotAssignmentStrategy {

    ParkingSpot getSpot(Long parkingLotId, Gate gate, VehicleType vehicleType);
}