import java.awt.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;


public class Employee extends Person {
    static Employee employee = new Employee("012345678", "Software Engineering",
            1, 1, 2022, 1, 1, 2023);

    Scanner keyboard = new Scanner(System.in);
    final private int EMPLOYEE_ID_DIGIT = 9;
    private String employeeId;
    private String department;
    private int dateOfStart_day;
    private int dateOfStart_month;
    private int dateOfStart_year;
    private int dateOfDismiss_day;
    private int dateOfDismiss_month;
    private int dateOfDismiss_year;


    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        try {
            System.out.println("Please enter citizen ID : ");
            employeeId = keyboard.nextLine();

            if (employeeId.matches("[0-9]*") && employeeId.length() == EMPLOYEE_ID_DIGIT) {
                this.employeeId = employeeId;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM employees WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.employees SET  employeeId = '" + this.employeeId + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");

                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                System.out.println("Please just use numeric and" + EMPLOYEE_ID_DIGIT + " digit !");
                Toolkit.getDefaultToolkit().beep();
                setEmployeeId("");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

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
                        "    UPDATE HospitalManagementSystemStock.dbo.employees SET  department = '" + this.department + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");

            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if (count == 1) {
            setDepartment("");
        }

    }

    public int getDateOfStart_day() {
        return dateOfStart_day;
    }

    public void setDateOfStart_day(int dateOfStart_day) {
        try {
            System.out.println("Please enter date of start day : ");
            String sDay = keyboard.nextLine();
            dateOfStart_day = Integer.parseInt(sDay);
            if (!sDay.matches(".*[0-9].*")) {
                System.out.println("Please use just digits.");
                Toolkit.getDefaultToolkit().beep();
                setDateOfStart_day(0);
            } else if (dateOfStart_day < 0) {
                Toolkit.getDefaultToolkit().beep();
                this.dateOfStart_day = 1;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM employees WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.employees SET  dateOfStart_day = '" + this.dateOfStart_day + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");

                } catch (Exception e) {
                    System.out.println(e);
                }
            } else if (dateOfStart_day >= 31) {
                Toolkit.getDefaultToolkit().beep();
                this.dateOfStart_day = 31;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM employees WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.employees SET  dateOfStart_day = '" + this.dateOfStart_day + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");

                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                this.dateOfStart_day = dateOfStart_day;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM employees WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.employees SET  dateOfStart_day = '" + this.dateOfStart_day + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } catch (Exception e) {
            System.out.println("Please enter just digit!");
            Toolkit.getDefaultToolkit().beep();
            setDateOfStart_day(0);
        }
    }

    public int getDateOfStart_month() {
        return dateOfStart_month;
    }

    public void setDateOfStart_month(int dateOfStart_month) {
        try {
            System.out.println("Please enter date of start month : ");
            String sMonth = keyboard.nextLine();
            dateOfStart_month = Integer.parseInt(sMonth);
            if (!sMonth.matches(".*[0-9].*")) {
                System.out.println("Please use just digits.");
                Toolkit.getDefaultToolkit().beep();
                setDateOfStart_month(1);
            } else if (dateOfStart_month < 0) {
                Toolkit.getDefaultToolkit().beep();
                this.dateOfStart_month = 1;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM employees WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.employees SET  dateOfStart_month = '" + this.dateOfStart_month + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");

                } catch (Exception e) {
                    System.out.println(e);
                }
            } else if (dateOfStart_month >= 12) {
                Toolkit.getDefaultToolkit().beep();
                this.dateOfStart_month = 12;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM employees WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.employees SET  dateOfStart_month = '" + this.dateOfStart_month + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");

                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                this.dateOfStart_month = dateOfStart_month;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM employees WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.employees SET  dateOfStart_month = '" + this.dateOfStart_month + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");

                } catch (Exception e) {
                    System.out.println(e);
                }

            }
        } catch (Exception e) {
            System.out.println("Please enter just digit!");
            Toolkit.getDefaultToolkit().beep();
            setDateOfStart_month(1);
        }
    }

    public int getDateOfStart_year() {
        return dateOfStart_year;
    }

    public void setDateOfStart_year(int dateOfStart_year) {
        try {
            System.out.println("Please enter date of start year : ");
            String sYear = keyboard.nextLine();
            dateOfStart_year = Integer.parseInt(sYear);
            if (!sYear.matches(".*[0-9].*")) {
                System.out.println("Please use just digits.");
                Toolkit.getDefaultToolkit().beep();
                setDateOfStart_year(1);
            } else if (dateOfStart_year < 1900) {
                Toolkit.getDefaultToolkit().beep();
                this.dateOfStart_year = 1900;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM employees WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.employees SET  dateOfStart_year = '" + this.dateOfStart_year + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");

                } catch (Exception e) {
                    System.out.println(e);
                }
            } else if (dateOfStart_year >= Year.now().getValue()) {
                Toolkit.getDefaultToolkit().beep();
                this.dateOfStart_year = Year.now().getValue();
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM employees WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.employees SET  dateOfStart_year = '" + this.dateOfStart_year + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");

                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                this.dateOfStart_year = dateOfStart_year;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM employees WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.employees SET  dateOfStart_year = '" + this.dateOfStart_year + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } catch (Exception e) {
            System.out.println("Please enter just digit!");
            Toolkit.getDefaultToolkit().beep();
            setDateOfStart_year(1);
        }

    }

    public int getDateOfDismiss_day() {
        return dateOfDismiss_day;
    }

    public void setDateOfDismiss_day(int dateOfDismiss_day) {
        try {
            System.out.println("Please enter date of dismissal day : ");
            String sDay = keyboard.nextLine();
            dateOfDismiss_day = Integer.parseInt(sDay);
            if (!sDay.matches(".*[0-9].*")) {
                System.out.println("Please use just digits.");
                Toolkit.getDefaultToolkit().beep();
                setDateOfDismiss_day(0);
            } else if (dateOfDismiss_day < 0) {
                Toolkit.getDefaultToolkit().beep();
                this.dateOfDismiss_day = 1;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM employees WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.employees SET  dateOfDismiss_day = '" + this.dateOfDismiss_day + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");

                } catch (Exception e) {
                    System.out.println(e);
                }
            } else if (dateOfDismiss_day >= 31) {
                Toolkit.getDefaultToolkit().beep();
                this.dateOfDismiss_day = 31;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM employees WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.employees SET  dateOfDismiss_day = '" + this.dateOfDismiss_day + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");

                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                this.dateOfDismiss_day = dateOfDismiss_day;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM employees WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.employees SET  dateOfDismiss_day = '" + this.dateOfDismiss_day + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } catch (Exception e) {
            System.out.println("Please enter just digit!");
            Toolkit.getDefaultToolkit().beep();
            setDateOfDismiss_day(0);
        }
    }

    public int getDateOfDismiss_month() {
        return dateOfDismiss_month;
    }

    public void setDateOfDismiss_month(int dateOfDismiss_month) {
        try {
            System.out.println("Please enter date of dismissal month : ");
            String sMonth = keyboard.nextLine();
            dateOfDismiss_month = Integer.parseInt(sMonth);
            if (!sMonth.matches(".*[0-9].*")) {
                System.out.println("Please use just digits.");
                Toolkit.getDefaultToolkit().beep();
                setDateOfDismiss_month(1);
            } else if (dateOfDismiss_month < 0) {
                Toolkit.getDefaultToolkit().beep();
                this.dateOfDismiss_month = 1;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM employees WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.employees SET  dateOfDismiss_month = '" + this.dateOfDismiss_month + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");

                } catch (Exception e) {
                    System.out.println(e);
                }
            } else if (dateOfDismiss_month >= 12) {
                Toolkit.getDefaultToolkit().beep();
                this.dateOfDismiss_month = 12;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM employees WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.employees SET  dateOfDismiss_month = '" + this.dateOfDismiss_month + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");

                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                this.dateOfDismiss_month = dateOfDismiss_month;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM employees WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.employees SET  dateOfDismiss_month = '" + this.dateOfDismiss_month + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } catch (Exception e) {
            System.out.println("Please enter just digit!");
            Toolkit.getDefaultToolkit().beep();
            setDateOfDismiss_month(1);
        }
    }

    public int getDateOfDismiss_year() {
        return dateOfDismiss_year;
    }

    public void setDateOfDismiss_year(int dateOfDismiss_year) {
        try {
            System.out.println("Please enter date of dismissal year : ");
            String sYear = keyboard.nextLine();
            dateOfDismiss_year = Integer.parseInt(sYear);
            if (!sYear.matches(".*[0-9].*")) {
                System.out.println("Please use just digits.");
                Toolkit.getDefaultToolkit().beep();
                setDateOfDismiss_year(1);
            } else if (dateOfDismiss_year < 2000) {
                Toolkit.getDefaultToolkit().beep();
                this.dateOfDismiss_year = 2000;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM employees WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.employees SET  dateOfDismiss_year = '" + this.dateOfDismiss_year + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");

                } catch (Exception e) {
                    System.out.println(e);
                }
            } else if (dateOfDismiss_year >= Year.now().getValue()) {
                Toolkit.getDefaultToolkit().beep();
                this.dateOfDismiss_year = Year.now().getValue();
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM employees WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.employees SET  dateOfDismiss_year = '" + this.dateOfDismiss_year + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");

                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                this.dateOfDismiss_year = dateOfDismiss_year;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM employees WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.employees SET  dateOfDismiss_year = '" + this.dateOfDismiss_year + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } catch (Exception e) {
            System.out.println("Please enter just digit!");
            Toolkit.getDefaultToolkit().beep();
            setDateOfDismiss_year(1);
        }
    }

    public long workInterval() {

        LocalDate hospitalizedDate = LocalDate.of(getDateOfStart_year(), getDateOfStart_month(), getDateOfStart_day());
        LocalDate leaveDate = LocalDate.of(getDateOfDismiss_year(), getDateOfDismiss_month(), getDateOfDismiss_day());

        LocalDate thisYearsBirthday = hospitalizedDate.with(Year.now());
        String birthdate = hospitalizedDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));   //17 February 2022
        long workInterval = ChronoUnit.YEARS.between(hospitalizedDate, leaveDate);
        return workInterval;
    }

    public String toString() {
        super.person_db();
        employee_db();
        return  super.person.toString() + "\nEMPLOYEE INFORMATION" + "\n--------------------------------------------\n"
                + "Employee ID : " + getEmployeeId() + "\nDepartment : " + getDepartment() +
                "\nDate of Start : " + getDateOfStart_day() + "/" + getDateOfStart_month() + "/" + getDateOfStart_year() +
                "\nDate of Dismiss : " + getDateOfDismiss_day() + "/" + getDateOfDismiss_month() + "/" + getDateOfDismiss_year()
                + "\nWork Interval : " + workInterval() + " Years"
                + "\n--------------------------------------------\n";
    }

    public Employee() {
    }

    public Employee(String employeeId, String department, int dateOfStart_day, int dateOfStart_month, int dateOfStart_year,
                    int dateOfDismiss_day, int dateOfDismiss_month, int dateOfDismiss_year) {

        this.employeeId = employeeId;
        this.department = department;
        this.dateOfStart_day = dateOfStart_day;
        this.dateOfStart_month = dateOfStart_month;
        this.dateOfStart_year = dateOfStart_year;
        this.dateOfDismiss_day = dateOfDismiss_day;
        this.dateOfDismiss_month = dateOfDismiss_month;
        this.dateOfDismiss_year = dateOfDismiss_year;
    }

    public void employee_db() {
        String citizenId = person.getCitizenId();

        try {
            DataBaseLayer.dataBaseLayer();
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            ResultSet myResult = myStatement.executeQuery("SELECT * FROM HospitalManagementSystemStock.dbo.employees WHERE employees.citizenId = '" + citizenId + "'");
            while (myResult.next()) {
                this.employeeId = myResult.getString("employeeId");
                this.department = myResult.getString("department");
                this.dateOfStart_day = myResult.getInt("dateOfStart_day");
                this.dateOfStart_month = myResult.getInt("dateOfStart_month");
                this.dateOfStart_year= myResult.getInt("dateOfStart_year");
                this.dateOfDismiss_day = myResult.getInt("dateOfDismiss_day");
                this.dateOfDismiss_month = myResult.getInt("dateOfDismiss_month");
                this.dateOfDismiss_year = myResult.getInt("dateOfDismiss_year");
            }
            myStatement.close(); // close statement
            DataBaseLayer.myConnection.close(); // close connection
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addEmployee() {
        super.addPerson();
        setEmployeeId("Unknown");
        setDepartment("Unknown");
        setDateOfStart_day(1);
        setDateOfStart_month(1);
        setDateOfStart_year(1);
        setDateOfDismiss_day(1);
        setDateOfDismiss_month(1);
        setDateOfDismiss_year(1);
    }

    public void viewEmployee() {
        System.out.println(toString());
    }

    public void changeEmployeeId() {
        setEmployeeId("Unknown");
        System.out.println("New Employee ID is " + getEmployeeId());
    }

    public void changeDepartment() {
        setDepartment("Unknown");
        System.out.println("New Department is " + getDepartment());
    }

    public void changeDateOfStart_day() {
        setDateOfStart_day(0);
        System.out.println("New DAY is " + getDateOfStart_day());
    }

    public void changeDateOfStart_month() {
        setDateOfStart_month(0);
        System.out.println("New MONTH is " + getDateOfStart_month());
    }

    public void changeDateOfStart_year() {
        setDateOfStart_year(0);
        System.out.println("New YEAR is " + getDateOfStart_year());
    }

    public void changeDateOfDismiss_day() {
        setDateOfDismiss_day(0);
        System.out.println("New DAY is " + getDateOfDismiss_day());
    }

    public void changeDateOfDismiss_month() {
        setDateOfDismiss_month(0);
        System.out.println("New MONTH is " + getDateOfDismiss_month());
    }

    public void changeDateOfDismiss_year() {
        setDateOfDismiss_year(0);
        System.out.println("New YEAR is " + getDateOfDismiss_year());
    }
}