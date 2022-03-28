package timertaskdbexample;

import java.sql.*;
import java.util.Scanner;
import java.util.Timer;
import timertaskdbexample.DbConnection.DBConnection;

public class TimerTaskDBExample {

    static Connection con = DBConnection.getDBConnection();
    static Statement stm;
    static Timer timer = new Timer();

   
    public static void getAllEmployee() {
        try {
            stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from employee");
            
            while(rs.next()){
                System.out.println("................Employee............................");
                System.out.println("Id : " + rs.getString("id"));
                System.out.println("Name : " + rs.getString("name"));
             
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
   
    }


    public static boolean addEmployee(Employee emp) {
        boolean execute = false;
        try {
            PreparedStatement pstm = con.prepareStatement("insert into employee values(?, ?)");
            pstm.setInt(1, emp.getId());
            pstm.setString(2, emp.getName());
            execute = pstm.execute();
            DeleteEmployeeTask task = new DeleteEmployeeTask(emp.getId());
            timer.schedule(task, 60000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return execute;
    }

    public static void main(String[] args) {

        boolean isRunning = true;
        Scanner sc = new Scanner(System.in);
        while (isRunning) {
            System.out.println("...Employee will delete after 1 minute of creation....");
            System.out.println("All Employee -> 1");
            System.out.println("Add Employee -> 2");
            System.out.println("Exit -> 3");

            int command = sc.nextInt();
            switch (command) {
                case 1:
                    getAllEmployee();
                    break;
                case 2:
                    System.out.println("Enter Employee Id : ");
                    int id = sc.nextInt();
                    System.out.println("Enter Employee Name : ");
                    String name = sc.nextLine();
                    name = sc.nextLine();
                    Employee emp = new Employee(id, name);
                    addEmployee(emp);

                    break;
                case 3:
                    try{
                        System.out.println("Please Wait 1 min to delete all Employee");
                        Thread.sleep(60000);
                    }catch(Exception ex){}
                    timer.cancel();
                    timer.purge();
                    isRunning = false;
                    break;
                default:
                    System.out.println("Wrong Command ! ");

            }

        }
    }

}
