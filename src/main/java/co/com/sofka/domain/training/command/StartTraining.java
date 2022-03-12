package co.com.sofka.domain.training.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.training.values.TrainingId;

public class StartTraining implements Command {

    private final TrainingId trainingId;

    public StartTraining(TrainingId trainingId) {
        this.trainingId = trainingId;
    }

    public TrainingId TrainingId() {
        return trainingId;
    }
}
