import java.sql.*;

public class Rollback {
    public static void main(String[] args){

        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");

            con.setAutoCommit(false);

            PreparedStatement debit = con.prepareStatement("
            Update Account set balance = balance -500 where id=1");

            PreparedStatement credit = con.prepareStatement("
            Update account set balance = balance+500 where id = 2 ");

            debit.executeUpdate();
            int a = 10/0;

            credit.executeUpdate();

            com.commit();
            System.out.println("Money Transfered");
        }
        catch(Exception e){
            try{
                if(con != null){
                    con.Rollback();
                    System.out.println("Rollback Excuted");
                }
            }
            catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }    
}
