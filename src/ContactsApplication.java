import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.Input;

public class ContactsApplication {

    private static List<String> currentRoster;

    public static void main(String[] args) throws IOException {
        rosterSwitchCase();
    }

    public static void roster() throws IOException {
        Map<String, String> callRoster = new HashMap<>();

        FileReader callRosterReader = new FileReader("src", "call-roster.txt", "call-roster.log");
        callRosterReader.writeToLog("Successfully read the " + callRosterReader.getFileName() + " file!");

        currentRoster = callRosterReader.getFileLines();
        System.out.println("Name       | Phone number |");
        System.out.println("---------------------------");
        for (String currentPerson : currentRoster) {
            String[] contactInfo = currentPerson.split(", ", 2);
            System.out.println(contactInfo[0] + " | " + contactInfo[1] + "\n");
            callRoster.put(contactInfo[0], contactInfo[1]);
        }

        System.out.println(callRoster);
    }

    public static void addContact() throws IOException {

    }

    public static void searchIndividualContact() throws IOException {

    }

    public static void deleteContact() throws IOException {

    }


    public static void rosterSwitchCase() throws IOException {
        Input userInput = new Input();
        boolean pickOption = true;

        while (pickOption) {
            System.out.println("1. View contact");
            System.out.println("2. Add new contact.");
            System.out.println("3. Search contact by name.");
            System.out.println("4. Delete an existing contact.");
            System.out.println("5. Exit.");
            System.out.println("Enter an option (1, 2, 3, 4, 5):");
            int userChoice = userInput.getInt();
            System.out.println();
            switch (userChoice) {
                case (1):
                    roster();
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
