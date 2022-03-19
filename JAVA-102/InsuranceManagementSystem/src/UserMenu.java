import account.AccountManager;
import account.Enterprise;
import account.Individual;

import java.util.Scanner;

public class UserMenu {
    String email;
    String password;
    Scanner in = new Scanner(System.in);
    Boolean exit = false;
    AccountManager accountManager = new AccountManager();

    /**
     * Kullanıcı giriş ve kayıt işlemini bu menu üzerinden yapar
     */
    public void showMenu() {
        System.out.print("\n--------Hoşgeldiniz--------");

        while (!exit) {
            System.out.println("\n1 - Giriş Yap");
            System.out.println("2 - Kayıt Ol");
            System.out.println("0 - Çıkış");

            System.out.print("\nGerçekleştirmek istediğiniz işlemi giriniz: ");
            int choice = in.nextInt();

            while (choice < 0 || choice > 2) {
                System.out.print("Lütfen geçerli bir seçim yapınız: ");
                choice = in.nextInt();
            }

            switch (choice) {
                case 1: loginUser();
                        break;
                case 2: registerUser();
                        break;
                case 0: this.exit = true;
                        break;
            }
        }
    }

    /**
     * Kullanıcıdan email ve şifre bilgileri alınır
    */
    public void getEmailAndPassword() {
        in = new Scanner(System.in);
        in = new Scanner(System.in);
        System.out.print("Email: ");
        this.email = in.nextLine();
        System.out.print("Şifre: ");
        this.password = in.nextLine();
    }

    /**
     * Kullanıcıya giriş menusu gösterilir
     */
    public void loginUser() {
        boolean exit = false;
        System.out.println("\n--------GİRİŞ--------");

        while (!exit) {
            in = new Scanner(System.in);
            System.out.println("1 - Bireysel Hesap Giriş");
            System.out.println("2 - Kurumsal Hesap Giriş");
            System.out.println("0 - Ana Menüye Dön");

            System.out.print("\nGerçekleştirmek istediğiniz işlemi giriniz: ");
            int choice = in.nextInt();

            while (choice < 0 || choice > 2) {
                System.out.print("Lütfen geçerli bir seçim yapınız: ");
                choice = in.nextInt();
            }

            switch (choice) {
                case 1: this.getEmailAndPassword();
                        accountManager.login(email, password, "Bireysel");
                        exit = true;
                        break;
                case 2: this.getEmailAndPassword();
                        accountManager.login(email, password, "Kurumsal");
                        exit = true;
                        break;
                case 0: exit = true;
            }
        }
    }

    /**
     * Kullanıcıya kayıt menusu gösterilir
     */
    public void registerUser() {
        boolean exit = false;
        System.out.println("\n--------KAYIT OL--------");

        while (!exit) {
            in = new Scanner(System.in);
            System.out.println("1 - Bireysel Hesap Aç");
            System.out.println("2 - Kurumsal Hesap Aç");
            System.out.println("0 - Ana Menüye Dön");

            System.out.print("\nGerçekleştirmek istediğiniz işlemi giriniz: ");
            int choice = in.nextInt();

            while (choice < 0 || choice > 2) {
                System.out.print("Lütfen geçerli bir seçim yapınız: ");
                choice = in.nextInt();
            }

            switch (choice) { //Kullanıcının seçmiş olduğu hesap tipine göre nesne oluşturulur
                case 1: Individual individual = new Individual();
                        individual.register();
                        accountManager.register(individual);
                        exit = true;
                        break;
                case 2: Enterprise enterprise = new Enterprise();
                        enterprise.register();
                        accountManager.register(enterprise);
                        exit = true;
                        break;
                case 0:
                    exit = true;
            }
        }
    }
}
