public class Trainee extends Position{

    private Person p;
    String trainingInprogress;

    public Trainee(String trainingInprogress) {
        this.trainingInprogress = trainingInprogress;


    }





    @Override
    public String toString() {
        return "Trainee{" + trainingInprogress
                 +
                '}';
    }

    @Override
    public void setPerson(Person p) {
        this.p = p;
    }

    @Override
    public Person getPerson() {
        return p;
    }
}
