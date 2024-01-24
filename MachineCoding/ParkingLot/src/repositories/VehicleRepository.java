package repositories;

import models.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VehicleRepository {
    private Map<String, Vehicle> vehicles = new HashMap<>();


    public Optional<Vehicle> findVehicleById(String vehicleNumber) {
        if (vehicles.containsKey(vehicleNumber)) {
            return Optional.of(vehicles.get(vehicleNumber));
        }
        return Optional.empty();
    }

    public void save(Vehicle vehicle) {
        if (!vehicles.containsKey(vehicle.getVehicleNumber())) {
            vehicles.put(vehicle.getVehicleNumber(), vehicle);
        }
    }
}
