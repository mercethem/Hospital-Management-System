import java.util.Scanner;

public class Main {
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

        switch (choose) {
            case 0:
                person.addPerson();
                System.out.println(person);
                break;
            case 1:
                person.viewPerson();
                break;
            case 2:
                System.out.println("Please enter what do you want to change :\n" +
                        "Name(0)\nSurname(1)\nDay(2)\nMonth(3)\nYear(4)\nBloodGroup(5)\nAddress(6)\nPhoneNumber(7)\nEmail(8)");
                choose = keyboard.nextInt();
                flagChange:
                switch (choose) {

                    case 0:
                        person.changeName();
                        break;
                    case 1:
                        person.changeSurname();
                        break;
                    case 2:
                        person.changeBirthdate_day();
                        break;
                    case 3:
                        person.changeBirthdate_month();
                        break;
                    case 4:
                        person.changeBirthdate_year();
                        break;
                    case 5:
                        person.changeBloodGroup();
                        break;
                    case 6:
                        person.changeAddress();
                        break;
                    case 7:
                        person.changePhoneNumber();
                        break;
                    case 8:
                        person.changeEmail();
                        break;
                    default:
                        System.out.println("Please enter right number!");
                        break flagChange;
                }
            default:
                System.out.println("Please enter right number!");
                Main.options();
        }
    }
}