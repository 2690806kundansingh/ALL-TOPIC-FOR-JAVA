/*
step1 : Create table
CREATE TABLE employee(
    id INT PRIMARY KEY,
    name VARCHAR(50),
    salary DOUBLE    
);

step2 : Create Store Procedure (MYSQL)
DELIMETER //

CREATE PROCEDURE insertEmploye(
    INT empId INT,
    IN empName VARCHAR(50)
    IN empSalary DOUBLE
)
BEGIN
   INSERT INTO employee(id,name,salary)
   VALUES(empId,empName,empSalary);
END //   

DELIMETER;
 */

/* Step 3 java Program */

import java.sql.*;
public class CallableStatementDemo{
    public static void main(String[] args){

        String url = "jdbc:mysql://localhost:3306/comapany";
        String user = "root";
        String password = "root";

        try{
            //load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Create Connection
            Connection con = DriverManager.getConnection(url, user, password);

            //create Statement
            CallableStatement cs = con.prepareCall("{call InsertEmployee(?,?,?)}");

            //Set parameter
            cs.setInt(1,101);
            cs.setString(2,"kundan");

            //Excetue Procudeure
            cs.execute();

            System.out.println("Employee Inserted Successfully");

            //Close Resources
            cs.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
