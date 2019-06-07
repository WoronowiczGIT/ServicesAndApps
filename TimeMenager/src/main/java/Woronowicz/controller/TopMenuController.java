package Woronowicz.controller;

import Woronowicz.view.ConnectionBox;
import Woronowicz.view.TopMenuView;
import javafx.event.Event;
import javafx.event.EventHandler;

public class TopMenuController {
    private TopMenuView menu;

    public TopMenuController(TopMenuView topMenu){
        menu = topMenu;
        menu.getConnection().setOnAction(connection);
        menu.getTasks().setOnAction(tasks);
        menu.getExit().setOnAction(exit);
    }

    private EventHandler connection = new EventHandler() {
        @Override
        public void handle(Event event) {
        ConnectionBox con = new ConnectionBox();
        con.display();
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
