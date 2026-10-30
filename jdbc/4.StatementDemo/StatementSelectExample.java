import java.sql.*;

public class StatementSelectExample {

    public static void main(String[] args) {

        try {

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/company",
                    "root",
                    "password");

            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM employee";

            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){

                System.out.println(
                        rs.getInt("id") + " "
                        + rs.getString("name") + " "
                        + rs.getDouble("salary"));
            }

            rs.close();
            stmt.close();
            con.close();

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}