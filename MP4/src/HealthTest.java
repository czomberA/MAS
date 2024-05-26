import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HealthTest {
    String name;
    String description;
    boolean requiredToHandleFood;
    List<EmployeesHealthTest> TakenTests = new ArrayList<>();

    public HealthTest(String name, String description, boolean requiredToHandleFood) {
        this.name = name;
        this.description = description;
        this.requiredToHandleFood = requiredToHandleFood;
    }

    public void addEmployeeToTest (EmployeesHealthTest eht) {
        TakenTests.add(eht);

    }

    @Override
    public String toString() {
        return "HealthTest{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", requiredToHandleFood=" + requiredToHandleFood +
                '}';
    }
}
