package interface_adapter.dashboard;

import java.util.ArrayList;
import java.util.List;

/**
 * The state for the Dashboard View.
 */
public class DashboardState {
    private final List<String> quizNames = new ArrayList<>();
    private String errorMessage;
    private String username;
    private String statusMessage = "";

    public List<String> getQuizzes() {
        return quizNames;
    }
    /**
     * The state for the Dashboard View.
     * @param quizzes quizzes
     */

    public void setQuizzes(List<String> quizzes) {
        this.quizNames.clear();
        this.quizNames.addAll(quizzes);
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
}
