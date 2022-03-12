package co.com.sofka.domain.training.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.training.values.*;

public class CreateBike implements Command {
    private final BikeId bikeId;
    private final Line line;
    private final Speed speed;
    private final Gas gas;
    private final Brand brand;
    private final TrainingId trainingId;


    public CreateBike(BikeId bikeId, Line line, Speed speed, Gas gas, Brand brand, TrainingId trainingId) {
        this.bikeId = bikeId;
        this.line = line;
        this.speed = speed;
        this.gas = gas;
        this.brand = brand;
        this.trainingId = trainingId;
    }

    public BikeId BikeId() {
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

    public TrainingId TrainingId() {
        return trainingId;
    }
}
