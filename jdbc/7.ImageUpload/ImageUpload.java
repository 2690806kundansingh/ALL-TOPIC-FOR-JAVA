import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ImageUpload{
    public static void main(String[] args){

        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "root";

        String imagePath = "C:/images/kundan.pnj";

        String sql = "INSERT INTO employee (id,name,photo) VALUES (?,?,?)";

        try{
            Connection con = DriverManager.getConnection(url, username, password);

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, 101);
            ps.setString(2, "kundan");

            FileInputStream fis = new FileInputStream(imagePath);

            ps.setBinaryStream(3, fis);

            int rows = ps.executeUpdate();

            if(rows > 0){
                System.out.println("Image stored successfully");
            }
            fis.close();
            ps.close();
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
