import java.sql.*;
public class DeleteOpera {
    public static void main(String []args){
        String url ="jdbc:mysql://localhost:3306/employee";
        String user ="root";
        String password ="Usha@2412";
        System.out.println("Connecting to the database");
        String query = "delete from employeedetails where emp_dep=?";
        String empdep ="hr";
        try{
            Connection connection =DriverManager.getConnection(url,user,password);
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,"hr");
            int update = ps.executeUpdate();
            if(update>0)
                System.out.println("Data deleted successfully");
            else
                System.out.println("Data not found");
        }
        catch(SQLException e){
            e.printStackTrace();
        }


    }
}
