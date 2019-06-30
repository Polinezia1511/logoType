package by.bsuir.logotype.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "responce_has_field", schema = "logotype", catalog = "")
@IdClass(ResponceHasFieldPK.class)
public class ResponceHasField {
    private int responceId;
    private int fieldId;
    private String value;

    @Id
    @Column(name = "responce_id")
    public int getResponceId() {
        return responceId;
    }

    public void setResponceId(int responceId) {
        this.responceId = responceId;
    }

    @Id
    @Column(name = "field_id")
    public int getFieldId() {
        return fieldId;
    }

    public void setFieldId(int fieldId) {
        this.fieldId = fieldId;
    }

    @Basic
    @Column(name = "value")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponceHasField that = (ResponceHasField) o;
        return responceId == that.responceId &&
                fieldId == that.fieldId &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(responceId, fieldId, value);
    }
}
