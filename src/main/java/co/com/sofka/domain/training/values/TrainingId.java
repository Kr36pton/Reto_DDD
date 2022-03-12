package co.com.sofka.domain.training.values;

import co.com.sofka.domain.generic.Identity;

public class TrainingId extends Identity {
    public TrainingId(String uid) {
        super(uid);
    }
    public TrainingId() { }

    public static TrainingId of(String uid){
        return new TrainingId(uid);
    }

}
