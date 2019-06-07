package Woronowicz.controller;

import Woronowicz.services.FtpConnection;

import java.io.File;

public class ConnectionBoxController {
    private FtpConnection connection;
    private File configFile;
    private String fileName = "connection.info";
    private String localPath = "./src/resources/";

    ConnectionBoxController(FtpConnection connection){
        this.connection = connection;
    }



}
