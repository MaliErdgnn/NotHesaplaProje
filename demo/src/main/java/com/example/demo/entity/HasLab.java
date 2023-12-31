package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "haslab")
@Getter
@Setter
public class HasLab {
    @Id
    @Column(name = "labid")
    private Long labID;


    @Column(name = "hesapid")
    private Long hesapID;

    public HasLab(Long labID, Long hesapID) {
        this.labID = labID;
        this.hesapID = hesapID;
    }
    public HasLab() {

    }
}
