public class Main {
    public static void main(String[] args) throws Exception {

        //Disjoint Inheritance:
            //Superclass: Chemical {abstract}
            //Subclasses: Hazardous and NonHazardous
        Chemical chem1 = new Hazardous("Acetylene", "C2H2", -17);
        Chemical chem2 = new NonHazardous("Citric acid", "C6H8O7", BiodegrabilityLevel.READILY);
        //Overlapping inheritance using composition:
            //Creating a chemical that's both Hazardous and Explosive
        chem1.addLink("specializationExplosive", "generalization", new Explosive(Initiators.HEAT));

        //Polymorphism in overlapping inheritance - method GetWarning() which returns the hazards of a chemical depending on subclass affiliation
        System.out.println("Hazardous Chemical - overlapping inheritance (Flammable and Explosive)");
        System.out.println(chem1.getWarning());
        System.out.println("NonHazardous Chemical");
        System.out.println(chem2.getWarning());
        System.out.println();

        //Multi-aspect inheritance: Person is divided by:
            // Position(Employee and Trainee) - implemented using composition
                //Position is an abstract class with abstract methods
            // Field(Chemist, Security, SafetyInspector, OperationsOverseer - Simple inheritance
        Person p1 = new Chemist("John", "Doe", new Employee(4000), "Organic Chemistry");
        ((Chemist) p1).addPermit("Handling of flammable materials");
        System.out.println("Chemist who is an employee:");
        System.out.println(p1.toString());
        Person p2 = new Chemist("Bill", "Smith", new Trainee("Handling of hazardous materials"), "Organic Chemistry");
        System.out.println("Chemist who is a trainee:");
        System.out.println(p2.toString());
        //Dynamic inheritance: Changing Chemist to OperationsOverseer
        System.out.println("Former Chemist turned OperationsOverseer");
        p1 = new OperationsOverseer(p1, 134);
        System.out.println(p1.toString());

        //MultiInheritance: SafetyInspector inheriting from both Security and Chemist
        Person p3 = new SafetyInspector("Alex", "Brown", new Employee(4500), "Hazardous Materials", 3);
        ((Chemist)p3).addPermit("Handling of flammable materials");
        ((Chemist)p3).addPermit("Handling of toxic materials");
        ((Chemist)p3).addPermit("Handling of explosive materials");
        System.out.println("Safety Inspector inheriting from Chemist and implementing Security interface:");
        System.out.println(p3.toString());
    }
}