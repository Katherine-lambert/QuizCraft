package use_case.delete_quiz;

import java.util.List;
// interface defines the methods that the use case will sue to interact with the
// data storage layer (database)

public interface DeleteQuizDataAccessInterface {
    /**
     * Deletes a quiz for the given user.
     * @param username the username of the quiz owner
     * @param quizName the name of the quiz to delete
     * @return true if quiz was successfully deleted, false otherwise
     */
    boolean deleteQuiz(String username, String quizName);

    /**
     * Checks if the quiz exists for the given user.
     * @param username the username to check
     * @param quizName the quiz name to check
     * @return true if the quiz exists, false otherwise
     */
    boolean quizExistsByName(String username, String quizName);

    /**
     * Retrieves the quizzes for the given user.
     * @param username the username to retrieve quizzes for
     * @return a list of quiz names
     */
    List<String> getQuizzesByUser(String username);
}
