package models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ParkingLot {
    private String name;
    private String address;
    List<ParkingFloor> parkingFloorList;
    List<Gate> entryGates;
    List<Gate> exitGates;


}
