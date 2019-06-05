package Woronowicz.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

public class TaskRepositoryTest {
    TaskRepository taskRepository;
    @Before
    public void setup(){
        taskRepository = new TaskRepository(0,new HashMap<>());
    }

    @Test
    public void getTask() {
        String name = "task";
        taskRepository.addTask(name);
        Assert.assertEquals(taskRepository.getTask(0).getName(),name);
    }

    @Test
    public void addTask() {
        String name = "task";
        taskRepository.addTask(name);
        Assert.assertEquals(taskRepository.getTask(0).getName(),name);
        taskRepository.addTask(name);
        Assert.assertNull(taskRepository.getTask(1));
    }

    @Test
    public void removeTask() {
        String name = "task";
        taskRepository.addTask(name);
        taskRepository.removeTask(0);
        Assert.assertNull(taskRepository.getTask(0));
    }

    @Test
    public void getTaskID() {
        String name = "task";
        taskRepository.addTask(name);
        Assert.assertEquals(taskRepository.getTaskID(name),0);

    }

    @Test
    public void modifyTaskName() {
        String oldName = "task";
        String newName = "newTask";
        taskRepository.addTask(oldName);
        taskRepository.modifyTaskName(0,newName);
        Assert.assertEquals(taskRepository.getTaskID(newName),0);
        Assert.assertEquals(taskRepository.getTaskID(oldName),-1);
    }
}