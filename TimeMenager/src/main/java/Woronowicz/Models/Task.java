package Woronowicz.Models;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Task {
    private Integer id;
    private String name;
    private Map<LocalDateTime,Integer> interval;

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

    public Map<LocalDateTime, Integer> getDuration() {
        return interval;
    }

    public void addInterval(LocalDateTime start, Integer time){
        interval.put(start,time);
    }
}
