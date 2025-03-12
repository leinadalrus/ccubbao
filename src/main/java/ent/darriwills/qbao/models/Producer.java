package ent.darriwills.qbao.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "producers")
public class Producer extends User {
    private @Id @Generated Long id;
    private String username;
    private String membership;

    private String avatar;
    private String timeStamp;

    public Producer(String username,
        String membership,
        String avatar,
        String timeStamp
    ) {
        this.username = username;
        this.membership = membership;
        this.avatar = avatar;
        this.timeStamp = timeStamp;
    }

    public Producer() {}

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getMembership() {
        return membership;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
        public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Producer))
            return false;

        Producer producer = (Producer) o;

        return Objects.equals(this.id, producer.id)
            && Objects.equals(this.username, producer.username)
            && Objects.equals(this.timeStamp, producer.timeStamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.username, this.timeStamp);
    }

    @Override
    public String toString() {
        return "Producer{" + "id=" + this.id + ", username=" + this.username + "'\'"
            + ", timeStamp=" + this.timeStamp + "}";
    }
}