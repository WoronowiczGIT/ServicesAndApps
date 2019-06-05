package Woronowicz.services;

import Woronowicz.Models.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TaskRepository {
    private int primaryKey;
    private Map<Integer,Task> availableTasks;

    public TaskRepository(int primaryKey, Map<Integer,Task> availableTasks){
        this.availableTasks = availableTasks;
        this.primaryKey = primaryKey;
    }
    public List<String> getTasknames(){
        List<String> names = new ArrayList<>();
        for (Task task: availableTasks.values()) {
            names.add(task.getName());
        }
        return names;
    }

    public Task getTask(int taskID){
        return availableTasks.get(taskID);
    }
    public void addTask(String name){
        if(isTaskNameDuped(name)) return;

        availableTasks.put(primaryKey,new Task(primaryKey,name));
        primaryKey++;
    }
    public void removeTask(int TaskID){
        availableTasks.remove(TaskID);
    }

    public int getTaskID(String name){
        for (Integer key: availableTasks.keySet()) {
            if(availableTasks
                    .get(key)
                    .getName()
                    .equalsIgnoreCase(name)){
                return key;
            }
        }
        return -1;
    }

    public void modifyTaskName(int TaskID, String newName){
        if(isTaskNameDuped(newName)) return;
        if(!availableTasks.containsKey(TaskID)) return;
        availableTasks.get(TaskID).setName(newName);
    }
    private boolean isTaskNameDuped(String name){
        for (Integer key: availableTasks.keySet()) {
            if(availableTasks
                    .get(key)
                    .getName()
                    .equalsIgnoreCase(name)){
                return true;
            }
        }
        return false;
    }




}
