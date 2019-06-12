package Woronowicz;

import Woronowicz.controllers.MainViewController;
import Woronowicz.views.MainView;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class App extends Application
{
    public static MainView view;
    public static MainViewController controller;
    public static TestRunner runner;
    public static void main( String[] args )
    {
        view = new MainView();
        runner = new TestRunner();

        System.out.println( "Hello World!" );

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        view.display(primaryStage);
        controller = new MainViewController(view, runner);
    }
}
