import java.awt.*;
import java.sql.Statement;
import java.time.Year;
import java.util.Scanner;

public class Appointment extends Person  {
    final private int APPOINTMENT_ID_DIGIT = 12;
    private String appointmentId;
    private String doctor_name;
    private String doctor_surname;
    private String department;
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

    public int getBirthdate_day() {
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
}
