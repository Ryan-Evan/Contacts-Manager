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
        return yesNo("[Yes / No]");
    }

    public boolean yesNo(String prompt) {
        System.out.println(prompt);
        String input = this.scanner.next();
        return (input.trim().equalsIgnoreCase("y") || input.trim().equalsIgnoreCase("yes"));
    }

    public boolean yesNoNewLine() {
        return yesNoNewLine("[Yes / No]");
    }

    public boolean yesNoNewLine(String prompt) {
        System.out.println(prompt);
        String input = scanner.nextLine();
        return (input.trim().equalsIgnoreCase("y") || input.trim().equalsIgnoreCase("yes"));
    }

    public int getInt() {
        System.out.println("Enter a number: ");
        return this.scanner.nextInt();
    }

    public int getInt(int min, int max) {
        return getInt(min, max,"Enter a number between " + min + " and " + max +": ");
    }

    public int getInt(int min, int max, String prompt) {
        int input;
        do{
            System.out.println(prompt);
            input = this.scanner.nextInt();
        }while(input < min || input > max);
        return input;
    }

    public double getDouble() {
        System.out.println("Enter a number with decimals: ");
        return this.scanner.nextDouble();
    }

    public double getDouble(double min, double max) {
        return getDouble(min, max, "Enter a number with decimals between " + min + " and " + max +": ");
    }

    public double getDouble(double min, double max, String prompt){
        double input;
        do{
            System.out.println(prompt);
            input = this.scanner.nextDouble();
        }while(input < min || input > max);
        return input;
    }

}
