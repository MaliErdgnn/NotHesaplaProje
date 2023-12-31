package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "hasquiz")
@Getter
@Setter
public class HasQuiz {
    @Id
    @Column(name = "quizid")
    private Long quizID;

    @Column(name = "hesapid")
    private Long hesapID;

    public HasQuiz(Long quizID, Long hesapID) {
        this.quizID = quizID;
        this.hesapID = hesapID;
    }
    public HasQuiz() {

    }
}
