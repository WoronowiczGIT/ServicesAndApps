package Woronowicz.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainView {

    private Stage window;
    private Label selectedTask;
    private Label timeOfTask;
    private Label timeOfCurrentTask;

    private ChoiceBox<String> choiceBox;
    private Button startTask;
    private Button finishTask;
    private MenuBar menuBar;

    public MainView(MenuBar menu){
        menuBar = menu;
        choiceBox = new ChoiceBox<>();

        startTask = new Button("START TASK");
        finishTask = new Button("FINISH TASK");

        selectedTask = new Label();
        timeOfTask = new Label();
        timeOfCurrentTask = new Label();

    }

    public void display(Stage stage) {
        window = stage;
        window.setTitle("Time Manager");
        GridPane pane = new GridPane();
        VBox vbox = new VBox();
        vbox.getChildren().addAll(menuBar,pane);

        setGreedPane(pane);
        pane.getChildren().addAll(choiceBox, startTask, finishTask, timeOfTask, selectedTask, timeOfCurrentTask);
        Scene scene = new Scene(vbox, 210, 200);

        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }

    private void setGreedPane(GridPane pane) {
        pane.setPadding(new Insets(20, 20, 20, 20));
        pane.setVgap(20);
        pane.setHgap(20);

        GridPane.setConstraints(choiceBox, 0, 0);
        GridPane.setConstraints(menuBar, 0, 0);

        GridPane.setConstraints(startTask, 1, 0);
        GridPane.setConstraints(finishTask, 1, 1);

        GridPane.setConstraints(selectedTask, 0, 2);
        GridPane.setConstraints(timeOfTask, 1, 2);
        GridPane.setConstraints(timeOfCurrentTask, 1, 3);
    }

    public Stage getWindow() {
        return window;
    }

    public Label getSelectedTask() {
        return selectedTask;
    }

    public Label getTimeOfTask() {
        return timeOfTask;
    }

    public Label getTimeOfCurrentTask() {
        return timeOfCurrentTask;
    }

    public ChoiceBox<String> getChoiceBox() {
        return choiceBox;
    }

    public Button getStartTaskBtn() {
        return startTask;
    }

    public Button getFinishTaskBtn() {
        return finishTask;
    }


}
