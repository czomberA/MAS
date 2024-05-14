public class Toxic extends ObjectPlusPlus{
    private double ld50;
    public Toxic(double ld50) {
        this.ld50 = ld50;
    }

    public double getLd50() {
        return ld50;
    }

    public void setLd50(double ld50) {
        this.ld50 = ld50;
    }
}
