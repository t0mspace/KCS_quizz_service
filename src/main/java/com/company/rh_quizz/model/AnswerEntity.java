package com.company.rh_quizz.model;

import jakarta.persistence.*;

@Entity
@Table(name = "answer",schema = "public")
public class AnswerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "content", length = 250, nullable = false, unique = true)
    private String content;

    @Column(name = "weighting", nullable = false)
    private Integer weighting;

    // Each answer belongs to one question
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_question", nullable = false)
    private QuestionEntity question;

    public AnswerEntity() {}

    public AnswerEntity(String content, Integer weighting, QuestionEntity question) {
        this.content = content;
        this.weighting = weighting;
        this.question = question;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getWeighting() {
        return weighting;
    }

    public void setWeighting(Integer weighting) {
        this.weighting = weighting;
    }

    public QuestionEntity getQuestion() {
        return question;
    }

    public void setQuestion(QuestionEntity question) {
        this.question = question;
    }
}
