package Woronowicz.Tests;

import javax.naming.NameNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestSelector {
    private File compiledFile;
    private List<Programs> availablePrograms;

    public TestSelector(){
        System.out.println(Programs.values());
        availablePrograms = new ArrayList<>();
        availablePrograms.addAll(Arrays.asList(Programs.values()));
    }
    public Test SelectTest(File compiledFile) throws NameNotFoundException {
        this.compiledFile = compiledFile;
        String name = compiledFile.getName().replace(".class","");
        for (Programs program: availablePrograms) {
            if(program.getName().equals(name)){
                return program.getTest();
            }
        }
        throw new NameNotFoundException();
    }

}
