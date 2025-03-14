package com.company.rh_quizz.repository;

import com.company.rh_quizz.model.QuestionEntity;
import com.company.rh_quizz.model.QuizzEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<QuizzEntity, Integer> {
    List<QuestionEntity> findAllById(Integer id);
}
