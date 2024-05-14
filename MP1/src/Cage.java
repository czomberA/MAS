import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cage implements Serializable{
    private int floor;
    private static int maxFloor = 2; //class attribute
    private static int minFloor = 0; //class attribute
    private int roomNumber;
    private int cageNumber;

    private static List<Cage> extent = new ArrayList<>();

    public Cage(int floor, int roomNumber, int cageNumber) {
        if (floor > 2 || floor < 0) {
            throw new IllegalArgumentException("There's no such floor!");
        } else {
            this.floor = floor;
        }
        this.roomNumber = roomNumber;
        this.cageNumber = cageNumber;
        addCage(this);
    }


    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {

            this.floor = floor;

    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    private static void addCage(Cage cage){
        extent.add(cage);
    }
    private static void removeCage(Cage cage){
        extent.remove(cage);
    }

    @Override
    public String toString() {
        return String.format("%d, room: %d, floor: %d", cageNumber, roomNumber, floor);
    }

    public static void writeExtent(ObjectOutputStream stream) throws IOException {
        stream.writeObject(extent);
    }

    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        extent = (ArrayList<Cage>) stream.readObject();
    }

    public int getCageNumber() {
        return cageNumber;
    }

    public void setCageNumber(int cageNumber) {
        cageNumber = cageNumber;
    }
}
