import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by Thomas Hodges on 7/5/15.
 * CMIS 141 - Final Project
 * This class enables the creation and modification of
 * the titanic.txt file as an object with a 2D array.
 */

public class Titanic {

    // Private 2D array for the data
    private String[][] titanicData;

    // Default constructor, accepts 2D array
    public Titanic(String[][] data) {
        this.titanicData = data;
    }

    // Creates a menu object and begins the prompts for user input
    public void passToMenu() {
        Menu menu = new Menu(this.titanicData);
        menu.input();
    }

//  [0]  Passenger class (1,2,3)
//  [1]  Survived (1=yes, 0=no)
//  [2]  Name (Passenger name)
//  [3]  sex (male or female)
//  [4]  age (some values are blank)
//  [5]  fare (some values are blank)

    // 1 row = 1 passenger
    public void totalPassengers() {
        System.out.println("\nThe total number of passengers on the Titanic was: "
            + titanicData.length);
    }

    // Calculates percent of position 1 = 0 / total
    public void perishedPercent() {
        // DecimalFormat to clean up the output value %##.##
        DecimalFormat df = new DecimalFormat("#.00");
        // counter needs to be a double for percentage to work
        double counter = 0;
        // For each row in titanicData...
        for (String[] row : titanicData) {
            // Test if the 2nd [1] position is a string of "0"
            if (row[1].equals("0")) {
                counter++;
            }
        }
        // Sets the counter to the percent of the total
        counter = (counter / titanicData.length) * 100;
        System.out.println("\n" + df.format(counter) + "% of people aboard the" +
                " Titanic perished.");
    }

    // Same as perishedPercent but for position 1 = 1 / total
    public void survivedPercent() {
        // DecimalFormat to clean up the output value %##.##
        DecimalFormat df = new DecimalFormat("#.00");
        double counter = 0;
        for (String[] row : titanicData) {
            if (row[1].equals("1")) {
                counter++;
            }
        }
        counter = (counter / titanicData.length) * 100;
        System.out.println("\n" + df.format(counter) + "% of people aboard the" +
                " Titanic survived.");
    }

    // Calculates percent of survivors separated by position 0
    public void survivedByClass() {
        // DecimalFormat to clean up the output value %##.##
        DecimalFormat df = new DecimalFormat("#.00");
        double firstClass = 0;
        double secondClass = 0;
        double thirdClass = 0;
        for (String[] row : titanicData) {
            // Tests for position [0] equals a string value 1, 2, or 3
            if (row[0].equals("1")) {
                firstClass++;
            } else if (row[0].equals("2")) {
                secondClass++;
            } else if (row[0].equals("3")) {
                thirdClass++;
            }
        }
        // Refactor counters to be percentages
        firstClass = (firstClass / titanicData.length) * 100;
        secondClass = (secondClass / titanicData.length) * 100;
        thirdClass = (thirdClass / titanicData.length) * 100;
        System.out.println("\n" + df.format(firstClass) + "% of people aboard the" +
                " Titanic were First Class citizens.");
        System.out.println(df.format(secondClass) + "% of people aboard the " +
                "Titanic were Second Class citizens.");
        System.out.println(df.format(thirdClass) + "% of people aboard the " +
                "Titanic were Third Class citizens.");
    }

    // Same as survivedByClass but for position 3 in each row
    public void survivedByGender() {
        // DecimalFormat to clean up the output value %##.##
        DecimalFormat df = new DecimalFormat("#.00");
        double male = 0;
        double female = 0;
        for (String[] row : titanicData) {
            if (row[3].equals("male")) {
                male++;
            } else if (row[3].equals("female")) {
                female++;
            }
        }
        male = (male / titanicData.length) * 100;
        female = (female / titanicData.length) * 100;
        System.out.println("\n" + df.format(male) + "% of people aboard the" +
                " Titanic were male.");
        System.out.println(df.format(female) + "% of people aboard the" +
                " Titanic were female.");
    }

    // Method displays position 2 of rows which position 5 > 200
    public void rippedOff() {
        System.out.println("\nThe following passengers paid more than $200" +
                " for their tickets:");
        // For each row in titanicData..
        for (String[] row : titanicData) {
            // Try-Catch to handle null values
            try {
                // Test if position 5 is greater than 200
                if (Double.parseDouble(row[5]) > 200) {
                    // Print that row's position 2
                    System.out.println(row[2]);
                }
            } catch (Exception e) {
                //Continues if null string is found.
            }
        }
    }

    // Method displays position 2 of rows where position 1 is 0 and 4 < 10
    public void perishedUnderTen() {
        System.out.println("\nThe following passengers were less than 10" +
                " years old and perished:");
        for (String[] row : titanicData) {
            // Try-Catch for null values
            try {
                // Test if position 1 is 0
                if (row[1].equals("0")) {
                    // And tests if position 4 is less than 10
                    if (Double.parseDouble(row[4]) < 10) {
                        // Prints that row's position 2
                        System.out.println(row[2]);
                    }
                }
            } catch (Exception e) {
                //Continues if null string is found.
            }
        }
    }

    // Same as perishedUnderTen but position 1 equals 1 for survivors
    public void survivedUnderTen() {
        System.out.println("\nThe following passengers were less than 10" +
                " years old and survived:");
        for (String[] row : titanicData) {
            try {
                if (row[1].equals("1")) {
                    if (Double.parseDouble(row[4]) < 10) {
                        System.out.println(row[2]);
                    }
                }
            } catch (Exception e) {
                //Continues if null string is found.
            }
        }
    }

    // Method that displays a count by each passenger's first letter
    public void totalByLetter() {
        // Create an array list of Characters
        ArrayList<Character> letters = new ArrayList<>();
        for (int i = 0; i < titanicData.length; i++) {
            // Adds to list, from titanicData, as Upper Case, the first letter
            letters.add(titanicData[i][2].toUpperCase().charAt(0));
        }

        System.out.println("\nFor each first letter of their last names," +
                " here is a count of the passengers:");

        // Create a set of characters using the letters
        Set<Character> chars = new HashSet<>(letters);
        // For each character in the chars set...
        for (Character ch : chars) {
            // Returns the number of elements in letters equal to the ch object
            System.out.println(ch + ": " + Collections.frequency(letters, ch));
        }
    }

}
