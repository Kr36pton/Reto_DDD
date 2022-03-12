package co.com.sofka.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.training.Training;
import co.com.sofka.domain.training.command.CreateBike;
import co.com.sofka.domain.training.command.StartTraining;
import co.com.sofka.domain.training.events.StartedTraining;
import co.com.sofka.domain.training.values.BikeId;

public class CalculateTimeTravelUseCase extends UseCase<TriggeredEvent<StartedTraining>, ResponseEvents>  {
    @Override
    public void executeUseCase(TriggeredEvent<StartedTraining> input) {
        var event = input.getDomainEvent();
        var bikeId = new BikeId();

        var training = Training.from(event.TrainingId(), retrieveEvents());

        emit().onResponse(new ResponseEvents(training.getUncommittedChanges()));
    }


}
