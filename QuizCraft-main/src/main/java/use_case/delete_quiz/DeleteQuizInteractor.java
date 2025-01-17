package use_case.delete_quiz;

import java.util.List;

public class DeleteQuizInteractor implements DeleteQuizInputBoundary {
    private final DeleteQuizDataAccessInterface quizDataAccessObject;
    private final DeleteQuizOutputBoundary deleteQuizPresenter;

    public DeleteQuizInteractor(DeleteQuizDataAccessInterface deleteQuizDataAccessInterface,
                               DeleteQuizOutputBoundary deleteQuizOutputBoundary) {
        this.quizDataAccessObject = deleteQuizDataAccessInterface;
        this.deleteQuizPresenter = deleteQuizOutputBoundary;
    }

    @Override
    public void execute(DeleteQuizInputData deleteQuizInputData) {
        String username = deleteQuizInputData.getUsername();
        String quizName = deleteQuizInputData.getQuizName();

        if (quizDataAccessObject.deleteQuiz(username, quizName)) {
            System.err.println("Quiz deleted successfully: " + quizName);
            DeleteQuizOutputData outputData = new DeleteQuizOutputData(true, "Quiz successfully deleted", quizName);

            deleteQuizPresenter.prepareSuccessView(outputData);
        } else {
            System.err.println("Failed to delete quiz: " + quizName);
            deleteQuizPresenter.prepareFailView("Failed to delete quiz");
        }
    }

    @Override
    public void switchToDashboardView(String username) {
        try {
            List<String> quizzes = quizDataAccessObject.getQuizzesByUser(username);
            deleteQuizPresenter.switchToDashboardView(quizzes);
        } catch (Exception e) {
            deleteQuizPresenter.prepareFailView("Failed to load quizzes: " + e.getMessage());
        }
    }

}