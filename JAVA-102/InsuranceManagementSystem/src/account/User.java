package account;

import address.Address;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class User{
    private String name;
    private String surname;
    private String email;
    private String password;
    private String profession;
    private int age;
    private ArrayList<Address> addressList;
    private Date lastLoginDate;

    public User() {
        addressList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getProfession() {
        return profession;
    }

    public int getAge() {
        return age;
    }

    public ArrayList<Address> getAddressList() {
        return addressList;
    }

    public String getLastLoginDate() { //Son giriş zamanı gösterilirken belli bir format ile gösterilir
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return formatter.format(lastLoginDate);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddressList(ArrayList<Address> addressList) {
        this.addressList = addressList;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }
}
