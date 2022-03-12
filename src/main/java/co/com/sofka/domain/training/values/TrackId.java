package co.com.sofka.domain.training.values;

import co.com.sofka.domain.generic.Identity;

public class TrackId extends Identity {
    private TrackId(String uid) {
        super(uid);
    }
    public TrackId() { }

    public static TrackId of(String uid){
        return new TrackId(uid);
    }
}
