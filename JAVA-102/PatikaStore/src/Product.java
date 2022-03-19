public class Product {
    private int id;
    private double price;
    private double discountRate;
    private int stockAmount;
    private String name;
    private Brand brand;
    private double screenSize;
    private int ram;
    private int storage;
    private int batteryPower;
    private String color;
    private int camera;
    static int notebookID = 1;
    static int phoneID = 1;

    public Product(double price, double discountRate, int stockAmount, String name, Brand brand, double screenSize, int ram, int storage) {
        this.id = notebookID++;
        this.price = price;
        this.discountRate = discountRate;
        this.stockAmount = stockAmount;
        this.name = name;
        this.brand = brand;
        this.screenSize = screenSize;
        this.ram = ram;
        this.storage = storage;
    }

    public Product(double price, double discountRate, int stockAmount, String name, Brand brand, double screenSize, int ram, int storage, int batteryPower, String color, int camera) {
        this.id = phoneID++;
        this.price = price;
        this.discountRate = discountRate;
        this.stockAmount = stockAmount;
        this.name = name;
        this.brand = brand;
        this.screenSize = screenSize;
        this.ram = ram;
        this.storage = storage;
        this.batteryPower = batteryPower;
        this.color = color;
        this.camera = camera;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public int getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(int batteryPower) {
        this.batteryPower = batteryPower;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCamera() {
        return camera;
    }

    public void setCamera(int camera) {
        this.camera = camera;
    }
}
