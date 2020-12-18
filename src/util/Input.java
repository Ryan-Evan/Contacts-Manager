package util;

import java.util.Scanner;

public class Input {

    private Scanner scanner;

    public Input(){
        this.scanner = new Scanner(System.in);
    }

    public String getString() {
        return this.scanner.nextLine();
    }

    public String getString(String prompt) {
        System.out.println(prompt);
        return getString();
    }

    public boolean yesNo() {
        System.out.println("[Yes / No]");
        String input = scanner.nextLine();
        return (input.trim().toLowerCase().equals("y") || input.trim().toLowerCase().equals("yes"));
    }

    public boolean yesNoNewLine() {
        System.out.println("[Yes / No]\n");
        String input = scanner.nextLine();
        return (input.trim().toLowerCase().equals("y") || input.trim().toLowerCase().equals("yes"));
    }

    public int getInt(int min, int max) {
        int input;
        do {
            System.out.println("Enter a number between " + min + " and " + max +": ");
            input = this.scanner.nextInt();
        } while (input < min || input > max);
        return input;
    }

    public int getInt() {
        int input;
        System.out.println("Enter a number: ");
        input = this.scanner.nextInt();
        return input;
    }

    public double getDouble(double min, double max) {
        double input;
        do {
            System.out.println("Enter a number with decimals between " + min + " and " + max +": ");
            input = this.scanner.nextDouble();
        } while (input < min || input > max);
        return input;
    }

    public double getDouble() {
        double input;
        System.out.println("Enter a number with decimals: ");
        input = this.scanner.nextDouble();
        return input;
    }

}
