import java.util.HashSet;

public class Chemist extends Person{
    private HashSet<String> permits = new HashSet<>();
    private String specialization;
    public Chemist(String name, String surname, Position position, String specialization) {
        super(name, surname, position);
        this.specialization = specialization;

    }

    public void addPermit(String p){
        if(permits.contains(p)){
            System.out.println("This permit has already been added");
        } else {
            permits.add(p);
        }
    }


    public HashSet<String> getPermits() {
        return permits;
    }

    public void setPermits(HashSet<String> permits) {
        this.permits = permits;
    }



    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return super.toString() + "Chemist{" +
                "permits=" + permits +
                ", specialization='" + specialization + '\'' +
                '}';
    }
}
