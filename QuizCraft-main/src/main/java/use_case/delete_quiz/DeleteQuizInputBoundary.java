package use_case.delete_quiz;

public interface DeleteQuizInputBoundary {
    /**
     * Executes the delete quiz use case.
     * @param deleteQuizInputData the input data
     */
    void execute(DeleteQuizInputData deleteQuizInputData);

    /**
     * Switches to dashboard view.
     */
    void switchToDashboardView(String username);
}
