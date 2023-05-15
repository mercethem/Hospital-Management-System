import java.awt.*;
import java.util.Scanner;

public abstract class Menu {
    static Person person = new Person();

    static Employee employee = new Employee();

    static Patient patient = new Patient();

    public static void options() {
        System.out.println("Please choose what do you want ?");
        System.out.println("Add (0)\nView(1)\nChange(2)");
        Scanner keyboard = new Scanner(System.in);

        int choose = keyboard.nextInt();

        if (choose == 0) {
            System.out.println("For Person(0)\nFor Employee(1)\nFor Patient(2)\n");
            choose = keyboard.nextInt();
            if (choose == 0) {
                person.addPerson();
                System.out.println(person);
                options();
            } else if (choose == 1) {
                employee.addEmployee();
                System.out.println(employee);
                options();
            } else if (choose == 2) {
                patient.addPatient();
                System.out.println(patient);
                options();
            } else {
                System.out.println("Please enter right number!\n");
                Toolkit.getDefaultToolkit().beep();
                options();
            }
        } else if (choose == 1) {
            System.out.println("For Person(0)\nFor Employee(1)\nFor Patient(2)\n");
            choose = keyboard.nextInt();
            if (choose == 0) {
                person.viewPerson();
                options();
            } else if (choose == 1) {
                employee.viewEmployee();
                options();
            } else if (choose == 2) {
                patient.viewPatient();
                options();
            } else {
                System.out.println("Please enter right number!\n");
                Toolkit.getDefaultToolkit().beep();
                options();
            }
        } else if (choose == 2) {
            System.out.println("For Person(0)\nFor Employee(1)\nFor Patient(2)\n");
            choose = keyboard.nextInt();
            if (choose == 0) {
                System.out.println("Please enter what do you want to change :\n" +
                        "Name(0)\nSurname(1)\nDay(2)\nMonth(3)\nYear(4)\nBloodGroup(5)\nAddress(6)\nPhoneNumber(7)\nEmail(8)");
                choose = keyboard.nextInt();
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
            } else if (choose == 1) {
                System.out.println("Please enter what do you want to change :\n" +
                        "Employee ID(0)\nDepartment(1)\nDate of Start Day(2)\nDate of Start Month(3)\n" +
                        "Date of Start Year(4)\nDate of Dismiss Day(5)\nDate of Dismiss Month(6)\nDate of Dismiss Year(7)\n");
                choose = keyboard.nextInt();
                if (choose == 0) {
                    employee.changeEmployeeId();
                    options();
                } else if (choose == 1) {
                    employee.changeDepartment();
                    options();
                } else if (choose == 2) {
                    employee.changeDateOfStart_day();
                    options();
                } else if (choose == 3) {
                    employee.changeDateOfStart_month();
                    options();
                } else if (choose == 4) {
                    employee.changeDateOfStart_year();
                    options();
                } else if (choose == 5) {
                    employee.changeDateOfDismiss_day();
                    options();
                } else if (choose == 6) {
                    employee.changeDateOfDismiss_month();
                    options();
                } else if (choose == 7) {
                    employee.changeDateOfDismiss_year();
                    options();
                } else {
                    System.out.println("Please enter right number!");
                    Toolkit.getDefaultToolkit().beep();
                    options();
                }
            } else if (choose == 2) {
                System.out.println("Please enter what do you want to change :\n" +
                        "Department(0)\nDate of Hospitality Day(1)\nDate of Hospitality Month(2)\nDate of Hospitality Year(3)\n" +
                        "Date of Leave Day(4)\nDate of Leave Month(5)\nDate of Leave Year(6)\n");
                choose = keyboard.nextInt();
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
                System.out.println("Please enter right number!");
                Toolkit.getDefaultToolkit().beep();
                options();
            }
        }
    }
}
