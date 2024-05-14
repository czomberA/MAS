public abstract class Chemical extends ObjectPlusPlus{
    private String name;
    private String formula;

    public Chemical(String name, String formula) {
        this.name = name;
        this.formula = formula;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public abstract String getWarning() throws Exception;
}
