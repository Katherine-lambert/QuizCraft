package app;

import javax.swing.JFrame;

/**
 * The Main class of our application.
 */
public class Main {
    /**
     * Builds and runs the CA architecture of the application.
     * @param args unused arguments
     */
    public static void main(String[] args) {
        final AppBuilder appBuilder = new AppBuilder();
        final JFrame application = appBuilder
                                            .addLoginView()
                                            .addSignupView()
                                            .addLoggedInView()
                                            .addCreateQuizView()
                                            .addViewQuizView()
                                            .addSignupUseCase()
                                            .addLoginUseCase()
                                            .addLoggedInUseCase()
                                            .addCreateQuizUseCase()
                                            .addViewQuizUseCase()
                                            .addLogoutUseCase()
                                            .addDeleteQuizUseCase()
                                            .build();

        application.pack();
        application.setVisible(true);
    }
}
