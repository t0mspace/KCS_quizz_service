package com.company.rh_quizz.repository;

import com.company.rh_quizz.model.QuizzEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public interface QuizzRepository extends JpaRepository<QuizzEntity, Integer> {
    QuizzEntity findByName(String name);
}
