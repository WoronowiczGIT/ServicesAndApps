package trajektoria;

import java.util.BitSet;
import java.util.stream.IntStream;

public class Trajektoria {
    private static int amplitude;
    private static int length;
    private static final String ERROR_MESSAGE = "klops";
    private static final char trailSymbol = '*';
    private static final char separatorSymbol = ' ';
    private static BitSet array;

    public static void main(String[] args) {

        validateInput(args);

        array = new BitSet(length);
        caseAmplitudeEqualOne();

        IntStream
                .range(0,amplitude)
                .filter(row -> row < length)
                .forEach(row -> {
                    computeTrailForRow(row);
                    printRow();
                    nextRow(row);
                });
    }

    private static void validateInput(String[] args){
        try {
            int requiredArgs = 2;
            if (args.length != requiredArgs) throw new NumberFormatException();

            amplitude = Integer.parseInt(args[0].trim());
            length = Integer.parseInt(args[1].trim());

            int minimumValue = 1;
            if(amplitude < minimumValue || length < minimumValue) throw new NumberFormatException();

        } catch (NumberFormatException e) {
            System.out.print(ERROR_MESSAGE);
            System.exit(0);
        }
    }

    private static void caseAmplitudeEqualOne(){
        if (amplitude == 1) {
            array.flip(0,length);
            printRow();
            System.exit(0); }
    }

    private static void computeTrailForRow(int row){
        int root = 0;
        int bufferSize = amplitude - 1;
        int shiftRight = bufferSize * 2;

        for (int i = 0; i < length; i++) {

            if (row == Math.abs(i - root)) {
                array.flip(i);
            }
            if (i == root + (bufferSize)) {
                root += shiftRight;
            }
        }
    }

    private static void printRow(){
        StringBuilder currentRow = new StringBuilder(length);

        for (int i = 0; i < length; i++) {

            if (array.get(i)) {
                currentRow.append(trailSymbol);
                if (isLastValidBit(i)) break;
            } else
                currentRow.append(separatorSymbol);
        }
        array.clear();
        System.out.print(currentRow.toString());
    }

    private static boolean isLastValidBit(int i){
        return array.nextSetBit(i + 1) == -1;
    }

    private static void nextRow(int row){
        if(row != amplitude -1 && row < length -1 )
            System.out.print("\n");
    }
}
