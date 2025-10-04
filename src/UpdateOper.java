import java.sql.*;
import java.util.Scanner;


public class UpdateOper {
    public static void main (String []args) throws Exception{
        String url ="jdbc:mysql://localhost:3306/employee";
        String user ="root";
        String password ="Usha@2412";
        Scanner sc = new Scanner(System.in);
        String empdep ="admin";
        String empsalary ="40000";
        String query ="update employeedetails set emp_dep=? where emp_salary=?";
        Connection con= DriverManager.getConnection(url,user,password);
//        Statement stat =con.createStatement();
        PreparedStatement ps =con.prepareStatement(query);
        ps.setString(1,"admin");
        ps.setString(2,"40000");
        int update=ps.executeUpdate();
        if(update>0)
            System.out.println("Data updated successfully");
        else
            System.out.println("Data not found");
    }
}
