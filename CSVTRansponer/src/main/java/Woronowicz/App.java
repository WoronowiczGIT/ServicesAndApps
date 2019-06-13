package Woronowicz;

import java.io.*;

import java.util.Arrays;
import java.util.regex.Pattern;

public class App {
    private static int tagIndx = 0;
    private static int groupIndx = 1;
    private static int randomIndx = 2;
    private static int questionIndex = 3;
    private static int firstAnswerIndex = 5;
    private static int currentAnswerNumber = 1;

    private static File result = new File("result.csv");
    private static File inputFile = new File("Chinese test pool-20190221 clean version INPUT.csv");
    private static BufferedReader reader;
    private static BufferedWriter writer;
    private static String separatorSymbol = ";";
    private static Pattern pattern = Pattern.compile(separatorSymbol);

    public static void main(String[] args) throws IOException {
        // reader = new BufferedReader(new InputStreamReader(System.in));
        reader = new BufferedReader(new FileReader(inputFile));
        writer = new BufferedWriter(new FileWriter(result));


        skipFirstLines(3);

        reader.lines().forEach(line -> {

            String[] inputColumns = pattern.split(line);
            currentAnswerNumber = 1;
            for (int answerIndex = firstAnswerIndex; answerIndex < inputColumns.length; answerIndex += 2) {
                try {
                    if (!validataLine(inputColumns)) break;

                    parseConstants(inputColumns);

                    //assign answer text
                    writer.write(inputColumns[answerIndex]);
                    writer.write(separatorSymbol);
                    //assign Yes or No
                    int yesORnoIndex = answerIndex + 1;
                    if (yesORnoIndex >= inputColumns.length) {
                        writer.write("###EMPTY ANSWER###");
                        writer.write(separatorSymbol);
                    } else {
                        writer.write(inputColumns[yesORnoIndex]);
                        writer.write(separatorSymbol);
                    }
                    //assign  type
                    writer.write("Qtype");
                    writer.write(separatorSymbol);
                    //assign group
                    writer.write(inputColumns[groupIndx]);
                    writer.write(separatorSymbol);
                    //assign random
                    writer.write(inputColumns[randomIndx]);
                    writer.write(separatorSymbol);
                    // assign points
                    writer.write("points");
                    writer.write(separatorSymbol);
                    //new line
                    writer.newLine();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        reader.close();
        writer.close();
    }

    public static boolean validataLine(String[] columns) throws IOException {

        if (Arrays.stream(columns).allMatch(String::isEmpty)) {
            return false;
        }
        if (columns.length < 3) {
            writer.write("missing question nr " + String.valueOf(0) + " ;");
            writer.newLine();
            return false;
        }
        return true;
    }

    public static void parseConstants(String[] columns) throws IOException {
        //assign question number
        writer.write(columns[tagIndx]);
        writer.write(separatorSymbol);
        //assign question
        writer.write(columns[questionIndex]);
        writer.write(separatorSymbol);
        //assign answer number
        writer.write(String.valueOf(currentAnswerNumber++));
        writer.write(separatorSymbol);
    }


    public static void skipFirstLines(int linesSkipped) throws IOException {
        for (int i = 0; i < linesSkipped; i++) {
            reader.readLine();
        }
    }
}
