package com.aubay.rh_quizz;

import com.aubay.rh_quizz.model.QuizzEntity;
import com.aubay.rh_quizz.model.SubjectEntity;
import com.aubay.rh_quizz.service.QuizzService;
import com.aubay.rh_quizz.service.SubjectService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import records.QuizzToSave;
import records.SubjectToSave;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class QuizzControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuizzService quizzService;

    @MockBean
    private SubjectService subjectService;

    @Autowired
    private ObjectMapper objectMapper;  // Used for converting objects to JSON

    @Test
    void testCreateQuizz() throws Exception {
        SubjectToSave subject = new SubjectToSave("Math");
        QuizzToSave quizzToSave = new QuizzToSave("Math Quiz", "Basic math quiz", subject, null, null);

        mockMvc.perform(post("/quizzes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(quizzToSave)))
                .andExpect(status().isOk());

        Mockito.verify(quizzService).save(Mockito.any(QuizzToSave.class));
    }

    @Test
    void testGetAllQuizzes() throws Exception {
        QuizzEntity quizz = new QuizzEntity(null, null, "Math Quiz");
        Mockito.when(quizzService.getAll()).thenReturn(Collections.singletonList(quizz));

        mockMvc.perform(get("/quizzes"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name").value("Math Quiz"));

        Mockito.verify(quizzService).getAll();
    }

    @Test
    void testDeleteQuizz() throws Exception {
        mockMvc.perform(delete("/quizzes/1"))
                .andExpect(status().isOk());

        Mockito.verify(quizzService).deleteById(1);
    }
}
