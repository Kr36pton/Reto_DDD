package co.com.sofka.domain.training;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.training.command.CreateBike;
import co.com.sofka.domain.training.events.*;
import co.com.sofka.domain.training.values.*;
import co.com.sofka.domain.generic.AggregateEvent;

import java.util.List;

public class Training extends AggregateEvent<TrainingId>{

    protected Driver driver;
    protected Track track;
    protected Bike bike;
    protected Boolean trainingStarted;
    protected Double time;

    public Training(TrainingId entityId, Boolean trainingStarted) {
        super(entityId);
        this.trainingStarted = trainingStarted;

        appendChange(new CreatedTraining(entityId)).apply();
    }

    private Training(TrainingId entityId) {
        super(entityId);
        subscribe(new TrainingChange(this));
    }

    public static Training from(TrainingId trainingId, List<DomainEvent> retrieveEvents) {
        var training = new Training(trainingId);
        retrieveEvents.forEach(training::applyEvent);
        return training;
    }

    public void createBike(BikeId bikeId, Line line, Speed speed, Gas gas, Brand brand, TrainingId trainingId){
        appendChange(new CreatedBike(bikeId, line, speed, gas, brand, trainingId)).apply();
    }
    public void createDriver(DriverId driverId, Name name){
        appendChange(new CreatedDriver(driverId, name)).apply();
    }
    public void createTrack(TrackId trackId, Country country, Length length, City city){
        appendChange(new CreatedTrack(trackId, country, length, city)).apply();
    }

    public void start() {
        appendChange(new StartedTraining(track.Length(), bike.Speed(), bike.Gas(), driver.Name(), bike.Brand(), bike.Line(), track.City(), identity())).apply();
    }

    public void calculateTimeTravel(){
        var time = new CalculateTimeTraveled(bike.Speed(), track.Length(), track.Track(), entityId);
        appendChange(time).apply();
    }
    public void timesTank(){

    }


}
