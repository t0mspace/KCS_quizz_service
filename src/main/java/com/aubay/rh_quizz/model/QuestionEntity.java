package com.aubay.rh_quizz.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "question",schema = "aubay")
public class QuestionEntity {
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;

    @Column(name = "content", length = 250, nullable = false, unique = true)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_quizz", nullable = false)
    private QuizzEntity quizz;

    @OneToMany(mappedBy = "id_quizz")
    private Collection<AnswerEntity> questions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public QuizzEntity getQuizz() {
        return quizz;
    }

    public void setQuizz(QuizzEntity quizz) {
        this.quizz = quizz;
    }
}
