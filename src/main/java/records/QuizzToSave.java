package records;

public record QuizzToSave(String name, String description, SubjectToSave subject, QuestionToSave question, AnswerToSave answer) {
}
