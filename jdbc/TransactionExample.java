import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionExample {
    public static void main(String[] args){
        String url = "jdbc:mysql://localhost:3306/bankName";
        String user = "root";
        String password = "password";

        Connection conn = null;
        PreparedStatement debit = null;
        PreparedStatement credit = null;

        try{
            // step 1 -> Open Connection
            conn = DriverManager.getConnection(url, user, password);

            //step2 -> Turn off autoCommit (start transaction)
            conn.setAutoCommit(false);

            //step3 -> first sql operation (deduct money)
            String debitQuery = "UPDATE account SET balance = balance -100 wnere account_id = ?";
            debit = conn.prepareStatement(debitQuery);
            credit.setInt(1, 102);
            credit.executeUpdate();
            
            //step 4 : Second  sql operation (add money)
            String creditQuery = "UPDATE account SET balance = balance + 100 where account_id = ?";
            credit = conn.prepareStatement(creditQuery);
            credit.setInt(1, 102);
            credit.executeUpdate();
            
            //step5: Commmit changes if bothe queries success
            conn.commit();
            System.out.println("Transaction Successfully !");
        }
        catch(SQLException e){
            System.out.println("Transaction failed ! Rolling back changes.");

            //step6 :Rollback on error
            if(conn != null){
                try{
                    conn.rollback();
                }catch(SQLException ex){
                    ex.printStackTrace();
                }
            }
        }
        finally{
            //step 7 : Explicitly close all resources in finally bloack
            try{
                if(debit != null) debit.close();
                if(credit != null) credit.close();
                if(conn != null){
                    conn.setAutoCommit(true);
                    conn.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }

    }    
}
