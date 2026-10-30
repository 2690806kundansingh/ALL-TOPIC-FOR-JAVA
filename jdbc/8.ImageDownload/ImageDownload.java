import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.*;

public class ImageDownload{
    public static void main(String[] args){
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "root";

        String sql = "SELECT photo FROM employee WHERE id = ?";

        try{
            Connection con = DriverManager.getConnection(url, username, password);

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, 101);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                InputStream inputStream = rs.getBinaryStream("photo");

                FileOutputStream fos = new FileOutputStream("C:/images*download.jpg");

                byte[] buffer = new byte[4096];

                int bytesRead;

                while((bytesRead = inputStream.read(buffer)) != -1){
                    fos.write(buffer,0,bytesRead);
                }

                fos.close();
                inputStream.close();

                System.out.println("Images download successfully");
            }
            rs.close();
            ps.close();
            con.close();
        } catch(Exception e){
            e.printStackTrace();
        }

        
    }        
}
