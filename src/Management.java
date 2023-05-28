import java.awt.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
/**
 ATTENTION(UYARI) En üstte miras alınan Person classı içerisindeki değer düzeni ile aynı içeriğe sahiptir. Düzenleme
 ve içeriği anlamak için person üzerindeki COMMENT'leri okumanız gerekmektedir çünkü içerik benzer mimaride tasarlanmıştır.
 */
public class Management extends Employee {

    Scanner keyboard = new Scanner(System.in);
    final private int MANAGEMENT_ID_DIGIT = 9;
    private String managementId;
    private String management_department;

    public Management() {
    }

    public Management(String managementId, String management_department) {

        this.managementId = managementId;
        this.management_department = management_department;
    }

    public String getManagementId() {
        return managementId;
    }

    public void setManagementId(String managementId) {
        try {
            System.out.println("Please enter Management ID : ");
            managementId = keyboard.nextLine();

            if (managementId.matches("[0-9]*") && managementId.length() == MANAGEMENT_ID_DIGIT) {
                this.managementId = managementId;
                try {
                    DataBaseLayer.dataBaseLayer();
                    Statement myStatement = DataBaseLayer.myConnection.createStatement();
                    myStatement.executeQuery("IF ( '" + super.getEmployeeId() + "' =(SELECT employeeId FROM HospitalManagementSystemStock.dbo.managements WHERE employeeId = '" + super.getEmployeeId()+ "') )\n" +
                            "UPDATE HospitalManagementSystemStock.dbo.managements SET  managementId = '" + this.managementId + "' WHERE employeeId = '" + super.getEmployeeId() + "'\n" +
                            "ELSE INSERT INTO HospitalManagementSystemStock.dbo.managements (managementId,employeeId) VALUES ('" + this.managementId + "','" + super.getEmployeeId() + "')");
                    myStatement.close(); // close statement
                    DataBaseLayer.myConnection.close(); // close connection
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

    public String getManagement_department() {
        return management_department;
    }

    public void setManagement_department(String employee_department) {
        int count = 0;
        System.out.println("Please enter department : ");
        management_department = keyboard.nextLine();

        if (management_department.length() < 2) {
            System.out.println("Please enter your true department!");
            Toolkit.getDefaultToolkit().beep();
            ++count;
        } else if (management_department.matches(".*\\p{Punct}.*")) {
            System.out.println("Please do not use punctuation character!");
            Toolkit.getDefaultToolkit().beep();
            ++count;
        } else if (management_department.matches(".*[0-9].*")) {
            System.out.println("Please do not use digit!");
            Toolkit.getDefaultToolkit().beep();
            ++count;
        } else {
            this.management_department = management_department;
            try {
                DataBaseLayer.dataBaseLayer();
                Statement myStatement = DataBaseLayer.myConnection.createStatement();
                myStatement.executeQuery("IF ( '" + super.getEmployeeId() + "' =(SELECT employeeId FROM HospitalManagementSystemStock.dbo.managements WHERE employeeId = '" + super.getEmployeeId()+ "') )\n" +
                        "UPDATE HospitalManagementSystemStock.dbo.managements SET  department = '" + this.management_department + "' WHERE employeeId = '" + super.getEmployeeId() + "'\n" +
                        "ELSE INSERT INTO HospitalManagementSystemStock.dbo.managements (department) VALUES ('" + this.management_department + "')");
                myStatement.close(); // close statement
                DataBaseLayer.myConnection.close(); // close connection
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if (count == 1) {
            setManagement_department("");
        }
    }

    public String toString() {

        management_db();
        return super.toString() + "\nMANAGEMENT INFORMATION" + "\n--------------------------------------------\n"
                + "Management ID : " + getManagementId() + "\nDepartment : " + getManagement_department() +
                "\n--------------------------------------------\n";
    }

    public void management_db() {

        String employeeId = getEmployeeId();

        try {
            DataBaseLayer.dataBaseLayer();
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            ResultSet myResult = myStatement.executeQuery("SELECT * FROM  managements WHERE employeeId = '" + employeeId + "'");
//            "IF ( '"+getEmployeeId()+"' = (SELECT employeeId FROM HospitalManagementSystemStock.dbo.managements WHERE employeeId = '"+getEmployeeId()+"') " +
//                    "SELECT * FROM  managements WHERE employeeId = '"+getEmployeeId()+"'"
            while (myResult.next()) {
                this.managementId = myResult.getString("managementId");
                this.management_department = myResult.getString("department");
            }
            myStatement.close(); // close statement
            DataBaseLayer.myConnection.close(); // close connection
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addManagement() {
        super.person_db();
        super.employee_db();
        setManagementId("Unknown");
        setManagement_department("Unknown");
    }

    public void viewManagement() {
        System.out.println(toString());
    }

    public void changeManagementId() {
        setManagementId("Unknown");
        System.out.println("New Management ID is " + getEmployeeId());
    }

    public void changeManagementDepartment() {
        setManagement_department("Unknown");
        System.out.println("New Department is " + getManagement_department());
    }
}
