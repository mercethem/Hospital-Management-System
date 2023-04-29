import java.sql.ResultSet;
import java.sql.Statement;

public class DataBaseQueries {
   public void dataBaseQueries(){
       try { //Database layer function and SQL query about student information
           DataBaseLayer.dataBaseLayer();
           Statement myStatement = DataBaseLayer.myConnection.createStatement();
           Person person = new Person();

//           ResultSet setCitizenId_db = myStatement.executeQuery("SELECT * FROM HospitalManagementSystemStock.dbo.persons WHERE persons.citizenId = '" + Person.person + "'");
             ResultSet getCitizenId_db = myStatement.executeQuery("SELECT * FROM HospitalManagementSystemStock.dbo.persons WHERE persons.citizenId = '" + Person.person.getCitizenId() + "'");
//
//           ResultSet setName_db = myStatement.executeQuery("SELECT * FROM LibraryStock.dbo.students WHERE students.studentId = '" + studentId + "'");
//           ResultSet getName_db = myStatement.executeQuery("SELECT * FROM LibraryStock.dbo.students WHERE students.studentId = '" + studentId + "'");
//
//           ResultSet setSurname_db = myStatement.executeQuery("SELECT * FROM LibraryStock.dbo.students WHERE students.studentId = '" + studentId + "'");
//           ResultSet getSurname_db = myStatement.executeQuery("SELECT * FROM LibraryStock.dbo.students WHERE students.studentId = '" + studentId + "'");
//
//           ResultSet setBirthdate_day_db = myStatement.executeQuery("SELECT * FROM LibraryStock.dbo.students WHERE students.studentId = '" + studentId + "'");
//           ResultSet getBirthdate_day_db = myStatement.executeQuery("SELECT * FROM LibraryStock.dbo.students WHERE students.studentId = '" + studentId + "'");
//
//           ResultSet setBirthdate_month_db = myStatement.executeQuery("SELECT * FROM LibraryStock.dbo.students WHERE students.studentId = '" + studentId + "'");
//           ResultSet getBirthdate_month_db = myStatement.executeQuery("SELECT * FROM LibraryStock.dbo.students WHERE students.studentId = '" + studentId + "'");
//
//           ResultSet setBirthdate_year_db = myStatement.executeQuery("SELECT * FROM LibraryStock.dbo.students WHERE students.studentId = '" + studentId + "'");
//           ResultSet getBirthdate_year_db = myStatement.executeQuery("SELECT * FROM LibraryStock.dbo.students WHERE students.studentId = '" + studentId + "'");
//
//           ResultSet setBloodGroup_db = myStatement.executeQuery("SELECT * FROM LibraryStock.dbo.students WHERE students.studentId = '" + studentId + "'");
//           ResultSet getBloodGroup_db = myStatement.executeQuery("SELECT * FROM LibraryStock.dbo.students WHERE students.studentId = '" + studentId + "'");
//
//           ResultSet setAddress_db = myStatement.executeQuery("SELECT * FROM LibraryStock.dbo.students WHERE students.studentId = '" + studentId + "'");
//           ResultSet getAddress_db = myStatement.executeQuery("SELECT * FROM LibraryStock.dbo.students WHERE students.studentId = '" + studentId + "'");
//
//           ResultSet setPhoneNumber_db = myStatement.executeQuery("SELECT * FROM LibraryStock.dbo.students WHERE students.studentId = '" + studentId + "'");
//           ResultSet getPhoneNumber_db = myStatement.executeQuery("SELECT * FROM LibraryStock.dbo.students WHERE students.studentId = '" + studentId + "'");
//
//           ResultSet setEmail_db = myStatement.executeQuery("SELECT * FROM LibraryStock.dbo.students WHERE students.studentId = '" + studentId + "'");
//           ResultSet getEmail_db = myStatement.executeQuery("SELECT * FROM LibraryStock.dbo.students WHERE students.studentId = '" + studentId + "'");
//



           myStatement.close(); // close statement
           DataBaseLayer.myConnection.close(); // close connection
       } catch (Exception exception) {
           System.out.println(exception);
       }
   }
}
