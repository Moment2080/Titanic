import java.text.DecimalFormat;

/**
 * Created by Thomas Hodges on 7/5/15.
 */

public class Titanic {

    private String[][] titanicData;

    public Titanic(String[][] data) {
        this.titanicData = data;
    }

    public void getAllData() {
        for (String[] row : titanicData) {
            for (String cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }

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

    public void perishedPercent() {
        DecimalFormat df = new DecimalFormat("#.00");
        double counter = 0;
        for (String[] row : titanicData) {
            if (row[1].equals("0")) {
                counter++;
            }
        }
        counter = (counter / titanicData.length) * 100;
        System.out.println("\n" + df.format(counter) + "% of people aboard the" +
                " Titanic perished.");
    }

    public void survivedPercent() {
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

    public void survivedByClass() {
        DecimalFormat df = new DecimalFormat("#.00");
        double firstClass = 0;
        double secondClass = 0;
        double thirdClass = 0;
        for (String[] row : titanicData) {
            if (row[0].equals("1")) {
                firstClass++;
            } else if (row[0].equals("2")) {
                secondClass++;
            } else if (row[0].equals("3")) {
                thirdClass++;
            }
        }
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

    public void survivedByGender() {
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

    public void rippedOff() {
        System.out.println("\nThe following passengers paid more than $200" +
                " for their tickets:");
        for (String[] row : titanicData) {
            try {
                if (Double.parseDouble(row[5]) > 200) {
                    System.out.println(row[2]);
                }
            } catch (Exception e) {
                //Continues if null string is found.
            }
        }
    }

    public void perishedUnderTen() {
        System.out.println("\nThe following passengers were less than 10" +
                " years old and perished:");
        for (String[] row : titanicData) {
            try {
                if (row[1].equals("0")) {
                    if (Double.parseDouble(row[4]) < 10) {
                        System.out.println(row[2]);
                    }
                }
            } catch (Exception e) {
                //Continues if null string is found.
            }
        }
    }

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

    public void totalByLetter() {

    }

}
