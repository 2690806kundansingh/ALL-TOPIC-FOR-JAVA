import java.sql.*;

public class ResultSet{
    public static void main(String[] args)throws Exception{

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/company",
                "root",
                "password");

        Statement stmt = con.createStatement(); 
        
        ResultSet rs = stmt.executeQuery("Select * from employee");

       while(rs.next()){

            System.out.println(
                    rs.getInt("id")+" "
                    +rs.getString("name")+" "
                    +rs.getDouble("salary"));

        }
        rs.close();
        stmt.close();
        con.close();
    }
}