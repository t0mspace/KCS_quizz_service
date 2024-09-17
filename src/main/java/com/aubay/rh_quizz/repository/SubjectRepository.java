package com.aubay.rh_quizz.repository;

import com.aubay.rh_quizz.model.QuizzEntity;
import com.aubay.rh_quizz.model.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity, Integer> {
    SubjectEntity findByName(String name);
}
