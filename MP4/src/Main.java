import java.time.LocalDate;
import java.util.Optional;


public class Main {
    public static void main(String[] args) throws Exception {
        //Constraints in parentheses are not part of the task's scope, I noted them because knowledge about them might be useful during testing
        //Adding some sample objects
        Product prod1 = new Product("Margherita", 20);
        Employee emp1 = new Employee("John", "Doe", 3000);
        Employee emp2 = new Employee("James", "Smith", 3000);
        Warehouse a = new Warehouse('A');
        Warehouse b = new Warehouse('B');

        //ATTRIBUTE - Price of a product has to be a positive number
        Attribute(prod1);
        //UNIQUE - Employees number has to be unique (+ Employees number can't be changed)
        Unique(emp1, emp2);
        //SUBSET - Employees work in a shift, one of the Employees manages it
        Subset(emp1, emp2);
        //ORDERED - Employees work history (WorksIn) is ordered by the start date
        Ordered(emp1, a, b);
        //BAG - Employees take health tests (Employee-EmployeesHealthTest-HealthTest), duplicates are allowed, implemented using ArrayList
        Bag(emp1);
        //XOR - Product is either stored in a Storeroom xor frozen in a Freezer
        XOR(prod1, a);
        //CUSTOM - Employee can't get a raise more often than every 6 months (+ old salary can't be smaller than the new one)
        Custom(emp1);


    }

    private static void Attribute(Product prod1) throws Exception {
        System.out.println("---ATTRIBUTE---");
        //Trying to set a negative price (throws exception)
        try {
            prod1.setPrice(-13);;
        } catch (Exception e){
            e.printStackTrace();

        }
        //Setting positive price
        prod1.setPrice(13);
        System.out.println(prod1.toString());
    }

    private static void Unique(Employee emp1, Employee emp3) throws Exception {
        System.out.println("---UNIQUE---");
        emp1.assignEmpNumber(1);
        //Trying to assign the same Employee number to Employee3 (throws exception)
        try {
            emp3.assignEmpNumber(1);
        } catch (Exception e){
            e.printStackTrace();
        }
        //Assigning different Employee number and listing all employees
        emp3.assignEmpNumber(3);
        emp3.printAllEmployeeNumbers();
    }

    private static void Subset(Employee e1, Employee e2) {
        System.out.println("---SUBSET---");
        Shift s1 = new Shift("Day");
        try {
            // Add the ordinary link
            e1.addLink(Employee.roleWorks, Shift.roleConsistsOf, s1);
            e2.addLink(Employee.roleWorks, Shift.roleConsistsOf, s1);
            e1.addLink_subset(Employee.manages, Shift.roleManagedBy, Employee.roleWorks, s1);

            // Show links info
            System.out.println("--Show link info of Employee1:");
            e1.showLinks(Employee.roleWorks, System.out);
            e1.showLinks(Employee.manages, System.out);
            System.out.println("--Show link info of Shift1:");
            s1.showLinks(Shift.roleConsistsOf, System.out);
            s1.showLinks(Shift.roleManagedBy, System.out);

        } catch (Exception e) {
            // Error
            e.printStackTrace();
        }
    }

    private static void Ordered(Employee e, Warehouse w1, Warehouse w2) {
        System.out.println("---ORDERED---");
        //Adding work history out of order
        WorksIn wi1 = new WorksIn(e, w1, LocalDate.of(2022,1,1), Optional.of(LocalDate.of(2023, 12, 12)));
        WorksIn wi2 = new WorksIn(e, w2, LocalDate.of(2023,12,13), null);
        WorksIn wi3 = new WorksIn(e, w1, LocalDate.of(2021,12,13), Optional.of(LocalDate.of(2021, 12, 12)));
        //It is now ordered by start date
        e.printWorkHistory();
    }

    private static void Bag(Employee e) {
        System.out.println("---BAG---");
        HealthTest ht = new HealthTest("Some name", "Very important test", true);
        LocalDate now = LocalDate.now();
        //Creating EmployeesHealthTest
        EmployeesHealthTest eht1 = new EmployeesHealthTest(e, ht, now);
        //Adding a duplicate
        e.addHealthTests(eht1);
        System.out.println(e.getHealthTests().toString());
    }

    private static void XOR(Product p, Warehouse w) {
        System.out.println("---XOR---");
        final String roleIsFrozen = "frozen";
        final String roleIsStored = "stored";
        final String roleStores = "stores";
        final String roleFreezes = "freezes";
        Warehouse.Storeroom srA1 = w.createStoreroom("A1");
        Warehouse.Freezer fA3 = w.createFreezer("A3", -10);
        try {
            // Add info about role constrained by the XOR
            p.addXorRole(roleIsFrozen);
            p.addXorRole(roleIsStored);

            // Add link no 1
            p.addLinkXor(roleIsFrozen, roleFreezes, fA3);

            // Add link no 2 {xor} ==> exception
            //prod1.addLinkXor(roleIsStored, roleStores, srA1);

            // Show links info
            p.showLinks(roleIsFrozen, System.out);
            // Show reverse links info
            fA3.showLinks(roleFreezes, System.out);

        } catch (Exception e) {
            // Error
            e.printStackTrace();
        }
    }

    private static void Custom(Employee e) throws Exception {
        System.out.println("---CUSTOM---\nOld salary: " + e.getSalary());
        e.GiveRaise(4000);
        System.out.println("New salary: " + e.getSalary());
        //Will throw exception (Last salary change was just now):
        try {
            e.GiveRaise(5000);
        }catch (Exception ex) {
            // Error
            ex.printStackTrace();
            System.out.println("Salary did not change: " + e.getSalary());
        }
    }


}