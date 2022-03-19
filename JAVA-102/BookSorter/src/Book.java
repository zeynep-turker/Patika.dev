public class Book implements Comparable<Book> {
    private String name;
    private int pageNumber;
    private String authorName;
    private String releaseDate;

    public Book(String name, int pageNumber, String authorName, String releaseDate) {
        this.name = name;
        this.pageNumber = pageNumber;
        this.authorName = authorName;
        this.releaseDate = releaseDate;
    }

    /**
     *
     * @return kitap bilgileri return edilir
     */
    @Override
    public String toString() {
        return "Kitap Adı: " + this.getName() + ", Sayfa Sayısı: " + this.getPageNumber()
                +  ", Yazar Adı: " + this.getAuthorName() + ", Yayın Tarihi: " + this.getReleaseDate();
    }

    /**
     * kitaplar isimlerine göre karşılaştırıldı
     * @param o
     * @return
     */
    @Override
    public int compareTo(Book o) {
        return this.getName().compareTo(o.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
