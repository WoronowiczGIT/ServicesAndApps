package Woronowicz.Tests;

import java.io.*;

public class TrajektoriaTest  implements Test {
    private File result = new File("result.txt");

    @Override
    public void runTest(File file) throws IOException {
        String call = file.getName().replace(".class","");
        String[] params = new String[]{"java", call,"10","50"};
        InputStream is = launch(file,params);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        BufferedWriter writer = new BufferedWriter(new FileWriter(result));

        reader.lines().forEach(line -> {
            try {
                System.out.println(line);
                writer.write(line+"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        writer.close();
        System.out.println(result.toString());
    }
    private String string =
            "*                 *                 *\n" +
            " *               * *               * *\n" +
            "  *             *   *             *   *\n" +
            "   *           *     *           *     *\n" +
            "    *         *       *         *       *\n" +
            "     *       *         *       *         *       *\n" +
            "      *     *           *     *           *     *\n" +
            "       *   *             *   *             *   *\n" +
            "        * *               * *               * *\n" +
            "         *                 *                 *";

    private String test1(){
        String result = "";
        return result;
    }
}
