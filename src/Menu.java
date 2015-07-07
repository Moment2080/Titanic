import java.util.Scanner;

/**
 * Created by Thomas Hodges on 7/6/15.
 */

public class Menu extends Titanic {

    private static Boolean runState = true;
    public Scanner input = new Scanner(System.in);
    public String choice;

    public Menu(String[][] data) {
        super(data);
    }

    public void showMenu() {
        System.out.println("\n*********Welcome to the Titanic Statistical Application" +
                "**************************\n");
        System.out.println("Enter the number of the question you want answered. " +
                "Enter 'Q' to quit the program:\n");
        System.out.println("1. How many passengers were on the Titanic?");
        System.out.println("2. What percentage of passengers perished on the Titanic?");
        System.out.println("3. What percentage of passengers survived the sinking of" +
                "the Titanic?");
        System.out.println("4. What percentage of passengers survived for each of the " +
                "three classes?");
        System.out.println("5. What percentage of passengers survived as a function " +
                "of gender?");
        System.out.println("6. What specific passengers paid more than $200 for their" +
                " tickets?");
        System.out.println("7. What specific passengers who were less than 10 years old" +
                " perished on the Titanic?");
        System.out.println("8. What specific passengers who were less than 10 years old" +
                " survived the sinking of the titanic?");
        System.out.println("9. For each letter in the alphabet, how many passengers last" +
                " names started with that letter?");
        System.out.println("Q. Quit the program.");
        System.out.print("\nEnter your selection: ");
    }

    public void input() {
        do {
            showMenu();
            choice = input.next().toLowerCase();
            switch (choice) {
                case "q" : runState = false;
                    break;
                case "1" : totalPassengers();
                    break;
                case "2" : perishedPercent();
                    break;
                case "3" : survivedPercent();
                    break;
                case "4" : survivedByClass();
                    break;
                case "5" : survivedByGender();
                    break;
                case "6" : rippedOff();
                    break;
                case "7" : perishedUnderTen();
                    break;
                case "8" : survivedUnderTen();
                    break;
                case "9" : totalByLetter();
                    break;
                default: break;
            }

        } while (runState);
    }

}
