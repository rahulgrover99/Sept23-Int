package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Gate {
    private int gateNumber;
    private Operator currentOperator;
    private GateType gateType;
}
