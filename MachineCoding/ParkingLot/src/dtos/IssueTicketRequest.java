package dtos;

import lombok.Getter;
import lombok.Setter;
import models.VehicleType;

@Getter
@Setter
public class IssueTicketRequest {
    private String vehicleNumber;
    private Long gateId;
    private VehicleType vehicleType;
}
