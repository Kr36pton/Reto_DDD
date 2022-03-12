package co.com.sofka.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.training.Training;
import co.com.sofka.domain.training.command.StartTraining;

public class StartTrainingUseCase extends UseCase<RequestCommand<StartTraining>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<StartTraining> requestCommand) {
        var command = requestCommand.getCommand();
        var training = Training.from(command.TrainingId(), retrieveEvents());

        training.start();

        emit().onResponse(new ResponseEvents(training.getUncommittedChanges()));
    }
}
