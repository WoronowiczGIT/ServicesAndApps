package Woronowicz.view;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

public class TopMenuView {
    private Menu mainMenu;
    private MenuBar menuBar;
    private MenuItem connection;
    private MenuItem tasks;
    private MenuItem exit;
    private SeparatorMenuItem separator;

    public TopMenuView(){
        mainMenu = new Menu("_Menu");
        menuBar = new MenuBar();
        separator = new SeparatorMenuItem();
        setup();
    }

    public void setup(){
        connection = new MenuItem("_Connection...");
        tasks = new MenuItem("_Tasks...");
        exit = new MenuItem("E_xit");
        mainMenu.getItems().addAll(connection,tasks,separator,exit);
        menuBar.getMenus().addAll(mainMenu);
    }

    public MenuBar getMenuBar() {
        return menuBar;
    }

    public MenuItem getConnection() {
        return connection;
    }

    public MenuItem getTasks() {
        return tasks;
    }

    public MenuItem getExit() {
        return exit;
    }
}
