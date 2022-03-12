package co.com.sofka.domain.training;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.training.events.*;

public class TrainingChange  extends EventChange {
    public TrainingChange(Training training) {

        apply((CreatedTraining event) -> {
            training.trainingStarted = Boolean.FALSE;
        });
        apply((CreatedTrack event) -> {
            training.track = new Track(event.trackId(), event.Country(), event.Length(), event.City());
        });
        apply((CreatedBike event) -> {
            training.bike = new Bike(event.BikeId(),event.Brand(),event.Line(), event.Gas(), event.Speed());
        });
        apply((CreatedDriver event) -> {
            training.driver = new Driver(event.DriverId(), event.Name());
        });
        apply((StartedTraining event) -> {
            training.trainingStarted = Boolean.TRUE;
        });
        apply((CalculateTimeTraveled event) -> {
            training.calculateTimeTravel();
        });
        apply((TimesTanked event) -> {
            training.timesTank();
        });

    }
}
