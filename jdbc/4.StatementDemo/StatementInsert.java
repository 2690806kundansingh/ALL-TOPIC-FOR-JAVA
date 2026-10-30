import java.sql.*;

public class StatementInsert{
    public static void main(String[] args){
        try{
             Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/company",
                    "root",
                    "password");


             Statement stmt = con.createStatement();
             
             String sql = "Inser into employee values(3,'aman',60000";

             int rows = stmt.executeUpdate(sql);

             System.out.println(rows + " Row Inserted");

             stmt.close();
             con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
