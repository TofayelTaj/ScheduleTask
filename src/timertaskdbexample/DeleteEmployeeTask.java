
package timertaskdbexample;


import java.util.TimerTask;
import java.sql.*;
import timertaskdbexample.DbConnection.DBConnection;


public class DeleteEmployeeTask extends TimerTask{

    Connection con = DBConnection.getDBConnection();
    
    
    private int employeeId;
    
    DeleteEmployeeTask(int employeeId){
        this.employeeId = employeeId;
    }
    
    @Override
    public void run() {
        
        try{
            String query = "DELETE FROM employee WHERE id ="+ employeeId;
            Statement stm = con.createStatement();
            stm.execute(query); 
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
    
    
    
}
