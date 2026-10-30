import java.sql.*;

public class TransactionCommit {
    public static void main(String[] args){
        String url = "jdbc:mysql://localhost:3306/bank";
        String username = "root";
        String password = "root";

        try{
            Connection con = DriverManager.getConnection(url, username, password);

            //disable auto commit
            con.setAutoCommit(false);

            PreparedStatement debit = con.prepareStatement(
                "Update account Set balance = balance - ? where id = ?");

                PreparedStatement credit = con.prepareStatement(
                    "Update account set balance = balance + ? where id = ?");

            //debit
            debit.setInt(1,1000);
            debit.setInt(2,1);
            
            debit.executeUpdate();

            //credit
            credit.setInt(1, 1000);
            credit.setInt(2,2);
            credit.executeUpdate();

            //save both changes
            con.commit();
            System.out.println("Transaction Successfully");
        }catch(Exception e){
            e.printStackTrace();
        }
    }    
}
