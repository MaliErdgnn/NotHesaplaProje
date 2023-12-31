package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "hasders")
@Getter
@Setter
public class HasDers {
    @Column(name = "ortid")
    private Long ortID;

    @Id
    @Column(name = "dersid")
    private Long dersID;

    public HasDers(Long ortID, Long dersID) {
        this.ortID = ortID;
        this.dersID = dersID;
    }

    public HasDers() {

    }
}
