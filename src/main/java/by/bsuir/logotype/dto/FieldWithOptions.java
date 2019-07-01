package by.bsuir.logotype.dto;

import by.bsuir.logotype.entity.Field;

import java.util.List;
import java.util.Objects;

public class FieldWithOptions {
    private Field field;
    private List<String> options;

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FieldWithOptions that = (FieldWithOptions) o;
        return Objects.equals(field, that.field) &&
                Objects.equals(options, that.options);
    }

    @Override
    public int hashCode() {
        return Objects.hash(field, options);
    }

    @Override
    public String toString() {
        return "FieldWithOptions{" +
                "field=" + field +
                ", options=" + options +
                '}';
    }
}
