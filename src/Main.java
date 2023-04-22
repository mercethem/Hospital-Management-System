import java.util.Scanner;

public class Main {
    static Person person = new Person("10607427704", "Ethem", "MERÇ", 26, 12,
            1990, "A rh +", "Üniversite", "5424974673","mercethem@gmail.com" );

    public static void main(String[] args) {
        options();
    }

    public static void options() {
        System.out.println("Please choose what do you want ?");
        System.out.println("Add Person (0)\nView Person(1)");
        Scanner keyboard = new Scanner(System.in);

        int choose = keyboard.nextInt();


        switch (choose) {
            case 0:
               person.addPerson("10607427704", "Ethem", "MERÇ", 26, 12,
                       1990, "A rh +", "Üniversite", "5424974673","mercethem@gmail.com"); //TODO Check that parameter
                //System.out.println(person);
                break;
            case 1:
                 person.viewPerson();

        }
    }
}