package com.aubay.rh_quizz.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

@Entity
@Table(name = "answer",schema = "aubay")
public class AnswerEntity {

    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Nullable
    @Column(name = "id")
    private int id;

    @Column(name = "content", length = 250, nullable = false, unique = true)
    private String content;

    @Column(name = "weighting", nullable = false)
    private Integer weighting;

    @ManyToOne
    @JoinColumn()
    private QuestionEntity question;
}
