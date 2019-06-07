package Woronowicz.controller;

import Woronowicz.services.FtpConnection;
import Woronowicz.view.ConnectionBox;
import Woronowicz.view.TopMenuView;
import javafx.event.Event;
import javafx.event.EventHandler;

public class TopMenuController {
    private TopMenuView menu;
    private FtpConnection ftpConnection;

    public TopMenuController(TopMenuView topMenu, FtpConnection ftpConnection){
        menu = topMenu;
        this.ftpConnection = ftpConnection;
        menu.getConnection().setOnAction(connectionMenu);
        menu.getTasks().setOnAction(tasks);
        menu.getExit().setOnAction(exit);
    }

    private EventHandler connectionMenu = new EventHandler() {
        @Override
        public void handle(Event event) {
        ConnectionBox cv = new ConnectionBox();
        new ConnectionBoxController(ftpConnection,cv);
        cv.display();

        }
    };

    private EventHandler tasks = new EventHandler() {
        @Override
        public void handle(Event event) {

        }
    };

    private EventHandler exit = new EventHandler() {
        @Override
        public void handle(Event event) {

        }
    };


}
