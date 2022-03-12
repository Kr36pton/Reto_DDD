package co.com.sofka.domain.training.values;

import co.com.sofka.domain.generic.Identity;

public class BikeId extends Identity {

    private BikeId(String uid) {
        super(uid);
    }
    public BikeId() { }

    public static BikeId of(String uid){
        return new BikeId(uid);
    }

}
