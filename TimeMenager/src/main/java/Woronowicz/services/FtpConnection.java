package Woronowicz.services;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FtpConnection {
    private File configFile;
    private String fileName = "connection.info";
    private String localPath = "./src/resources/";
    private String ftpAddress;
    private int port;
    private String userName;
    private String password;
    private FTPClient client;

    public FtpConnection(){
        this.configFile = new File(localPath+fileName);
        List<String> data = readData(configFile);
        setupConnection(data);
    }
    public List<String> readData(File file){
        List<String> info = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            reader.lines().forEach(line -> {
                String[] data = line.split(": ");
                info.add(data[1]);
            });

        }catch (FileNotFoundException e){
            System.out.println("file not found");
        }
        return info;
    }
    public boolean validateFroamt(List<String> info){
       return info.size() == 4;
    }

    public boolean setupConnection(List<String> info){
        if(!validateFroamt(info)) return false;

        try {
            ftpAddress = info.get(0);
            port = Integer.parseInt(info.get(1));
            userName = info.get(2);
            password = info.get(3);
        }catch (NumberFormatException e){
            System.out.println("incorrect connection data");
            return false;
        }
        System.out.println("connection setup");
        return true;

    }

    public void connect(){
        client = new FTPClient();
        try {
            client.connect(ftpAddress, port);
            client.login(userName, password);
            client.enterLocalPassiveMode();
            client.setFileType(FTP.BINARY_FILE_TYPE);
        }catch (IOException e){
            System.out.println("connection failed");
        }
        System.out.println("connected to server");
    }
    public void disconnect(){
        try {
            if (client.isConnected()) {
                client.logout();
                client.disconnect();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("disconnected from server");
    }

    public FTPClient getClient(){
        return this.client;
    }

    public void setFtpAddress(String ftpAddress) {
        this.ftpAddress = ftpAddress;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
