package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "lab")
@Getter
@Setter
public class Lab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "labid")
    private Long labID;

    @Column(name = "labnot")//@Column(name = "labNot", precision = 5, scale = 2)
    private double labNot;

    public Lab(Long labID, double labNot) {
        this.labID = labID;
        this.labNot = labNot;
    }
    public Lab(double labNot) {
        this.labNot = labNot;
    }
    public Lab() {

    }
}
