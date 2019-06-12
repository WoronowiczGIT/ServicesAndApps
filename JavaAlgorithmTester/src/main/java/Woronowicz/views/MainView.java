package Woronowicz.views;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import javafx.stage.Stage;




public class MainView {
    public static Stage getWindow() {
        return window;
    }

    private static Stage window;
    private static GridPane pane;
    private static Button testBtn;
    private static Button selectBtn;
    private static Label selectFileLbl;
    private static Label selectedFileLbl;
    private static Label introduction;


    public void display(Stage primaryStage) {
    window = primaryStage;
        setPane();

        selectFileLbl = new Label("Select File to Test: ");
        selectedFileLbl = new Label("<here show selected path to a file>");
        introduction = new Label("Select file you want to Test: ");

        testBtn = new Button("Test");
        selectBtn = new Button("Select File");

        pane.getChildren().addAll(testBtn,selectedFileLbl,selectFileLbl,selectBtn,introduction);
        setChildrenPlacement();
        Scene scene = new Scene(pane,400,400);
        window.setScene(scene);
        window.setTitle("NCDC Tester");
        window.show();
    }
    public void setPane(){
        pane = new GridPane();
        pane.setPadding(new Insets(20,20,20,20));
        pane.setVgap(20);
        pane.setHgap(20);
        pane.setMinHeight(400);
        pane.setMinWidth(400);
    }
    public void setChildrenPlacement(){
        GridPane.setConstraints(testBtn,1,1);
        GridPane.setConstraints(selectBtn,1,0);
        GridPane.setConstraints(selectFileLbl,0,1);
        GridPane.setConstraints(selectedFileLbl,0,2);
        GridPane.setConstraints(introduction,0,0);
    }

    public  Button getTestBtn() {
        return testBtn;
    }

    public  Button getSelectBtn() {
        return selectBtn;
    }

    public  Label getSelectFileLbl() {
        return selectFileLbl;
    }

    public  Label getSelectedFileLbl() {
        return selectedFileLbl;
    }
}
