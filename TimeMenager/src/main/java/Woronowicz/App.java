package Woronowicz;

import Woronowicz.controller.MainViewController;
import Woronowicz.controller.TopMenuController;
import Woronowicz.services.*;
import Woronowicz.view.MainView;
import Woronowicz.view.TopMenuView;
import javafx.application.Application;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.HashMap;

public class App extends Application {

    private static FtpConnection connection;
    private static Loader loader;
    private static TaskRepository taskRepository;
    private static TimeManager timeManager;
    private static TaskManager taskManager;


    static MainView view;
    static MainViewController MVController;
    static TopMenuController TMController;

    public static void main(String[] args) throws InterruptedException, IOException {

        taskRepository = new TaskRepository(0, new HashMap<>());
        connection = new FtpConnection();
        loader = new Loader(taskRepository, connection);

        taskManager = new TaskManager(taskRepository);
        taskManager.selectTask(0);
        timeManager = new TimeManager(taskRepository);

        TopMenuView topMenuView = new TopMenuView();
        TMController = new TopMenuController(topMenuView,connection);

        view = new MainView(topMenuView.getMenuBar());
        launch(args);
    }



    @Override
    public void start(Stage primaryStage){
        view.display(primaryStage);
        MVController = new MainViewController(taskManager,timeManager,taskRepository,loader,view);
    }
}
