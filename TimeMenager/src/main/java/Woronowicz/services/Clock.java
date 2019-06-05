package Woronowicz.services;

import java.time.LocalDateTime;

public class Clock {
    private LocalDateTime taskStarted;
    private LocalDateTime taskEnded;
    private boolean isTicking;

    public Clock() {
        isTicking = false;
    }

    public void start() {
        if(isTicking) return;
        isTicking = true;
        taskStarted = LocalDateTime.now();
    }

    public void finish() {
        if(!isTicking) return;
        isTicking = false;
        taskEnded = LocalDateTime.now();
    }

    public boolean isClockTicking(){
        return isTicking;
    }
    public LocalDateTime getTaskStarted(){
        return taskStarted;
    }
    public LocalDateTime getTaskEnded(){
        return taskEnded;
    }


}
