package by.bsuir.logotype.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Field {
    private int id;
    private String label;
    private FieldType type;
    private boolean required;
    private boolean isActive;
    private String fieldOption;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "label")
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Basic
    @Column(name = "required")
    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    @Basic
    @Column(name = "field_option")
    public String getFieldOption() {
        return fieldOption;
    }

    public void setFieldOption(String fieldOption) {
        this.fieldOption = fieldOption;
    }

    @Basic
    @Column(name = "isActive")
    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }

    @Enumerated(EnumType.STRING)
    public FieldType getType() {
        return type;
    }

    public void setType(FieldType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field field = (Field) o;
        return id == field.id &&
                required == field.required &&
                isActive == field.isActive &&
                Objects.equals(label, field.label) &&
                type == field.type &&
                Objects.equals(fieldOption, field.fieldOption);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, label, type, required, isActive, fieldOption);
    }

    @Override
    public String toString() {
        return "Field{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", type=" + type +
                ", required=" + required +
                ", isActive=" + isActive +
                ", fieldOption='" + fieldOption + '\'' +
                '}';
    }
}
