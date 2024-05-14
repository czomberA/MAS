import java.util.HashSet;

public class SafetyInspector extends Chemist implements ISecurity{

    private int badgeNumber;
    public SafetyInspector(String name, String surname, Position position, String specialization, int badgeNumber) {
        super(name, surname, position, specialization);
        this.badgeNumber = badgeNumber;

    }

    public SafetyInspector(Chemist prevPosition, int badgeNumber){
        super(prevPosition.getName(), prevPosition.getSurname(), prevPosition.getPosition(), prevPosition.getSpecialization());
        this.badgeNumber = badgeNumber;
        HashSet<String> permitsToCopy = prevPosition.getPermits();

        prevPosition.getPosition().setPerson(null);

    }


    @Override
    public int getBadgeNumber() {
        return badgeNumber;
    }

    @Override
    public void setBadgeNumber(int badgeNumber) {
        this.badgeNumber = badgeNumber;
    }


    @Override
    public String toString() {
        return super.toString() + "SafetyInspector{badgeNumber=" + badgeNumber +
                '}';
    }
}
