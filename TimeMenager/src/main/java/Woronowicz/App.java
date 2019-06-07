package Woronowicz;

import Woronowicz.controller.MainViewController;
import Woronowicz.services.*;
import Woronowicz.view.MainView;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.HashMap;

public class App extends Application {
    private Stage window;
    private static FtpConnection connection;
    private static Loader loader;
    private static TaskRepository taskRepository;
    private static TimeManager timeManager;
    private static TaskManager taskManager;

    private static Label selectedTask;
    private static Label timeOfTask;
    private static Label timeOfCurrentTask;

    private static ChoiceBox<String> choiceBox;
    Button startTask;
    Button finishTask;

    static int seconds = 0;
    static MainView view;
    static MainViewController controler;

    public static void main(String[] args) throws InterruptedException, IOException {

        taskRepository = new TaskRepository(0, new HashMap<>());
        connection = new FtpConnection();
        loader = new Loader(taskRepository, connection);

        taskManager = new TaskManager(taskRepository);
        taskManager.selectTask(0);
        timeManager = new TimeManager(taskRepository);
        timer();

        view = new MainView();
        launch(args);
    }

    public static void timer(){

        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(100),
                e -> {
                    if(taskManager.isTaskOnGoing()){
                        updateTimeOfCurrentTask(seconds/10);
                        seconds++;
                    }
                }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
    private static void updateTimeOfCurrentTask(int i) {
        view.getTimeOfCurrentTask().setText(i + " seconds");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        view.display(primaryStage);
        controler = new MainViewController(taskManager,timeManager,taskRepository,loader,view);
    }
}
