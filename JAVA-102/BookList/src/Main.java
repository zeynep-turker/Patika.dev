import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>(10);
        books.add(new Book("Simyacı", 184, "Paulo Coelho", "28.09.2019"));
        books.add(new Book("Kırmızı Pazartesi", 100, "Gabriel Garcia Marquez", "30.10.2019"));
        books.add(new Book("Hayvan Çiftliği", 152, "George Orwell", "28.09.2000"));
        books.add(new Book("Cesur Yeni Dünya", 272, "Aldous Huxley", "02.09.2019"));
        books.add(new Book("Uğultulu Tepeler", 408, "Emily Bronte", "01.08.2019"));
        books.add(new Book("Cimri", 199, "Adam Coelho", "28.09.2019"));
        books.add(new Book("Sihirbazın Kitabı", 150, "Gökhan Yılmaz", "30.10.2019"));
        books.add(new Book("Yabancı", 253, "Öznur Yıldırım", "28.09.2000"));
        books.add(new Book("Gençlik", 272, "Fatma Huxley", "02.09.2019"));
        books.add(new Book("Güneşli Tepeler", 852, "Cenk Bronte", "01.08.2019"));

        //stream collect kullanılarak yeni bir map oluşturuldu
        Map<String, String> nameAndAuthor = books
                .stream()
                .collect(Collectors.toMap(book -> book.getName(), book -> book.getAuthorName()));

        System.out.println("----------Kitaplar ve Yazarları----------");
        nameAndAuthor.forEach((key, value) -> System.out.println(key + " -> " + value)); //map ekranda gösterilir


        System.out.println("\n\n----------Sayfa sayısı 100'den fazla olan kitaplar----------");
        //stream filter kullanılarak sayfa numarası 100 den büyük olanlar listelendi ve collect ile de yeni bir list oluşturuldu
        List<Book> bookList = books
            .stream()
            .filter(book -> book.getPageNumber() > 100)
            .collect(Collectors.toList());

        for (Book book : bookList) System.out.println(book);
    }
}
