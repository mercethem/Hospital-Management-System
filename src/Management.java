import java.awt.*;
import java.sql.Statement;
import java.util.Scanner;

public class Management extends Employee {

    Scanner keyboard = new Scanner(System.in);
    final private int MANAGEMENT_ID_DIGIT = 9;
    private String managementId;
    private String department;



    public String getManagementId() {
        return managementId;
    }

    public void setManagementId(String managementId) {
        try {
            System.out.println("Please enter Employee ID : ");
            managementId = keyboard.nextLine();

            if (managementId.matches("[0-9]*") && managementId.length() == MANAGEMENT_ID_DIGIT) {
                this.managementId = managementId;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getEmployeeId() + "' =(SELECT employeeId FROM employees WHERE employeeId = '" + super.getEmployeeId() + "') )\n" +
                            "    UPDATE HospitalManagementSystemStock.dbo.managements SET  managemenId = '" + this.managementId + "' WHERE employeeId = '" + super.getEmployeeId() + "'\n");

                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                System.out.println("Please just use numeric and" + MANAGEMENT_ID_DIGIT + " digit !");
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
    public void setDepartment(String  department) {
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
                myStatement.executeQuery("IF ( '" + super.getEmployeeId() + "' =(SELECT employeeId FROM employees WHERE employeeId = '" + super.getEmployeeId() + "') )\n" +
                        "    UPDATE HospitalManagementSystemStock.dbo.managements SET  department = '" + this.department + "' WHERE employeeId = '" + super.getEmployeeId() + "'\n");

            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if (count == 1) {
            setDepartment("");
        }


    }


}
