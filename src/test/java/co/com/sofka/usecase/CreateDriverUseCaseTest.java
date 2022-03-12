package co.com.sofka.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.training.command.CreateBike;
import co.com.sofka.domain.training.command.CreateDriver;
import co.com.sofka.domain.training.command.CreateTraining;
import co.com.sofka.domain.training.events.CreatedBike;
import co.com.sofka.domain.training.events.CreatedDriver;
import co.com.sofka.domain.training.events.CreatedTraining;
import co.com.sofka.domain.training.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateDriverUseCaseTest {
    @Mock
    private DomainEventRepository repository;
    @Test
    void createDriver() {
        var id = TrainingId.of("xxxx");
        var command = new CreateDriver(DriverId.of("xxxx"),
                new Name("xxxx"),
                new TrainingId("xxxx"));
        var useCase = new CreateDriverUseCase();

        when(repository.getEventsBy(id.value())).thenReturn(eventStored(id));
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(id.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var createdDriver = (CreatedDriver) events.get(0);

        Assertions.assertEquals("xxxx", createdDriver.DriverId().value());

    }
    private List<DomainEvent> eventStored(TrainingId id) {
        return List.of(
                new CreatedTraining(id)
        );
    }

}