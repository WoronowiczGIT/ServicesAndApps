package myTester.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
    private static Label footer;

    private static VBox vBox;
    private static HBox hBox;

    public void display(Stage primaryStage) {
    window = primaryStage;
        setPane();
        footer = new Label("https://github.com/WoronowiczGIT");
        selectFileLbl = new Label("Select File to Test: ");
        selectedFileLbl = new Label("<here show selected path to a file>");
        introduction = new Label("Program wygląda okropnie(jego kod również), ale działa! \n" +
                "Wystarczy wskazać plik do kompilacji i czekać wcisnąć test :-)\n" +
                "(Oczywiście istnieje opcja, że się wysypie zamiast pokazać błąd, \n" +
                "ale raczej powinien działać) ");

        testBtn = new Button("Test");
        testBtn.setAlignment(Pos.BASELINE_RIGHT);
        selectBtn = new Button("Select File");


        pane.getChildren().addAll(testBtn,selectedFileLbl,selectFileLbl,selectBtn);
        setChildrenPlacement();
        sethBox();
        setvBox();
        Scene scene = new Scene(vBox,400,200);
        window.setScene(scene);
        window.setResizable(false);
        window.setTitle("NCDC Tester");
        window.show();
    }
    public void setPane(){
        pane = new GridPane();
        pane.setPadding(new Insets(20,20,20,20));
        pane.setVgap(10);
        pane.setHgap(10);

    }
    public void setChildrenPlacement(){

        GridPane.setConstraints(selectBtn,0,1);
        GridPane.setConstraints(selectFileLbl,0,0);
        GridPane.setConstraints(selectedFileLbl,1,1);
    }

    public void sethBox(){
        hBox = new HBox();
        hBox.getChildren().addAll(selectBtn);
        hBox.getChildren().addAll(selectedFileLbl);
    }

    public void setvBox(){
        vBox = new VBox();

        vBox.getChildren().addAll(introduction);
       // vBox.getChildren().addAll(pane);
        //vBox.getChildren().addAll(selectFileLbl);
        vBox.getChildren().addAll(hBox);
        vBox.setSpacing(10);
        //vBox.setAlignment(Pos.CENTER);

        vBox.getChildren().addAll(testBtn);
        vBox.getChildren().addAll(footer);


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
