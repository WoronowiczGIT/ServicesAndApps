package Woronowicz.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainView{

    private Stage window;
    private static Label selectedTask;
    private static Label timeOfTask;
    private static Label timeOfCurrentTask;

    private static ChoiceBox<String> choiceBox;
    private Button startTask;
    private Button finishTask;

    public void display(Stage stage) {
        window = stage;
        window.setTitle("Time Manager");
        GridPane pane = new GridPane();

        choiceBox = new ChoiceBox<>();

        startTask = new Button("START TASK");
        finishTask = new Button("FINISH TASK");

        selectedTask = new Label();
        timeOfTask = new Label();
        timeOfCurrentTask = new Label();

        setGreedPane(pane);
        pane.getChildren().addAll(choiceBox, startTask, finishTask, timeOfTask, selectedTask, timeOfCurrentTask);
        Scene scene = new Scene(pane, 300, 300);

        window.setScene(scene);
        window.setMinWidth(250);
        window.setMinHeight(250);
        window.show();

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

    public Stage getWindow() {
        return window;
    }

    public static Label getSelectedTask() {
        return selectedTask;
    }

    public static Label getTimeOfTask() {
        return timeOfTask;
    }

    public static Label getTimeOfCurrentTask() {
        return timeOfCurrentTask;
    }

    public static ChoiceBox<String> getChoiceBox() {
        return choiceBox;
    }

    public Button getStartTaskBtn() {
        return startTask;
    }

    public Button getFinishTaskBtn() {
        return finishTask;
    }


}
