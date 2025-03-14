package com.company.rh_quizz.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import records.QuestionToSave;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "quizz",schema = "public")
public class QuizzEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", length = 250, nullable = false, unique = true)
    private String name;

    @Nullable
    @Column(name = "description", length = 250, nullable = true)
    private String description;

    @ManyToOne
    @JoinColumn( // this will add a user_id column to the message table as a foreign key
            name = "id_subject", // specifies the name of the foreign key column in the database
            referencedColumnName = "id" // primary key of the user who owns this MESSAGE
    )
    private SubjectEntity subject;

    @OneToMany(targetEntity = QuestionEntity.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<QuestionEntity> questions = new ArrayList<>();;

    public QuizzEntity(QuestionToSave question, SubjectEntity subject, String name) {
        this.name = name;
        this.subject=subject;
    }

    public QuizzEntity() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(@Nullable String description) {
        this.description = description;
    }

    public SubjectEntity getSubject() {
        return subject;
    }

    public void setSubject(SubjectEntity subject) {
        this.subject = subject;
    }

    public QuestionEntity getQuestions() {
        return (QuestionEntity) questions;
    }

    public void addQuestions(QuestionEntity question) {
        if(!this.questions.contains(question))
        {
            this.questions.add(question);
        }
    }
}
