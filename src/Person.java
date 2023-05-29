import java.awt.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Person extends IdNumbers { //Soyut ID number classından soy alan bir sınıf olup kişi bilgilerini ve
                                        // metodlarını içerir
    final private int CITIZEN_ID_DIGIT = 11; //Nüfus numarasının rakam sayısını belirten bir sabit
    final private int PHONE_NUMBER_DIGIT = 10; //Kişi cep numarasının rakam sayısını belirten bir sabit
    final private String PHONE_CODE = "0090"; //Programın kullanıldığı ülkenin telefon sabit kodu

    Scanner keyboard = new Scanner(System.in);
    /**
     Alt kısımdaki enkapsüle edilmiş private değişkenlerin isimleri göründüğü üzere tam anlamını taşımaktadır.
     */
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

    /**
     Constructor'lar stabil java syntax kuralları gereği ilki boş olarak sonrasında şahsıma münhasır düzenlenmiştir.
     Tüm bilgi içeriklerini alacak şekilde aksi taktirde kişi eklemek istediğinde nesne oluşturarak doldurulmayan alan
     String ise unknown olarak int ise 0 olarak atanacak şekilde düzenlenmiştir.
     */
    public Person() {
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

    /**
     Setter ve getter metodları kullanılarak enkapsülasyon desteklenmiş olup istenilen sadece rakam kullanılmasıysa
     istenilenin sınırları dışına çıkılmayacak, puctuation character, harf ya da white spaces alamayacak şekilde
     ya da sadece harf se diğer karakterleri alamyacak şekilde tasarlanmış olup getter metodlarda objelerin
     database'den çekildiği şekli ile aktarılacak şekilde tasarlanmıştır.

     ATTENTION(DİKKAT)= SQL kodları ile bağlanılan setter ve getterler dökümantasyonda test edildiği şekli ile
     aktarılacaktır.
     */
    public final void setCitizenId(String citizenId) {
        System.out.println("Please enter citizen ID : ");
        citizenId = keyboard.nextLine();

        if (citizenId.matches("[0-9]*") && citizenId.length() == CITIZEN_ID_DIGIT) {
            this.citizenId = citizenId;
            try {
                DataBaseLayer.dataBaseLayer();
                Statement myStatement = DataBaseLayer.myConnection.createStatement();
                myStatement.executeQuery("IF ( '" + citizenId + "' =(SELECT citizenId FROM persons WHERE citizenId = '" + citizenId + "') )\n" +
                        "    UPDATE HospitalManagementSystemStock.dbo.persons SET  citizenId = '" + citizenId + "' WHERE citizenId= '" + citizenId + "'\n" +
                        "ELSE\n" +
                        "    INSERT INTO persons (citizenId) VALUES ('" + this.citizenId + "')");
                myStatement.close(); // close statement
                DataBaseLayer.myConnection.close(); // close connection
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            System.out.println("Please just use numeric and" + CITIZEN_ID_DIGIT + " digit !");
            Toolkit.getDefaultToolkit().beep();
            setCitizenId("");
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
            Toolkit.getDefaultToolkit().beep();
            ++count;
        } else if (name.matches(".*\\p{Punct}.*")) {
            System.out.println("Please do not use punctuation character!");
            Toolkit.getDefaultToolkit().beep();
            ++count;
        } else if (name.matches(".*[0-9].*")) {
            System.out.println("Please do not use digit!");
            Toolkit.getDefaultToolkit().beep();
            ++count;
        } else {
            this.name = name;
            try {
                DataBaseLayer.dataBaseLayer();
                Statement myStatement = DataBaseLayer.myConnection.createStatement();
                myStatement.executeQuery("IF ( '" + this.citizenId + "' =(SELECT citizenId FROM persons WHERE citizenId = '" + this.citizenId + "') )\n" +
                        "    UPDATE HospitalManagementSystemStock.dbo.persons SET  name = '" + this.name + "' WHERE citizenId= '" + this.citizenId + "'\n");
                myStatement.close(); // close statement
                DataBaseLayer.myConnection.close(); // close connection
            } catch (Exception e) {
                System.out.println(e);
            }
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
            Toolkit.getDefaultToolkit().beep();
            ++count;
        } else if (surname.matches(".*\\p{Punct}.*")) {
            System.out.println("Please do not use punctuation character!");
            Toolkit.getDefaultToolkit().beep();
            ++count;
        } else if (surname.matches(".*[0-9].*")) {
            System.out.println("Please do not use digit!");
            Toolkit.getDefaultToolkit().beep();
            ++count;
        } else {
            this.surname = surname;
            try {
                DataBaseLayer.dataBaseLayer();
                Statement myStatement = DataBaseLayer.myConnection.createStatement();
                myStatement.executeQuery("IF ( '" + this.citizenId + "' =(SELECT citizenId FROM persons WHERE citizenId = '" + this.citizenId + "') )\n" +
                        "    UPDATE HospitalManagementSystemStock.dbo.persons SET  surname = '" + this.surname + "' WHERE citizenId= '" + this.citizenId + "'\n");
                myStatement.close(); // close statement
                DataBaseLayer.myConnection.close(); // close connection
            } catch (Exception e) {
                System.out.println(e);
            }
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
                Toolkit.getDefaultToolkit().beep();
                setBirthdate_day(0);
            } else if (birthdate_day < 0) {
                Toolkit.getDefaultToolkit().beep();
                this.birthdate_day = 1;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + this.citizenId + "' =(SELECT citizenId FROM persons WHERE citizenId = '" + this.citizenId + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.persons SET  birthdate_day = '" + this.birthdate_day + "' WHERE citizenId= '" + this.citizenId + "'\n");
                    myStatement.close(); // close statement
                    DataBaseLayer.myConnection.close(); // close connection
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else if (birthdate_day >= 31) {
                Toolkit.getDefaultToolkit().beep();
                this.birthdate_day = 31;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + this.citizenId + "' =(SELECT citizenId FROM persons WHERE citizenId = '" + this.citizenId + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.persons SET  birthdate_day = '" + this.birthdate_day + "' WHERE citizenId= '" + this.citizenId + "'\n");
                    myStatement.close(); // close statement
                    DataBaseLayer.myConnection.close(); // close connection
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                this.birthdate_day = birthdate_day;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + this.citizenId + "' =(SELECT citizenId FROM persons WHERE citizenId = '" + this.citizenId + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.persons SET  birthdate_day = '" + this.birthdate_day + "' WHERE citizenId= '" + this.citizenId + "'\n");
                    myStatement.close(); // close statement
                    DataBaseLayer.myConnection.close(); // close connection
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } catch (Exception e) {
            System.out.println("Please enter just digit!");
            Toolkit.getDefaultToolkit().beep();
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
                Toolkit.getDefaultToolkit().beep();
                setBirthdate_month(1);
            } else if (birthdate_month < 0) {
                Toolkit.getDefaultToolkit().beep();
                this.birthdate_month = 1;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + this.citizenId + "' =(SELECT citizenId FROM persons WHERE citizenId = '" + this.citizenId + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.persons SET  birthdate_month = '" + this.birthdate_month + "' WHERE citizenId= '" + this.citizenId + "'\n");
                    myStatement.close(); // close statement
                    DataBaseLayer.myConnection.close(); // close connection
                } catch (Exception e) {
                    System.out.println(e);
                }

            } else if (birthdate_month >= 12) {
                Toolkit.getDefaultToolkit().beep();
                this.birthdate_month = 12;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + this.citizenId + "' =(SELECT citizenId FROM persons WHERE citizenId = '" + this.citizenId + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.persons SET  birthdate_month = '" + this.birthdate_month + "' WHERE citizenId= '" + this.citizenId + "'\n");
                    myStatement.close(); // close statement
                    DataBaseLayer.myConnection.close(); // close connection
                } catch (Exception e) {
                    System.out.println(e);
                }

            } else {
                this.birthdate_month = birthdate_month;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + this.citizenId + "' =(SELECT citizenId FROM persons WHERE citizenId = '" + this.citizenId + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.persons SET  birthdate_month = '" + this.birthdate_month + "' WHERE citizenId= '" + this.citizenId + "'\n");
                    myStatement.close(); // close statement
                    DataBaseLayer.myConnection.close(); // close connection
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } catch (Exception e) {
            System.out.println("Please enter just digit!");
            Toolkit.getDefaultToolkit().beep();
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
                Toolkit.getDefaultToolkit().beep();
                setBirthdate_year(1);
            } else if (birthdate_year < 1900) {
                Toolkit.getDefaultToolkit().beep();
                this.birthdate_year = 1900;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + this.citizenId + "' =(SELECT citizenId FROM persons WHERE citizenId = '" + this.citizenId + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.persons SET  birthdate_year = '" + this.birthdate_year + "' WHERE citizenId= '" + this.citizenId + "'\n");
                    myStatement.close(); // close statement
                    DataBaseLayer.myConnection.close(); // close connection
                } catch (Exception e) {
                    System.out.println(e);
                }

            } else if (birthdate_year >= Year.now().getValue()) {
                Toolkit.getDefaultToolkit().beep();
                this.birthdate_year = Year.now().getValue();
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + this.citizenId + "' =(SELECT citizenId FROM persons WHERE citizenId = '" + this.citizenId + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.persons SET  birthdate_year = '" + this.birthdate_year + "' WHERE citizenId= '" + this.citizenId + "'\n");
                    myStatement.close(); // close statement
                    DataBaseLayer.myConnection.close(); // close connection
                } catch (Exception e) {
                    System.out.println(e);
                }

            } else {
                this.birthdate_year = birthdate_year;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + this.citizenId + "' =(SELECT citizenId FROM persons WHERE citizenId = '" + this.citizenId + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.persons SET  birthdate_year = '" + this.birthdate_year + "' WHERE citizenId= '" + this.citizenId + "'\n");
                    myStatement.close(); // close statement
                    DataBaseLayer.myConnection.close(); // close connection
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } catch (Exception e) {
            System.out.println("Please enter just digit!");
            Toolkit.getDefaultToolkit().beep();
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
            try {
                DataBaseLayer.dataBaseLayer();
                Statement myStatement = DataBaseLayer.myConnection.createStatement();
                myStatement.executeQuery("IF ( '" + this.citizenId + "' =(SELECT citizenId FROM persons WHERE citizenId = '" + this.citizenId + "') )\n" +
                        "    UPDATE HospitalManagementSystemStock.dbo.persons SET  bloodGroup = '" + this.bloodGroup + "' WHERE citizenId= '" + this.citizenId + "'\n");
                myStatement.close(); // close statement
                DataBaseLayer.myConnection.close(); // close connection
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (bloodGroup.equals("arh-")) {
            bloodGroup = "A Rh-";
            this.bloodGroup = bloodGroup;
            try {
                DataBaseLayer.dataBaseLayer();
                Statement myStatement = DataBaseLayer.myConnection.createStatement();
                myStatement.executeQuery("IF ( '" + this.citizenId + "' =(SELECT citizenId FROM persons WHERE citizenId = '" + this.citizenId + "') )\n" +
                        "    UPDATE HospitalManagementSystemStock.dbo.persons SET  bloodGroup = '" + this.bloodGroup + "' WHERE citizenId= '" + this.citizenId + "'\n");
                myStatement.close(); // close statement
                DataBaseLayer.myConnection.close(); // close connection
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (bloodGroup.equals("brh+")) {
            bloodGroup = "B Rh+";
            this.bloodGroup = bloodGroup;
            try {
                DataBaseLayer.dataBaseLayer();
                Statement myStatement = DataBaseLayer.myConnection.createStatement();
                myStatement.executeQuery("IF ( '" + this.citizenId + "' =(SELECT citizenId FROM persons WHERE citizenId = '" + this.citizenId + "') )\n" +
                        "    UPDATE HospitalManagementSystemStock.dbo.persons SET  bloodGroup = '" + this.bloodGroup + "' WHERE citizenId= '" + this.citizenId + "'\n");
                myStatement.close(); // close statement
                DataBaseLayer.myConnection.close(); // close connection
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (bloodGroup.equals("brh-")) {
            bloodGroup = "B Rh-";
            this.bloodGroup = bloodGroup;
            try {
                DataBaseLayer.dataBaseLayer();
                Statement myStatement = DataBaseLayer.myConnection.createStatement();
                myStatement.executeQuery("IF ( '" + this.citizenId + "' =(SELECT citizenId FROM persons WHERE citizenId = '" + this.citizenId + "') )\n" +
                        "    UPDATE HospitalManagementSystemStock.dbo.persons SET  bloodGroup = '" + this.bloodGroup + "' WHERE citizenId= '" + this.citizenId + "'\n");
                myStatement.close(); // close statement
                DataBaseLayer.myConnection.close(); // close connection
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (bloodGroup.equals("abrh+")) {
            bloodGroup = "AB Rh+";
            this.bloodGroup = bloodGroup;
            try {
                DataBaseLayer.dataBaseLayer();
                Statement myStatement = DataBaseLayer.myConnection.createStatement();
                myStatement.executeQuery("IF ( '" + this.citizenId + "' =(SELECT citizenId FROM persons WHERE citizenId = '" + this.citizenId + "') )\n" +
                        "    UPDATE HospitalManagementSystemStock.dbo.persons SET  bloodGroup = '" + this.bloodGroup + "' WHERE citizenId= '" + this.citizenId + "'\n");
                myStatement.close(); // close statement
                DataBaseLayer.myConnection.close(); // close connection
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (bloodGroup.equals("abrh-")) {
            bloodGroup = "AB Rh-";
            this.bloodGroup = bloodGroup;
            try {
                DataBaseLayer.dataBaseLayer();
                Statement myStatement = DataBaseLayer.myConnection.createStatement();
                myStatement.executeQuery("IF ( '" + this.citizenId + "' =(SELECT citizenId FROM persons WHERE citizenId = '" + this.citizenId + "') )\n" +
                        "    UPDATE HospitalManagementSystemStock.dbo.persons SET  bloodGroup = '" + this.bloodGroup + "' WHERE citizenId= '" + this.citizenId + "'\n");
                myStatement.close(); // close statement
                DataBaseLayer.myConnection.close(); // close connection
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (bloodGroup.equals("0rh+")) {
            bloodGroup = "0 Rh+";
            this.bloodGroup = bloodGroup;
            try {
                DataBaseLayer.dataBaseLayer();
                Statement myStatement = DataBaseLayer.myConnection.createStatement();
                myStatement.executeQuery("IF ( '" + this.citizenId + "' =(SELECT citizenId FROM persons WHERE citizenId = '" + this.citizenId + "') )\n" +
                        "    UPDATE HospitalManagementSystemStock.dbo.persons SET  bloodGroup = '" + this.bloodGroup + "' WHERE citizenId= '" + this.citizenId + "'\n");
                myStatement.close(); // close statement
                DataBaseLayer.myConnection.close(); // close connection
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (bloodGroup.equals("0rh-")) {
            bloodGroup = "0 Rh-";
            this.bloodGroup = bloodGroup;
            try {
                DataBaseLayer.dataBaseLayer();
                Statement myStatement = DataBaseLayer.myConnection.createStatement();
                myStatement.executeQuery("IF ( '" + this.citizenId + "' =(SELECT citizenId FROM persons WHERE citizenId = '" + this.citizenId + "') )\n" +
                        "    UPDATE HospitalManagementSystemStock.dbo.persons SET  bloodGroup = '" + this.bloodGroup + "' WHERE citizenId= '" + this.citizenId + "'\n");
                myStatement.close(); // close statement
                DataBaseLayer.myConnection.close(); // close connection
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            System.out.println("Please enter your true blood group!");
            Toolkit.getDefaultToolkit().beep();
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
            Toolkit.getDefaultToolkit().beep();
            setAddress("");
        } else {
            this.address = address;
            try {
                DataBaseLayer.dataBaseLayer();
                Statement myStatement = DataBaseLayer.myConnection.createStatement();
                myStatement.executeQuery("IF ( '" + this.citizenId + "' =(SELECT citizenId FROM persons WHERE citizenId = '" + this.citizenId + "') )\n" +
                        "    UPDATE HospitalManagementSystemStock.dbo.persons SET  address = '" + this.address + "' WHERE citizenId= '" + this.citizenId + "'\n");
                myStatement.close(); // close statement
                DataBaseLayer.myConnection.close(); // close connection
            } catch (Exception e) {
                System.out.println(e);
            }
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
            Toolkit.getDefaultToolkit().beep();
            setPhoneNumber("");
        } else if (!phoneNumber.matches("-?\\d+(\\.\\d+)?")) {
            System.out.println("Please enter just digits!");
            Toolkit.getDefaultToolkit().beep();
            setPhoneNumber("");
        } else {
            this.phoneNumber = PHONE_CODE + phoneNumber;
            try {
                DataBaseLayer.dataBaseLayer();
                Statement myStatement = DataBaseLayer.myConnection.createStatement();
                myStatement.executeQuery("IF ( '" + this.citizenId + "' =(SELECT citizenId FROM persons WHERE citizenId = '" + this.citizenId + "') )\n" +
                        "    UPDATE HospitalManagementSystemStock.dbo.persons SET  phoneNumber = '" + this.phoneNumber + "' WHERE citizenId= '" + this.citizenId + "'\n");
                myStatement.close(); // close statement
                DataBaseLayer.myConnection.close(); // close connection
            } catch (Exception e) {
                System.out.println(e);
            }
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
            Toolkit.getDefaultToolkit().beep();
            setEmail("");
        } else if (Email.length() < 3) {
            System.out.println("Please enter your true E-mail address!");
            Toolkit.getDefaultToolkit().beep();
            setEmail("");
        } else {
            this.Email = Email;
            try {
                DataBaseLayer.dataBaseLayer();
                Statement myStatement = DataBaseLayer.myConnection.createStatement();
                myStatement.executeQuery("IF ( '" + this.citizenId + "' =(SELECT citizenId FROM persons WHERE citizenId = '" + this.citizenId + "') )\n" +
                        "    UPDATE HospitalManagementSystemStock.dbo.persons SET  Email = '" + this.Email + "' WHERE citizenId= '" + this.citizenId + "'\n");
                myStatement.close(); // close statement
                DataBaseLayer.myConnection.close(); // close connection
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public String getEmail() {
        return Email;
    }

    public String toString() { //Görüntüleme yapılırken getleri kullanarak bir String literali oluşturulmuştur
//        person_db();
        return "\nID INFORMATION" + "\n--------------------------------------------\n" +
                "Citizen ID : " + getCitizenId() + "\nName : " + getName() + "\nSurname : " + getSurname() + "\nBirthdate : " +
                getBirthdate_day() + "/" + getBirthdate_month() + "/" + getBirthdate_year() + "\nAge : " + age() +
                "\nBlood Group : " + getBloodGroup() + "\nAddress : " + getAddress() +
                "\nPhone Number : " + getPhoneNumber() + "\nE-Mail : " + getEmail() +
                "\n--------------------------------------------\n";
    }

    public void person_db() { //İşlem yapılacak kişinin bilgilerini database üzerinden bilgisayara çeken metod.
        System.out.println("Please enter a citizen number : ");
        citizenId = keyboard.nextLine();
        if (citizenId.matches("[0-9]*") && citizenId.length() == CITIZEN_ID_DIGIT) {
            this.citizenId = citizenId;
        } else {
            System.out.println("Please just use numeric and" + CITIZEN_ID_DIGIT + " digit !");
            Toolkit.getDefaultToolkit().beep();
            person_db();
        }
        try {
            DataBaseLayer.dataBaseLayer();
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            ResultSet myResult = myStatement.executeQuery("SELECT * FROM HospitalManagementSystemStock.dbo.persons WHERE persons.citizenId = '" + citizenId + "'");
            while (myResult.next()) {
                this.citizenId = myResult.getString("citizenId");
                this.name = myResult.getString("name");
                this.surname = myResult.getString("surname");
                this.birthdate_day = myResult.getInt("birthdate_day");
                this.birthdate_month = myResult.getInt("birthdate_month");
                this.birthdate_year = myResult.getInt("birthdate_year");
                this.bloodGroup = myResult.getString("bloodGroup");
                this.address = myResult.getString("address");
                this.phoneNumber = myResult.getString("phoneNumber");
                this.Email = myResult.getString("Email");
            }
            myStatement.close(); // close statement
            DataBaseLayer.myConnection.close(); // close connection
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public long age() { //Özellikleri database'den alınan kişinin doğum tarigi baz alarak yaşını hesaplayan metod
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(getBirthdate_year(), getBirthdate_month(), getBirthdate_day());

        LocalDate thisYearsBirthday = birthday.with(Year.now());
        String birthdate = birthday.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));   //17 February 2022
        long age = ChronoUnit.YEARS.between(birthday, today);
        return age;
    }

    public String citizenId(String citizenId) {
        return citizenId; //TODO Check and control the abstract!!!! Do creating a new citizen ID creator!
    }

    public void addPerson() { //Default özellikleri ile ilk atamaları yapılmış ve kişi eklemek için gerekli setterleri
                                // tek çatı altında toplayan metod

        setCitizenId("Unknown");
        setName("Unknown");
        setSurname("Unknown");
        setBirthdate_day(1);
        setBirthdate_month(1);
        setBirthdate_year(1);
        setBloodGroup("Unknown");
        setAddress("Unknown");
        setPhoneNumber("Unknown");
        setEmail("Unknown");

    }

    public void viewPerson() { //Kişi bilgileri görüntüleme metodu
        person_db(); //İstenen kişinin bilgilerini databaseden çeker
        System.out.println(toString()); //Literale dökümante ederek ekrana yazdırır
    }
    /** Alt kısımdaki metodlar kişinin bilgilerini değiştirmek için önce set ederek sonra set ettiği bilgiyi kontrol
        ederek get eden metodları barındırır
     */
    public void changeName() {
        person_db();
        setName("Unknown");
        System.out.println("New NAME is " + getName());
    }

    public void changeSurname() {
        person_db();
        setSurname("Unknown");
        System.out.println("New SURNAME is " + getSurname());
    }

    public void changeBirthdate_day() {
        person_db();
        setSurname("Unknown");
        System.out.println("New DAY is " + getBirthdate_day());
    }

    public void changeBirthdate_month() {
        person_db();
        setBirthdate_month(0);
        System.out.println("New MONTH is " + getBirthdate_month());
    }

    public void changeBirthdate_year() {
        person_db();
        setBirthdate_year(0);
        System.out.println("New YEAR is " + getBirthdate_year());
    }

    public void changeBloodGroup() {
        person_db();
        setBloodGroup("Unknown");
        System.out.println("New BLOOD GROUP is " + getBloodGroup());
    }

    public void changeAddress() {
        person_db();
        setAddress("Unknown");
        System.out.println("New ADDRESS is " + getAddress());
    }

    public void changePhoneNumber() {
        person_db();
        setPhoneNumber("Unknown");
        System.out.println("New PHONE NUMBER is " + getPhoneNumber());
    }

    public void changeEmail() {
        person_db();
        setEmail("Unknown");
        System.out.println("New EMAIL is " + getEmail());
    }
}
