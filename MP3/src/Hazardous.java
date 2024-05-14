public class Hazardous extends Chemical{
    public Hazardous(String name, String formula) {
        super(name, formula);
    }
    private static String roleNameFlammable = "specializationFlammable";
    private static String roleNameToxic = "specializationToxic";
    private static String roleNameExplosive = "specializationExplosive";
    private static String roleNameGeneralization = "generalization";
    public Hazardous(String name, String formula, int flashPoint) {
        super (name, formula);
        addFlammable(flashPoint);

    }

    private void addFlammable(int flashPoint) {
        Flammable f = new Flammable(flashPoint);
        this.addLink(roleNameFlammable, roleNameGeneralization, f);
    }

    private void addToxic(double ld50){
        Toxic t = new Toxic(ld50);
        this.addLink(roleNameToxic,roleNameGeneralization, t);
    }

    private void addExplosive(Initiators initiator){
        Explosive e = new Explosive (initiator);
        this.addLink(roleNameExplosive, roleNameGeneralization, e);
    }

    public String getWarning() throws Exception {
        String warning = String.format("WARNING! %s is: \n", this.getName()) ;
        if(this.anyLink(roleNameFlammable)){
            ObjectPlusPlus[] obj = this.getLinks(roleNameFlammable);
            int fp = ((Flammable) obj [0]).getFlashPoint();
            warning = warning + String.format("Flammable (Flash point = %d\u00B0C)", fp) + "\n";
        }
        if(this.anyLink(roleNameToxic)){
            ObjectPlusPlus[] obj = this.getLinks(roleNameToxic);
            double ld = ((Toxic) obj [0]).getLd50();
            warning = warning + String.format("Toxic (Lethal Dose 50 = %f)", ld) + "\n";
        }
        if(this.anyLink(roleNameExplosive)){
            ObjectPlusPlus[] obj = this.getLinks(roleNameExplosive);
            Initiators ini = ((Explosive) obj [0]).getInitiator();
            warning = warning + String.format("Explosive (Initiator = %s)", ini) + "\n";
        }
        return warning;
    }


}
