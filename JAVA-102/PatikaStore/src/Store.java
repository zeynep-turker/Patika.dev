import java.util.*;

public class Store {
    TreeSet<Brand> brands = new TreeSet<>();
    HashMap<String, ArrayList<Product>> products = new HashMap<>();
    Scanner in = new Scanner(System.in);

    public Store() {
        String[] brandNames = {"Samsung", "Lenovo", "Apple", "Huawei", "Casper", "Asus", "HP", "Xiaomi", "Monster"};
        for (int i = 0; i < brandNames.length; ++i) {
            brands.add(new Brand(i + 1, brandNames[i]));
        }
        products.put("Notebook", new ArrayList<Product>());
        products.put("Cep Telefonu", new ArrayList<Product>());
    }

    private TreeSet<Brand> getBrands() {
        return brands;
    }

    public void printBrands() {
        Iterator<Brand> iterator = getBrands().iterator();

        while (iterator.hasNext()) {
            Brand brand = iterator.next();
            System.out.println(brand.getId() + " - " + brand.getName());
        }
    }

    public void addProduct(String name) {
        Product newProduct;
        in = new Scanner(System.in);

        System.out.println("Ürünün bilgilerini giriniz: ");

        System.out.print("Ürün İsmi: ");
        String productName = in.nextLine();

        System.out.print("Birim Fiyatı : ");
        double price = in.nextDouble();

        System.out.print("İndirim Oranı: ");
        double discountRate = in.nextDouble();

        System.out.print("Stok Miktarı: ");
        int stockAmount = in.nextInt();

        System.out.println("Marka Seçiniz: ");
        this.printBrands();
        int choice = in.nextInt();
        while (choice<0 || choice > getBrands().size()){
            System.out.println("Lütfen geçerli bir marka yapınız: ");
            choice = in.nextInt();
        }
        ArrayList<Brand> brands = new ArrayList<>(getBrands());
        Brand brand = brands.get(choice);

        System.out.print("Depolama: ");
        int storage = in.nextInt();

        System.out.print("RAM: ");
        int ram = in.nextInt();

        System.out.print("Ekran Boyutu: ");
        double screenSize = in.nextDouble();

        int memory, camera, batteryPower;
        String color;

        if(name.equals("Notebook")) {
            newProduct = new Product(price, discountRate, stockAmount, productName, brand, screenSize, ram, storage);
        }
        else {
            System.out.print("Pil Gücü: ");
            batteryPower = in.nextInt();

            System.out.print("Renk: ");
            color = in.next();

            System.out.print("Kamera: ");
            camera = in.nextInt();

            newProduct = new Product(price, discountRate, stockAmount, productName, brand, screenSize, ram, storage, batteryPower, color, camera);
        }

        products.get(name).add(newProduct);
    }

    public void removeProduct(String name) {
        this.printProducts(name);
        System.out.print("\nSilmek istediğiniz ürünün Id'sini giriniz: ");

        int choice = in.nextInt();
        if(choice < 1) {
            System.out.println("Geçersiz Id girdiniz!");
            return;
        }

        for (int i=0; i<getProducts().get(name).size(); ++i){
            if(getProducts().get(name).get(i).getId() == choice){
                getProducts().get(name).remove(i);
                return;
            }
        }
        System.out.println("Bu Id'ye sahip ürün bulunamadı!");
    }

    public HashMap<String, ArrayList<Product>> getProducts() {
        return products;
    }

    public void printProducts(String name) {
        ArrayList<Product> products = this.products.get(name);
        this.showProduct(products, name);
    }

    public void showProduct(ArrayList<Product> products, String name) {


        if(name.equals("Notebook")) {
            System.out.println("\n-----------------------------------------ÜRÜNLER--------------------------------------------------");
            System.out.println("| ID | Ürün Adı                      | Fiyat     | Marka     | Depolama  | Ekran     | RAM          |");
            System.out.println("----------------------------------------------------------------------------------------------------");
        }
        else{
            System.out.println("\n----------------------------------------------------------ÜRÜNLER------------------------------------------------------------------");
            System.out.println("| ID | Ürün Adı                      | Fiyat     | Marka     | Depolama  | Ekran     | Kamera    | Pil       | RAM       | Renk      |");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        }

        for (int i=0; i<products.size(); ++i){
            Product product = products.get(i);
            if(name.equals("Notebook")){
                System.out.format("| %-2s | %-30s| %s TL | %-10s| %-10s| %-12s | %-10s |\n" ,
                        product.getId(), product.getName(), product.getPrice(), product.getBrand().getName(),
                        product.getStorage(), product.getScreenSize(), product.getRam());
            }
            else
                System.out.format("| %-2s | %-30s| %s TL | %-10s| %-10s| %-12s | %-10s | %-10s | %-10s | %-10s |\n" ,
                        product.getId(), product.getName(), product.getPrice(), product.getBrand().getName(),
                        product.getStorage(), product.getScreenSize(), product.getCamera(), product.getBatteryPower(), product.getRam(), product.getColor());
        }
        System.out.println("\n");
    }

    public void printProductAsBrands(String name) {
        ArrayList<Product> sortedList = new ArrayList<>();

        sortedList.addAll(this.getProducts().get(name));

        sortedList.sort((o1, o2)
                -> o1.getBrand().compareTo(
                o2.getBrand()));

        this.showProduct(sortedList, name);
    }

    public void printProductAsID(String name) {
        ArrayList<Product> sortedList = new ArrayList<>();

        sortedList.addAll(this.getProducts().get(name));

        sortedList.sort((o1, o2)
                -> o1.getId() - o2.getId());

        this.showProduct(sortedList, name);
    }


}
