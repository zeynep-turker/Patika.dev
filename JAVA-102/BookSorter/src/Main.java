import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        TreeSet<Book> books = new TreeSet<>();

        books.add(new Book("Simyacı", 184, "Paulo Coelho", "28.09.2019"));
        books.add(new Book("Kırmızı Pazartesi", 100, "Gabriel Garcia Marquez", "30.10.2019"));
        books.add(new Book("Hayvan Çiftliği", 152, "George Orwell", "28.09.2000"));
        books.add(new Book("Cesur Yeni Dünya", 272, "Aldous Huxley", "02.09.2019"));
        books.add(new Book("Uğultulu Tepeler", 408, "Emily Bronte", "01.08.2019"));

        Iterator<Book> iterator = books.iterator();

        System.out.println("Kitaplar A'dan Z'ye göre sıralanıyor..\n");
        while (iterator.hasNext()) { //treeSet iterator ile gezildi
            System.out.println(iterator.next().toString());
        }
        System.out.println("\n");

        /*
          Kitapların sayfa sırasına göre karşılaştırılması için compare methodu override edildi
         */
        TreeSet<Book> books1 = new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPageNumber() - o2.getPageNumber();
            }
        });

        books1.addAll(books);

        Iterator<Book> iterator1 = books1.iterator();

        System.out.println("Kitaplar sayfa sırasına göre sıralanıyor..\n");
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next().toString());
        }
    }
}
