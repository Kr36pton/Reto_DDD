package co.com.sofka.domain.training.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.training.values.*;

public class CreatedTrack extends DomainEvent {
    private final TrackId trackId;
    private final Country country;
    private final Length length;
    private final City city;

    public CreatedTrack(TrackId trackId, Country country, Length length, City city) {
        super("trainingf1.track.created");
        this.trackId = trackId;
        this.country = country;
        this.length = length;
        this.city = city;
    }



    public TrackId trackId() {
        return trackId;
    }

    public TrackId TrackId() {
        return trackId;
    }

    public Country Country() {
        return country;
    }

    public Length Length() {
        return length;
    }

    public City City() {
        return city;
    }
}
