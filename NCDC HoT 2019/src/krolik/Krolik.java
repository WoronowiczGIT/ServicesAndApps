package krolik;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Krolik {
    private static Map<Integer, Integer> values = new HashMap<>();
    private static int nameIndex = 0;
    private static boolean nameHasIndex = false;
    private static String name;

    private static final String brackets = "{}";
    private static final String separator = ",";
    private static final String ERROR_MESSAGE = "klops";

    private static final int maximumValue = 10000;
    private static final int minimumValue = -10000;
    private static final short requiredArgs = 1;


    public static void main(String[] args){
        validateInput(args);
        parseName(args[0]);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile(separator);

        reader.lines().forEach(line -> {
            String[] columns = pattern.split(line);
            IntStream.range(0, columns.length).forEach(i -> {
                if (columns[i].equals(name)) {
                    checkNameIndex(i);
                } else {
                    int value = parseValue(columns[i]);
                    if (value != 0) {
                        assignValue(i, value);
                    }
                }
            });
        });

        if (isResultValid()) {
            presentResult();
        } else {
            terminateApp();
        }
    }

    private static void validateInput(String[] args) {
        if (args.length != requiredArgs) {
            terminateApp();
        }
    }

    private static void parseName(String parameter) {
        StringBuilder builder = new StringBuilder();
        builder.append(brackets);
        builder.insert(1, parameter);

        name = builder.toString();
    }

    private static void checkNameIndex(int currentIndex) {
        if (nameHasIndex) {
            if (nameIndex != currentIndex) {
                terminateApp();
            }
        } else {
            nameHasIndex = true;
            nameIndex = currentIndex;
        }
    }

    private static void terminateApp() {
        System.out.print(ERROR_MESSAGE);
        System.exit(0);
    }

    private static int parseValue(String column) throws NumberFormatException {
        int value;
        try {
            value = Integer.parseInt(column);
            if (value <= minimumValue || value >= maximumValue) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            value = 0;
        }

        return value;
    }

    private static void assignValue(int index, int value) {
        if (nameHasIndex && nameIndex == index) {
            assignToNameIndex(index, value);
        } else if (!nameHasIndex) {
            assignToCurrentIndex(index, value);
        }
    }

    private static void assignToCurrentIndex(int index, int value) {
        if (!values.containsKey(index)) {
            values.put(index, value);
        } else {
            int columnValue = values.get(index) + value;
            values.put(index, columnValue);
        }
    }

    private static void assignToNameIndex(int index, int value) {
        if (!values.containsKey(index)) {
            values.put(index, value);
        } else {
            int currentScore = values.get(index) + value;
            values.put(index, currentScore);
        }
    }

    private static boolean isResultValid() {
        return nameHasIndex && values.get(nameIndex) != null;
    }

    private static void presentResult() {
        System.out.print(values.get(nameIndex));
    }
}

