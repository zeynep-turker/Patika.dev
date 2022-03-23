import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(10000);

        for(int i=1; i<=10000; ++i){
            numbers.add(i);
        }

        MyThread[] myThreads = new MyThread[4];
        Thread[] threads = new Thread[4];


        int from = 0;
        int to;
        for (int i=0; i<4; ++i) { //10000 lik aray 4 e bölünerek MyThread nesneleri oluşturuldu ve bu MyThread nesneleriyle Threadler oluşturuldu.
            to = 2500 * (i+1);
            myThreads[i] = new MyThread(new ArrayList<>(numbers.subList(from, to)));
            threads[i] = new Thread(myThreads[i]);
            threads[i].start(); //Thread çalıştırılır
            from += 2500;
        }

        try {
            for (int i=0; i<4; ++i) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Tek ve çift sayılar ekranda gösterilir
        myThreads[0].printEvenNumber();
        myThreads[0].printOddNumber();

        myThreads[1].printEvenNumber();
        myThreads[1].printOddNumber();
    }
}

