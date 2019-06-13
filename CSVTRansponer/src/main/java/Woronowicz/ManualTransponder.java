package Woronowicz;

public class ManualTransponder {

    public void getReferenecs(){}
    public static void displayManual(){
        System.out.println("type in corresponding cells following example:\n" +
                "schema: 1=A1,2=A2,3=B2\n" +
                "input: " +
                "\nX;X;X\n" +
                "A;B;C\n" +
                "output: \nX\nX;X"+
                "\nA\nB;C");
        System.out.println("first value defines column in CSV file, second value a position in relation to last row.");
    }

    public static void main(String[] args) {
        displayManual();
    }
}
