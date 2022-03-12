package co.com.sofka.domain.training.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Speed implements ValueObject<Double> {
private final Double value;

    public Speed(Double value) {
        this.value = Objects.requireNonNull(value);
        if (value < 0) {
            throw new IllegalArgumentException("El valor del tamaño no puede ser negativo");
        }
    }
@Override
public Double value() {
        return value;
        }

}
