package Woronowicz;

import Woronowicz.Tests.Test;
import Woronowicz.Tests.TestSelector;

import javax.naming.NameNotFoundException;
import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

public class TestRunner {
    private Pattern javaPattern;
    private Compiler compiler;
    private TestSelector selector;
    private ResultDisplay display;

    public TestRunner() {
        javaPattern = Pattern.compile("^\\w*\\.java$");
        compiler = new Compiler();
        display = new ResultDisplay();
        selector = new TestSelector();
    }

    public void run(File file) throws IOException, InterruptedException, NameNotFoundException {
        String path = file.getAbsolutePath();
        String name = file.getName();
        System.out.println(validateInput(name));
        System.out.println(path + "\n" + name);
        System.out.println(file.getParent());
        if (!validateInput(name)) return;

        if (!compiler.compile(file)) return;
        File compiledFile = compiler.getCompiledFile();

        Test myTest = selector.SelectTest(compiledFile);

        myTest.runTest(compiledFile);
        myTest.displayScore(myTest.getResult());
        // display
        // clean
    }

    private boolean validateInput(String name) {
        return javaPattern.matcher(name).matches();
    }
}
