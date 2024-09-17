package records;

import com.aubay.rh_quizz.model.SubjectEntity;

public record QuizzToSave(String name, String description, SubjectToSave subject, QuestionToSave question, AnswerToSave answer) {
}
