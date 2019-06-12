package Woronowicz.Tests;

import Woronowicz.Tests.Patterns.KrolikPattern;
import Woronowicz.Tests.Patterns.WilkPattern;

import java.awt.*;
import java.io.*;

public class WilkTest implements Test {
    private File result = new File("WilkResults.txt");

    InputStream is;
    OutputStream os;
    BufferedReader reader;
    BufferedWriter writer;

    String messege;
    int i = 0;
    @Override
    public void runTest(File file) throws IOException {
        writer = new BufferedWriter(new FileWriter(result));

        String program = file.getName().replace(".class","");
        String start = "java";

        String[] params = new String[]{start,program};

        for (WilkPattern pattern: WilkPattern.values()) {
            messege = " passed";

            Process process = launch(file,params);
            is = process.getInputStream();
            os = process.getOutputStream();

            OutputStreamWriter osw = new OutputStreamWriter(os);
            for (int j = 0; j < pattern.getCsv().length; j++) {
                System.out.println(pattern.getCsv()[j]);
                osw.write(pattern.getCsv()[j]+"\n");
            }
            osw.close();

            reader = new BufferedReader(new InputStreamReader(is));

            reader.lines().forEach(line -> {
                System.out.println(line);
                if(!line.equals(pattern.getResult()[i])){
                    messege = " failed";

                }else i++;

            });
            i=0;
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
