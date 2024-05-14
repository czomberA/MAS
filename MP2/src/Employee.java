import java.util.ArrayList;
import java.util.List;

public class Employee {
    String name;
    String lastName;

    List<WorksIn> workHistory = new ArrayList<>();

    public Employee(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public void addWorksIn (WorksIn work) {
        if(!workHistory.contains(work)){
            workHistory.add(work);
            work.addEmployee(this);
        }
    }

    @Override
    public String toString() {
        return "Employee{" + name + ' ' +
                lastName +
                ", Work History:" + workHistory +
                '}';
    }
}
