package com.company.rh_quizz.repository;

import com.company.rh_quizz.model.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity, Integer> {
    SubjectEntity findByName(String name);
}
