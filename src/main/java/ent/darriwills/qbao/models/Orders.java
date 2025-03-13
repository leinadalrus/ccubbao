package ent.darriwills.qbao.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String producerId;
    private String consumerId;
    private String timeStamp;

    Orders(String producerId, String consumerId, String timeStamp) {
        this.producerId = producerId;
        this.consumerId = consumerId;
        this.timeStamp = timeStamp;
    }

    Orders() {}

    public Long getId() {
        return id;
    }

    public String getProducerId() {
        return producerId;
    }

    public String getConsumerId() {
        return consumerId;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Orders))
            return false;
        
        var order = (Orders) o;
        return Objects.equals(this.id, order.id)
            && Objects.equals(this.producerId, order.producerId)
            && Objects.equals(this.consumerId, order.consumerId)
            && Objects.equals(this.timeStamp, order.timeStamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.producerId, this.consumerId, this.timeStamp);
    }

    @Override
    public String toString() {
        return "Orders{" + "id=" + this.id + ", producerId='" + this.producerId
            + '\'' +", consumerId='" + this.consumerId + '\'' + ", timeStamp="
                + this.timeStamp + '}';
    }
}