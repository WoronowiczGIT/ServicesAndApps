package Woronowicz.Tests;

import java.io.*;


public interface Test {
    void runTest(File file) throws IOException;

    default InputStream launch(File file,String[] parameters) throws IOException {
        Process process = new ProcessBuilder()
                .command(parameters)
                .directory(new File(file.getParent()))
                .start();

        return process.getInputStream();
    }
}
