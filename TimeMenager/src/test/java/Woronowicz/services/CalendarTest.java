package Woronowicz.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class CalendarTest {
    Calendar calendar;

    @Before
    public void setup() {
        calendar = new Calendar();
    }

    @Test
    public void getTasksFromDay() {
        calendar.addDay();
        Assert.assertTrue(calendar.getTasksFromDay(LocalDate.now()).isEmpty());
    }

    @Test
    public void addDay() {
    }

    @Test
    public void isDayEmpty() {
        calendar.addDay();
        Assert.assertTrue(calendar.isDayEmpty(LocalDate.now()));
    }

    @Test
    public void isCalendarEmpty() {
        Assert.assertTrue(calendar.isCalendarEmpty());
    }
}