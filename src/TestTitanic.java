import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Thomas Hodges on 7/5/15.
 * CMIS 141 - Final Project
 * This program takes the titanic.txt file from the command
 * line and creates a 2D array.
 */

public class TestTitanic {

    // Method that builds a 2D array from the txt file
    public void filler(String[] args) {

        // Try-catch is needed for passing args to method
        try {
            // Turns the txt file into one large string
            String content = new Scanner(new File(args[0]))
                    .useDelimiter("\\Z") // To the end of the file
                    .next();
            String[] rows = content.split("\n"); // Breaks up by new line
            // Creates a 2D array as "long" as the input file
            String[][] titanic = new String[rows.length][];

            // Fills the 2D array
            for (int i = 0; i < rows.length; i++) {
                titanic[i] = rows[i].split("\\t");
            }

            // Creates a new Titanic object
            Titanic titanicObject = new Titanic(titanic);
            // Calls the passToMenu method from Titanic class
            titanicObject.passToMenu();

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

    }

    public static void main(String[] args) {

        // Create an object from this class
        TestTitanic runner = new TestTitanic();
        // Calls the program method to fill the array
        runner.filler(args);

    }
}
