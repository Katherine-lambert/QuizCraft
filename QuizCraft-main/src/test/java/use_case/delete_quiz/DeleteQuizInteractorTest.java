package use_case.delete_quiz;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;

class DeleteQuizInteractorTest {

    @Test
    void successfulDelete() {
        // Setup mock data access object
        DeleteQuizDataAccessInterface mockUserDataAccessObject = new MockDeleteQuizDataAccessObject();
        
        // Create input data
        DeleteQuizInputData inputData = new DeleteQuizInputData("testUser", "testQuiz");
        
        // Create the interactor with mocked dependencies
        DeleteQuizOutputBoundary mockPresenter = new DeleteQuizOutputBoundary() {
            @Override
            public void prepareSuccessView(DeleteQuizOutputData outputData) {
                assertTrue(outputData.isSuccess());
                assertEquals("Quiz successfully deleted", outputData.getMessage());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected");
            }

            @Override
            public void switchToDashboardView(List<String> quizzes) {
                // Not used in the test, so do nothing
            }
        };

        DeleteQuizInputBoundary interactor = new DeleteQuizInteractor(mockUserDataAccessObject, mockPresenter);
        interactor.execute(inputData);
    }

    @Test
    void failureQuizNotFound() {
        // Setup mock data access object that returns false (quiz not found)
        DeleteQuizDataAccessInterface mockUserDataAccessObject = new MockDeleteQuizDataAccessObject() {
            @Override
            public boolean deleteQuiz(String username, String quizName) {
                return false;
            }
        };
        
        // Create input data
        DeleteQuizInputData inputData = new DeleteQuizInputData("testUser", "nonExistentQuiz");
        
        // Create the interactor with mocked dependencies
        DeleteQuizOutputBoundary mockPresenter = new DeleteQuizOutputBoundary() {
            @Override
            public void prepareSuccessView(DeleteQuizOutputData outputData) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Failed to delete quiz", error);
            }

            @Override
            public void switchToDashboardView(List<String> quizzes) {
                // Not used in the test, so do nothing
            }
        };

        DeleteQuizInputBoundary interactor = new DeleteQuizInteractor(mockUserDataAccessObject, mockPresenter);
        interactor.execute(inputData);
    }
}

class MockDeleteQuizDataAccessObject implements DeleteQuizDataAccessInterface {

    @Override
    public boolean deleteQuiz(String username, String quizName) {
        // Always simulate success
        return true;
    }

    @Override
    public boolean quizExistsByName(String username, String quizName) {
        // Not used in the test, so just return true or false
        return true;
    }

    @Override
    public List<String> getQuizzesByUser(String username) {
        // Not used in the test, so return an empty list
        return new ArrayList<>();
    }
}
