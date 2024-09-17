package com.aubay.rh_quizz.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "quizz",schema = "aubay")
public class QuizzEntity {

    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Nullable
    @Column(name = "id")
    private int id;

    @Column(name = "name", length = 250, nullable = false, unique = true)
    private String name;

    @Nullable
    @Column(name = "description", length = 250, nullable = true)
    private String description;

    @OneToOne(targetEntity = UserEntity.class, optional = false)
    private UserEntity createdBy;

    @OneToOne(targetEntity = UserEntity.class, optional = true)
    private UserEntity updatedBy;

    @ManyToOne
    @JoinColumn(name = "id_subject", nullable = false)
    private SubjectEntity subject;

    @OneToMany(mappedBy = "id_quizz")
    private Collection<QuestionEntity> questions;

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

    public UserEntity getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserEntity createdBy) {
        this.createdBy = createdBy;
    }

    public UserEntity getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(UserEntity updatedBy) {
        this.updatedBy = updatedBy;
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

    public void setQuestions(QuestionEntity question) {
        if(!this.questions.contains(question))
        {
            this.questions.add(question);
        }
    }
}
