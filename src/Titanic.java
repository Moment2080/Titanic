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

//    Passenger class (1,2,3)
//    Survived (1=yes, 0=no)
//    Name (Passenger name)
//    sex (male or female)
//    age (some values are blank)
//    fare (some values are blank)

    // 1 row = 1 passenger
    public void totalPassengers() {
        System.out.println("\nThe total number of passengers on the Titanic was: "
            + titanicData.length);
    }

    public void perishedPercent() {

    }

    public void survivedPercent() {

    }

    public void survivedByClass() {

    }

    public void survivedByGender() {

    }

    public void rippedOff() {

    }

    public void perishedUnderTen() {

    }

    public void survivedUnderTen() {

    }

    public void totalByLetter() {

    }

}
