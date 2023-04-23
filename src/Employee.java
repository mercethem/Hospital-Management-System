import java.awt.*;
import java.time.Year;

public class Employee extends Person {
    final private int EMPLOYEE_ID_DIGIT = 11;
    private String employeeId;
    private String department;
    private int dateOfStart_day;
    private int dateOfStart_month;
    private int dateOfStart_year;
    private int dismissalDate_day;
    private int dismissalDate_month;
    private int dismissalDate_year;


    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        try {
            System.out.println("Please enter citizen ID : ");
            employeeId = keyboard.nextLine();

            if (employeeId.matches("[0-9]*") && employeeId.length() == EMPLOYEE_ID_DIGIT) {
                this.employeeId = employeeId;
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
        }
        if (count == 1) {
            setDepartment("");
        }

    }


    public Employee() {
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
            } else if (dateOfStart_day >= 31) {
                Toolkit.getDefaultToolkit().beep();
                this.dateOfStart_day = 31;
            } else {
                this.dateOfStart_day = dateOfStart_day;
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
            } else if (dateOfStart_month >= 12) {
                Toolkit.getDefaultToolkit().beep();
                this.dateOfStart_month = 12;
            } else {
                this.dateOfStart_month = dateOfStart_month;
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
            } else if (dateOfStart_year >= Year.now().getValue()) {
                Toolkit.getDefaultToolkit().beep();
                this.dateOfStart_year = Year.now().getValue();
            } else {
                this.dateOfStart_year = dateOfStart_year;
            }
        } catch (Exception e) {
            System.out.println("Please enter just digit!");
            Toolkit.getDefaultToolkit().beep();
            setDateOfStart_year(1);
        }

    }

    public int dismissalDate_day() {
        return dismissalDate_day;
    }

    public void setDismissalDate_day(int dismissalDate_day) {
        try {
            System.out.println("Please enter date of dismissal day : ");
            String sDay = keyboard.nextLine();
            dismissalDate_day = Integer.parseInt(sDay);
            if (!sDay.matches(".*[0-9].*")) {
                System.out.println("Please use just digits.");
                Toolkit.getDefaultToolkit().beep();
                setDismissalDate_day(0);
            } else if (dismissalDate_day < 0) {
                Toolkit.getDefaultToolkit().beep();
                this.dismissalDate_day = 1;
            } else if (dismissalDate_day >= 31) {
                Toolkit.getDefaultToolkit().beep();
                this.dismissalDate_day = 31;
            } else {
                this.dismissalDate_day = dismissalDate_day;
            }
        } catch (Exception e) {
            System.out.println("Please enter just digit!");
            Toolkit.getDefaultToolkit().beep();
            setDismissalDate_day(0);
        }
    }

    public int getDismissalDate_month() {
        return dismissalDate_month;
    }

    public void setDismissalDate_month(int dismissalDate_month) {
        try {
            System.out.println("Please enter date of dismissal month : ");
            String sMonth = keyboard.nextLine();
            dismissalDate_month = Integer.parseInt(sMonth);
            if (!sMonth.matches(".*[0-9].*")) {
                System.out.println("Please use just digits.");
                Toolkit.getDefaultToolkit().beep();
                setDismissalDate_month(1);
            } else if (dismissalDate_month < 0) {
                Toolkit.getDefaultToolkit().beep();
                this.dismissalDate_month = 1;
            } else if (dismissalDate_month >= 12) {
                Toolkit.getDefaultToolkit().beep();
                this.dismissalDate_month = 12;
            } else {
                this.dismissalDate_month = dismissalDate_month;
            }
        } catch (Exception e) {
            System.out.println("Please enter just digit!");
            Toolkit.getDefaultToolkit().beep();
            setDismissalDate_month(1);
        }
    }

    public int getDismissalDate_year() {
        return dismissalDate_year;
    }

    public void setDismissalDate_year(int dismissalDate_year) {
        try {
            System.out.println("Please enter date of dismissal year : ");
            String sYear = keyboard.nextLine();
            dismissalDate_year = Integer.parseInt(sYear);
            if (!sYear.matches(".*[0-9].*")) {
                System.out.println("Please use just digits.");
                Toolkit.getDefaultToolkit().beep();
                setDismissalDate_year(1);
            } else if (dismissalDate_year < 2000) {
                Toolkit.getDefaultToolkit().beep();
                this.dismissalDate_year = 2000;
            } else if (dismissalDate_year >= Year.now().getValue()) {
                Toolkit.getDefaultToolkit().beep();
                this.dismissalDate_year = Year.now().getValue();
            } else {
                this.dismissalDate_year = dismissalDate_year;
            }
        } catch (Exception e) {
            System.out.println("Please enter just digit!");
            Toolkit.getDefaultToolkit().beep();
            setDismissalDate_year(1);
        }
    }
}