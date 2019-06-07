package Woronowicz.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConnectionBox {
    private Stage window;
    private Scene scene;
    private GridPane pane;

    private TextField addressField;
    private TextField portField;
    private TextField usernameField;
    private TextField passwordField;
    private CheckBox rememberMeCheckBox;
    private Button applyBtn;

    private Label addressLabel;
    private Label portLabel;
    private Label usernameLabel;
    private Label passwordLabel;

    public ConnectionBox() {
        window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Connection");
        pane = new GridPane();
        scene = new Scene(pane, 300, 250);
    }

    public void display() {
        addressField = new TextField();
        addressLabel = new Label("Server adress: ");

        portField = new TextField();
        portLabel = new Label("Port number: ");

        usernameField = new TextField();
        usernameLabel = new Label("Username: ");

        passwordField = new TextField();
        passwordLabel = new Label("Password: ");

        rememberMeCheckBox = new CheckBox("Remember me");

        applyBtn = new Button("Apply");

        pane.getChildren().addAll(addressField,addressLabel,portField,portLabel,usernameField,usernameLabel,passwordField,passwordLabel,rememberMeCheckBox,applyBtn);
        pane.setPadding(new Insets(20,20,20,20));
        pane.setVgap(20);
        pane.setHgap(20);

        setupGridPane();
        window.setResizable(false);
        window.setScene(scene);
        window.showAndWait();
    }

    private void setupGridPane() {
        GridPane.setConstraints(addressLabel,0,1);
        GridPane.setConstraints(addressField,1,1);

        GridPane.setConstraints(portLabel,0,2);
        GridPane.setConstraints(portField,1,2);

        GridPane.setConstraints(usernameLabel,0,3);
        GridPane.setConstraints(usernameField,1,3);

        GridPane.setConstraints(passwordLabel,0,4);
        GridPane.setConstraints(passwordField,1,4);

        GridPane.setConstraints(applyBtn,0,5);
        GridPane.setConstraints(rememberMeCheckBox,1,5);

    }

    public TextField getAddressField() {
        return addressField;
    }

    public TextField getPortField() {
        return portField;
    }

    public TextField getUsernameField() {
        return usernameField;
    }

    public TextField getPasswordField() {
        return passwordField;
    }

    public CheckBox getRememberMeCheckBox() {
        return rememberMeCheckBox;
    }

    public Button getApplyBtn() {
        return applyBtn;
    }
}
