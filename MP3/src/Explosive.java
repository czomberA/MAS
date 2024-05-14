public class Explosive extends ObjectPlusPlus{
    private Initiators initiator;

    public Explosive(Initiators initiator) {
        this.initiator = initiator;
    }

    public Initiators getInitiator() {
        return initiator;
    }

    public void setInitiator(Initiators initiator) {
        this.initiator = initiator;
    }
}
