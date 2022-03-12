package co.com.sofka.domain.training.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.training.values.*;

public class CreatedBike extends DomainEvent {
    private final BikeId bikeId;
    private final Line line;
    private final Speed speed;
    private final Gas gas;
    private final Brand brand;


    public CreatedBike(BikeId bikeId, Line line, Speed speed, Gas gas, Brand brand, TrainingId trainingId) {
        super("trainingf1.bike.created");
        this.bikeId = bikeId;
        this.line = line;
        this.speed = speed;
        this.gas = gas;
        this.brand = brand;
    }

    public BikeId BikeId(){
        return bikeId;
    }

    public Line Line() {
        return line;
    }

    public Speed Speed() {
        return speed;
    }

    public Gas Gas() {
        return gas;
    }

    public Brand Brand() {
        return brand;
    }
}
