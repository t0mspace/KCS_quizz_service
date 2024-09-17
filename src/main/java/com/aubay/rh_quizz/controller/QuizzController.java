package com.aubay.rh_quizz.controller;

import com.aubay.rh_quizz.model.QuizzEntity;
import com.aubay.rh_quizz.service.QuizzService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import records.QuizzToSave;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "RH Quizz APi")
@RestController
@RequestMapping("/quiz")
public class QuizzController {

    private final QuizzService quizzService;

    public QuizzController(QuizzService quizzService) {
        this.quizzService = quizzService;
    }

    @PostMapping
    public void create(@RequestBody QuizzToSave quiz)
    {
       quizzService.save(quiz);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id)
    {
        this.quizzService.deleteById(Integer.parseInt(id));
    }

    @PutMapping("{id}")
    public QuizzToSave update(@RequestBody QuizzToSave quizz)
    {
        return quizz;
    }

    @GetMapping
    public List<QuizzEntity> getAll()
    {
        return this.quizzService.getAll();
    }

    @GetMapping("/{name}")
    public QuizzEntity getByName(@PathVariable("name") String name) {
        return quizzService.findByName(name);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizzEntity> getById(@PathVariable String id) {
        QuizzEntity quizz = quizzService.getById(Integer.parseInt(id));

        return ResponseEntity.ok(quizz);

    }
}
