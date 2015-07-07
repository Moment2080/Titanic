import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Thomas Hodges on 7/5/15.
 */

public class TestTitanic {

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
            Titanic bigList = new Titanic(titanic);
            bigList.passToMenu();

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
