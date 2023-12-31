package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "hasproje")
@Getter
@Setter
public class HasProje {
    @Id
    @Column(name = "projeid")
    private Long projeID;


    @Column(name = "hesapid")
    private Long hesapID;

    public HasProje(Long projeID, Long hesapID) {
        this.projeID = projeID;
        this.hesapID = hesapID;
    }
    public HasProje(){

    }
}
