public class Shift extends ObjectPlus4{
    String name;

    public Shift(String name) {
        this.name = name;
    }

    public static final String roleConsistsOf = "Consists of";
    public static final String roleManagedBy = "Managed by";

    @Override
    public String toString() {
        return "Shift{" +
                "name='" + name + '\'' +
                '}';
    }
}
