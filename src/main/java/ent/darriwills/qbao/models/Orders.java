package ent.darriwills.qbao.models;

import jakarta.persistence.Entity;
import jakarta.persistent.GeneratedValue;
import jakarta.persistent.Id;

public class Orders {
    @Id @GeneratedValue private Long id;
    private String producerId;
    private String consumerId;
    private String timeStamp;

    Orders(String producerId, String consumerId, String timeStamp) {
        this.producerId = producerId;
        this.consumerId = consumerId;
        this.timeStamp = timeStamp;
    }

    Orders() {}
}