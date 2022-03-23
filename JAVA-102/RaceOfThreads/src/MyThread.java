import java.util.ArrayList;

public class MyThread implements Runnable{
    private static final ArrayList<Integer> oddNumber = new ArrayList<Integer>(10000);
    private static final ArrayList<Integer> evenNumber = new ArrayList<Integer>(10000);
    private final ArrayList<Integer> numbers;

    public MyThread(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }

    /**
     * Her thread sayı listesini kontrol eder ve arraydeki elemanlar çift ise addEvenNumber, tek ise addOddNumber methodunu çağırır
     */
    @Override
    public void run() {
        for (Integer number : this.numbers) {
            if (number % 2 == 0) {
                this.addEvenNumber(number);
            } else {
                this.addOddNumber(number);
            }
        }
    }

    /**
     * Arraye senkronize bir şekilde eleman eklenir. Bu sayede aynı anda bir thread arraye eleman ekleyebilir
     * @param number arraye eklenilecek sayı
     */
    private synchronized void addOddNumber(Integer number) {
        oddNumber.add(number);
    }

    /**
     * Arraye senkronize bir şekilde eleman eklenir. Bu sayede aynı anda bir thread arraye eleman ekleyebilir
     * @param number arraye eklenilecek sayı
     */
    private synchronized void addEvenNumber(Integer number) {
        evenNumber.add(number);
    }

    /**
     * Tek sayılar ekranda gösterilir
     */
    public void printOddNumber() {
        System.out.println("---------------------------Tek Sayılar---------------------------");
        System.out.println(oddNumber);
        System.out.println();
    }

    /**
     * Çift sayılar ekranda gösterilir
     */
    public void printEvenNumber() {
        System.out.println("---------------------------Çift Sayılar---------------------------");
        System.out.println(evenNumber);
        System.out.println();
    }
}
