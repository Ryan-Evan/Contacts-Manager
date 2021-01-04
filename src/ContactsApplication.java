import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.Input;

public class ContactsApplication {

    private static List<String> currentRoster;

    public static void main(String[] args) throws IOException {
        roster();
    }

    public static void roster() throws IOException {
        Map<Person, String> callRoster = new HashMap<>();

        FileReader callRosterReader = new FileReader("src", "call-roster.txt", "call-roster.log");
        callRosterReader.writeToLog("Successfully read the " + callRosterReader.getFileName() + " file!");

        currentRoster = callRosterReader.getFileLines();
        System.out.println("Name       | Phone number |");
        System.out.println("---------------------------");
        for (String currentPerson : currentRoster) {
            String[] contactInfo = currentPerson.split(", ", 2);
            System.out.println(contactInfo[0] + " | " + contactInfo[1] + "\n");
            Person person = new Person(contactInfo[0]);
            callRoster.put(person, contactInfo[1]);
        }

        System.out.println(callRoster);
    }

}
