package com.company.rh_quizz;

import com.company.rh_quizz.model.QuizzEntity;
import com.company.rh_quizz.service.QuizzService;
import com.company.rh_quizz.service.SubjectService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import records.SubjectToSave;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class SubjectControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SubjectService subjectService;

    @MockBean
    private QuizzService quizzService;

    @Autowired
    private ObjectMapper objectMapper;  // Used for converting objects to JSON

    @Test
    void testCreateSubject() throws Exception {
        SubjectToSave subjectToSave = new SubjectToSave("Math");

        mockMvc.perform(post("/subject")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(subjectToSave)))
                .andExpect(status().isOk());

        Mockito.verify(subjectService).save(Mockito.any(SubjectToSave.class));
    }

    @Test
    void testGetAllQuizzes() throws Exception {
        QuizzEntity quizz = new QuizzEntity(null, null, "Math Quiz");
        Mockito.when(quizzService.getAll()).thenReturn(Collections.singletonList(quizz));

        mockMvc.perform(get("/subject"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name").value("Math Quiz"));

        Mockito.verify(quizzService).getAll();
    }

    @Test
    void testUpdateSubject() throws Exception {
        SubjectToSave updatedSubject = new SubjectToSave("Updated Math");

        mockMvc.perform(put("/subject/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedSubject)))
                .andExpect(status().isOk());

        Mockito.verify(subjectService).save(Mockito.any(SubjectToSave.class));
    }

    @Test
    void testDeleteSubject() throws Exception {
        mockMvc.perform(delete("/subject/1"))
                .andExpect(status().isOk());

        Mockito.verify(quizzService).deleteById(1);
    }
}
