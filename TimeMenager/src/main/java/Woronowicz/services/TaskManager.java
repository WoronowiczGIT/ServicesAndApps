package Woronowicz.services;

import Woronowicz.Models.Task;

import java.time.LocalDateTime;

public class TaskManager {
    private TaskRepository repository;
    private Task taskSelected;
    private Clock clock;

    TaskManager(TaskRepository repository){
        this.repository = repository;
        this.clock = new Clock();
    }
    public void selectTask(int id){
        Task newTask = repository.getTask(id);
        if(newTask != null){
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
        repository.getTask(id).addInterval(start,end);
    }


}
