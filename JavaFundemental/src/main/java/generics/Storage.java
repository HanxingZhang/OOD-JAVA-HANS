package generics;

public class Storage<T> {

    private T item;

    public void putInStorage(T item) {
        this.item = item;
    }

    public T getFromStorage() {
        return item;
    }

}
