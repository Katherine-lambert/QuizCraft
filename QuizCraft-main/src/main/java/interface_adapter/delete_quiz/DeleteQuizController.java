package interface_adapter.delete_quiz;

import use_case.delete_quiz.DeleteQuizInputBoundary;
import use_case.delete_quiz.DeleteQuizInputData;

// responsible for handling user input and invoking the appropriate use case
// (the DeleteQuizInteractor). Acts as a mediator between the view and the use 
// case layer

/**
 * The controller for the Delete Quiz Use Case.
 */
public class DeleteQuizController {
    private final DeleteQuizInputBoundary deleteQuizUseCaseInteractor;

    public DeleteQuizController(DeleteQuizInputBoundary deleteQuizUseCaseInteractor) {
        this.deleteQuizUseCaseInteractor = deleteQuizUseCaseInteractor;
    }

    /**
     * Executes the Delete Quiz Use Case.
     * @param username the username of the user deleting the quiz
     * @param quizName the name of the quiz to delete
     */
    public void execute(String username, String quizName) {
        DeleteQuizInputData deleteQuizInputData = new DeleteQuizInputData(username, quizName);
        deleteQuizUseCaseInteractor.execute(deleteQuizInputData);
    }

    /**
     * Switches to the dashboard view.
     */
    public void switchToDashboardView(String username) {
        deleteQuizUseCaseInteractor.switchToDashboardView(username);
    }
}