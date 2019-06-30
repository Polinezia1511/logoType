package by.bsuir.logotype.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ResponcePK implements Serializable {
    private int id;
    private int userId;

    @Column(name = "id")
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "user_id")
    @Id
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
        ResponcePK that = (ResponcePK) o;
        return id == that.id &&
                userId == that.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId);
    }
}
