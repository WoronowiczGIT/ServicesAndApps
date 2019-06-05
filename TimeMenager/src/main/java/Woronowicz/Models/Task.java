package Woronowicz.Models;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Task {
    private Integer id;
    private String name;
    private Map<LocalDateTime,LocalDateTime> interval;

    public Task(Integer id, String name){
        interval = new HashMap<>();
        this.name = name;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public Map<LocalDateTime, LocalDateTime> getIntervals() {
        return interval;
    }

    public void addInterval(LocalDateTime start, LocalDateTime finish){
        interval.put(start,finish);
    }
}
