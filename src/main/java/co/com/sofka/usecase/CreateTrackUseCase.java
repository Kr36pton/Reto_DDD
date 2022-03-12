package co.com.sofka.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.training.Training;
import co.com.sofka.domain.training.command.CreateTraining;
import co.com.sofka.domain.training.values.TrainingId;

public class CreateTrackUseCase extends UseCase<RequestCommand<CreateTraining>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateTraining> input) {

        var command = input.getCommand();
        var trainingId = new TrainingId();

        var training = Training.from(command.TrainingId(), retrieveEvents());

        emit().onResponse(new ResponseEvents(training.getUncommittedChanges()));

    }


}
