package co.com.sofka.domain.training.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.training.values.BikeId;
import co.com.sofka.domain.training.values.DriverId;
import co.com.sofka.domain.training.values.Name;
import co.com.sofka.domain.training.values.TrainingId;

public class CreateDriver  implements Command {
    private final DriverId driverId;
    private final Name name;
    private final TrainingId trainingId;

    public CreateDriver(DriverId driverId, Name name, TrainingId trainingId) {
        this.driverId = driverId;
        this.name = name;
        this.trainingId = trainingId;
    }
    public DriverId DriverId() {
        return driverId;
    }

    public TrainingId TrainingId() {
        return trainingId;
    }
    public Name Name(){
        return name;
    }
}
