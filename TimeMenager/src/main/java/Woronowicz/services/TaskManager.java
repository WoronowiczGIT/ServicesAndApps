package Woronowicz.services;

import Woronowicz.Models.Task;

import java.time.LocalDate;
import java.util.List;

public class TaskManager {

    private Calendar calendar;
    private Clock clock;
    private boolean ongoingTask;
    private Task selectedTask;

    public TaskManager() {
        clock = new Clock();
        calendar = new Calendar();
        selectedTask = new Task("placeholderTask");
        ongoingTask = false;
    }
    public void selectTask(Task task){
        selectedTask = task;
    }

    public void startTask(){
        if(ongoingTask) return;
        ongoingTask = true;
        clock.start();
    }
    public void endTask() {
        if (!ongoingTask) return;
        clock.finish();
        ongoingTask = false;
    }
    public void updateTask(){
        List<Task> tasks = calendar.getTasksFromDay(LocalDate.now());
        long time = clock.getDuration();
        if(calendar.isCalendarEmpty()) calendar.addDay();

        for (int i = 0; i < tasks.size(); i++) {
            if(tasks.get(i) == selectedTask){
                tasks.get(i).addTime(time);
                return;
            }
        }
        selectedTask.addTime(time);
        calendar.getTasksFromDay(LocalDate.now()).add(selectedTask);
    }

}
