import java.util.HashMap;
import java.util.Map;

public class Product extends ObjectPlus4{
    String productName;
    int quantity;
    int price;
    Manufacturer manufacturer;

    public Product(String productName, int quantity) {
        this.productName = productName;
        this.quantity = quantity;

    }

    public void setManufacturer(Manufacturer manufacturer) {
        if(this.manufacturer == null){
            this.manufacturer = manufacturer;
        } else {
            System.out.println("This product already has a manufacturer specified");
        }
    }




    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price + ", " + manufacturer ;

    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) throws Exception {
        if (price <= 0){
            throw new Exception(String.format("The price (%s) must be positive", price));
        }
        this.price = price;
    }
}
