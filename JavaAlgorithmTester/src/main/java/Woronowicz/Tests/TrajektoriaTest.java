package Woronowicz.Tests;

import Woronowicz.Tests.Patterns.TrajektoriaPattern;

import java.io.*;

public class TrajektoriaTest  implements Test {
    private File result = new File("TrajektoriaWyniki.txt");
    InputStream is;
    BufferedReader reader;
    BufferedWriter writer;
    String messege;

    int i = 0;
    @Override
    public void runTest(File file) throws IOException {
        writer = new BufferedWriter(new FileWriter(result));

        String program = file.getName().replace(".class","");
        String start = "java";
        String[] params = new String[]{start, program,"",""};

        for (TrajektoriaPattern pattern: TrajektoriaPattern.values()) {
            params[2] = pattern.getAmp();
            params[3] = pattern.getLength();

            is = launch(file,params).getInputStream();
            reader = new BufferedReader(new InputStreamReader(is));


            messege = " passed";
            reader.lines().forEach(line -> {
                if(!line.equals(pattern.getPattern()[i])){
                    messege = " failed";
                }
                i++;
            });
            i = 0;
            writer.write(pattern.name() + messege);
            writer.newLine();
        }
        writer.close();
    }

    @Override
    public File getResult() {
        return result;
    }
}
