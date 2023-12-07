package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "odev")
@Getter
@Setter
public class odev {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "odevID")
    private Long odevID;

    @Column(name = "odevNot", precision = 5, scale = 2)
    private Double odevNot;
}
