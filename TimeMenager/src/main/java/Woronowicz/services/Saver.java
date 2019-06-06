package Woronowicz.services;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class Saver {
    private FtpConnection connection;
    private TaskRepository repository;
    private File logs = new File("./src/resources/logs.csv");
    private String remoteFile = "/logs.csv";
    private String pattern = "yyyy-MM-dd HH:mm:ss";
    private static int currentID;
    private DateTimeFormatter formatter;

    public Saver(TaskRepository repository, FtpConnection connection) throws IOException {
        this.formatter = DateTimeFormatter.ofPattern(pattern);
        this.repository = repository;
        this.connection = connection;
        load();
    }
    public void load() throws IOException {
        connection.connect();

        if(connection.getClient().isConnected()){
            System.out.println("remote available");
            downloadLogs();
            connection.disconnect();
        }
        loadLocal();
    }

    public void loadLocal() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(logs));

        reader.lines().forEach(line -> {
            if(line.length() < 30){
                repository.addTask(line);
                currentID = repository.getTaskID(line);
            }else {
                String[] fields = line.split(",");
                LocalDateTime start = LocalDateTime.parse(fields[0], formatter);
                int time = Integer.parseInt(fields[1]);
                repository
                        .getTask(currentID)
                        .addInterval(start,time);
            }
        });
        System.out.println("loaded successful");
    }

    public void downloadLogs() throws IOException {
        try{
        String remoteFile = this.remoteFile;
        File downloadedFile = logs;
        OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(downloadedFile));
        boolean success = connection.getClient().retrieveFile(remoteFile, outputStream);
        outputStream.close();

        if (success) {
            System.out.println("File #1 has been downloaded successfully.");
        }}catch(FileNotFoundException e){
            System.out.println("no remote log file");
        }
    }

    public void saveRemote() throws IOException {
        saveLocal();
        connection.connect();
        if(connection.getClient().isConnected()){
            sendToServer();
            connection.disconnect();
        }
    }

    public void sendToServer() throws IOException {
        File firstLocalFile = logs;

        String firstRemoteFile = "logs.csv";
        InputStream inputStream = new FileInputStream(firstLocalFile);

        System.out.println("Start uploading logs");
        boolean done = connection.getClient().storeFile(firstRemoteFile, inputStream);
        inputStream.close();
        if (done) {
            System.out.println("logs uploaded successfully.");
        }
    }

    public void saveLocal() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(logs));

        for (String name : repository.getTasknames()) {
            writer.write(name+"\n");
            int id = repository.getTaskID(name);
            Set<LocalDateTime> dates = repository.getTask(id).getDuration().keySet();

            for (LocalDateTime date: dates) {
                writer.write(formatter.format(date)+",");
                writer.write(String.valueOf(repository.getTask(id).getDuration().get(date))+"\n");
            }
        }
        writer.close();
        System.out.println("saved successful");
    }


}
