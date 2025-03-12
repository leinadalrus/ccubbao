package ent.darriwills.qbao.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {
    private @Id @Generated Long id;

    public User() {}

    public Long getId() {
        return id;
    }

    @Override
        public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof User))
            return false;

        User consumer = (User) o;

        return Objects.equals(this.id, consumer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    @Override
    public String toString() {
        return "User{" + "id=" + this.id + "}";
    }
}