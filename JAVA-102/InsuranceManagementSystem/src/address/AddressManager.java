package address;

import account.User;
import java.util.Scanner;

public class AddressManager {

    /**
     * kullanıcının adres liste bilgisi gösterilir
     * @param user kullanıcı
     */
    public static void showAddress(User user) {
        System.out.println("\n--------ADRES LİSTESİ--------");
        if(user.getAddressList().size() == 0) {
            System.out.println("\nKayıtlı adresiniz bulunmamaktadır\n");
            return;
        }
        for(Address address : user.getAddressList()){
            System.out.println(address.print());
        }
    }

    /**
     * kullanıcıya ev adresi eklenir
     * @param user kullanıcı
     */
    public static void addHomeAddress(User user) {
        Scanner in = new Scanner(System.in);
        System.out.print("\nEv adresinizi giriniz: ");
        String address = in.nextLine();
        HomeAddress homeAddress = new HomeAddress(address);
        user.getAddressList().add(homeAddress);
        System.out.println("Adres başarılı bir şekilde eklendi");
    }

    /**
     * kullanıcıya iş adresi eklenir
     * @param user kullanıcı
     */
    public static void addBusinessAddress(User user){
        Scanner in = new Scanner(System.in);
        System.out.print("\nİş adresinizi giriniz: ");
        String address = in.nextLine();
        BusinessAddress businessAddress = new BusinessAddress(address);
        user.getAddressList().add(businessAddress);
        System.out.println("Adres başarılı bir şekilde eklendi");
    }

    /**
     * kullanıcının ev adresi silinir
     * @param user kullanıcı
     */
    public static void removeHomeAddress(User user) {
        for (int i=0; i<user.getAddressList().size(); ++i){
            if(user.getAddressList().get(i).type().equals("Home")){
                user.getAddressList().remove(i);
                System.out.println("\nAdres başarılı bir şekilde kaldırıldı");
            }
        }
    }

    /**
     * kullanıcının iş adresi silinir
     * @param user kullanıcı
     */
    public static void removeBusinessAddress(User user) {
        for (int i=0; i<user.getAddressList().size(); ++i){
            if(user.getAddressList().get(i).type().equals("Business")){
                user.getAddressList().remove(i);
                System.out.println("\nAdres başarılı bir şekilde kaldırıldı");
            }
        }
    }
}
