import java.awt.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Patient extends Person { //TODO patient object change and test
    static Patient patient = new Patient("Neurosurgery",
            10, 10, 2021,
            10, 11, 2021);
    Scanner keyboard = new Scanner(System.in);
    private String department;
    private int dateOfHospitalized_day;
    private int dateOfHospitalized_month;
    private int dateOfHospitalized_year;
    private int dateOfLeave_day;
    private int dateOfLeave_month;
    private int dateOfLeave_year;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        int count = 0;
        System.out.println("Please enter department : ");
        department = keyboard.nextLine();

        if (department.length() < 2) {
            System.out.println("Please enter your true department!");
            Toolkit.getDefaultToolkit().beep();
            ++count;
        } else if (department.matches(".*\\p{Punct}.*")) {
            System.out.println("Please do not use punctuation character!");
            Toolkit.getDefaultToolkit().beep();
            ++count;
        } else if (department.matches(".*[0-9].*")) {
            System.out.println("Please do not use digit!");
            Toolkit.getDefaultToolkit().beep();
            ++count;
        } else {
            this.department = department;
            try {
                DataBaseLayer.dataBaseLayer();
                Statement myStatement = DataBaseLayer.myConnection.createStatement();
                myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM employees WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                        "    UPDATE HospitalManagementSystemStock.dbo.patients SET  department = '" + this.department + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if (count == 1) {
            setDepartment("");
        }

    }

    public int getDateOfHospitalized_day() {
        return dateOfHospitalized_day;
    }

    public void setDateOfHospitalized_day(int dateOfHospitalized_day) {
        try {
            System.out.println("Please enter date of hospitalized day : ");
            String sDay = keyboard.nextLine();
            dateOfHospitalized_day = Integer.parseInt(sDay);
            if (!sDay.matches(".*[0-9].*")) {
                System.out.println("Please use just digits.");
                Toolkit.getDefaultToolkit().beep();
                setDateOfHospitalized_day(0);
            } else if (dateOfHospitalized_day < 0) {
                Toolkit.getDefaultToolkit().beep();
                this.dateOfHospitalized_day = 1;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM employees WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.patients SET  dateOfHospitalized_day = '" + this.dateOfHospitalized_day + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else if (dateOfHospitalized_day >= 31) {
                Toolkit.getDefaultToolkit().beep();
                this.dateOfHospitalized_day = 31;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM employees WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.patients SET  dateOfHospitalized_day = '" + this.dateOfHospitalized_day + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                this.dateOfHospitalized_day = dateOfHospitalized_day;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM employees WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.patients SET  dateOfHospitalized_day = '" + this.dateOfHospitalized_day + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } catch (Exception e) {
            System.out.println("Please enter just digit!");
            Toolkit.getDefaultToolkit().beep();
            setDateOfHospitalized_day(0);
        }
    }

    public int getDateOfHospitalized_month() {
        return dateOfHospitalized_month;
    }

    public void setDateOfHospitalized_month(int dateOfHospitalized_month) {
        try {
            System.out.println("Please enter date of hospitalized month : ");
            String sDay = keyboard.nextLine();
            dateOfHospitalized_month = Integer.parseInt(sDay);
            if (!sDay.matches(".*[0-9].*")) {
                System.out.println("Please use just digits.");
                Toolkit.getDefaultToolkit().beep();
                setDateOfHospitalized_month(0);
            } else if (dateOfHospitalized_month < 0) {
                Toolkit.getDefaultToolkit().beep();
                this.dateOfHospitalized_month = 1;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM employees WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.patients SET  dateOfHospitalized_month = '" + this.dateOfHospitalized_month + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else if (dateOfHospitalized_month >= 12) {
                Toolkit.getDefaultToolkit().beep();
                this.dateOfHospitalized_month = 12;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM employees WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.patients SET  dateOfHospitalized_month = '" + this.dateOfHospitalized_month + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                this.dateOfHospitalized_month = dateOfHospitalized_month;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM employees WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.patients SET  dateOfHospitalized_month = '" + this.dateOfHospitalized_month + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } catch (Exception e) {
            System.out.println("Please enter just digit!");
            Toolkit.getDefaultToolkit().beep();
            setDateOfHospitalized_month(0);
        }
    }

    public int getDateOfHospitalized_year() {
        return dateOfHospitalized_year;
    }

    public void setDateOfHospitalized_year(int dateOfHospitalized_year) {
        try {
            System.out.println("Please enter date of hospitalized year : ");
            String sDay = keyboard.nextLine();
            dateOfHospitalized_year = Integer.parseInt(sDay);
            if (!sDay.matches(".*[0-9].*")) {
                System.out.println("Please use just digits.");
                Toolkit.getDefaultToolkit().beep();
                setDateOfHospitalized_year(0);
            } else if (dateOfHospitalized_year < 1900) {
                Toolkit.getDefaultToolkit().beep();
                this.dateOfHospitalized_year = 1900;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM employees WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.patients SET  dateOfHospitalized_year = '" + this.dateOfHospitalized_year + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else if (dateOfHospitalized_year >= Year.now().getValue()) {
                Toolkit.getDefaultToolkit().beep();
                this.dateOfHospitalized_year = Year.now().getValue();
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM employees WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.patients SET  dateOfHospitalized_year = '" + this.dateOfHospitalized_year + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                this.dateOfHospitalized_year = dateOfHospitalized_year;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM employees WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.patients SET  dateOfHospitalized_year = '" + this.dateOfHospitalized_year + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } catch (Exception e) {
            System.out.println("Please enter just digit!");
            Toolkit.getDefaultToolkit().beep();
            setDateOfHospitalized_year(0);
        }
    }

    public int getDateOfLeave_day() {
        return dateOfLeave_day;
    }

    public void setDateOfLeave_day(int dateOfLeave_day) {
        try {
            System.out.println("Please enter date of leave day : ");
            String sDay = keyboard.nextLine();
            dateOfLeave_day = Integer.parseInt(sDay);
            if (!sDay.matches(".*[0-9].*")) {
                System.out.println("Please use just digits.");
                Toolkit.getDefaultToolkit().beep();
                setDateOfLeave_day(0);
            } else if (dateOfLeave_day < 0) {
                Toolkit.getDefaultToolkit().beep();
                this.dateOfLeave_day = 1;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM employees WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.patients SET  dateOfLeave_day = '" + this.dateOfLeave_day + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else if (dateOfLeave_day >= 31) {
                Toolkit.getDefaultToolkit().beep();
                this.dateOfLeave_day = 31;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM employees WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.patients SET  dateOfLeave_day = '" + this.dateOfLeave_day + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                this.dateOfLeave_day = dateOfLeave_day;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM employees WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.patients SET  dateOfLeave_day = '" + this.dateOfLeave_day + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } catch (Exception e) {
            System.out.println("Please enter just digit!");
            Toolkit.getDefaultToolkit().beep();
            setDateOfLeave_day(0);
        }
    }

    public int getDateOfLeave_month() {
        return dateOfLeave_month;
    }

    public void setDateOfLeave_month(int dateOfLeave_month) {
        try {
            System.out.println("Please enter date of leave month : ");
            String sDay = keyboard.nextLine();
            dateOfLeave_month = Integer.parseInt(sDay);
            if (!sDay.matches(".*[0-9].*")) {
                System.out.println("Please use just digits.");
                Toolkit.getDefaultToolkit().beep();
                setDateOfLeave_month(0);
            } else if (dateOfLeave_month < 0) {
                Toolkit.getDefaultToolkit().beep();
                this.dateOfLeave_month = 1;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM employees WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.patients SET  dateOfLeave_month = '" + this.dateOfLeave_month + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else if (dateOfLeave_month >= 12) {
                Toolkit.getDefaultToolkit().beep();
                this.dateOfLeave_month = 12;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM employees WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.patients SET  dateOfLeave_month = '" + this.dateOfLeave_month + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");
                } catch (Exception e) {
                    System.out.println(e);
                }

            } else {
                this.dateOfLeave_month = dateOfLeave_month;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM employees WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.patients SET  dateOfLeave_month = '" + this.dateOfLeave_month + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");
                } catch (Exception e) {
                    System.out.println(e);
                }

            }
        } catch (Exception e) {
            System.out.println("Please enter just digit!");
            Toolkit.getDefaultToolkit().beep();
            setDateOfLeave_month(0);
        }
    }

    public int getDateOfLeave_year() {
        return dateOfLeave_year;
    }

    public void setDateOfLeave_year(int dateOfLeave_year) {
        try {
            System.out.println("Please enter date of leave year : ");
            String sDay = keyboard.nextLine();
            dateOfLeave_year = Integer.parseInt(sDay);
            if (!sDay.matches(".*[0-9].*")) {
                System.out.println("Please use just digits.");
                Toolkit.getDefaultToolkit().beep();
                setDateOfLeave_year(0);
            } else if (dateOfLeave_year < 1900) {
                Toolkit.getDefaultToolkit().beep();
                this.dateOfLeave_year = 1900;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM employees WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.patients SET  dateOfLeave_year = '" + this.dateOfLeave_year + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");
                } catch (Exception e) {
                    System.out.println(e);
                }

            } else if (dateOfLeave_year >= Year.now().getValue()) {
                Toolkit.getDefaultToolkit().beep();
                this.dateOfLeave_year = Year.now().getValue();
            } else {
                this.dateOfLeave_year = dateOfLeave_year;
            }
        } catch (Exception e) {
            System.out.println("Please enter just digit!");
            Toolkit.getDefaultToolkit().beep();
            setDateOfLeave_year(0);
        }
    }


    public Patient() {
    }

    public Patient(String department, int dateOfHospitalized_day, int dateOfHospitalized_month, int dateOfHospitalized_year,
                   int dateOfLeave_day, int dateOfLeave_month, int dateOfLeave_year) {
        this.department = department;
        this.dateOfHospitalized_day = dateOfHospitalized_day;
        this.dateOfHospitalized_month = dateOfHospitalized_month;
        this.dateOfHospitalized_year = dateOfHospitalized_year;
        this.dateOfLeave_day = dateOfLeave_day;
        this.dateOfLeave_month = dateOfLeave_month;
        this.dateOfLeave_year = dateOfLeave_year;
    }

    public String toString() {
        super.person_db();
        patient_db();
        return super.person.toString() + "\nPATIENT INFORMATION" + "\n--------------------------------------------\n"
                + "Department : " + getDepartment() + "\nDate of Hospitalized : " + getDateOfHospitalized_day() + "/" +
                getDateOfHospitalized_month() + "/" + getDateOfHospitalized_year() +
                "\nDate of Leave : " + getDateOfLeave_day() + "/" + getDateOfLeave_month() + "/" + getDateOfLeave_year()
                + "\nHospitalized Interval : " + hospitalizedInterval() + " Days"
                + "\n--------------------------------------------\n";
    }

    public void patient_db() {
        String citizenId = getCitizenId();

        try {
            DataBaseLayer.dataBaseLayer();
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            ResultSet myResult = myStatement.executeQuery("SELECT * FROM HospitalManagementSystemStock.dbo.patients WHERE patients.citizenId = '" + citizenId + "'");
            while (myResult.next()) {
                this.department = myResult.getString("department");
                this.dateOfHospitalized_day = myResult.getInt("dateOfHospitalized_day");
                this.dateOfHospitalized_month = myResult.getInt("dateOfHospitalized_month");
                this.dateOfHospitalized_year = myResult.getInt("dateOfHospitalized_year");
                this.dateOfLeave_day = myResult.getInt("dateOfLeave_day");
                this.dateOfLeave_month = myResult.getInt("dateOfLeave_month");
                this.dateOfLeave_year = myResult.getInt("dateOfLeave_year");
            }
            myStatement.close(); // close statement
            DataBaseLayer.myConnection.close(); // close connection
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public long hospitalizedInterval() {

        LocalDate hospitalizedDate = LocalDate.of(getDateOfHospitalized_year(), getDateOfHospitalized_month(), getDateOfHospitalized_day());
        LocalDate leaveDate = LocalDate.of(getDateOfLeave_year(), getDateOfLeave_month(), getDateOfLeave_day());

        LocalDate thisYearsBirthday = hospitalizedDate.with(Year.now());
        String birthdate = hospitalizedDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));   //17 February 2022
        long hospitalizedInterval = ChronoUnit.DAYS.between(hospitalizedDate, leaveDate);
        return hospitalizedInterval;
    }


    public void addPatient() {
        super.addPerson();
        setDepartment("Unknown");
        setDateOfHospitalized_day(1);
        setDateOfHospitalized_month(1);
        setDateOfHospitalized_year(1);
        setDateOfLeave_day(1);
        setDateOfLeave_month(1);
        setDateOfLeave_year(1);
    }

    public void viewPatient() {
        System.out.println(toString());
    }


    public void changeDepartment() {
        setDepartment("Unknown");
        System.out.println("New Department is " + getDepartment());
    }

    public void changeDateOfHospitalized_day() {
        setDateOfHospitalized_day(0);
        System.out.println("New DAY is " + getDateOfHospitalized_day());
    }

    public void changeDateOfHospitalized_month() {
        setDateOfHospitalized_month(0);
        System.out.println("New MONTH is " + getDateOfHospitalized_month());
    }

    public void changeDateOfHospitalized_year() {
        setDateOfHospitalized_year(0);
        System.out.println("New YEAR is " + getDateOfHospitalized_year());
    }

    public void changeDateOfLeave_day() {
        setDateOfLeave_day(0);
        System.out.println("New DAY is " + getDateOfLeave_day());
    }

    public void changeDateOfLeave_month() {
        setDateOfLeave_month(0);
        System.out.println("New MONTH is " + getDateOfLeave_month());
    }

    public void changeDateOfLeave_year() {
        setDateOfLeave_year(0);
        System.out.println("New YEAR is " + getDateOfLeave_year());
    }
}