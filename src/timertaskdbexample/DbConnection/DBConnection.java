
package timertaskdbexample.DbConnection;

import java.sql.*;


public class DBConnection {
    
    private static Connection con = null;
    
    private DBConnection(){}
    
    public static Connection getDBConnection(){
        if(con != null){
            return con;
        }else{
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/timer_task", "root", "");
            } catch (Exception ex) {
               ex.printStackTrace();
            }
        }
        return con;
        
    }
    
    
}
