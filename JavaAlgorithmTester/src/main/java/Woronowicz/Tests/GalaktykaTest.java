package Woronowicz.Tests;

import Woronowicz.Tests.Patterns.GalaktykaPattern;

import java.io.*;

public class GalaktykaTest implements Test {
    private File result = new File("GalaktykaWyniki.txt");
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
        String[] params = new String[]{start, program,""};

        for (GalaktykaPattern pattern: GalaktykaPattern.values()) {
            params[2] = pattern.getInput();

            is = launch(file,params).getInputStream();
            reader = new BufferedReader(new InputStreamReader(is));

            messege = " passed";
            reader.lines().forEach(line -> {
                try {
                    if(!line.equals(pattern.getResult()[i])){
                        messege = " failed";
                    }
                }catch (ArrayIndexOutOfBoundsException e){
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
