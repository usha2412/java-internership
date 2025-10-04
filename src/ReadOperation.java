import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ReadOperation {
    public static void main(String[] args) {
        String url ="jdbc:mysql://localhost:3306/employee";
        String user ="root";
        String password ="Usha@2412";
        System.out.println("Connecting to the database");
        try{
            Connection connection = DriverManager.getConnection(url,user,password);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from employeedetails");
            System.out.println("|"+"emp_id"+"|"+"emp_name"+"|"+"emp_dep"+"|"+"emp_salary"+"|");
            while(rs.next()){
                System.out.println("|" + rs.getInt("emp_id")+"|"+ rs.getString("emp_name")+"|"+ rs.getString("emp_dep")+"|"+rs.getString("emp_salary")+"|");
            }
            rs.close();
            statement.close();
            connection.close();

        }
        catch (SQLException e){
            e.printStackTrace();
        }


        }
    }
