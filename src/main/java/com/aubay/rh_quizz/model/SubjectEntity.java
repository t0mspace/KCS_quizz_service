package com.aubay.rh_quizz.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import records.SubjectToSave;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "subject",schema="aubay")
public class SubjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", length = 250, nullable = false, unique = true)
    private String name;

    @Nullable
    @OneToMany(targetEntity = QuizzEntity.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<QuizzEntity> quizzes=new ArrayList<>();

    public SubjectEntity(SubjectToSave subject) {
        this.name = subject.name();
    }

    public SubjectEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Nullable
    public List<QuizzEntity> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(@Nullable List<QuizzEntity> quizzes) {
        this.quizzes = quizzes;
    }

    public void addQuizze(QuizzEntity quiz) {
        if(!this.quizzes.contains(quiz))
        {
            this.quizzes.add(quiz);
        }
    }
}
