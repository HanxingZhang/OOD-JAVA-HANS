package generics;

public class Chair extends Furniture {

    private boolean adjustable;

    public Chair() {
        super();
    }

    public Chair(boolean adjustable) {
        super();
        this.adjustable = adjustable;
    }

    public Chair(String name, boolean adjustable) {
        super(name);
        this.adjustable = adjustable;
    }

    public boolean getAdjustable() {
        return adjustable;
    }

    public void setAdjustable() {
        this.adjustable = adjustable;
    }
}
