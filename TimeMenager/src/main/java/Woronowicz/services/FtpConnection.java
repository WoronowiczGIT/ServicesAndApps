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

    public FtpConnection() throws FileNotFoundException {
        this.configFile = new File(localPath+fileName);
        connectionSetup();
    }

    public void connectionSetup() throws FileNotFoundException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(configFile));
            List<String> info = new ArrayList<>();

            reader.lines().forEach(line -> {
                String[] data = line.split(": ");
                info.add(data[1]);
            });
            if (info.size() < 4) {
                System.out.println("incorrect info");
                return;
            }
            ftpAddress = info.get(0);
            port = Integer.parseInt(info.get(1));
            userName = info.get(2);
            password = info.get(3);
        }catch (FileNotFoundException e){
            System.out.println("failed to read connection file");
        }
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
    }

    public FTPClient getClient(){
        return this.client;
    }
}
