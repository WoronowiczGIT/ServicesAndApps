package Woronowicz;

import Woronowicz.Tests.Programs;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jdk.nashorn.internal.objects.Global;
import jdk.nashorn.internal.parser.JSONParser;
import jdk.nashorn.internal.runtime.Context;

import java.io.*;
import java.nio.file.Files;

public class TestWriter {
    private File testFile;

    public void setProgram(Programs program){
        testFile = new File("program.getName()");
    }

    public byte[] convertToByteArray(String string){
        return string.getBytes();
    }

    public void writeToFile(String line) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(testFile,true));


    }

    public static void main(String[] args) throws IOException {

        FileWriter fileWriter = new FileWriter("test.csv",true);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        String[] params = new String[]{"10","20","*   \n *  \n  * \n   *"};
        Gson gs = new Gson();

            gs.toJson(new test(params[0],params[1],params[2]),fileWriter);

            writer.close();


    }
    static class test{
        String param1;
        String param2;
        String result;

        test(String param1,String param2,String result){
            this.param1 = param1;
            this.param2 = param2;
            this.result = result;
        }
    }
}
