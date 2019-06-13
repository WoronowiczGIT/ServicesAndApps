package Woronowicz;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while(true) {
            System.out.println("Transponer CSV: \n" +
                    "Do you wish to set references manually?(Y/N)");
            String answer = scanner.next();

            if (answer.equalsIgnoreCase("Y")) {

            } else if (answer.equalsIgnoreCase("N")) {

            } else {
                System.out.println("type (R) to chose again");
                if (!scanner.next().equalsIgnoreCase("R"))
                    System.exit(0);
            }
        }
    }
}
