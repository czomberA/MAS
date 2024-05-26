import java.time.LocalDate;

public class EmployeesHealthTest {
    Employee e;
    HealthTest ht;
    LocalDate dateTaken;

    public EmployeesHealthTest(Employee e, HealthTest ht, LocalDate dateTaken) {
        this.e = e;
        this.ht = ht;
        this.dateTaken = dateTaken;
        e.addHealthTests(this);
        ht.addEmployeeToTest(this);
    }

    public Employee getE() {
        return e;
    }

    public void setE(Employee e) {
        this.e = e;
    }

    public HealthTest getHt() {
        return ht;
    }

    public void setHt(HealthTest ht) {
        this.ht = ht;
    }

    public LocalDate getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(LocalDate dateTaken) {
        this.dateTaken = dateTaken;
    }

    public void addEmployee(Employee employee){
        if(this.e == null){
            this.e = employee;
        }
    }

    public void addHealthTest(HealthTest healthTest){
        if(this.ht == null){
            this.ht = healthTest;
        }
    }

    @Override
    public String toString() {
        return "EmployeesHealthTest{" +
                "e=" + e.lastName + " " + e.name +
                ", ht=" + ht +
                ", dateTaken=" + dateTaken +
                '}';
    }
}
