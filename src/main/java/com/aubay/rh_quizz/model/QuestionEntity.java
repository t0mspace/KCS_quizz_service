package com.aubay.rh_quizz.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "question",schema = "aubay")
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "content", length = 250, nullable = false, unique = true)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_quizz", nullable = false)
    private QuizzEntity quizz;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<AnswerEntity> answers;

    public int getId() {
        return id;
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

    public Collection<AnswerEntity> getAnswers() {
        return answers;
    }

    public void setAnswers(Collection<AnswerEntity> answers) {
        this.answers = answers;
    }
}
