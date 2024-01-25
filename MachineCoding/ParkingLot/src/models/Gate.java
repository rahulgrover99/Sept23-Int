package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Gate {
    private int gateNumber;
    private Operator currentOperator;
    private GateType gateType;
}
