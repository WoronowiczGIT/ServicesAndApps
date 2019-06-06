package Woronowicz.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

public class TaskManagerTest {
    TaskManager manager;
    TaskRepository repository;

    @Before
    public void setup() {
        repository = new TaskRepository(0, new HashMap<>());
        repository.addTask("task1");
        repository.addTask("task2");
        manager = new TaskManager(repository);
    }

    @Test
    public void selectTask() {
        int id = 1;
        manager.selectTask(id);
        Assert.assertEquals(manager.getSelectedTask(), repository.getTask(id));
    }

    @Test
    public void updateTask() throws InterruptedException {
        manager.selectTask(0);
        int intervals = 5;
        for (int i = 0; i < intervals; i++) {

            manager.startTask();
            Thread.sleep(100);
            manager.finishTask();
            manager.updateTask();

        }
        Assert.assertEquals(intervals, manager.getSelectedTask().getDuration().keySet().size());

        Assert.assertFalse(repository.getTask(0).getDuration().keySet().isEmpty());

    }


}