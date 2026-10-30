/*
step1 : create table
CREATE TABLE employess(
    id INT,
    name VARCAHR(50),
    salary DOUBLE
);
 */

import java.sql.*;

public class BatchDemo {
    public static void main(String[] args){
        String url = "jdbc:mysql://localhost:3306/comapny";
        String user = "root";
        String password = "root";

        try{
            Class.forName("com.mysql,cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, user, password);

            PreparedStatement ps = con.prepareStatement("INSERt INTO employee VALUEs(?,?,?)");

            //first Record
            ps.setInt(1, 101);
            ps.setString(2, "kundan");
            ps.setDouble(3, 50000);
            ps.addBatch();

            //second Record
            ps.setInt(1, 102);
            ps.setString(2, "chandan");
            ps.setDouble(3, 60000);
            ps.addBatch();

            //Execute batch
            ps.execute();

            System.out.println("Batch Exceuted Succeffuly");
            ps.close();
            con.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    } 
}
