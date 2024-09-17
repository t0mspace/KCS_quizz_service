package com.aubay.rh_quizz.controller;

import com.aubay.rh_quizz.model.SubjectEntity;
import com.aubay.rh_quizz.service.QuizzService;
import com.aubay.rh_quizz.service.SubjectService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import records.SubjectToSave;

import java.util.List;
import java.util.Optional;

@Tag(name = "RH Quizz APi")
@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private final SubjectService subjectService;

    @Autowired
    private final QuizzService quizzService;

    public SubjectController(QuizzService quizzService, SubjectService subjectService) {
        this.subjectService = subjectService;
        this.quizzService = quizzService;
    }

    @PostMapping
    public void create(@RequestBody SubjectToSave subject)
    {
        subjectService.save(subject);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id)
    {
        this.quizzService.deleteById(Integer.parseInt(id));
    }

    @PutMapping("{id}")
    public void update(@RequestBody SubjectToSave subjectToSave)
    {
        this.subjectService.save(subjectToSave);
    }

    @GetMapping
    public List<SubjectEntity> getAll()
    {
        return this.subjectService.getAll();
    }

    @GetMapping("{id}")
    public Optional<SubjectEntity> getById(@PathVariable("id") String id )
    {
        return this.subjectService.getById(id);
    }
}
