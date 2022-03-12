package co.com.sofka.domain.training.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Brand implements ValueObject<String> {
    private final String value;

    public Brand(String brand) {
        this.value = Objects.requireNonNull(brand);
        if (brand.isBlank()) {
            throw new IllegalArgumentException("La marca no puede esta vacia");
        }
    }

    public String value() {
        return value;
    }

}
