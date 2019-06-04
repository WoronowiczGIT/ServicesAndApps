package Woronowicz.Models;

public class Task {
    private String name;
    private long timeSpentMinutes;

    public Task(String name) {
        this.name = name;
        timeSpentMinutes = 0;
    }

    public String getName() {
        return name;
    }

    public long getTime() {
        return timeSpentMinutes;
    }

    public void addTime(long seconds) {
        timeSpentMinutes += seconds;
    }
}
