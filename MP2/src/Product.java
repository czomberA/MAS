import java.util.HashMap;
import java.util.Map;

public class Product{
    String productName;
    int quantity;
    int price;
    Manufacturer manufacturer;
    private Map<String, Warehouse.Storeroom> storerooms = new HashMap<>();

    public Product(String productName, int quantity, int price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        if(this.manufacturer == null){
            this.manufacturer = manufacturer;
        } else {
            System.out.println("This product already has a manufacturer specified");
        }
    }

    public void addStorageroom(Warehouse.Storeroom storeroom) {
        if (!storerooms.containsKey(storeroom.getRoomNumber())){
            storerooms.put(storeroom.getRoomNumber(), storeroom);
            storeroom.addProductQualif(this);

        }
    }


    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price + ", " + manufacturer +
                storerooms.values() +
                '}';
    }
}
