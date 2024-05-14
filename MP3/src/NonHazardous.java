public class NonHazardous extends Chemical{
    BiodegrabilityLevel bioLevel;
    public NonHazardous(String name, String formula, BiodegrabilityLevel bioLevel) {
        super(name, formula);
        this.bioLevel = bioLevel;
    }

    public BiodegrabilityLevel getBioLevel() {
        return bioLevel;
    }

    public void setBioLevel(BiodegrabilityLevel bioLevel) {
        this.bioLevel = bioLevel;
    }

    @Override
    public String getWarning() throws Exception {
        return String.format("%s is non-hazardous", this.getName());
    }
}
