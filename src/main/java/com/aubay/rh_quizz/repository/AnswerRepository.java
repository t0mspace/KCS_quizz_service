package com.aubay.rh_quizz.repository;

import com.aubay.rh_quizz.model.QuizzEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<QuizzEntity, Integer> {
    QuizzEntity findByName(String name);
}
