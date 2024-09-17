package com.aubay.rh_quizz.service;

import com.aubay.rh_quizz.model.SubjectEntity;
import com.aubay.rh_quizz.repository.SubjectRepository;
import org.springframework.stereotype.Service;
import records.SubjectToSave;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<SubjectEntity> getAll() {
        return subjectRepository.findAll();
    }

    public SubjectEntity getByName(String name) {
        return subjectRepository.findByName(name);
    }

    public void save(SubjectToSave subjectToSave) {
        // Convert the DTO to the entity
        SubjectEntity subjectEntity = new SubjectEntity(subjectToSave);
        subjectRepository.save(subjectEntity);
    }

    public void delete(int id) {
        subjectRepository.deleteById(id);
    }

    public Optional<SubjectEntity> getById(String id) {
        return subjectRepository.findById(Integer.parseInt(id));
    }
}
