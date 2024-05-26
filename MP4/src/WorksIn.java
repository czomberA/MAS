import java.time.LocalDate;
import java.util.Optional;

public class WorksIn {
    Employee employee;
    Warehouse warehouse;
    LocalDate start;
    Optional<LocalDate> end;


    public WorksIn(Employee employee, Warehouse warehouse, LocalDate start, Optional<LocalDate> end) {
        this.employee = employee;
        this.warehouse = warehouse;
        this.start = start;
        this.end = end;
        employee.addWorksIn(this);
        warehouse.addWorksIn(this);
    }

    public void addEmployee(Employee employee){
        if(this.employee == null){
            this.employee = employee;
        }
    }

    public void addWarehouse(Warehouse warehouse){
        if(this.warehouse == null){
            this.warehouse = warehouse;
        }
    }

    @Override
    public String toString() {
        String s =  "{Warehouse " + warehouse.name +
                ", start=" + start;

        if (end != null) {
            String withEnd = "{Warehouse " + warehouse.name +
                    ", start=" + start + ", end=" + end.get() + '}';
            return withEnd;
        }
        return s;
    }
}
