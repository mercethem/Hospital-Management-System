import java.awt.*;
import java.util.Scanner;

public class Menu {
    static Person person = new Person("10607427704", "Ethem", "MERÇ", 26, 12,
            1990, "A rh +", "Üniversite", "5424974673", "mercethem@gmail.com");

    public static void main(String[] args) {
        options();
    }

    public static void options() {
        System.out.println("Please choose what do you want ?");
        System.out.println("Add Person (0)\nView Person(1)\nChange Information(2)");
        Scanner keyboard = new Scanner(System.in);

        int choose = keyboard.nextInt();

        if (choose == 0) {
            person.addPerson();
            System.out.println(person);
            options();
        } else if (choose == 1) {
            person.viewPerson();
            options();
        } else if (choose == 2) {
            System.out.println("Please enter what do you want to change :\n" +
                    "Name(0)\nSurname(1)\nDay(2)\nMonth(3)\nYear(4)\nBloodGroup(5)\nAddress(6)\nPhoneNumber(7)\nEmail(8)");

            choose = keyboard.nextInt();
            if (choose == 0) {
                person.changeName();
            } else if (choose == 1) {
                person.changeSurname();
            } else if (choose == 2) {
                person.changeBirthdate_day();
            } else if (choose == 3) {
                person.changeBirthdate_month();
            } else if (choose == 4) {
                person.changeBirthdate_year();
            } else if (choose == 5) {
                person.changeBloodGroup();
            } else if (choose == 6) {
                person.changeAddress();
            } else if (choose == 7) {
                person.changePhoneNumber();
            } else if (choose == 8) {
                person.changeEmail();
            } else {
                System.out.println("Please enter right number!");
                Toolkit.getDefaultToolkit().beep();
                options();
            }
        } else {
            System.out.println("Please enter right number!");
            Toolkit.getDefaultToolkit().beep();
            options();
        }
    }

}
