package interface_adapter.delete_quiz;

import java.util.List;

// meidator between the use case and the view layer. Formats the output data
// from the use case into a form that the view can present to the user
// Handles view-specific logic (e.g. switching views)

import interface_adapter.ViewManagerModel;
import interface_adapter.dashboard.DashboardState;
import interface_adapter.dashboard.DashboardViewModel;
import use_case.delete_quiz.DeleteQuizOutputBoundary;
import use_case.delete_quiz.DeleteQuizOutputData;

public class DeleteQuizPresenter implements DeleteQuizOutputBoundary {
    private final DashboardViewModel dashboardViewModel;
    private final ViewManagerModel viewManagerModel;

    public DeleteQuizPresenter(ViewManagerModel viewManagerModel,
                              DashboardViewModel dashboardViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.dashboardViewModel = dashboardViewModel;
    }

    @Override
    public void prepareSuccessView(DeleteQuizOutputData outputData) {
        // On success, update the dashboard state
        final DashboardState dashboardState = dashboardViewModel.getState();
        dashboardState.setStatusMessage("Quiz '" + outputData.getQuizName() + "' deleted successfully");
        this.dashboardViewModel.setState(dashboardState);
        this.dashboardViewModel.firePropertyChanged();
        
        // Stay on dashboard view
        this.viewManagerModel.setState(dashboardViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        // On failure, update dashboard state with error
        final DashboardState dashboardState = dashboardViewModel.getState();
        dashboardState.setStatusMessage(error);
        dashboardViewModel.firePropertyChanged();
    }

    @Override
    public void switchToDashboardView(List<String> quizzes) {
        // Update the dashboard state with the new quiz list
        DashboardState dashboardState = dashboardViewModel.getState();
        dashboardState.setQuizzes(quizzes);
        dashboardViewModel.setState(dashboardState);
        dashboardViewModel.firePropertyChanged();

        // Switch to dashboard view
        viewManagerModel.setState(dashboardViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
