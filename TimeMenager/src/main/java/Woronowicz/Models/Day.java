package Woronowicz.Models;

import java.time.LocalDate;

import java.util.ArrayList;

import java.util.List;


public class Day {
    private LocalDate today;
    private List<Task> tasks;

    public Day(){
        today = LocalDate.now();
        tasks = new ArrayList<>();
    }
    public LocalDate getDate(){
        return today;
    }
    public List<Task> getTasks(){
        return tasks;
    }

    public Task getTask(String name){
        for (Task task: tasks) {
            if(task.getName().equals(name)){
                return task;
            }
        }
        return null;
    }

    public void addTask(String name){
        for (Task task: tasks) {
            if(task.getName().equals(name)){
                return;
            }
        }
        tasks.add(new Task(name));
    }


}
