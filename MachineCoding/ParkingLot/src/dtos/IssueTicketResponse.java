package dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class IssueTicketResponse {
    private int spotNumber;
    private int floorNumber;
    private String ticketId;
    private Date entryTime;
    private int gateNumber;
    private String vehicleNumber;
    private int statusCode;
    private String message;
}
