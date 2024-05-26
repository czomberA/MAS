import java.util.*;

public class Warehouse extends ObjectPlus4{
    char name;
    List<WorksIn> workHistory = new ArrayList<>();
    List<Storeroom> storerooms = new ArrayList<>();
    List<Freezer> freezers = new ArrayList<>();



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
    public Freezer createFreezer (String roomNumber, int temperature){
        Freezer freezer = new Freezer(roomNumber, temperature);
        freezers.add(freezer);
        return freezer;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "name=" + name;
    }

    class Storeroom extends ObjectPlus4{
        private
        String roomNumber;

        public Storeroom(String roomNumber) {
            this.roomNumber = roomNumber;
        }

        private Map<String, Product> productQualif = new TreeMap<>();



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
    class Freezer extends ObjectPlus4{
        private String FreezerNumber;
        private int Temperature;

        public Freezer(String freezerNumber, int temperature) {
            FreezerNumber = freezerNumber;
            Temperature = temperature;
        }

        @Override
        public String toString() {
            return "Freezer{" +
                    "FreezerNumber='" + FreezerNumber + '\'' +
                    ", Temperature=" + Temperature +
                    '}';
        }
    }
}


