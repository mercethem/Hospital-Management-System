import java.awt.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Year;
import java.util.Scanner;

public class Appointment extends Patient {
    final private int APPOINTMENT_ID_DIGIT = 12;
    private String appointmentId;
    private String doctor_name;
    private String doctor_surname;
    private String appointment_department;
    private int appointment_day;
    private int appointment_month;
    private int appointment_year;


    Scanner keyboard = new Scanner(System.in);

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        try {
            System.out.println("Please enter appointment ID : ");
            appointmentId = keyboard.nextLine();

            if (appointmentId.matches("[0-9]*") && appointmentId.length() == APPOINTMENT_ID_DIGIT) {
                this.appointmentId = appointmentId;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM employees WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.appointments SET  appointmentId = '" + this.appointmentId + "' WHERE citizenId = '" + super.getCitizenId() + "'\n");
                    myStatement.close();
                    myStatement.close(); // close statement
                    DataBaseLayer.myConnection.close(); // close connection
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                System.out.println("Please just use numeric and" + APPOINTMENT_ID_DIGIT + " digit !");
                Toolkit.getDefaultToolkit().beep();
                setAppointmentId("");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void setDoctor_name(String doctor_name) {
        int count = 0;
        System.out.println("Please enter doctor name : ");
        doctor_name = keyboard.nextLine();

        if (doctor_name.length() < 3) {
            System.out.println("Please enter your true name!");
            Toolkit.getDefaultToolkit().beep();
            ++count;
        } else if (doctor_name.matches(".*\\p{Punct}.*")) {
            System.out.println("Please do not use punctuation character!");
            Toolkit.getDefaultToolkit().beep();
            ++count;
        } else if (doctor_name.matches(".*[0-9].*")) {
            System.out.println("Please do not use digit!");
            Toolkit.getDefaultToolkit().beep();
            ++count;
        } else {
            this.doctor_name = doctor_name;
            try {
                DataBaseLayer.dataBaseLayer();
                Statement myStatement = DataBaseLayer.myConnection.createStatement();
                myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM persons WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                        "    UPDATE HospitalManagementSystemStock.dbo.appointments SET  doctorName = '" + this.doctor_name + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");
                myStatement.close(); // close statement
                DataBaseLayer.myConnection.close(); // close connection
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if (count == 1) {
            setDoctor_name("");
        }
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_surname(String doctor_surname) {
        int count = 0;
        System.out.println("Please enter doctor surname : ");
        doctor_surname = keyboard.nextLine();

        if (doctor_surname.length() < 2) {
            System.out.println("Please enter your true name!");
            Toolkit.getDefaultToolkit().beep();
            ++count;
        } else if (doctor_surname.matches(".*\\p{Punct}.*")) {
            System.out.println("Please do not use punctuation character!");
            Toolkit.getDefaultToolkit().beep();
            ++count;
        } else if (doctor_surname.matches(".*[0-9].*")) {
            System.out.println("Please do not use digit!");
            Toolkit.getDefaultToolkit().beep();
            ++count;
        } else {
            this.doctor_surname = doctor_surname;
            try {
                DataBaseLayer.dataBaseLayer();
                Statement myStatement = DataBaseLayer.myConnection.createStatement();
                myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM persons WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                        "    UPDATE HospitalManagementSystemStock.dbo.appointments SET  doctorSurname = '" + this.doctor_surname + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");
                myStatement.close(); // close statement
                DataBaseLayer.myConnection.close(); // close connection
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if (count == 1) {
            setDoctor_surname("");
        }
    }

    public String getDoctor_surname() {
        return doctor_surname;
    }

    public String getAppointmentDepartment() {
        return appointment_department;
    }

    public void setAppointmentDepartment(String appointment_department) {
        int count = 0;
        System.out.println("Please enter department : ");
        appointment_department = keyboard.nextLine();

        if (appointment_department.length() < 2) {
            System.out.println("Please enter your true department!");
            Toolkit.getDefaultToolkit().beep();
            ++count;
        } else if (appointment_department.matches(".*\\p{Punct}.*")) {
            System.out.println("Please do not use punctuation character!");
            Toolkit.getDefaultToolkit().beep();
            ++count;
        } else if (appointment_department.matches(".*[0-9].*")) {
            System.out.println("Please do not use digit!");
            Toolkit.getDefaultToolkit().beep();
            ++count;
        } else {
            this.appointment_department = appointment_department;
            try {
                DataBaseLayer.dataBaseLayer();
                Statement myStatement = DataBaseLayer.myConnection.createStatement();
                myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM employees WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                        "    UPDATE HospitalManagementSystemStock.dbo.employees SET  department = '" + this.appointment_department + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");
                myStatement.close(); // close statement
                DataBaseLayer.myConnection.close(); // close connection
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if (count == 1) {
            setAppointmentDepartment("");
        }
    }

    public void setAppointment_day(int appointment_day) {
        try {
            System.out.println("Please enter appointment day : ");
            String sDay = keyboard.nextLine();
            appointment_day = Integer.parseInt(sDay);
            if (!sDay.matches(".*[0-9].*")) {
                System.out.println("Please use just digits.");
                Toolkit.getDefaultToolkit().beep();
                setAppointment_day(0);
            } else if (appointment_day < 0) {
                Toolkit.getDefaultToolkit().beep();
                this.appointment_day = 1;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM persons WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.appointments SET  appointment_day = '" + this.appointment_day + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");
                    myStatement.close(); // close statement
                    DataBaseLayer.myConnection.close(); // close connection
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else if (appointment_day >= 31) {
                Toolkit.getDefaultToolkit().beep();
                this.appointment_day = 31;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM persons WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.appointments SET  appointment_day = '" + this.appointment_day + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");
                    myStatement.close(); // close statement
                    DataBaseLayer.myConnection.close(); // close connection
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                this.appointment_day = appointment_day;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM persons WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.appointments SET  appointment_day = '" + this.appointment_day + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");
                    myStatement.close(); // close statement
                    DataBaseLayer.myConnection.close(); // close connection
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } catch (Exception e) {
            System.out.println("Please enter just digit!");
            Toolkit.getDefaultToolkit().beep();
            setAppointment_day(0);
        }
    }

    public int getAppointment_day() {
        return appointment_day;
    }

    public void setAppointment_month(int appointment_month) {
        try {
            System.out.println("Please enter appointment month : ");
            String sMonth = keyboard.nextLine();
            appointment_month = Integer.parseInt(sMonth);
            if (!sMonth.matches(".*[0-9].*")) {
                System.out.println("Please use just digits.");
                Toolkit.getDefaultToolkit().beep();
                setAppointment_month(1);
            } else if (appointment_month < 0) {
                Toolkit.getDefaultToolkit().beep();
                this.appointment_month = 1;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM persons WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.appointments SET  appointment_month = '" + this.appointment_month + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");
                    myStatement.close(); // close statement
                    DataBaseLayer.myConnection.close(); // close connection
                } catch (Exception e) {
                    System.out.println(e);
                }

            } else if (appointment_month >= 12) {
                Toolkit.getDefaultToolkit().beep();
                this.appointment_month = 12;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM persons WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.appointments SET  appointment_month = '" + this.appointment_month + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");
                    myStatement.close(); // close statement
                    DataBaseLayer.myConnection.close(); // close connection
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                this.appointment_month = appointment_month;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM persons WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.appointments SET  appointment_month = '" + this.appointment_month + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");
                    myStatement.close(); // close statement
                    DataBaseLayer.myConnection.close(); // close connection
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } catch (Exception e) {
            System.out.println("Please enter just digit!");
            Toolkit.getDefaultToolkit().beep();
            setAppointment_month(1);
        }
    }

    public int getAppointment_month() {
        return appointment_month;
    }

    public void setAppointment_year(int appointment_year) {
        try {
            System.out.println("Please enter appointment year : ");
            String sYear = keyboard.nextLine();
            appointment_year = Integer.parseInt(sYear);
            if (!sYear.matches(".*[0-9].*")) {
                System.out.println("Please use just digits.");
                Toolkit.getDefaultToolkit().beep();
                setAppointment_year(1);
            } else if (appointment_year < 1900) {
                Toolkit.getDefaultToolkit().beep();
                this.appointment_year = 1900;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM persons WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.appointments SET  appointment_year = '" + this.appointment_year + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");
                    myStatement.close(); // close statement
                    DataBaseLayer.myConnection.close(); // close connection
                } catch (Exception e) {
                    System.out.println(e);
                }

            } else if (appointment_year >= Year.now().getValue()) {
                Toolkit.getDefaultToolkit().beep();
                this.appointment_year = Year.now().getValue();
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM persons WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.appointments SET  appointment_year = '" + this.appointment_year + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");
                    myStatement.close(); // close statement
                    DataBaseLayer.myConnection.close(); // close connection
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                this.appointment_year = appointment_year;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getCitizenId() + "' =(SELECT citizenId FROM persons WHERE citizenId = '" + super.getCitizenId() + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.appointments SET  appointment_year = '" + this.appointment_year + "' WHERE citizenId= '" + super.getCitizenId() + "'\n");
                    myStatement.close(); // close statement
                    DataBaseLayer.myConnection.close(); // close connection
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } catch (Exception e) {
            System.out.println("Please enter just digit!");
            Toolkit.getDefaultToolkit().beep();
            setAppointment_year(1);
        }
    }

    public int getAppointment_year() {
        return appointment_year;
    }

    public Appointment() {
    }

    public Appointment(String appointmentId, String doctor_name, String doctor_surname, String appointment_department,
                       int appointment_day, int appointment_month, int appointment_year) {

        this.appointmentId = appointmentId;
        this.doctor_name = doctor_name;
        this.doctor_surname = doctor_surname;
        this.appointment_department = appointment_department;
        this.appointment_day = appointment_day;
        this.appointment_month = appointment_month;
        this.appointment_year = appointment_year;
    }

    public String toString() {
        super.person_db();
        appointment_db();
        return "\nAPPOINTMENT INFORMATION" + "\n--------------------------------------------\n"
                + "Appointment ID : " + getAppointmentId() + "\nDoctor Name : " + getDoctor_name() +
                "\nDoctor Surname : " + getDoctor_surname() + "\nDepartment : " + getAppointmentDepartment() +
                "\nAppointment Date : " + getAppointment_day() + "/" + getAppointment_month() + "/" + getAppointment_year()
                + "\n--------------------------------------------\n";
    }

    public void appointment_db() {
        String citizenId = getCitizenId();

        try {
            DataBaseLayer.dataBaseLayer();
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            ResultSet myResult = myStatement.executeQuery("SELECT * FROM HospitalManagementSystemStock.dbo.appointments WHERE appointments.citizenId = '" + citizenId + "'");
            while (myResult.next()) {
                this.appointmentId = myResult.getString("appointmentId");
                this.doctor_name = myResult.getString("doctorName");
                this.doctor_surname = myResult.getString("doctorSurname");
                this.appointment_department = myResult.getString("department");
                this.appointment_day = myResult.getInt("appointment_day");
                this.appointment_month = myResult.getInt("appointment_month");
                this.appointment_year = myResult.getInt("appointment_year");
            }
            myStatement.close(); // close statement
            DataBaseLayer.myConnection.close(); // close connection
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addAppointment() {
        super.addPerson();
        setAppointmentId("Unknown");
        setDoctor_name("Unknown");
        setDoctor_surname("Unknown");
        setAppointmentDepartment("Unknown");
        setAppointment_day(1);
        setAppointment_month(1);
        setAppointment_year(1);
    }

    public void viewAppointment() {
        System.out.println(toString());
    }

    public void changeAppointmentId() {
        setAppointmentId("Unknown");
        System.out.println("New Appointment ID is " + getAppointmentId());
    }

    public void changeDoctorName() {
        setDoctor_name("Unknown");
        System.out.println("New NAME is " + getDoctor_name());
    }

    public void changeDoctorSurname() {
        setDoctor_surname("Unknown");
        System.out.println("New SURNAME is " + getDoctor_surname());
    }

    public void changeAppointmentDepartment() {
        setDepartment("Unknown");
        System.out.println("New Department is " + getAppointmentDepartment());
    }


    public void changeAppointment_day() {
        setAppointment_day(0);
        System.out.println("New DAY is " + getAppointment_day());
    }

    public void changeAppointment_month() {
        setAppointment_month(0);
        System.out.println("New MONTH is " + getAppointment_month());
    }

    public void changeAppointment_year() {
        setAppointment_year(0);
        System.out.println("New YEAR is " + getAppointment_year());
    }
}
