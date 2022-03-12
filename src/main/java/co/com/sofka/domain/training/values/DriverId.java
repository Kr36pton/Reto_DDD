package co.com.sofka.domain.training.values;

import co.com.sofka.domain.generic.Identity;

public class DriverId extends Identity {

    private DriverId(String uid) {
        super(uid);
    }

    public DriverId(){}

    public static DriverId of(String uid){
        return new DriverId(uid);
    }
}
