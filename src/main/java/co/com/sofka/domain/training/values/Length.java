package co.com.sofka.domain.training.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Length implements ValueObject<Integer> {
    private final Integer value;

    public Length(Integer value) {
        this.value = Objects.requireNonNull(value);
        if(value < 0){
            throw new IllegalArgumentException("El valor del tamaño no puede ser negativo");
        }
    }
    @Override
    public Integer value() {
        return value;
    }
}
