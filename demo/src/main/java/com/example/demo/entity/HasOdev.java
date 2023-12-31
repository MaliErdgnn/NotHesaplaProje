package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "hasodev")
@Getter
@Setter
public class HasOdev {
    @Id
    @Column(name = "odevid")
    private Long odevID;

    @Column(name = "hesapid")
    private Long hesapID;

    public HasOdev(Long odevID, Long hesapID) {
        this.odevID = odevID;
        this.hesapID = hesapID;
    }
    public HasOdev() {

    }
}
