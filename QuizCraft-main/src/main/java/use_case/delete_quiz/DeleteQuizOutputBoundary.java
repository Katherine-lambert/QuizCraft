package use_case.delete_quiz;
import java.util.List;

// interface through which use case sends data back to the controller or presenter
// prepares appropriate output for view, whether the use case was auccessful or failed

public interface DeleteQuizOutputBoundary {
    /**
     * Prepares the success view for the Delete Quiz Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(DeleteQuizOutputData outputData);
    /**
     * Prepares the failure view for the Delete Quiz Use Case.
     * @param error the explanation of the failure
     */
    void prepareFailView(String error);
    /**
     * Switches to the dashboard view after successful quiz deletion.
     */
    void switchToDashboardView(List<String> quizzes);
}
