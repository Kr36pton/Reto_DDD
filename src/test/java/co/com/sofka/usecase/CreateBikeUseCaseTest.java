package co.com.sofka.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.training.command.CreateBike;
import co.com.sofka.domain.training.events.CreatedBike;
import co.com.sofka.domain.training.events.CreatedTraining;
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
class CreateBikeUseCaseTest {
    @Mock
    private DomainEventRepository repository;
    @Test
    void createBike() {
        var id = TrainingId.of("xxxx");
        var command = new CreateBike(BikeId.of("xxxx"),
                new Line("xxxx"),
                new Speed(100.0),
                new Gas(100),
                new Brand("Ferrari"),
                new TrainingId("xxxx"));
        var useCase = new CreateBikeUseCase();

        when(repository.getEventsBy(id.value())).thenReturn(eventStored(id));
        useCase.addRepository(repository);

    var events = UseCaseHandler.getInstance()
            .setIdentifyExecutor(id.value())
            .syncExecutor(useCase, new RequestCommand<>(command))
            .orElseThrow()
            .getDomainEvents();

    var createdBike = (CreatedBike) events.get(0);

        Assertions.assertEquals("xxxx", createdBike.BikeId().value());

    }
    private List<DomainEvent> eventStored(TrainingId id) {
        return List.of(
                new CreatedTraining(id)

        );
    }

}