package use_case.delete_quiz;

// carries the data that the use case needs in order to perform its logic

public class DeleteQuizInputData {
    private final String username;
    private final String quizName;

    public DeleteQuizInputData(String username, String quizName) {
        this.username = username;
        this.quizName = quizName;
    }

    public String getUsername() {
        return username;
    }

    public String getQuizName() {
        return quizName;
    }
}
