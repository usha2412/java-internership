import java.sql.*;

public class CreateOperation {
    public static void main(String[] args) {
        String url ="jdbc:mysql://localhost:3306/employee";
        String user ="root";
        String password ="Usha@2412";
        System.out.println("Connecting to the database");
        String query ="insert into employeedetails(emp_name,emp_dep,emp_salary) values(?,?,?)";
        try{
            Connection connection = DriverManager.getConnection(url,user,password);
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,"Reshma");
            ps.setString(2,"prof");
            ps.setString(3,"40000");
            ps.executeUpdate();

            ps.setString(1,"Aditya");
            ps.setString(2,"prof");
            ps.setString(3,"80000");
            ps.executeUpdate();

            ps.setString(1,"Sanjay");
            ps.setString(2,"Warden");
            ps.setString(3,"30000");
            ps.executeUpdate();
            System.out.println("Data inserted successfully");



        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
