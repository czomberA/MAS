public class Security extends Person implements ISecurity{
    private int badgeNumber;


    public Security(String name, String surname, Position position, int badgeNumber) {
        super(name, surname, position);
        this.badgeNumber = badgeNumber;
    }

    @Override
    public int getBadgeNumber() {
        return badgeNumber;
    }

    @Override
    public void setBadgeNumber(int badgeNumber) {
        this.badgeNumber = badgeNumber;
    }


}
