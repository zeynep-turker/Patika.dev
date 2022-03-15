public class MyList<T> {
    private T list[];
    private int size = 0;
    private int capacity = 10;

    MyList() {
        list = (T[]) new Object[10];
    }

    MyList(int capacity) {
        list = (T[]) new Object[capacity];
    }

    void add(T data){
        if(getSize() == getCapacity()){ //listenin kapasitesi dolduysa 2 katına artırılır
            setCapacity(getCapacity() * 2);
        }
        list[size++] = data; //data, listeye eklenir
    }

    public T get(int index) {
        if(index < 0 || index > size-1) //gelen index!in liste sınırını aşıp aşmadığı kontrol edilir
            return null;

        return list[index];
    }
    public T remove(int index) {
        if(index < 0 || index > size-1) //gelen index!in liste sınırını aşıp aşmadığı kontrol edilir
            return null;

        T data = list[index];

        for(int i=index; i<getSize(); ++i){ // listeden kaldırılan datanın yerine diğer elemanlar sırasıyla kaydırılır
            list[i] = list[i+1];
        }
        list[--size] = null;

        return data;
    }

    public T set(int index, T data) {
        if(index < 0 || index > size-1) //gelen index!in liste sınırını aşıp aşmadığı kontrol edilir
            return null;

        list[index] = data;

        return data;
    }

    public String toString() {
        String str = "[";

        for (int i=0; i<getSize(); ++i) {
            if(i != 0 && i != getSize()){
                str += ",";
            }
            str += get(i);
        }
        str += "]";

        return str;
    }

    int indexOf(T data) {
        int index = -1;

        for(int i=0; i<getSize(); ++i) { //listenin başından başlanılarak gelen data aranır ve bulunursa index i return edilir
            if(data == get(i)) {
                index = i;
                break;
            }
        }

        return index;
    }

    int lastIndexOf(T data) {
        int index = -1;

        for(int i=getSize()-1; i>=0; --i) { //listenin sonundan başlanılarak gelen data aranır ve bulunursa index i return edilir
            if(data == get(i)) {
                index = i;
                break;
            }
        }

        return index;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T[] toArray() {
        return list;
    }

    public void clear() {
        for (int i=0; i<size; ++i)
            list[i] = null;

        size = 0;
    }

    public MyList<T> subList(int start,int finish) { //gelen aralıktaki elemanlar yeni oluşturulan generic objenin listesine eklenir ve obje return edilir
        MyList<T> sublist = new MyList<>(finish - start + 1);

        for(int i=start; i<=finish; ++i){
            sublist.add(get(i));
        }

        return sublist;
    }

    public boolean contains(T data) {
        for (int i=0; i<getSize(); ++i) { //gelen data listenin içinde kontrol edilir ve bulunursa true aksi takdirde false return edilir
            if(data == get(i))
                return true;
        }
        return false;
    }

    public int size() {
        return getSize();
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        T[] newList = (T[]) new Object[capacity];

        for(int i=0; i<size; ++i){
            newList[i] = list[i];
        }

        list = newList;
        this.capacity = capacity;
    }

}
