package co.com.sofka.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.training.Bike;
import co.com.sofka.domain.training.Training;
import co.com.sofka.domain.training.command.CreateBike;
import co.com.sofka.domain.training.values.BikeId;

public class CreateBikeUseCase extends UseCase<RequestCommand<CreateBike>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateBike> input) {
        var command = input.getCommand();
        var bikeId = new BikeId();

        var training = Training.from(command.TrainingId(), retrieveEvents());

        training.createBike(command.BikeId(),command.Line(),command.Speed(),command.Gas(), command.Brand(), command.TrainingId());

        emit().onResponse(new ResponseEvents(training.getUncommittedChanges()));
    }

}
