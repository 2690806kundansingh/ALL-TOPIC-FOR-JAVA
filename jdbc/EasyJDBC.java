import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EasyJDBC {
    public static void main(String[] args){
        //databaseconnection
        String url = "jdbc:mysql://localhost:3306/testDb";
        String user = "root";
        String password = "password";

        //declare resuources outside try bloack to access them in finaaly
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        try{
            //step1 : load and register the jdbc driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //step2 : Established the connection to the database
            conn  = DriverManager.getConnection(url, user, password);

            //step3 : Create a prepared Stament (write you sql query)
            String sql = "SELECT id,name,salary FROM employess where id = ?";
            pre = conn.prepareStatement(sql);
            pre.setInt(1, 101);

            //step 4: Execute the query
            rs = pre.executeQuery();

            //step 5: Process the Result set
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double salary = rs.getDouble("salary");

                System.out.println("ID:" + id+"|Name:" + name + "|Salary: $" + salary);
            }

        }catch(ClassNotFoundException e){
            System.err.println("jdbc");
            e.printStackTrace();
        } catch(SQLException e){
            System.err.println("Database eror occured");
            e.printStackTrace();
        }
        finally{
            //step 6: Close all resource inreverse order of creation
            try{
                if(rs != null) rs.close();
                if(pre != null) pre.close();
                if(conn != null) conn.close();
                System.out.println("All resourse closed successfully.");
            } catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}
