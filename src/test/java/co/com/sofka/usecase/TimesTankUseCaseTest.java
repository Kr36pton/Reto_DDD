package co.com.sofka.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.training.events.*;
import co.com.sofka.domain.training.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TimesTankUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void calculateTankQuantity() {
        var id = TrainingId.of("xxxx");
        var event = new StartedTraining(id,
                DriverId.of("driver"),
                BikeId.of("Bike"),
                TrackId.of("Track"),
                new Length(10),
                new Speed(200.0),
                new Gas(100.0),
                new Name("Pacho"),
                new Brand("Tommy"),
                new Line("XXXXX"),
                new City("Medellin"),
                Boolean.TRUE);
        event.setAggregateRootId(id.value());
        var useCase = new TimesTankUseCaseTest();

        when(repository.getEventsBy(id.value())).thenReturn(eventStored(id));
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(id.value())
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var quantityOfTankReleased = (TimesTanked) events.get(0);

        Assertions.assertEquals(1, quantityOfTankReleased.Length());


    }

    private List<DomainEvent> eventStored(TrainingId id) {
        return List.of(
                new CreatedTraining(id),
                new CreatedTrack( TrackId.of("Track"),
                        new Country("Brasil"),
                        new Length(10),
                        new City("Medellin")),
                new CreatedBike( BikeId.of("Bike"),
                        new Speed(200),
                        new Brand("Ferrari"),
                        new Line("XXXXX"),
                        new Gas(100)),
                new CreatedDriver(DriverId.of("driver"), new Name("Pacho"))

        );

    }
}