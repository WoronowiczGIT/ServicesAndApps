package Woronowicz.services;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class Saver {
    private TaskRepository repository;
    private File state = new File("./src/resources/logs.csv");
    private String pattern = "yyyy-MM-dd HH:mm:ss";
    private static int currentID;
    private DateTimeFormatter formatter;

    public Saver(TaskRepository repository) throws IOException {
        this.formatter = DateTimeFormatter.ofPattern(pattern);
        this.repository = repository;
        loadState();
    }

    public void saveState() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(state));

        for (String name : repository.getTasknames()) {
            writer.write(name+"\n");
            int id = repository.getTaskID(name);
            Set<LocalDateTime> dates = repository.getTask(id).getIntervals().keySet();

            for (LocalDateTime date: dates) {
                writer.write(formatter.format(date)+",");
                writer.write(formatter.format(repository.getTask(id).getIntervals().get(date))+"\n");
            }
        }
        writer.close();
        System.out.println("saved successful");
    }

    public void loadState() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(state));

        reader.lines().forEach(line -> {
            if(line.length() < 30){
                repository.addTask(line);
                currentID = repository.getTaskID(line);
            }else {
                String[] dates = line.split(",");
                LocalDateTime start = LocalDateTime.parse(dates[0], formatter);
                LocalDateTime finish = LocalDateTime.parse(dates[1], formatter);
                repository
                        .getTask(currentID)
                        .addInterval(start,finish);
            }
        });
        System.out.println("loaded successful");
    }
}
