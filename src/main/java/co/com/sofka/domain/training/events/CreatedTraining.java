package co.com.sofka.domain.training.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.training.values.TrainingId;

public class CreatedTraining extends DomainEvent {
    private final TrainingId trainingId;

    public CreatedTraining(TrainingId trainingId) {
        super("trainingf1.training.created");
        this.trainingId = trainingId;

    }

    public TrainingId TrainingId() {
        return trainingId;
    }

}
