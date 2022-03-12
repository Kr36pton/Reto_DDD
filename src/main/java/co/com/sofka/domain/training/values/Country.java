package co.com.sofka.domain.training.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Country implements ValueObject<String> {
    private final String value;

    public Country(String nationality) {
        this.value = Objects.requireNonNull(nationality);
        if(nationality.isBlank()){
            throw new IllegalArgumentException("El pais no puede estar vacio");
        }
    }
    public String value() {
        return value;
    }
}
