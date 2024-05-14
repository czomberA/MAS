import java.util.HashSet;

public class Employee extends Position{
    private int salary;

    private Person person;

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public Person getPerson() {
        return person;
    }

    public Employee(int salary) {
        this.salary = salary;
    }



    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }



    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                '}';
    }
}
