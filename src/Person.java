import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

public class Person {
    //private Scanner keyboard = new Scanner(System.in);

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

    public void setCitizenId(String citizenId){
        this.citizenId = citizenId;
    }
    public String getCitizenId(){
        return citizenId;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public String getSurname(){
        return surname;
    }
    public void setBirthdate_day(int birthdate_day){
        this.birthdate_day = birthdate_day;
    }
    public int getBirthdate_day(){
        return birthdate_day;
    }
    public void setBirthdate_month(int birthdate_month){
        this.birthdate_month = birthdate_month;
    }
    public int getBirthdate_month(){
        return birthdate_month;
    }
    public void setBirthdate_year(int birthdate_year){
        this.birthdate_year = birthdate_year;
    }
    public int getBirthdate_year(){
        return birthdate_year;
    }
    public void setBloodGroup(String bloodGroup){
        this.bloodGroup = bloodGroup;
    }
    public String getBloodGroup(){
        return bloodGroup;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return address;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setEmail(String Email){
        this.Email = Email;
    }
    public String getEmail(){
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
    public String toString(){

        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(getBirthdate_year(), getBirthdate_month(), getBirthdate_day());
        String formattedDate = birthday.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
        long age = ChronoUnit.YEARS.between(birthday, today);

        return "Citizen ID : " + getCitizenId() + "\nName : " + getName() + "\nSurname : " + getSurname() + "\nBirthdate : " +
                formattedDate + "\nAge : " + age + "\nBlood Group : " + getBloodGroup() + "\nAddress : " + getAddress() +
                "\nPhone Number : " + getPhoneNumber()+ "\nE-Mail : " + getEmail();
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

}
