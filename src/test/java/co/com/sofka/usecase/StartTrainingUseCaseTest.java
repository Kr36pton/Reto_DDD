package co.com.sofka.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.training.command.CreateTraining;
import co.com.sofka.domain.training.command.StartTraining;
import co.com.sofka.domain.training.events.*;
import co.com.sofka.domain.training.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Objects;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StartTrainingUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void inicializarJuego() {
        var id = TrainingId.of("xxxx");
        var command = new StartTraining(id);
        var useCase = new StartTrainingUseCase();

        when(repository.getEventsBy(id.value())).thenReturn(eventStored(id));
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(id.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var trainingStarted = (StartedTraining) events.get(0);
        Assertions.assertEquals("xxxx", trainingStarted.TrainingId().value());
    }

    private List<DomainEvent> eventStored(TrainingId id) {
        return List.of(
                new CreatedTraining(id),
                new CreatedTrack( TrackId.of("Track"),
                        new Country("Colombia"),
                        new Length(100),
                        new City("Cali")),
                new CreatedBike( BikeId.of("Bike"),
                        new Line("XXXXX"),
                        new Speed(110.0),
                        new Gas(10),
                        new Brand("Ferrari"),
                        id),
                new CreatedDriver(DriverId.of("driver"), new Name("Pacho"))
                );

    }
}