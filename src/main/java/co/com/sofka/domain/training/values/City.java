package co.com.sofka.domain.training.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class City implements ValueObject<String> {
private final String value;

public City(String name) {
    this.value = Objects.requireNonNull(name);
    if (name.isBlank()) {
        throw new IllegalArgumentException("La ciudad no puede esta vacia");
    }
}

    public String value() {
        return value;
    }
}
