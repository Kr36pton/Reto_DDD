package co.com.sofka.domain.training;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.training.values.City;
import co.com.sofka.domain.training.values.Country;
import co.com.sofka.domain.training.values.Length;
import co.com.sofka.domain.training.values.TrackId;

public class Track extends Entity<TrackId> {

    private final Country country;
    private final Length length;
    private final City city;
    private Track track;

    public Track(TrackId entityId, Country country, Length length, City city) {
        super(entityId);
        this.country = country;
        this.length = length;
        this.city = city;
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

    public Track Track() {
        return track;
    }
}
