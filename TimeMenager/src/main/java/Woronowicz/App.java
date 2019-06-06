package Woronowicz;

import Woronowicz.services.*;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.HashMap;

public class App extends Application {
    private Stage window;
    private static FtpConnection connection;
    private static Saver saver;
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

    public static void main(String[] args) throws InterruptedException, IOException {

        taskRepository = new TaskRepository(0, new HashMap<>());

        connection = new FtpConnection();

        saver = new Saver(taskRepository, connection);

        taskManager = new TaskManager(taskRepository);
        taskManager.selectTask(0);
        timeManager = new TimeManager(taskRepository);
        timer();
        launch(args);
    }

    public static void timer(){

        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(100),
                e -> {
                    if(taskManager.isTaskOnGoing()){
                        updateTimeOfCurrentTask(seconds/10);
                        seconds++;
                    }else {
                        seconds = 0;
                        updateTimeOfCurrentTask(seconds);
                    }
                }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        window.setTitle("Time Manager");
        GridPane pane = new GridPane();


        choiceBox = new ChoiceBox<>();
        setChoiceBox(choiceBox);


        choiceBox.setOnAction(e -> handleSelection(choiceBox));

        startTask = new Button("START TASK");
        startTask.setOnAction(e -> startTask());

        finishTask = new Button("FINISH TASK");
        finishTask.setOnAction(e -> endTask());

        window.setOnCloseRequest(e -> closeProgram());

        selectedTask = new Label();
            updateSelectionLabel();
        timeOfTask = new Label();
            updateTimeLabel();
        timeOfCurrentTask = new Label();
            updateTimeOfCurrentTask(0);
        setGreedPane(pane);
        pane.getChildren().addAll(choiceBox, startTask, finishTask, timeOfTask, selectedTask, timeOfCurrentTask);
        Scene scene = new Scene(pane, 300, 300);
        window.setScene(scene);
        window.show();
    }

    private void closeProgram() {
        window.close();
        if (taskManager.isTaskOnGoing()) {
            taskManager.finishTask();
            taskManager.updateTask();
        }
        try {
            saver.saveRemote();
        } catch (IOException e) {
            System.out.println("failed to saveRemote");
        }

    }

    private void startTask() {
        choiceBox.setDisable(true);
        taskManager.startTask();
    }

    private void endTask() {
        if (taskManager.isTaskOnGoing()) {
            taskManager.finishTask();
            taskManager.updateTask();
            choiceBox.setDisable(false);
            updateTimeLabel();
        }

        try {
            saver.saveLocal();
        } catch (IOException e) {
            System.out.println("failed to saveLocal");
        }
    }

    private void updateTimeLabel() {
        timeOfTask.setText(timeManager.timeTotal(taskManager.getSelectedTask().getId()) + " seconds");
    }

    private void updateSelectionLabel() {
        selectedTask.setText("total time for: \n"
                + taskManager.getSelectedTask().getName());
    }

    private static void updateTimeOfCurrentTask(int i){
        timeOfCurrentTask.setText(i+" seconds");
    }

    private void setGreedPane(GridPane pane) {
        pane.setPadding(new Insets(20, 20, 20, 20));
        pane.setVgap(20);
        pane.setHgap(20);

        GridPane.setConstraints(choiceBox, 0, 0);

        GridPane.setConstraints(startTask, 1, 0);
        GridPane.setConstraints(finishTask, 1, 1);

        GridPane.setConstraints(selectedTask, 0, 2);
        GridPane.setConstraints(timeOfTask, 1, 2);
        GridPane.setConstraints(timeOfCurrentTask, 1, 3);
    }

    private void handleSelection(ChoiceBox<String> choiceBox) {
        String value = choiceBox.getValue();
        int id = taskRepository.getTaskID(value);
        taskManager.selectTask(id);
        System.out.println(taskManager.getSelectedTask().getName());
        updateTimeLabel();
        updateSelectionLabel();
    }

    private void setChoiceBox(ChoiceBox<String> choiceBox) {
        choiceBox.getItems().addAll(taskRepository.getTasknames());
        choiceBox.setValue(taskManager.getSelectedTask().getName());
    }


}
