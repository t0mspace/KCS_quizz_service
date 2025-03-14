package com.company.rh_quizz.service;

import com.company.rh_quizz.model.QuizzEntity;
import com.company.rh_quizz.model.SubjectEntity;
import com.company.rh_quizz.repository.QuizzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import records.QuizzToSave;

import java.util.List;

@Service
public class QuizzService {

    private final QuizzRepository quizzRepository;
    private final SubjectService subjectService;

    @Autowired
    public QuizzService(QuizzRepository quizzRepository, SubjectService subjectService) {
        this.quizzRepository = quizzRepository;
        this.subjectService = subjectService;
    }

    public List<QuizzEntity> getAll() {
        return quizzRepository.findAll();
    }

    public QuizzEntity save(QuizzToSave quizzToSave) {
        // Convert the DTO to the entity
        SubjectEntity subjectEntity = subjectService.getByName(quizzToSave.subject().name());
        QuizzEntity quizzEntity = new QuizzEntity(
                quizzToSave.question(),
                subjectEntity,
                quizzToSave.name()
        );
        quizzEntity.setDescription(quizzToSave.description());
        return quizzRepository.save(quizzEntity);
    }

//    public QuizzEntity update(QuizzToSave quizz) {
//        return quizzRepository.up(quizz);
//    }

    public QuizzEntity getById(int id) {
        return quizzRepository.findById(id).orElse(null);
    }

    public QuizzEntity findByName(String name) {
        return quizzRepository.findByName(name);
    }

    public void deleteById(Integer quizzId) {
        quizzRepository.deleteById(quizzId);
    }
}
