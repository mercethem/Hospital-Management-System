import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

//todo yapılması gerekenler arasında klavyteden gelenleri sert ve getlere ayarlar ayrıca enkapsülasyon yaparak düzenlemeleri personda tamamladıktan sonra düzenleme yap
public class person {

    private long citizenId;
    private String name;
    private String surname;
    private short birthdate_day;
    private short birthdate_month;
    private short birthdate_year;
    private String bloodGroup;
    private String address;
    private long phoneNumber;
    private String Email;

    public void setCitizenId(long citizenId){
        citizenId = citizenId;
    }
    public long getCitizenId(){
        return citizenId;
    }
    public void setName(String name){
        name = name;
    }
    public String getName(){
        return name;
    }
    public void setSurname(String surname){
        surname = surname;
    }
    public String getSurname(){
        return surname;
    }
    public void setBirthdate_day(short birthdate_day){
        birthdate_day = birthdate_day;
    }
    public short getBirthdate_day(){
        return birthdate_day;
    }
    public void setBirthdate_month(short birthdate_month){
        birthdate_month = birthdate_month;
    }
    public short getBirthdate_month(){
        return birthdate_month;
    }
    public void setBirthdate_year(short birthdate_year){
        birthdate_year = birthdate_year;
    }
    public short getBirthdate_year(){
        return birthdate_year;
    }
    public void setBloodGroup(String bloodGroup){
        bloodGroup = bloodGroup;
    }
    public String getBloodGroup(){
        return bloodGroup;
    }
    public void setAddress(String address){
        address = address;
    }
    public String getAddress(){
        return address;
    }
    public void setPhoneNumber(long phoneNumber){
        phoneNumber = phoneNumber;
    }
    public long getPhoneNumber(){
        return phoneNumber;
    }
    public void setEmail(String Email){
        Email = Email;
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
        System.out.println("age " + age);
        System.out.println("birthday " + formattedDate);
    }
    public person() {

        this.citizenId = 0;
        this.name = "";
        this.surname = "";
        this.birthdate_day = 0;
        this.birthdate_month = 0;
        this.birthdate_year = 0;
        this.bloodGroup = "";
        this.address = "";
        this.phoneNumber = 0;
        this.Email = "";

        System.out.println("New person created");


    }
    public String toString(){

        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(birthdate_year, birthdate_month, birthdate_day);
        String formattedDate = birthday.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
        long age = ChronoUnit.YEARS.between(birthday, today);
        System.out.println("age " + age);
        System.out.println("birthday " + formattedDate);

        return "Citizen ID : " + getCitizenId() + "Name : " + getName() + "Surname : " + getSurname() + "Birthdate : " +
                formattedDate + "Age : " + age + "Blood Group : " + getBloodGroup() + "Address : " + getAddress() +
                "Phone Number : " + getPhoneNumber()+ "E-Mail : " + getEmail();
    }

    public person(long citizenId, String name, String surname, short birthdate_day, short birthdate_month,
                  short birthdate_year, String bloodGroup, String address, long phoneNumber, String Email) {
        this.citizenId = 0;
        this.name = "";
        this.surname = "";
        this.birthdate_day = 0;
        this.birthdate_month = 0;
        this.birthdate_year = 0;
        this.bloodGroup = "";
        this.address = "";
        this.phoneNumber = 0;
        this.Email = "";

    }








}
