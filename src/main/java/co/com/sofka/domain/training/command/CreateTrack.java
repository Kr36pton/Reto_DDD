package co.com.sofka.domain.training.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.training.values.*;

public class CreateTrack implements Command {

    private final TrackId trackId;
    private final Country country;
    private final Length length;
    private final City city;

    public CreateTrack(TrackId trackId, Country country, Length length, City city) {
        this.trackId = trackId;
        this.country = country;
        this.length = length;
        this.city = city;
    }

    public TrackId TrackId() {
        return trackId;
    }

}
