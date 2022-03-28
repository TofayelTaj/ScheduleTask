
package timertaskdbexample;

public class Employee {
    
//...........Variables...............    
    private int id;
    private String name;
    
//..................Constructors.......................
    Employee(){
        
    }
    Employee(int id, String name){
        this.id = id;
        this.name = name;
    }
//.........Getters.................    
    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + '}';
    }
    
    
}
