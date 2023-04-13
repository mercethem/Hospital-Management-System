import java.util.Scanner;

public class Add {
    public static void addPerson(){

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter citizen ID : ");
        String citizenId = keyboard.nextLine();
        System.out.println("Please enter name : ");
        String name = keyboard.nextLine();
        System.out.println("Please enter surname : ");
        String surname = keyboard.nextLine();
        System.out.println("Please enter birthdate_day : ");
        int birthdate_day = keyboard.nextInt();
        System.out.println("Please enter birthdate_month : ");
        int birthdate_month = keyboard.nextInt();
        System.out.println("Please enter birthdate_year : ");
        int birthdate_year = keyboard.nextInt();
        keyboard.nextLine();
        System.out.println("Please enter blood group : ");
        String bloodGroup = keyboard.nextLine();
        System.out.println("Please enter address : ");
        String address = keyboard.nextLine();
        System.out.println("Please enter phone-number : ");
        String phoneNumber = keyboard.nextLine();
        System.out.println("Please enter Email : ");
        String Email = keyboard.nextLine();

        Person person = new Person();
        person.setCitizenId(citizenId);
        person.setName(name);
        person.setSurname(surname);
        person.setBirthdate_day(birthdate_day);
        person.setBirthdate_month(birthdate_month);
        person.setBirthdate_year(birthdate_year);
        person.setBloodGroup(bloodGroup);
        person.setAddress(address);
        person.setPhoneNumber(phoneNumber);
        person.setEmail(Email);
        System.out.println(person);

    }
}
