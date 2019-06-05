package Woronowicz.services;

import Woronowicz.Models.Task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TimeManager {
    private TaskRepository repository;

    public TimeManager(TaskRepository repository) {
        this.repository = repository;
    }

    public int timeDaily(int taskID, LocalDate day) {
        Task task = repository.getTask(taskID);
        if (task.equals(null)) return 0;
        int time = 0;
        for (LocalDateTime key : task.getIntervals().keySet()) {
            if (key.toLocalDate().equals(day)) {
                time += key.until(task.getIntervals().get(key), ChronoUnit.SECONDS);
            }
        }
        return time;
    }

    public int timeTotal(int taskID) {
        Task task = repository.getTask(taskID);
        if (task.equals(null)) return 0;
        int time = 0;
        for (LocalDateTime key : task.getIntervals().keySet()) {
            time += key.until(task.getIntervals().get(key), ChronoUnit.SECONDS);
        }
        return time;
    }


}
