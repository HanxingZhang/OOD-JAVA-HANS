package generics;

public class Table extends Furniture {
    private String shape;

    public Table() {
    }

    public Table(String shape) {
        this.shape = shape;
    }

    public Table(String name, String shape) {
        super(name);
        this.shape = shape;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }
}
