package address;

public class HomeAddress implements Address{
    String address;

    public HomeAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String type() {
        return "Home";
    }

    @Override
    public String print() {
        return "Ev Adresi: " + address;
    }
}
