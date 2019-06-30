package by.bsuir.logotype.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ResponceHasFieldPK implements Serializable {
    private int responceId;
    private int fieldId;

    @Column(name = "responce_id")
    @Id
    public int getResponceId() {
        return responceId;
    }

    public void setResponceId(int responceId) {
        this.responceId = responceId;
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
        ResponceHasFieldPK that = (ResponceHasFieldPK) o;
        return responceId == that.responceId &&
                fieldId == that.fieldId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(responceId, fieldId);
    }
}
