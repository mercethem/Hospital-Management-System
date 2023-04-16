import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Person {
    Scanner keyboard = new Scanner(System.in);
    final int CITIZEN_ID_DIGIT = 11;
    final int PHONE_NUMBER_DIGIT = 10;
    final String PHONE_CODE = "0090";
    private String citizenId;
    private String name;
    private String surname;
    private int birthdate_day;
    private int birthdate_month;
    private int birthdate_year;
    private String bloodGroup;
    private String address;
    private String phoneNumber;
    private String Email;

    public void setCitizenId(String citizenId) {
    try{
        System.out.println("Please enter citizen ID : ");
        citizenId = keyboard.nextLine();

        if (citizenId.matches("[0-9]*") && citizenId.length() == CITIZEN_ID_DIGIT) {
            this.citizenId = citizenId;
        } else {
            System.out.println("Please just use numeric and 11 digit !");
            setCitizenId("");
        }
    }catch (Exception e){
        System.out.println(e);
    }
    }

    public String getCitizenId() {
        return citizenId;
    }

    public void setName(String name) {
        int count = 0;
        System.out.println("Please enter name : ");
        name = keyboard.nextLine();

        if (name.length() < 3) {
            System.out.println("Please enter your true name!");
            ++count;
        } else if (name.matches(".*\\p{Punct}.*")) {
            System.out.println("Please do not use punctuation character!");
            ++count;
        } else if (name.matches(".*[0-9].*")) {
            System.out.println("Please do not use digit!");
            ++count;
        } else {
            this.name = name;
        }
        if (count == 1) {
            setName("");
        }
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        int count = 0;
        System.out.println("Please enter surname : ");
        surname = keyboard.nextLine();

        if (surname.length() < 2) {
            System.out.println("Please enter your true name!");
            ++count;
        } else if (surname.matches(".*\\p{Punct}.*")) {
            System.out.println("Please do not use punctuation character!");
            ++count;
        } else if (surname.matches(".*[0-9].*")) {
            System.out.println("Please do not use digit!");
            ++count;
        } else {
            this.surname = surname;
        }
        if (count == 1) {
            setSurname("");
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setBirthdate_day(int birthdate_day) {
        try {
            System.out.println("Please enter birthdate day : ");
            String sDay = keyboard.nextLine();
            birthdate_day = Integer.parseInt(sDay);
            if (!sDay.matches(".*[0-9].*")) {
                System.out.println("Please use just digits.");
                setBirthdate_day(0);
            } else if (birthdate_day < 0) {
                this.birthdate_day = 1;
            } else if (birthdate_day >= 31) {
                this.birthdate_day = 31;
            } else {
                this.birthdate_day = birthdate_day;
            }
        } catch (Exception e) {
            System.out.println("Please enter just digit!");
            setBirthdate_day(0);
        }
    }

    public int getBirthdate_day() {
        return birthdate_day;
    }

    public void setBirthdate_month(int birthdate_month) {
        try {
            System.out.println("Please enter birthdate month : ");
            String sMonth = keyboard.nextLine();
            birthdate_month = Integer.parseInt(sMonth);
            if (!sMonth.matches(".*[0-9].*")) {
                System.out.println("Please use just digits.");
                setBirthdate_month(1);
            } else if (birthdate_month < 0) {
                this.birthdate_month = 1;
            } else if (birthdate_month >= 12) {
                this.birthdate_month = 12;
            } else {
                this.birthdate_month = birthdate_month;
            }
        } catch (Exception e) {
            System.out.println("Please enter just digit!");
            setBirthdate_month(1);
        }
    }

    public int getBirthdate_month() {
        return birthdate_month;
    }

    public void setBirthdate_year(int birthdate_year) {
        try {
            System.out.println("Please enter birthdate year : ");
            String sYear = keyboard.nextLine();
            birthdate_year = Integer.parseInt(sYear);
            if (!sYear.matches(".*[0-9].*")) {
                System.out.println("Please use just digits.");
                setBirthdate_year(1);
            } else if (birthdate_year < 1900) {
                this.birthdate_year = 1900;
            } else if (birthdate_year >= Year.now().getValue()) {
                this.birthdate_year = Year.now().getValue();
            } else {
                this.birthdate_year = birthdate_year;
            }
        } catch (Exception e) {
            System.out.println("Please enter just digit!");
            setBirthdate_year(1);
        }
    }

    public int getBirthdate_year() {
        return birthdate_year;
    }

    public void setBloodGroup(String bloodGroup) {
        System.out.println("Please enter blood group : ");
        bloodGroup = keyboard.nextLine();
        bloodGroup = bloodGroup.toLowerCase().replace(" ", "");

        if (bloodGroup.equals("arh+")) {
            bloodGroup = "A Rh+";
            this.bloodGroup = bloodGroup;
        } else if (bloodGroup.equals("arh-")) {
            bloodGroup = "A Rh-";
            this.bloodGroup = bloodGroup;
        } else if (bloodGroup.equals("brh+")) {
            bloodGroup = "B Rh+";
            this.bloodGroup = bloodGroup;
        } else if (bloodGroup.equals("brh-")) {
            bloodGroup = "B Rh-";
            this.bloodGroup = bloodGroup;
        } else if (bloodGroup.equals("abrh+")) {
            bloodGroup = "AB Rh+";
            this.bloodGroup = bloodGroup;
        } else if (bloodGroup.equals("abrh-")) {
            bloodGroup = "AB Rh-";
            this.bloodGroup = bloodGroup;
        } else if (bloodGroup.equals("0rh+")) {
            bloodGroup = "0 Rh+";
            this.bloodGroup = bloodGroup;
        } else if (bloodGroup.equals("0rh-")) {
            bloodGroup = "0 Rh-";
            this.bloodGroup = bloodGroup;
        } else {
            System.out.println("Please enter your true blood group!");
            setBloodGroup("");
        }

    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setAddress(String address) {
        System.out.println("Please enter address : ");
        address = keyboard.nextLine();
        address = address.trim().replace("  ", "");// 2 Space to 1 space

        if (address.length() < 10) {
            System.out.println("Please enter your true address!");
            setAddress("");
        } else {
            this.address = address;
        }

    }

    public String getAddress() {
        return address;
    }

    public void setPhoneNumber(String phoneNumber) {
        System.out.println("Please enter phone number without leading zeros: ");
        phoneNumber = keyboard.nextLine();
        phoneNumber = phoneNumber.replace(" ", "");

        if (phoneNumber.length() != PHONE_NUMBER_DIGIT) {
            System.out.println("Please enter your phone number such as " + PHONE_NUMBER_DIGIT + " digits!");
            setPhoneNumber("");
        } else if (!phoneNumber.matches("-?\\d+(\\.\\d+)?")) {
            System.out.println("Please enter just digits!");
            setPhoneNumber("");
        } else {
            this.phoneNumber = PHONE_CODE + phoneNumber;
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setEmail(String Email) {
        System.out.println("Please enter E-Mail : ");
        Email = keyboard.nextLine();
        Email = Email.trim().replace(" ", "");
        if (!Email.contains("@")) {
            System.out.println("You did not use \"@\" ");
            setEmail("");
        } else if (Email.length() < 3) {
            System.out.println("Please enter your true E-mail address!");
            setEmail("");
        } else {
            this.Email = Email;
        }
    }

    public String getEmail() {
        return Email;
    }

    public void birthdate() {
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(getBirthdate_year(), getBirthdate_month(), getBirthdate_day());
        LocalDate thisYearsBirthday = birthday.with(Year.now());
        String formattedDate = birthday.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));   //17 February 2022
        long age = ChronoUnit.YEARS.between(birthday, today);
    }

    public Person() {
    }

    public String toString() {

        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(getBirthdate_year(), getBirthdate_month(), getBirthdate_day());
        String formattedDate = birthday.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
        long age = ChronoUnit.YEARS.between(birthday, today);

        return "Citizen ID : " + getCitizenId() + "\nName : " + getName() + "\nSurname : " + getSurname() + "\nBirthdate : " +
                formattedDate + "\nAge : " + age + "\nBlood Group : " + getBloodGroup() + "\nAddress : " + getAddress() +
                "\nPhone Number : " + getPhoneNumber() + "\nE-Mail : " + getEmail();
    }

    public Person(String citizenId, String name, String surname, int birthdate_day, int birthdate_month,
                  int birthdate_year, String bloodGroup, String address, String phoneNumber, String Email) {

        this.citizenId = citizenId;
        this.name = name;
        this.surname = surname;
        this.birthdate_day = birthdate_day;
        this.birthdate_month = birthdate_month;
        this.birthdate_year = birthdate_year;
        this.bloodGroup = bloodGroup;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.Email = Email;
    }

    public void addPerson() {
        Person person = new Person();

        person.setCitizenId("Unknown");
        person.setName("Unknown");
        person.setSurname("Unknown");
        person.setBirthdate_day(1);
        person.setBirthdate_month(1);
        person.setBirthdate_year(1);
        person.setBloodGroup("Unknown");
        person.setAddress("Unknown");
        person.setPhoneNumber("Unknown");
        person.setEmail("Unknown");
    }
}
