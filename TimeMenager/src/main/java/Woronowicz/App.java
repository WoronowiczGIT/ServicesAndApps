package Woronowicz;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class App extends Application {

    public static void main(String[] args) throws InterruptedException {launch(args); }
    private Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception {


        String programing = "Programing";
        String reading = "Reading";
        String tutorials = "Video Tutorials";
        String kata = "Kata";
        String games = "Games";
        // setup defaults
//        manager.addTask(programing);
//        manager.addTask(reading);
//        manager.addTask(tutorials);
//        manager.addTask(kata);
//        manager.addTask(games);
//        manager.selectTask(programing);
        //read from file / web
        window = primaryStage;
            window.setTitle("Time Manager");
        GridPane pane = new GridPane();
            pane.setPadding(new Insets(20,20,20,20));
            pane.setVgap(20);
            pane.setHgap(20);

        ChoiceBox<String> choiceBox = new ChoiceBox<>();
            GridPane.setConstraints(choiceBox,0,0);

//        for (String task: manager.getTasks()) {
//            choiceBox.getItems().add(task);
//        }choiceBox.setValue("Programing");

        Button startTask = new Button("START TASK");
            GridPane.setConstraints(startTask,1,0);
            startTask.setOnAction(e-> System.out.println("click"));

        Button finishTask = new Button("FINISH TASK");
            GridPane.setConstraints(finishTask,1,1);

        window.setOnCloseRequest(e->{ closeProgram(); });

        Label totalTimeLabel =  new Label("total time");

        Label totalTimeDisplay =  new Label();

        pane.getChildren().addAll(choiceBox,startTask,finishTask);
        Scene scene = new Scene(pane,300,300);
            window.setScene(scene);
            window.show();


    }
    private void closeProgram(){
        window.close();

    }






}
