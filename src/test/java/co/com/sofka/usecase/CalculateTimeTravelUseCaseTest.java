package co.com.sofka.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.training.events.*;
import co.com.sofka.domain.training.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


class CalculateTimeTravelUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void calculateTime() {
        var id = TrainingId.of("xxxx");
        //Length length, Speed speed, Gas gas, Name name, Brand brand, Line line, City city, TrainingId trainingId
        var event = new StartedTraining(
                new Length(100),
                new Speed(200.0),
                new Gas(100),
                new Name("Pacho"),
                new Brand("Lambo"),
                new Line("XXXXX"),
                new City("Medellin"),
                id);
        event.setAggregateRootId(id.value());
        var useCase = new CalculateTimeTravelUseCase();

        when(repository.getEventsBy(id.value())).thenReturn(eventStored(id));
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(id.value())
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var Timecalculated = (CalculateTimeTraveled) events.get(0);

        Assertions.assertEquals(0.5, Timecalculated.Time());


    }

    private List<DomainEvent> eventStored(TrainingId id) {
        return List.of(
                new CreatedTraining(id),
                new CreatedTrack( TrackId.of("Track"),
                        new Country("Brasil"),
                        new Length(100),
                        new City("Rio")),
                new CreatedBike( BikeId.of("Bike"),
                        new Line("xxxx"),
                        new Speed(100.0),
                        new Gas(100),
                        new Brand("Ferrari"),
                        new TrainingId("xxxx")));
                new CreatedDriver(DriverId.of("driver"), new Name("Pacho")
        );

    }
}