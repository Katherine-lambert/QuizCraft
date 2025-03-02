package use_case.create_quiz;
import entity.Quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Output Data for the CreateQuiz Use Case.
 */
public class CreateQuizOutputData {

    private final String quizName;
    private final List<Map<String, Object>> questions = new ArrayList<>();

    public CreateQuizOutputData(String quizName, List<Map<String, Object>> questions) {
        this.quizName = quizName;
        this.questions.addAll(new ArrayList<>(questions));
    }

    public String getQuizName() {
        return quizName;
    }

    public List<Map<String, Object>> getQuestions() {
        return questions;
    }
}
