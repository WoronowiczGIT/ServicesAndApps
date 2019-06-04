package Woronowicz.services;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Clock {
     private LocalDateTime taskStarted;
     private LocalDateTime taskEnded;
     private long duration;

    public long getDuration(){
        duration = ChronoUnit.SECONDS.between(taskStarted,taskEnded);
        if(duration < 0) return 0;
        return duration;
    }

    public void start() {
        taskStarted = LocalDateTime.now();
    }

    public void finish() {
        taskEnded = LocalDateTime.now();
    }


}
