package repositories;

import models.Gate;
import models.GateType;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GateRepository {

    private Map<Long, Gate> gates;

    public GateRepository() {
        this.gates = new HashMap<>();
        gates.put(1L, Gate.builder().gateType(GateType.ENTRY).gateNumber(1).build());

    }

    public Optional<Gate> findGateById(Long gateId) {
        if (gates.containsKey(gateId)) {
            return Optional.of(gates.get(gateId));
        }
        return Optional.empty();

    }

}
