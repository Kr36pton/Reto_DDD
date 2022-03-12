package co.com.sofka.domain.training;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.training.values.*;

public class Bike extends Entity<BikeId> {

    private final Brand brand;
    private final Line line;
    private final Gas gas;
    private final Speed speed;

    public Bike(BikeId entityId, Brand brand, Line line, Gas gas, Speed speed) {
        super(entityId);
        this.brand = brand;
        this.line = line;
        this.gas = gas;
        this.speed = speed;
    }

    public Brand Brand() {
        return brand;
    }

    public Line Line() {
        return line;
    }

    public Gas Gas() {
        return gas;
    }

    public Speed Speed() {
        return speed;
    }
}
