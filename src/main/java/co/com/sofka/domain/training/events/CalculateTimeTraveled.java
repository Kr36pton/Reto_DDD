package co.com.sofka.domain.training.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.training.Bike;
import co.com.sofka.domain.training.Track;
import co.com.sofka.domain.training.values.Length;
import co.com.sofka.domain.training.values.Speed;
import co.com.sofka.domain.training.values.TrainingId;

public class CalculateTimeTraveled extends DomainEvent {
    private final Speed speed;
    private final Length length;
    private final Track track;
    private final TrainingId trainingId;
    private Bike bike;
    private Double time;

    public CalculateTimeTraveled(Speed speed, Length length, Track track, TrainingId trainingId){
        super("trainingf1.calculate.timetravel");
        this.speed = speed;
        this.length = length;
        this.track = track;
        this.trainingId = trainingId;
    }

    public Speed Speed() {
        return speed;
    }

    public Length Length() {
        return length;
    }

    public Track Track() {
        return track;
    }

    public TrainingId TrainingId(){
        return trainingId;
    }

    public Double calculateTimeTravel(){
        time = track.Length().value() / bike.Speed().value() ;
        return time;
    }

    public double Time() {
        return time;
    }
}
