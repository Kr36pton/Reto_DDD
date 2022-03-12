package co.com.sofka.domain.training.command;

import co.com.sofka.domain.generic.Command;

import co.com.sofka.domain.training.values.*;

public class CreateTraining implements Command {

    private final TrainingId trainingId;

    public CreateTraining(TrainingId trainingId) {
        this.trainingId = trainingId;
    }

    public TrainingId TrainingId() {
        return trainingId;
    }

}
