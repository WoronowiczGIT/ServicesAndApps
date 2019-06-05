package Woronowicz.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashMap;

import static org.junit.Assert.*;

public class TimeManagerTest {
    TimeManager timeManager;
    TaskRepository repository;
    TaskManager taskManager;

    @Before
    public void setup() throws InterruptedException {
        repository = new TaskRepository(0,new HashMap<>());
        repository.addTask("dummie");
        taskManager = new TaskManager(repository);
        timeManager = new TimeManager(repository);

        taskManager.selectTask(0);
        taskManager.startTask();
        Thread.sleep(2000);
        taskManager.finishTask();
        taskManager.updateTask();
    }

    @Test
    public void timeDaily() {
       int time = timeManager.timeDaily(0, LocalDate.now());
        Assert.assertTrue(time > 1);
    }

    @Test
    public void timeTotal() {
        int time = timeManager.timeTotal(0);
        Assert.assertTrue(time > 1);
    }
}