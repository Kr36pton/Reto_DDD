package co.com.sofka.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.training.command.CreateTraining;
import co.com.sofka.domain.training.events.CreatedTraining;
import co.com.sofka.domain.training.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

class CreateTrainingUseCaseTest {
    @Test
    void createTraining() {

        var command = new CreateTraining(TrainingId.of("xxxx"));

        CreatedTraining createdTraining = executedusecase(command);

        Assertions.assertTrue(Objects.nonNull(createdTraining.TrainingId()));

    }

    private CreatedTraining executedusecase(CreateTraining command) {
        var useCase = new CreateTrainingUseCase();

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var createdTraining = (CreatedTraining) events.get(0);
        return createdTraining;
    }

}