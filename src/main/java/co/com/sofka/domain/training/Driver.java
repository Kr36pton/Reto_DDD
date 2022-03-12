package co.com.sofka.domain.training;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.training.values.*;

public class Driver extends Entity<DriverId> {
    private final Name name;


    public Driver(DriverId entityId, Name name) {
        super(entityId);
        this.name = name;
    }

    public Name Name() {
        return name;
    }
}
