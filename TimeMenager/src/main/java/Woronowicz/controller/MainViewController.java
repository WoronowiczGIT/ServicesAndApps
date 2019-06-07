package Woronowicz.controller;

import Woronowicz.services.*;
import Woronowicz.view.MainView;
import javafx.event.Event;
import javafx.event.EventHandler;

import java.io.IOException;


public class MainViewController {
    private static MainView view;
    private static Loader loader;
    private static TaskRepository taskRepository;
    private static TimeManager timeManager;
    private static TaskManager taskManager;

    static int seconds = 0;

    public MainViewController(TaskManager taskManager, TimeManager timeManager, TaskRepository taskRepository, Loader loader, MainView view) throws IOException {
        this.view = view;

        this.loader = loader;
        this.taskRepository = taskRepository;
        this.timeManager = timeManager;
        this.taskManager = taskManager;

        this.view.getStartTaskBtn().setOnAction(starTaskClicked);
        this.view.getFinishTaskBtn().setOnAction(finishTask);
        this.view.getChoiceBox().setOnAction(handleSelection);
        this.view.getWindow().setOnCloseRequest(closeProgram);

        setChoiceBox();
    }

    private EventHandler starTaskClicked = new EventHandler() {
        @Override
        public void handle(Event event) {
            seconds = 0;
            view.getChoiceBox().setDisable(true);
            taskManager.startTask();
            view.getStartTaskBtn().setDisable(true);
            view.getFinishTaskBtn().setDisable(false);
        }
    };

    private EventHandler closeProgram = new EventHandler() {
        @Override
        public void handle(Event event) {
            view.getWindow().close();
            if (taskManager.isTaskOnGoing()) {
                taskManager.finishTask();
                taskManager.updateTask();
            }
            try {
                loader.saveRemote();
            } catch (IOException e) {
                System.out.println("failed to saveRemote");
            }

        }
    };
    private EventHandler finishTask = new EventHandler() {
        @Override
        public void handle(Event event) {
            if (taskManager.isTaskOnGoing()) {

                taskManager.finishTask();
                taskManager.updateTask();

                view.getChoiceBox().setDisable(false);
                view.getStartTaskBtn().setDisable(false);
                view.getFinishTaskBtn().setDisable(true);

                updateTimeLabel();
            }

            try {
                loader.saveLocal();
            } catch (IOException e) {
                System.out.println("failed to saveLocal");
            }
        }
    };

    private EventHandler handleSelection = new EventHandler() {
        @Override
        public void handle(Event event) {
            String value = view.getChoiceBox().getValue();
            int id = taskRepository.getTaskID(value);
            if (id == -1) return;
            taskManager.selectTask(id);

            updateTimeLabel();
            updateSelectionLabel();

            System.out.println(taskManager.getSelectedTask().getName() + " got selected");
        }
    };

    private void setChoiceBox() {
        if (taskRepository.getTasknames().isEmpty()) return;
        view.getChoiceBox().getItems().addAll(taskRepository.getTasknames());
        view.getChoiceBox().setValue(taskManager.getSelectedTask().getName());
    }

    private void updateTimeLabel() {
        view.getTimeOfTask().setText(timeManager.timeTotal(taskManager.getSelectedTask().getId()) + " seconds");
    }

    private void updateSelectionLabel() {
        view.getSelectedTask().setText("total time for: \n"
                + taskManager.getSelectedTask().getName());
    }




}
