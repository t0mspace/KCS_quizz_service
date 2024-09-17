package com.aubay.rh_quizz.service;

import com.aubay.rh_quizz.model.QuizzEntity;
import com.aubay.rh_quizz.repository.QuizzRepository;
import org.springframework.stereotype.Service;
import records.QuizzToSave;

import java.util.List;

@Service
public class QuizzService {

    private final QuizzRepository quizzRepository;

    public QuizzService(QuizzRepository quizzRepository) {
        this.quizzRepository = quizzRepository;
    }

    public List<QuizzEntity> getAll() {
        return quizzRepository.findAll();
    }

    public QuizzEntity save(QuizzToSave quizz) {
        return quizzRepository.save(quizz);
    }

    public QuizzEntity update(QuizzToSave quizz) {
        return quizzRepository.save(quizz);
    }

    public QuizzEntity findById(int id) {
        return quizzRepository.findById(id).orElse(null);
    }

    public QuizzEntity findByName(String name) {
        return quizzRepository.findByName(name);
    }

    public void deleteById(Integer quizzId) {
        quizzRepository.deleteById(quizzId);
    }
}
