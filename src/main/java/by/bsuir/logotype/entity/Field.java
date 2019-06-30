package by.bsuir.logotype.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Field {
    private int id;
    private String label;
    private FieldType type;
    private boolean required;
    private boolean isActive;

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
}
