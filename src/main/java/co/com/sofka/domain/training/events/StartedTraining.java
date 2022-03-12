package co.com.sofka.domain.training.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.training.values.*;

public class StartedTraining extends DomainEvent {
    private final Length length;
    private final Speed speed;
    private final Gas gas;
    private final Name name;
    private final Brand brand;
    private final Line line;
    private final City city;
    private TrainingId trainingId;

    public StartedTraining(Length length, Speed speed, Gas gas, Name name, Brand brand, Line line, City city, TrainingId trainingId) {
        super("trainingf1.training.started");
        this.length = length;
        this.speed = speed;
        this.gas = gas;
        this.name = name;
        this.brand = brand;
        this.line = line;
        this.city = city;
        this.trainingId = trainingId;
    }


    public Length Length() {
        return length;
    }

    public Speed Speed() {
        return speed;
    }

    public Gas Gas() {
        return gas;
    }

    public Name Name() {
        return name;
    }

    public Brand Brand() {
        return brand;
    }

    public Line Line() {
        return line;
    }

    public City City() {
        return city;
    }

    public TrainingId TrainingId() {
        return trainingId;
    }
}
