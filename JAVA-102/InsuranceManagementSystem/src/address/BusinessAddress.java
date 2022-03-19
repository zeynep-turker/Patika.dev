package address;

public class BusinessAddress implements Address{
    String address;

    public BusinessAddress(String address) {
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
        return "Business";
    }

    @Override
    public String print() {
        return "İş Adresi: " + address;
    }
}
