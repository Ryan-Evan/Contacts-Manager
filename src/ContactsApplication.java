import java.io.IOException;
import java.sql.SQLClientInfoException;
import java.util.*;

import util.Input;

public class ContactsApplication {

    static Input userInput = new Input();
    private static List<String> currentRoster;
    static Map<String, String> callRoster = new HashMap<>();

    public static void main(String[] args) throws IOException {
        roster();
        rosterSwitchCase();
    }

    public static void roster() throws IOException {
        FileReader callRosterReader = new FileReader("src", "call-roster.txt", "call-roster.log");
        callRosterReader.writeToLog("Successfully read the " + callRosterReader.getFileName() + " file!");

        currentRoster = callRosterReader.getFileLines();
        for (String currentPerson : currentRoster) {
            String[] contactInfo = currentPerson.split(", ", 2);
            System.out.println(contactInfo[0] + " | " + contactInfo[1] + "\n");
            callRoster.put(contactInfo[0], contactInfo[1]);
        }
    }

    public static void localRoster() throws IOException {
        String name = "Name";
        String number = "Phone Number";
        System.out.format("%12s | %12s |%n",name, number);
        System.out.println("-------------------------------");
        callRoster.forEach((key, value) -> System.out.format("%12s | %12s | %n",key, value));
    }

    public static void addContact() throws IOException {
            userInput.getString();
        String newName = userInput.getString("Enter the name of the new contact:");
        String newNumber = userInput.getString("Enter the new contact's number:");
        callRoster.put(newName, newNumber);
    }

    public static void searchIndividualContact() throws IOException {
        userInput.getString();
        String userSearch= userInput.getString("What contact are you looking for?");
            if (callRoster.containsKey(userSearch)){
               System.out.println(userSearch + "'s number is: " + callRoster.get(userSearch));
            }else {
                System.out.println("Contact not found");
            }
        }

    public static void deleteContact() throws IOException {
        userInput.getString();
        String userSearch= userInput.getString("What contact are you looking to delete?");
        if (callRoster.containsKey(userSearch)){
            callRoster.remove(userSearch);
            System.out.println(userSearch + " removed from contact list.");
        }else {
            System.out.println("Contact not found");
        }
    }

    public static void exitAndSave() {

    }

    public static void rosterSwitchCase() throws IOException {
        boolean pickOption = true;

        while (pickOption) {
            System.out.println("1. View all contacts.");
            System.out.println("2. Add new contact.");
            System.out.println("3. Search contact by name.");
            System.out.println("4. Delete an existing contact.");
            System.out.println("5. Exit.");
            System.out.println("Enter an option (1, 2, 3, 4, 5):");
            int userChoice = userInput.getInt();
            System.out.println();
            switch (userChoice) {
                case (1):
                    localRoster();
                    System.out.println();
                    break;
                case (2):
                    addContact();
                    System.out.println();
                    break;
                case (3):
                    searchIndividualContact();
                    System.out.println();
                    break;
                case (4):
                    deleteContact();
                    System.out.println();
                    break;
                case (5):
                    System.out.println("Are you sure you want to quit?");
                    boolean userConfirm = userInput.yesNo();
                    System.out.println();
                    if (userConfirm) {
                        pickOption = false;
                        exitAndSave();
                        System.out.println("Program terminated...");
                    } else {
                        System.out.println("Please pick an option.");
                    }
                    break;
                default:
                    break;
            }
        }
    }

}
