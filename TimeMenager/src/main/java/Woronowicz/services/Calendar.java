package Woronowicz.services;

import Woronowicz.Models.Task;

import java.time.LocalDate;
import java.util.*;

public class Calendar {
    private Map<LocalDate,List<Task>> calendar;

    public Calendar(){ calendar = new HashMap<>();}

    public List<Task> getTasksFromDay(LocalDate date){
        return calendar.get(date);
    }

    public void addDay(){
        List<Task> list = new ArrayList<>();
        calendar.put(LocalDate.now(),list);
    }

    public boolean isDayEmpty(LocalDate date){
        return calendar.get(date).isEmpty();
    }
    public boolean isCalendarEmpty(){
        return calendar.isEmpty();
    }







}
