package Woronowicz.Tests;

import java.awt.*;
import java.io.*;


public interface Test {
    void runTest(File file) throws IOException;
    File getResult();

    default Process launch(File file,String[] parameters) throws IOException {
        Process process = new ProcessBuilder()
                .command(parameters)
                .directory(new File(file.getParent()))
                .start();

        return process;
    }

    default void displayScore(File result) throws IOException {
        if(Desktop.isDesktopSupported()){
            Desktop.getDesktop().open(result);
        }
    }


}
