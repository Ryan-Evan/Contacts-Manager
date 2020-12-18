import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class FileReader {

    // Properties for this class
    // Goal: Read in a file and parse through it

    private String directoryName; // i.e 'data', 'src/fileIo'
    private String fileName; // i.e 'day18.txt', 'jolts.txt'
    private String logFileName; // Will hold logging info
    private Path directoryPath; // Path representation of the parent directory for our files
    private Path filePath; // path representation for the actual file itself
    private Path logFilePath; // Path representation of the log file
    private List<String> fileLines; // Holding spot for the content inside of the data itself
    private List<String> logFileLines; // Holding spot for the content inside the log file

    // Constructor
    // Want to send in a directory path name and a file name, logFile name, and generate EVERYTHING from just those two values
    public FileReader(String directoryName, String fileName, String logFileName) throws IOException {
        this.directoryName = directoryName;
        this.fileName = fileName;
        this.logFileName = logFileName;
        // Instantiating Path values
        this.directoryPath = Paths.get(directoryName); // Paths.get("data")
        this.filePath = Paths.get(directoryName, fileName);
        this.logFilePath = Paths.get(directoryName, logFileName);

        // Check if files exist, and create them if they don;t currently exist
        // Log File
        if (Files.notExists(this.logFilePath)) {
            try {
                Files.createFile(this.logFilePath);
            } catch (IOException e) {
                // Store this exception message in the log file
                // If there is an issue creating the log file, let's throw an IOException
                throw new IOException("Unable to create the logfile (" + this.logFileName + ")!");
            }
        }

        // Directory for data file ('data'), ('src/fileIo')
        if (Files.notExists(this.directoryPath)) {
            try {
                Files.createDirectories(this.directoryPath); // createDirectories will create any missing parent directories along with the enclosed directory
            } catch (IOException e) {
                // Add this error message to the log
                // Files.write(Path filePath, List<String> message(s)
                Files.write(this.logFilePath, Arrays.asList(e.getMessage()), StandardOpenOption.APPEND); // Appends to the end of the log file
                throw new IOException("Unable to create the data directory (" + this.directoryName + ")!");
                // Stop all execution
            }
        }

        // Data File ('day18.txt')
        if (Files.notExists(this.filePath)) {
            // If we've made it into this if statement, that means the file DOES NOT exist, so we're going to make it
            try {
                Files.createFile(this.filePath);
            } catch (IOException e) {
                Files.write(this.logFilePath, Arrays.asList(e.getMessage()), StandardOpenOption.APPEND); // Appends to the end of the log file
                throw new IOException("Unable to create the data file (" + this.fileName + ")!");
                // Stop all execution
            }
        }

        // Test if instantiation worked
        System.out.println(filePath); // Display the file path for the passed in arguments
        this.fileLines = Files.readAllLines(this.filePath); // Gives every line in (i.e 'day18.txt' as a String, inside of a List<String>
    }

    // PSVM
    public static void main(String[] args) throws IOException{
        // Instantiate a FileReader object, and see if it works
        FileReader callRosterReader = new FileReader("src", "call-roster.txt", "call-roster.log");
        callRosterReader.writeToLog("Successfully read the " + callRosterReader.getFileName() + " file!");

        System.out.println("Call Roster file, here's the first line: ");
        System.out.println(callRosterReader.getFileLines().get(0));
    }


    // Custom Method(s)
    public void writeToLog(String message) throws IOException{
        try {
            // Write the string 'message' to the log file
            Files.write(this.logFilePath, Arrays.asList(message), StandardOpenOption.APPEND);
        } catch (IOException e) {
            Files.write(this.logFilePath, Arrays.asList(e.getMessage()), StandardOpenOption.APPEND);
            throw new IOException("Unable to write custom message to log file");
        }
    }


    // Getters and Setters
    public String getDirectoryName() {
        return directoryName;
    }

    public void setDirectoryName(String directoryName) {
        this.directoryName = directoryName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getLogFileName() {
        return logFileName;
    }

    public void setLogFileName(String logFileName) {
        this.logFileName = logFileName;
    }

    public Path getDirectoryPath() {
        return directoryPath;
    }

    public void setDirectoryPath(Path directoryPath) {
        this.directoryPath = directoryPath;
    }

    public Path getFilePath() {
        return filePath;
    }

    public void setFilePath(Path filePath) {
        this.filePath = filePath;
    }

    public Path getLogFilePath() {
        return logFilePath;
    }

    public void setLogFilePath(Path logFilePath) {
        this.logFilePath = logFilePath;
    }

    public List<String> getFileLines() {
        return fileLines;
    }

    public void setFileLines(List<String> fileLines) {
        this.fileLines = fileLines;
    }

    public List<String> getLogFileLines() {
        return logFileLines;
    }

    public void setLogFileLines(List<String> logFileLines) {
        this.logFileLines = logFileLines;
    }
}
