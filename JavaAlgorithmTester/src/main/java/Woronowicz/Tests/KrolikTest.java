package Woronowicz.Tests;

import Woronowicz.Tests.Patterns.KrolikPattern;

import java.io.*;

public class KrolikTest  implements Test{
    private File result = new File("KrolikResults.txt");

    InputStream is;
    OutputStream os;
    BufferedReader reader;
    BufferedWriter writer;

    String messege;

    @Override
    public void runTest(File file) throws IOException {
        writer = new BufferedWriter(new FileWriter(result));

        String program = file.getName().replace(".class","");
        String start = "java";
        String name = "";
        String[] params = new String[]{start,program,name};

        for (KrolikPattern pattern: KrolikPattern.values()) {
            messege = " passed";
            params[2] = pattern.getName();
            Process process = launch(file,params);
            is = process.getInputStream();
            os = process.getOutputStream();

            OutputStreamWriter osw = new OutputStreamWriter(os);
            for (int j = 0; j < pattern.getCsv().length; j++) {
                osw.write(pattern.getCsv()[j]+"\n");

            }
            osw.close();

            reader = new BufferedReader(new InputStreamReader(is));

            reader.lines().forEach(line -> {
                System.out.println(line);
                if(!line.equals(pattern.getResult())){
                    messege = " failed";
                }
            });
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
