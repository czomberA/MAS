import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public  abstract class Pet implements Serializable{
    private String name;
   private String breed; //optional attribute
   private int year_of_birth; //not a full date, because in case of shelters it's usually unknown and only the year can be approximated

    private Cage cage; //complex attribute

    private static List<Pet> extent = new ArrayList<>();

    public Pet(String name, String breed, int year_of_birth, Cage cage) {
        this.name = name;
        this.breed = breed;
        if (this.breed == null){
            this.breed = "unknown";
        }
        this.year_of_birth = year_of_birth;
        this.cage = cage;
        extent.add(this);

    }


    public int getAge() {
        return Year.now().getValue() - year_of_birth; //derived attribute
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getYear_of_birth() {
        return year_of_birth;
    }

    public void setYear_of_birth(int year_of_birth) {
        this.year_of_birth = year_of_birth;
    }



    public Cage getCage() {
        return cage;
    }

    public void setCage(Cage cage) {
        this.cage = cage;
    }


    public static void writeExtent(ObjectOutputStream stream) throws IOException {
        stream.writeObject(extent);
    }

    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        //extent = null;
        extent = (ArrayList<Pet>) stream.readObject();
        //System.out.println(extent);
    }

    public static void show(){
        for(Pet pet : extent){
            System.out.println(pet);
        }
    }


    @Override
    public String toString() {
        int age = getAge();
        String cageString = cage.toString();
        String breedString;

        return String.format("%s: [Breed: %s][Age: %d][Cage: %s]",name, breed, age, cageString );
    }


}
