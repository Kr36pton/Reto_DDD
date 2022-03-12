package co.com.sofka.domain.training.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.training.values.DriverId;
import co.com.sofka.domain.training.values.Name;

public class CreatedDriver extends DomainEvent {
    private final DriverId driverId;
    private final Name name;


    public CreatedDriver(DriverId driverId, Name name) {
        super("trainingf1.driver.created");
        this.driverId = driverId;
        this.name = name;
    }

    public DriverId DriverId() {
        return driverId;
    }

    public Name Name() {
        return name;
    }
}
