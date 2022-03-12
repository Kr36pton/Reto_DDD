package co.com.sofka.domain.training.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Gas implements ValueObject<Integer> {
private final Integer value;

    public Gas(Integer value) {
        this.value = Objects.requireNonNull(value);
        if(value < 0){
            throw new IllegalArgumentException("El valor de la durabilidad no puede ser negativo");
        }
    }
    @Override
    public Integer value() {
        return value;
    }


}
