import java.io.*;
import java.util.Date;

public class Main {
    public static void main(String[] args){

        final String extentFile = "data.txt";
        // creating example cages
        Cage c1 = new Cage(0, 1, 12);
        Cage c2 = new Cage(1, 6, 5);
        Cage c3 = new Cage(1, 6, 6);

        //creating example dogs
        Dog Burek = new Dog("Burek", "German Sheppard", 2020, c1);
        Burek.AddTricks("stay");
        Burek.AddTricks("roll");
        Dog Azor = new Dog("Azor", null, 2022, c2);
        Dog Rex = new Dog("Rex", "Bulldog", 2011, c3);

        System.out.println("All dogs: " + Dog.getAllDogs());
        System.out.println("Seniors: " + Dog.getAllSeniors()); //class method
        System.out.println("All dogs who are bulldogs: " + Dog.getAllDogs("Bulldog")); //overloaded method

        //extent persistence
        try {
            // Write the extent to the given stream
            var out = new ObjectOutputStream(new FileOutputStream(extentFile));
            Pet.writeExtent(out);
            out.close();

            // Read the extent from the given stream
            var in = new ObjectInputStream(new FileInputStream(extentFile));
            Pet.readExtent(in);
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Extent:");
        Dog.show();
    }
}