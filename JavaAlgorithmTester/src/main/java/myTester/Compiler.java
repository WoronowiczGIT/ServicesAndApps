package myTester;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Compiler {
    private File compiledFile;

    public boolean compile(File file) throws IOException, InterruptedException {
        System.out.println("compiler running");

        File dir = new File(file.getParent());

        ProcessBuilder pb = new ProcessBuilder()
                .command(Arrays.asList("javac",file.getName()))
                .directory(dir);

        Process proc = pb.start();
        System.out.println("compiled successful " + proc.isAlive());
        proc.waitFor();
        String newFile = file.getAbsolutePath().replace(".java",".class");
        compiledFile = new File(newFile);

        return compiledFile != null;
    }

    public File getCompiledFile(){
        return compiledFile;
    }
    private static void pBuilderDirectory() throws IOException, InterruptedException {

    }
}
