/*
step1 - create a table
CREATE TABLE employee(
    id INT PRIMARY KEY,
    name VARVHAR(20),
    salary DUBLE
);
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PreparedStatementDemo {
    public static void main(String[] args){
        String url = "jdbc:mysql://localhost:3306/company";
        String user = "root";
        String password = "root";

        try{
            //load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create connection
            Connection con = DriverManager.getConnection(url, user, password);

            //create PreparedStatement
             PreparedStatement ps = con.prepareStatement("INSERT INTO employee VALUES(?,?,?)");

             //set Values
             ps.setInt(1, 101);
             ps.setString(2, "kundan");
             ps.setDouble(3, 50000);

             //Execute query
             int rows = ps.executeUpdate();

             System.out.println(rows + " Record Inserted");

             //Close resources
             ps.close();
             con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
