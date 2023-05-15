import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseLayer  {
    static Connection myConnection;
    static String url = "jdbc:sqlserver://localhost\\DESKTOP-T9F59R5:1433;database=HospitalManagementSystemStock;useSSL=false;encrypt=false;integratedSecurity=true;"; // Database URL

    public static void dataBaseLayer() { //Database layer function
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // Driver name
            myConnection = DriverManager.getConnection(url);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}