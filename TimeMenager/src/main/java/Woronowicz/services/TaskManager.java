package Woronowicz.services;

import Woronowicz.Models.Task;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TaskManager {
    private TaskRepository repository;
    private Task taskSelected;
    private Clock clock;

    public TaskManager(TaskRepository repository){
        this.repository = repository;
        this.clock = new Clock();
    }
    public void selectTask(int id){
        Task newTask = repository.getTask(id);
        if(newTask != null && !clock.isClockTicking()){
            taskSelected = newTask;}
    }
    public Task getSelectedTask(){
        return taskSelected;
    }

    public void startTask(){
        if(clock.isClockTicking()) return;
        clock.start();
    }
    public void finishTask(){
        if(!clock.isClockTicking()) return;
        clock.finish();
    }

    public void updateTask(){
        int id = taskSelected.getId();
        LocalDateTime start = clock.getTaskStarted();
        LocalDateTime end = clock.getTaskEnded();

        long time = start.until(end, ChronoUnit.SECONDS);
        repository.getTask(id).addInterval(start,(int)time);
    }

    public boolean isTaskOnGoing(){
        return clock.isClockTicking();
    }


}
