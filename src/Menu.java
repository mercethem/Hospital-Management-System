import java.awt.*;
import java.util.Scanner;

public abstract class Menu {
    static Person person = new Person();
    static Employee employee = new Employee();
    static Patient patient = new Patient();
    static Management management = new Management();
    static Appointment appointment = new Appointment();

    public static void options() { //İlk yönlendirme metodudur
        System.out.println("Please choose what do you want ?");
        System.out.println("Add (0)\nView(1)\nChange(2)");
        Scanner keyboard = new Scanner(System.in);

        String input = keyboard.nextLine();

        if (input.matches("[0-2]*")) {
            int choose = Integer.parseInt(input);
            if (choose == 0) {
                System.out.println("For Person(0)\nFor Employee(1)\nFor Management(2)\nFor Patient(3)\n" +
                        "For Appointment(4)");
                input = keyboard.nextLine();
                if (input.matches("[0-4]*")) {
                    choose = Integer.parseInt(input);
                    if (choose == 0) {
                        person.addPerson();
                        options();
                    } else if (choose == 1) {
                        employee.addEmployee();
                        options();
                    } else if (choose == 2) {
                        management.addManagement();
                        options();
                    } else if (choose == 3) {
                        patient.addPatient();
                        options();
                    } else if (choose == 4) {
                        appointment.addAppointment();
                        options();
                    } else {
                        System.out.println("Please enter right number!\n");
                        Toolkit.getDefaultToolkit().beep();
                        options();
                    }
                } else {
                    System.out.println("Please enter right choose!\n");
                    Toolkit.getDefaultToolkit().beep();
                    options();
                }
            } else if (choose == 1) {
                System.out.println("For Person(0)\nFor Employee/Management(1)\nFor Patient(2)\nFor Appointment(3)");
                input = keyboard.nextLine();
                if (input.matches("[0-3]*")) {
                    choose = Integer.parseInt(input);
                    if (choose == 0) {
                        person.viewPerson();
                        options();
                    } else if (choose == 1) {
                        management.viewManagement();
                        // belirtir
                        options();
                    } else if (choose == 2) {
                        patient.viewPatient();
                        options();
                    } else if (choose == 3) {
                        appointment.viewAppointment();
                        options();
                    } else {
                        System.out.println("Please enter right number!\n");
                        Toolkit.getDefaultToolkit().beep();
                        options();
                    }
                } else {
                    System.out.println("Please enter right choose!\n");
                    Toolkit.getDefaultToolkit().beep();
                    options();
                }
            } else if (choose == 2) {
                System.out.println("For Person(0)\nFor Employee(1)\nFor Management(2)\nFor Patient(3)\nFor Appointment(4)\n");
                input = keyboard.nextLine();
                if (input.matches("[0-4]*")) {
                    choose = Integer.parseInt(input);
                    if (choose == 0) {
                        System.out.println("Please enter what do you want to change :\n" +
                                "Name(0)\nSurname(1)\nDay(2)\nMonth(3)\nYear(4)\nBloodGroup(5)\nAddress(6)\nPhoneNumber(7)\nEmail(8)");
                        input = keyboard.nextLine();
                        if (input.matches("[0-8]*")) {
                            choose = Integer.parseInt(input);
                            if (choose == 0) {
                                person.changeName();
                                options();
                            } else if (choose == 1) {
                                person.changeSurname();
                                options();
                            } else if (choose == 2) {
                                person.changeBirthdate_day();
                                options();
                            } else if (choose == 3) {
                                person.changeBirthdate_month();
                                options();
                            } else if (choose == 4) {
                                person.changeBirthdate_year();
                                options();
                            } else if (choose == 5) {
                                person.changeBloodGroup();
                                options();
                            } else if (choose == 6) {
                                person.changeAddress();
                                options();
                            } else if (choose == 7) {
                                person.changePhoneNumber();
                                options();
                            } else if (choose == 8) {
                                person.changeEmail();
                                options();
                            } else {
                                System.out.println("Please enter right number!");
                                Toolkit.getDefaultToolkit().beep();
                                options();
                            }
                        } else {
                            System.out.println("Please enter right choose!");
                            Toolkit.getDefaultToolkit().beep();
                            options();
                        }
                    } else if (choose == 1) {
                        System.out.println("Please enter what do you want to change :\n" +
                                "Department(0)\nDate of Start Day(1)\nDate of Start Month(2)\n" +
                                "Date of Start Year(3)\nDate of Dismiss Day(4)\nDate of Dismiss Month(5)\nDate of Dismiss Year(6)\n");
                        input = keyboard.nextLine();
                        if (input.matches("[0-6]*")) {
                            choose = Integer.parseInt(input);
                            if (choose == 0) {
                                employee.changeEmployeeDepartment();
                                options();
                            } else if (choose == 1) {
                                employee.changeDateOfStart_day();
                                options();
                            } else if (choose == 2) {
                                employee.changeDateOfStart_month();
                                options();
                            } else if (choose == 3) {
                                employee.changeDateOfStart_year();
                                options();
                            } else if (choose == 4) {
                                employee.changeDateOfDismiss_day();
                                options();
                            } else if (choose == 5) {
                                employee.changeDateOfDismiss_month();
                                options();
                            } else if (choose == 6) {
                                employee.changeDateOfDismiss_year();
                                options();
                            } else {
                                System.out.println("Please enter right number!");
                                Toolkit.getDefaultToolkit().beep();
                                options();
                            }
                        } else {
                            System.out.println("Please enter right choose!");
                            Toolkit.getDefaultToolkit().beep();
                            options();
                        }
                    } else if (choose == 2) {
                        System.out.println("Please enter what do you want to change :\n" +
                                "Management ID(0)\nManagement Department(1)\n");
                        input = keyboard.nextLine();
                        if (input.matches("[0]*")) {
                            choose = Integer.parseInt(input);
                            if (choose == 0) {
                                management.changeManagementDepartment();
                                options();
                            } else {
                                System.out.println("Please enter right number!");
                                Toolkit.getDefaultToolkit().beep();
                                options();
                            }
                        } else {
                            System.out.println("Please enter right choose!");
                            Toolkit.getDefaultToolkit().beep();
                            options();
                        }
                    } else if (choose == 3) {
                        System.out.println("Please enter what do you want to change :\n" +
                                "Department(0)\nDate of Hospitality Day(1)\nDate of Hospitality Month(2)\nDate of Hospitality Year(3)\n" +
                                "Date of Leave Day(4)\nDate of Leave Month(5)\nDate of Leave Year(6)\n");
                        input = keyboard.nextLine();
                        if (input.matches("[0-6]*")) {
                            choose = Integer.parseInt(input);
                            if (choose == 0) {
                                patient.changeDepartment();
                                options();
                            } else if (choose == 1) {
                                patient.changeDateOfHospitalized_day();
                                options();
                            } else if (choose == 2) {
                                patient.changeDateOfHospitalized_month();
                                options();
                            } else if (choose == 3) {
                                patient.changeDateOfHospitalized_year();
                                options();
                            } else if (choose == 4) {
                                patient.changeDateOfLeave_day();
                                options();
                            } else if (choose == 5) {
                                patient.changeDateOfLeave_month();
                                options();
                            } else if (choose == 6) {
                                patient.changeDateOfLeave_year();
                                options();
                            } else {
                                System.out.println("Please enter right number!");
                                Toolkit.getDefaultToolkit().beep();
                                options();
                            }
                        } else {
                            System.out.println("Please enter right choose!");
                            Toolkit.getDefaultToolkit().beep();
                            options();
                        }
                    } else if (choose == 4) {
                        System.out.println("Please enter what do you want to change :\n" +
                                "Doctor Name(0)\nDoctor Surname(1)\nAppointment Department(2)\nAppointment Day(3)\n" +
                                "Appointment month(4)\nAppointment Year(5)\n");
                        input = keyboard.nextLine();
                        if (input.matches("[0-5]*")) {
                            choose = Integer.parseInt(input);
                            if (choose == 0) {
                                appointment.changeDoctorName();
                                options();
                            } else if (choose == 1) {
                                appointment.changeDoctorSurname();
                                options();
                            } else if (choose == 2) {
                                appointment.changeAppointmentDepartment();
                                options();
                            } else if (choose == 3) {
                                appointment.changeAppointment_day();
                                options();
                            } else if (choose == 4) {
                                appointment.changeAppointment_month();
                                options();
                            } else if (choose == 5) {
                                appointment.changeAppointment_year();
                                options();
                            } else {
                                System.out.println("Please enter right number!");
                                Toolkit.getDefaultToolkit().beep();
                                options();
                            }
                        } else {
                            System.out.println("Please enter right choose!");
                            Toolkit.getDefaultToolkit().beep();
                            options();
                        }
                    } else {
                        System.out.println("Please enter right number!");
                        Toolkit.getDefaultToolkit().beep();
                        options();
                    }

                } else {
                    System.out.println("Please enter right choose!");
                    Toolkit.getDefaultToolkit().beep();
                    options();
                }
            } else {
                System.out.println("Please enter right choose!");
                Toolkit.getDefaultToolkit().beep();
                options();
            }
        } else {
            System.out.println("Please enter right choose!");
            Toolkit.getDefaultToolkit().beep();
            options();
        }
    }
}
