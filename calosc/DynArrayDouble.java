// Z1
public class DynArrayDouble {
    private Double[] table;
    private int nElems;

    public DynArrayDouble(int maxSize) {
        table = new Double[maxSize];
        nElems = 0;
    }

    public void add(Double value) {
        if (nElems >= table.length) {
            Double[] loctable = new Double[table.length * 2];
            for (int i = 0; i < table.length; i++) loctable[i] = table[i];
            table = loctable;
        }
        table[nElems] = value;
        nElems++;
    }

    public boolean remove(int index){
        if(index>=nElems || index<0 || nElems==0){
            return false;
        }
        for (int i = index; i < nElems-1; i++) {
            table[i]= table[i+1];
        }
        nElems--;
        return true;
    }
    public int find(Double searchElem){
        for (int i = 0; i < nElems; i++) {
            if(table[i].doubleValue()==searchElem)
                return i;
        }
        return -1;
    }
    public int size(){
        return nElems;
    }
    public Double get(int index){
        return table[index];
    }
    public void print(){
        for (int i = 0; i < nElems; i++) {
            System.out.print(get(i)+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int maxSize = 5;
        DynArrayDouble array = new DynArrayDouble(maxSize);

        array.add(new Double(123));
        array.add(new Double(234.432));
        array.add(new Double(345));
        array.print();
        array.remove(1);
        array.print();
        array.add(new Double(555.55));
        array.print();
        array.add(new Double(666.666));
        array.print();
        System.out.println(array.find(new Double(555.55)));
    }

}

 /*
Konstruktor DynArrayDouble(int maxSize): Tworzy nową tablicę o maksymalnym rozmiarze maxSize i ustawia liczbę elementów w tablicy na 0.

Metoda add(Double value): Dodaje podaną wartość do tablicy. Jeśli tablica jest pełna, jej rozmiar jest automatycznie podwajany.

Metoda get(int index): Zwraca element z tablicy o podanym indeksie.

Metoda size(): Zwraca liczbę elementów w tablicy.

Metoda remove(int index): Usuwa element z tablicy o podanym indeksie. Jeśli indeks jest nieprawidłowy lub tablica jest pusta, zwraca false. W przeciwnym razie, zwraca true.

Metoda find(Double searchElem): Znajduje i zwraca indeks elementu o podanej wartości. Jeśli element nie zostanie znaleziony, zwraca -1.

Metoda print(): Drukuje zawartość tablicy.
     */

/*
remove(ind index)
Działanie metody jest następujące:

Sprawdza, czy tablica nie jest pusta oraz czy podany indeks jest prawidłowy (czy jest mniejszy niż liczba elementów w tablicy i większy lub równy 0). Jeśli jeden z tych warunków jest nie spełniony zwraca false
Przesuwa wszystkie elementy znajdujące się po usuwanym elemencie o jedno miejsce w lewo, tak aby zachować ciągłość tablicy
Zmniejsza liczbę elementów w tablicy o 1
Zwraca true, oznaczając że usunięcie się powiodło
 */

// TO SAMO TYLKO STRING
/*
public class DynArrayString {
    private String[] table;
    private int nElems;

    public DynArrayString(int maxSize) {
        table = new String[maxSize];
        nElems = 0;
    }

    public void add(String value) {
        if (nElems >= table.length) {
            String[] locTable = new String[table.length * 2];
            for (int i = 0; i < table.length; i++) {
                locTable[i] = table[i];
            }
            table = locTable;
        }
        table[nElems] = value;
        nElems++;
    }

    public String get(int index) {
        return table[index];
    }

    public int size() {
        return nElems;
    }

    public boolean remove(int index) {
        if (nElems == 0 || index >= nElems || index < 0) {
            return false;
        }
        for (int i = index; i < nElems - 1; i++) {
            table[i] = table[i + 1];
        }
        nElems--;
        return true;
    }
     public int find(String searchElem) {
        for (int i = 0; i < nElems; i++) {
            if (table[i].equals(searchElem)) {
                return i;
            }
        }
        return -1;
    }

    public void print() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int maxSize = 5;
        DynArrayString array = new DynArrayString(maxSize);

        array.add("Hello");
        array.add("World");
        array.add("Java");
        array.print();
        array.remove(1);
        array.print();
        array.add("String");
        array.print();
        array.add("Array");
        array.print();
    }
}

 */

