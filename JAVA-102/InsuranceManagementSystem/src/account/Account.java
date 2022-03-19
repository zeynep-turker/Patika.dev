package account;

import insurance.*;
import address.AddressManager;
import exception.InvalidAuthenticationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

enum AuthenticationStatus {
    SUCCESS, FAIL
}

public abstract class Account implements Comparable<Account> {
    User user;
    private String type;
    private AuthenticationStatus loginStatus;
    private final ArrayList<Insurance> insuranceList = new ArrayList<>();
    private final Scanner in = new Scanner(System.in);

    public final void showUserInfo() {
        System.out.println("\n--------HESAP BİLGİLERİ--------");
        System.out.println("Ad: "+getUser().getName());
        System.out.println("Soyisim: "+getUser().getSurname());
        System.out.println("Yaş: " + getUser().getAge());
        System.out.println("Meslek: " + getUser().getProfession());
        System.out.println("Son giriş tarihi: " + getUser().getLastLoginDate());
        System.out.println("Kayıt olduğu sigorta sayısı: " + this.insuranceList.size());
        System.out.println();
    }

    public abstract void addInsurance(Insurance insurance);

    public ArrayList<Insurance> getInsuranceList() {
        return insuranceList;
    }

    public void login(String email, String password) {
        try {
            if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
                Date date = new Date();
                getUser().setLastLoginDate(date);
                System.out.println("\nGiriş Başarılı!");
                System.out.println("Hoşgeldin "+ getUser().getName() + " " + getUser().getSurname());
                System.out.println();
                loginStatus = AuthenticationStatus.SUCCESS;
                accountMenu();
            }
            else {
                throw new InvalidAuthenticationException("Email veya şifre yanlış");
            }
        }
        catch (InvalidAuthenticationException e) {
            e.getMessage();
        }
    }

    public void register(){
        Scanner in = new Scanner(System.in);
        System.out.println("Lütfen Bilgileriniz giriniz");
        System.out.print("İsim: ");
        this.getUser().setName(in.next());
        System.out.print("Soyisim: ");
        this.getUser().setSurname(in.next());
        System.out.print("Email: ");
        this.getUser().setEmail(in.next());
        System.out.print("Şifre: ");
        this.getUser().setPassword(in.next());
        System.out.print("Meslek: ");
        this.getUser().setProfession(in.next());
        System.out.print("Yaş: ");
        this.getUser().setAge(in.nextInt());
    }

    public void accountMenu() {
        boolean exit = false;

        while(!exit) {
            System.out.println("\n--------HESAP MENU--------");
            System.out.println("1 - Hesap Bilgilerim");
            System.out.println("2 - Adreslerim");
            System.out.println("3 - Sigortalarım");
            System.out.println("0 - Çıkış Yap");

            System.out.print("\nGerçekleştirmek istediğiniz işlemi giriniz: ");
            int choice = in.nextInt();

            while (choice < 0 || choice > 3) {
                System.out.print("Lütfen geçerli bir seçim yapınız: ");
                choice = in.nextInt();
            }

            switch (choice) {
                case 1: showUserInfo();
                        break;
                case 2: addressMenu();
                        break;
                case 3: insuranceMenu();
                        break;
                case 0: exit = true;
                        loginStatus = AuthenticationStatus.FAIL;
                        break;
            }
        }
    }

    public void addressMenu() {
        boolean exit = false;

        while(!exit) {
            System.out.println("\n--------ADRES MENU--------");
            System.out.println("1 - Adreslerim");
            System.out.println("2 - Ev Adresi Ekle");
            System.out.println("3 - İş Adresi Ekle");
            System.out.println("4 - Ev Adresi Sil");
            System.out.println("5 - İş Adresi Sil");
            System.out.println("0 - Çıkış");

            System.out.print("\nGerçekleştirmek istediğiniz işlemi giriniz: ");
            int choice = in.nextInt();

            while (choice < 0 || choice > 5) {
                System.out.print("Lütfen geçerli bir seçim yapınız: ");
                choice = in.nextInt();
            }

            switch (choice) {
                case 1:
                    AddressManager.showAddress(getUser());
                    break;
                case 2:
                    AddressManager.addHomeAddress(getUser());
                    break;
                case 3:
                    AddressManager.addBusinessAddress(getUser());
                    break;
                case 4:
                    AddressManager.removeHomeAddress(getUser());
                    break;
                case 5:
                    AddressManager.removeBusinessAddress(getUser());
                    break;
                case 0:
                    exit = true;
                    break;
            }
        }
    }

    public void showIssurance() {
        System.out.println("\n--------SİGORTALARINIZ--------");
        if(insuranceList.size() == 0) {
            System.out.println("\nKayıtlı sigortanız bulunmamaktadır!\n");
            return;
        }
        for(Insurance insurance : insuranceList){
            System.out.println(insurance.getName() + " Sigortası");
        }
    }

    public void controlInsurance(Insurance insurance) {
        for(Insurance ins : insuranceList) {
            if(ins.getName().equals(insurance.getName())) {
                System.out.println();
                System.out.println(insurance.getName() + " sigortanız zaten bulunmakta!\n");
                return;
            }
        }
        this.insuranceList.add(insurance);
    }

    public void insuranceMenu() {
        boolean exit = false;

        while(!exit) {
            System.out.println("\n--------SİGORTA MENU--------");
            System.out.println("1 - Sigortalarım");
            System.out.println("2 - Sağlık Sigortası Ekle");
            System.out.println("3 - Konut Sigortası Ekle");
            System.out.println("4 - Seyahat Sigortası Ekle");
            System.out.println("5 - Otomobil Sigortası Ekle");
            System.out.println("0 - Çıkış");

            System.out.print("\nGerçekleştirmek istediğiniz işlemi giriniz: ");
            int choice = in.nextInt();

            while (choice < 0 || choice > 5) {
                System.out.print("Lütfen geçerli bir seçim yapınız: ");
                choice = in.nextInt();
            }

            switch (choice) {
                case 1:
                    this.showIssurance();
                    break;
                case 2:
                    this.controlInsurance(new HealthInsurance());
                    break;
                case 3:
                    this.controlInsurance(new ResidenceInsurance());
                    break;
                case 4:
                    this.controlInsurance(new TravelInsurance());
                    break;
                case 5:
                    this.controlInsurance(new CarInsurance());
                    break;
                case 0:
                    exit = true;
                    break;
            }
        }
    }

    public String getLoginStatus() {
        return loginStatus.toString();
    }

    @Override
    public int compareTo(Account o) {
        return this.getUser().getEmail().compareTo(o.getUser().getEmail());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public User getUser() {
        return user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
