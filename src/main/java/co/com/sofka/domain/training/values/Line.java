package co.com.sofka.domain.training.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Line  implements ValueObject<String> {
    private final String value;

    public Line(String name) {
        this.value = Objects.requireNonNull(name);
        if(name.isBlank()){
            throw new IllegalArgumentException("La linea no puede esta vacia");
        }
    }
    public String value() {
        return value;
    }
}
