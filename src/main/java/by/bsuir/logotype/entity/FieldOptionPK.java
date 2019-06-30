package by.bsuir.logotype.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class FieldOptionPK implements Serializable {
    private int id;
    private int fieldId;

    @Column(name = "id")
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "field_id")
    @Id
    public int getFieldId() {
        return fieldId;
    }

    public void setFieldId(int fieldId) {
        this.fieldId = fieldId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FieldOptionPK that = (FieldOptionPK) o;
        return id == that.id &&
                fieldId == that.fieldId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fieldId);
    }
}
