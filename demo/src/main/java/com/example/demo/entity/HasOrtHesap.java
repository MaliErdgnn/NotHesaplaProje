package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "hasorthesap")
@Getter
@Setter
public class HasOrtHesap {

    @Column(name = "email")
    private String email;

    @Id
    @Column(name = "ortid")
    private Long ortID;

    public HasOrtHesap(String email, Long ortID) {
        this.email = email;
        this.ortID = ortID;
    }
    public HasOrtHesap() {

    }
}
