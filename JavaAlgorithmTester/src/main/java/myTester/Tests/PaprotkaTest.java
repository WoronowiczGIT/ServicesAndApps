package myTester.Tests;

import myTester.Tests.Patterns.PaprotkaPattern;

import java.io.*;

public class PaprotkaTest  implements Test {
    private File result = new File("paprotkaResults.txt");

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

        for (PaprotkaPattern pattern: PaprotkaPattern.values()) {
            messege = " passed";
            //sendParametersToFile(pattern);
            Process process = launch(file,params);
            is = process.getInputStream();
            os = process.getOutputStream();

            OutputStreamWriter osw = new OutputStreamWriter(os);
            osw.write(pattern.getFirstLine()+"\n");
            osw.write(pattern.getSecondLine()+"\n");
            osw.close();

            reader = new BufferedReader(new InputStreamReader(is));

            reader.lines().forEach(line -> {
                if(!line.equals(pattern.getResult()[i])){
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



