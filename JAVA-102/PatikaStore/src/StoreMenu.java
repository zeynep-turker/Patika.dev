import java.util.Scanner;

public class StoreMenu {
    private Scanner in = new Scanner(System.in);
    private Store store;

    public StoreMenu() {
        store = new Store();
    }

    public void showMenu() {
        boolean exit = false;

        while(!exit) {
            System.out.println("\n1 - Notebook İşlemleri");
            System.out.println("2 - Cep Telefonu İşlemleri");
            System.out.println("3 - Marka Listele");
            System.out.println("4 - Çıkış");

            System.out.print("\nGeçerleştirmek istediğiniz işlemi giriniz: ");

            int choice = in.nextInt();
            while (choice < 1 || choice > 4) {
                System.out.print("Lütfen geçerli bir seçenek giriniz: ");
                choice = in.nextInt();
            }

            switch (choice) {
                case 1:
                    this.operations("Notebook");
                    break;
                case 2:
                    this.operations("Cep Telefonu");
                    break;
                case 3:
                    this.showBrands();
                    break;
                case 4:
                    exit = true;
                    break;
            }
        }
    }

    private void operations(String name) {
        boolean exit = false;

        while(!exit) {
            System.out.println("\n1 - Ürün Ekle");
            System.out.println("2 - Ürün Çıkar");
            System.out.println("3 - Ürünleri Listele");
            System.out.println("4 - Ürünleri ID'lerine Göre Listele");
            System.out.println("5 - Ürünleri Markalarına Göre Listele");
            System.out.println("6 - Çıkış");

            System.out.print("\nLütfen seçiminizi giriniz: ");
            int choice = in.nextInt();

            while(choice<0 || choice> 6) {
                System.out.println("Lütfen geçerli bir seçim giriniz: ");
                choice = in.nextInt();
            }

            switch (choice){
                case 1: store.addProduct(name);
                        break;
                case 2: store.removeProduct(name);
                        break;
                case 3: store.printProducts(name);
                        break;
                case 4: store.printProductAsID(name);
                        break;
                case 5: store.printProductAsBrands(name);
                        break;
                case 6: exit=true;
                        break;
            }
        }
    }

    private void showBrands() {
        this.store.printBrands();
    }
}
