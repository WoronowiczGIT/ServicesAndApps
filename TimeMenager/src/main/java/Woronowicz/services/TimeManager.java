package Woronowicz.services;

import Woronowicz.Models.Task;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TimeManager {
    private TaskRepository repository;

    public TimeManager(TaskRepository repository) {
        this.repository = repository;
    }

    public int timeDaily(int taskID, LocalDate day) {
        Task task = repository.getTask(taskID);
        if (task.equals(null)) return 0;

        int time = 0;
        for (LocalDateTime key : task.getDuration().keySet()) {
            if (key.toLocalDate().equals(day)) {
                time += task.getDuration().get(key);
            }
        }
        return time;
    }

    public int timeTotal(int taskID) {
        Task task = repository.getTask(taskID);
        if (task.equals(null)) return 0;
        int time = 0;
        for (LocalDateTime key : task.getDuration().keySet()) {
            time += task.getDuration().get(key);
        }
        return time;
    }


}
