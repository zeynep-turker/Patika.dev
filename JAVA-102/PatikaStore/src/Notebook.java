public class Notebook {//extends Product{
    private int storage;

    public Notebook(int id, double price, int discountRate, int stockAmount, String name, Brand brand, double screenSize, int ram, int storage) {
        //super(id, price, discountRate, stockAmount, name, brand, screenSize, ram);
        this.storage = storage;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }
}
