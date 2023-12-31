package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "odev")
@Getter
@Setter
public class Odev {

    @Id
    @Column(name = "odevid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long odevID;

    @Column(name = "odevnot")//@Column(name = "odevNot", precision = 5, scale = 2)
    private double odevNot;

    public Odev(Long odevID, double odevNot) {
        this.odevID = odevID;
        this.odevNot = odevNot;
    }
    public Odev(double odevNot) {
        this.odevNot = odevNot;
    }
    public Odev() {

    }
}
