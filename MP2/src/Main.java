import java.time.LocalDate;
import java.util.Optional;


public class Main {
    public static void main(String[] args) throws Exception {
        //Binary: Product-Manufacturer (*-1)
        //With attribute: Employee-(WorksIn)-Warehouse [*-* association between employee and warehouse]
        //Composition: Warehouse-Storeroom (inner class)
        //Qualified: Storeroom(Product name)-Product

        //creating example objects
        Warehouse WarA = new Warehouse('A');
        Warehouse WarB = new Warehouse('B');
        Manufacturer manu1 = new Manufacturer("FrozenPizza");
        Product prod1 = new Product("Margherita", 20, 12);
        Product prod2 = new Product("Pepperoni", 24, 18);
        Employee emp1 = new Employee("John", "Doe");

        //Adding composition using inner class
        Warehouse.Storeroom a1 = WarA.createStoreroom("A1");
        Warehouse.Storeroom a2 = WarA.createStoreroom("A2");
        //Adding binary association
        prod1.setManufacturer(manu1);
        manu1.addProduct(prod2);
        //Adding qualified association
        prod1.addStorageroom(a1);
        prod1.addStorageroom(a2);
        prod2.addStorageroom(a2);
        //finding product information based on the qualifier (product name)
        System.out.println(a1.findProdQualif("Margherita"));
        System.out.println(a2.findProdQualif("Pepperoni"));
        //Adding association with attribute
        WorksIn wi1 = new WorksIn(emp1, WarA, LocalDate.of(2022,1,1), Optional.of(LocalDate.of(2023, 12, 12)));
        WorksIn wi2 = new WorksIn(emp1, WarB, LocalDate.of(2023,12,13), null);
        System.out.println(emp1.toString());

    }
}