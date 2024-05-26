import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Employee extends ObjectPlus4{
    String name;
    String lastName;
    int salary;
    int employeeNumber = defaultEmployeeNumber;

    LocalDate lastRaise;
    private static Map<Integer, Employee> uniqueness = new HashMap<>();
    List<EmployeesHealthTest> healthTests = new ArrayList<>();

    Set<WorksIn> workHistory = new TreeSet<>(new Comparator<WorksIn>() {
        @Override
        public int compare(WorksIn o1, WorksIn o2) {

            return  o1.start.compareTo(o2.start);
        }
    });

    public void GiveRaise (int newSalary) throws Exception {
        if (this.salary > newSalary){
            throw new IllegalArgumentException("New salary has to be more than old salary");
        }

        if (lastRaise == null) {
            this.salary = newSalary;
            this.lastRaise = LocalDate.now();
        } else {
            long monthsSinceLastChange = ChronoUnit.MONTHS.between(lastRaise, LocalDate.now());
            if (monthsSinceLastChange < 6) {
                throw new Exception("Salary can only be changed once every six months.");
            }

            this.salary = newSalary;
            this.lastRaise = LocalDate.now();

        }
    }

    public Employee(String name, String lastName, int salary) {
        this.name = name;
        this.lastName = lastName;
        this.salary = salary;
    }

    public void assignEmpNumber(int employeeNumber) throws Exception{
        if (this.employeeNumber != defaultEmployeeNumber){
            throw new Exception("Employees number cannot be changed");
        }
        if (uniqueness.containsKey(employeeNumber)){
            throw new Exception("There already exist an Employee with this number!");
        }
        this.setEmployeeNumber(employeeNumber);
        uniqueness.put(employeeNumber, this);
    }

    public void addWorksIn (WorksIn work) {
        if(!workHistory.contains(work)){
            workHistory.add(work);
            work.addEmployee(this);
        }
    }

    public void addHealthTests (EmployeesHealthTest eht) {
        healthTests.add(eht);
    }

    @Override
    public String toString() {
        return "Employee{[" + employeeNumber + "] " + name + ' ' +
                lastName +"}";
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void printAllEmployeeNumbers() {
        uniqueness.forEach((key, value) -> System.out.println(key + " " + value));

        }


    public void setEmployeeNumber(int employeeNumber) {

            this.employeeNumber = employeeNumber;

    }

    public void printWorkHistory(){
        for (WorksIn wi : workHistory) {
            System.out.println(wi);
        }
    }
    public final static int defaultEmployeeNumber = -1;
    public static final String roleWorks = "works";
    public static final String manages = "manages";

    public int getSalary() {
        return salary;
    }

    public List<EmployeesHealthTest> getHealthTests() {
        return healthTests;
    }
}
