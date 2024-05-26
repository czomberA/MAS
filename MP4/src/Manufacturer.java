import java.util.ArrayList;
import java.util.List;

public class Manufacturer {
    String companyName;

    private List<Product> products = new ArrayList<>();

    public Manufacturer(String companyName) {
        this.companyName = companyName;
    }

    public void addProduct(Product product){
        if (!products.contains(product)){
            products.add(product);
            product.setManufacturer(this);
        } else {
            System.out.println("Manufacturer already has this product registered");
        }
    }


    @Override
    public String toString() {
        return "Manufacturer{" +
                "companyName='" + companyName + '\'' +
                '}';
    }
}
