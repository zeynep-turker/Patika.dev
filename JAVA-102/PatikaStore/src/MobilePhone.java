public class MobilePhone{
    private int memory;
    private int batteryPower;
    private String color;

    public MobilePhone(int id, double price, int discountRate, int stockAmount, String name, Brand brand, double screenSize, int ram, int memory, int batteryPower, String color) {
        //super(id, price, discountRate, stockAmount, name, brand, screenSize, ram);
        this.memory = memory;
        this.batteryPower = batteryPower;
        this.color = color;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
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
}
