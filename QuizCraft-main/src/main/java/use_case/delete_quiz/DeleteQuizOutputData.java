package use_case.delete_quiz;
// provides the result of the use case after performing the deletion

public class DeleteQuizOutputData {
    private final boolean success;
    private final String message;
    private final String quizName;

    public DeleteQuizOutputData(boolean success, String message, String quizName) {
        this.success = success;
        this.message = message;
        this.quizName = quizName;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getQuizName() {
        return quizName;
    }
}
