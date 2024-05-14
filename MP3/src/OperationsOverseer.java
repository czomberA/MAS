public class OperationsOverseer extends Person{
    private int officeNumber;

    public OperationsOverseer(String name, String surname, Position p, int officeNumber) {
        super(name, surname, p);
        this.officeNumber = officeNumber;
    }

    public OperationsOverseer (Person previousPerson, int officeNumber){
        super(previousPerson.getName(), previousPerson.getSurname(), previousPerson.getPosition());
        this.officeNumber = officeNumber;

    }

    public int getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(int officeNumber) {
        this.officeNumber = officeNumber;
    }

    @Override
    public String toString() {
        return super.toString() + "OperationsOverseer{" +
                "officeNumber=" + officeNumber +
                '}';
    }
}
