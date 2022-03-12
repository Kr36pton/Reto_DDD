package co.com.sofka.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.training.command.CreateTrack;
import co.com.sofka.domain.training.events.CreatedTrack;
import co.com.sofka.domain.training.events.CreatedTraining;
import co.com.sofka.domain.training.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateTrackUseCaseTest {
    @Mock
    private DomainEventRepository repository;
    @Test
    void createDriver() {
        var id = TrainingId.of("xxxx");
        //TrackId trackId, Country country, Length length, City city
        var command = new CreateTrack(TrackId.of("xxxx"),
                new Country("xxxx"),
                new Length(100),
                new City("xxxx"));
        var useCase = new CreateTrackUseCase();

        when(repository.getEventsBy(id.value())).thenReturn(eventStored(id));
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(id.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var createdTrack = (CreatedTrack) events.get(0);

        Assertions.assertEquals("xxxx", createdTrack.TrackId().value());

    }
    private List<DomainEvent> eventStored(TrainingId id) {
        return List.of(
                new CreatedTraining(id)
        );
    }

}