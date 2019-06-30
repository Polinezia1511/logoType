package by.bsuir.logotype.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.Objects;

@Entity
@IdClass(ResponcePK.class)
public class Responce {
    private int id;
    private int userId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Responce responce = (Responce) o;
        return id == responce.id &&
                userId == responce.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId);
    }
}
