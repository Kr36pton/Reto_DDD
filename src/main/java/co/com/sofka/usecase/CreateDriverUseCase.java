package co.com.sofka.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.training.Training;
import co.com.sofka.domain.training.command.CreateDriver;
import co.com.sofka.domain.training.values.TrainingId;

public class CreateDriverUseCase extends UseCase<RequestCommand<CreateDriver>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateDriver> input) {
        var command = input.getCommand();
        var trainingId = new TrainingId();

        var training = Training.from(command.TrainingId(), retrieveEvents());

        training.createDriver(command.DriverId(),command.Name());

        emit().onResponse(new ResponseEvents(training.getUncommittedChanges()));

    }
}
