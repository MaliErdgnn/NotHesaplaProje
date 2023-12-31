package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "quiz")
@Getter
@Setter
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quizid")
    private Long quizID;

    @Column(name = "quiznot")//@Column(name = "quizNot", precision = 5, scale = 2)
    private double quizNot;

    public Quiz(Long quizID, double quizNot) {
        this.quizID = quizID;
        this.quizNot = quizNot;
    }

    public Quiz(double quizNot) {
        this.quizNot = quizNot;
    }

    public Quiz() {

    }
}
