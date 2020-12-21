package generics;

public abstract class Furniture {
    String name;

    public Furniture() {
        super();
    }

    public Furniture(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
