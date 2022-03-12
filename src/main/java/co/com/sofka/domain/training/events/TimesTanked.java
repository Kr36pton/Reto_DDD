package co.com.sofka.domain.training.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.training.values.Gas;
import co.com.sofka.domain.training.values.Length;

public class TimesTanked  extends DomainEvent {
    private final Gas gas;
    private final Length length;

    public TimesTanked(Gas gas, Length length){
        super("training.timestank");
        this.gas = gas;
        this.length = length;
    }

    public Gas Gas() {
        return gas;
    }

    public Length Length() {
        return length;
    }


}
