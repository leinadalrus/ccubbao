package ent.darriwills.qbao.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "consumers")
public class Customer extends User {
    private @Id Long id;

    @NotNull
    @Column(name = "username")
    private String username;
    private String membership;

    private String avatar;

    @Column(name = "timestamp")
    private String timeStamp;

    public Customer(String username,
        String membership,
        String avatar,
        String timeStamp
    ) {
        this.username = username;
        this.membership = membership;
        this.avatar = avatar;
        this.timeStamp = timeStamp;
    }

    public Customer() {}

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
        if (!(o instanceof Customer))
            return false;

        Customer customer = (Customer) o;

        return Objects.equals(this.id, customer.id)
            && Objects.equals(this.username, customer.username)
            && Objects.equals(this.timeStamp, customer.timeStamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.username, this.timeStamp);
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + this.id + ", username=" + this.username + "'\'"
            + ", timeStamp=" + this.timeStamp + "}";
    }
}