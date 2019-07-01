package Woronowicz.controller;

import Woronowicz.App;
import Woronowicz.services.FtpConnection;
import Woronowicz.view.ConnectionBox;
import javafx.event.Event;
import javafx.event.EventHandler;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.List;

public class ConnectionBoxController {
    private static Logger logger = Logger.getLogger(App.class.getName());

    private ConnectionBox boxView;
    private FtpConnection connection;
    private File configFile;
    private String fileName = "connection.info";
    private String localPath = "./src/resources/";
    private List<String> data;

    ConnectionBoxController(FtpConnection connection, ConnectionBox boxView) {

        configFile = new File(localPath + fileName);
        this.connection = connection;
        this.boxView = boxView;

        boxView.getAddressField().setOnKeyTyped(changeAddress);
        boxView.getPortField().setOnKeyTyped(changePort);
        boxView.getUsernameField().setOnKeyTyped(changeUsername);
        boxView.getPasswordField().setOnKeyTyped(changePassword);

        boxView.getApplyBtn().setOnAction(applyChanges);

        readCurrentData();
    }
    public final void logINFO(String msg){
        logger.info(this.getClass().getSimpleName()+" "+msg);
    }

    public void readCurrentData() {
        data = connection.readData(configFile);
        if (connection.validateFroamt(data)) {
            logINFO("reading connection data from file data");
            boxView.getAddressField().setText(data.get(0));
            boxView.getPortField().setText(data.get(1));
            boxView.getUsernameField().setText(data.get(2));
            boxView.getPasswordField().setText(data.get(3));
        }
    }

    private EventHandler changeAddress = new EventHandler() {
        @Override
        public void handle(Event event) {
            String newAddress = boxView.getAddressField().getText();
            data.set(0, newAddress);
        }
    };

    private EventHandler changePort = new EventHandler() {
        @Override
        public void handle(Event event) {
            String newPort = boxView.getPortField().getText();
            data.set(1, newPort);
        }
    };

    private EventHandler changeUsername = new EventHandler() {
        @Override
        public void handle(Event event) {
            String newUsername = boxView.getUsernameField().getText();
            data.set(2, newUsername);
        }
    };

    private EventHandler changePassword = new EventHandler() {
        @Override
        public void handle(Event event) {
            String newPassword = boxView.getPasswordField().getText();
            data.set(3, newPassword);
        }
    };

    private EventHandler applyChanges = new EventHandler() {
        @Override
        public void handle(Event event) {
           connection.setupConnection(data);
            System.out.println("changes applied");
        }
    };

}

