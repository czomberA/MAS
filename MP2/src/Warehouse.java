import java.util.*;

public class Warehouse {
    char name;
    List<WorksIn> workHistory = new ArrayList<>();
    List<Storeroom> storerooms = new ArrayList<>();



    public Warehouse(char name) {
        this.name = name;
    }

    public void addWorksIn (WorksIn worker){
        if(!workHistory.contains(worker)){
            workHistory.add(worker);
            worker.addWarehouse(this);
        }
    }

    public Storeroom createStoreroom (String roomNumber){
        Storeroom storeroom = new Storeroom(roomNumber);
        storerooms.add(storeroom);
        return storeroom;
        }

    @Override
    public String toString() {
        return "Warehouse{" +
                "name=" + name;
    }

    class Storeroom {
        private
        String roomNumber;

        public Storeroom(String roomNumber) {
            this.roomNumber = roomNumber;
        }

        private Map<String, Product> productQualif = new TreeMap<>();

        public void addProductQualif (Product newProduct){
            if (!productQualif.containsKey(newProduct.productName)){
                productQualif.put(newProduct.productName, newProduct);
                newProduct.addStorageroom(this);
            }
        }

        public Product findProdQualif (String prodName) throws Exception{
            if(!productQualif.containsKey(prodName)){
                throw new Exception("Unable to find the product");
            }
            return productQualif.get(prodName);
        }

        public String getRoomNumber() {
            return roomNumber;
        }

        public void setRoomNumber(String roomNumber) {
            this.roomNumber = roomNumber;
        }

        public Map<String, Product> getProductQualif() {
            return productQualif;
        }

        public void setProductQualif(Map<String, Product> productQualif) {
            this.productQualif = productQualif;
        }

        @Override
        public String toString() {
            return "Storeroom{" +
                    "roomNumber='" + roomNumber + '\'' +
                    '}';
        }


    }
}


