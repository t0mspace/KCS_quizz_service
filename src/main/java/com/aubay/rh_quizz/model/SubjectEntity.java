package com.aubay.rh_quizz.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "subject",schema = "aubay")
public class SubjectEntity {

    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Nullable
    @Column(name = "id")
    private int id;

    @Column(name = "name", length = 250, nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "id_subject")
    private Set<QuizzEntity> quizzes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<QuizzEntity> getQuizzes() {
        return this.quizzes;
    }

    public void setQuizzes(QuizzEntity quizzes) {
        this.quizzes.add(quizzes);
    }
}
