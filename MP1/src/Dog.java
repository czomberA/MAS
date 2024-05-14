import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Dog extends Pet{
    private static List<Dog> extent = new ArrayList<>(); //extent
    private static int isSenior = 10; //class attribute
    private ArrayList<String> tricks = new ArrayList<>(); //multivalued, optional attribute

   public Dog (String name, String breed,int year_of_birth, Cage cage){
       super(name,breed,year_of_birth, cage);
       addDog(this);
   }
   private static void addDog(Dog dog){
        extent.add(dog);
    }
    private static void removeDog(Dog dog){
        extent.remove(dog);
    }

    public void AddTricks(String TrickName){
        tricks.add(TrickName);
    }



    //override
    @Override
    public String toString() {
        String dogString = super.toString();
        if (!tricks.isEmpty()){
            dogString += String.format("[known tricks: %s]", tricks);
        }
        return dogString;
    }

    public static List<Dog> getAllDogs(){
        return extent;
    }

    //Class method returning all dogs older than 10
    public static List<Dog> getAllSeniors(){
        return extent.stream().filter(dog -> dog.getAge() > isSenior).collect(Collectors.toList());
    }

    //overloaded method
    public static List<Dog> getAllDogs(String breed){
       return extent.stream().filter(dog -> dog.getBreed().equals(breed)).collect(Collectors.toList());
    }

}
