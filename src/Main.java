import java.util.Scanner;

public class Main {
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
                Person person = new Person("10607427704", "Ethem", "MERÇ", 26, 12,
                        1990, "A rh +", "Üniversite", "5424974673","mercethem@gmail.com" );
                //person.addPerson();
                System.out.println(person);
                options();
                break;
            case 1:
                Person person1 = new Person("10607427704", "Ethem", "MERÇ", 26, 12,
                        1990, "A rh +", "Üniversite", "5424974673","mercethem@gmail.com" );
                System.out.println(person1.toString());



        }
    }
}