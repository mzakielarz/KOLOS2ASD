package sort;


//Klasa implmentujaca tablice dynamiczna liczb calkowitych
// wraz z mozliwoscia sortowania

public class IntDynArrayWithSort
{
    private int [] table;  //Referencja do tablicy
    private int nElems;  //Aktualna liczba elementow w tablicy

    public IntDynArrayWithSort(int maxSize)  // Konstruktor
    {
        table = new int[maxSize]; // Tworzymy tablice
        nElems = 0;               // Na razie brak elementow w tablicy
    }

    //Add z relokacja
    public void add(int value)    	// Wstawienie elementu do tablicy
    {
        if (nElems >= table.length)
        {
            int [] locTable = new int[table.length*2];
            for (int i=0; i<table.length; i++) locTable[i]=table[i];
            table = locTable;
        }

        table[nElems] = value;       	// Wstawiamy element
        nElems++;                      	// Zwiekszamy licznik elementow
    }

    public int get(int index) // Pozyskanie elementu o danym indeksie
    {
        return table[index];
    }

    public int size() // Aktualna liczba elementow w tablicy
    {
        return nElems;
    }

    public boolean remove(int index) 	// Usuniecie elementu o danym indeksie
    {
        if (nElems==0) return false;
        for (int j = index; j < nElems-1; j++) 	// Przesuwamy pozostale elementy w lewo
        {
            table[j] = table[j + 1];
        }
        nElems--;                   		// Zmniejszamy licznik elementow
        return true;
    }

    public int find(int searchElem) // Szukanie okreslonego elementu
    {
        for (int j = 0; j < nElems; j++)
        {
            if (table[j] == searchElem) return j; //Element znaleziono
        }
        return -1; // Elementu nie znaleziono
    }

     //-----------------------------------------------------------------
    
    public void bubbleSort() //Sortowanie bąbelkowe
    {        
        for (int i = nElems - 1; i > 0; i--)   // petla zewnetrzna (malejaca)
        {               
            for (int j = 0; j < i; j++)        // petla wewnetrzna (rosnaca)
            {
                if (table[j] > table[j + 1])       // zla kolejnosc?
                {
                    swap(j, j + 1);     // no to zamiana
                }
            }
        }
    }

    //-----------------------------------------------------------------

    public void selectionSort() //Sortowanie przez wybor
    {        
        for (int i = 0; i < nElems - 1; i++)
        {
            System.out.print("i="+i+" Przed: ");
            for (int j=0; j<nElems; j++)
            {
                System.out.print(table[j]+" ");
            }
            
            int minPos = i;
            for (int j = i + 1; j < nElems; j++) //Wyszukanie elementu najmniejszego od pozycji i+1 do nElemes-1
            {
                if (table[j] < table[minPos])
                {
                    minPos = j; // ...mamy nowe minimum
                }
            }
            swap(i, minPos); //Zamiana najmniejszego elementu z elementem na pozycji i
            
            System.out.print(" Po: ");
            for (int j=0; j<nElems; j++)                
            {
                System.out.print(table[j]+" ");
            }
            System.out.println();            
        } 
   }

    //-----------------------------------------------------------------
    
    public void insertionSort() //Sortowanie przez wstawianie
    {        
        for (int i = 1; i < nElems; i++)  // i to pozycja pierwego nieposortowanego elementu
        {
            int e = table[i]; // kopiujemy wyróżniony element
            
            System.out.print("i="+i+" temp="+e+" Przed: ");
            for (int j=0; j<nElems; j++)
            {
                System.out.print(table[j]+" ");
            }
            
            int j = i;           // zaczynamy przesuwanie od i
            while (j > 0 && table[j - 1] >= e) // dopóki elementy są większe niż temp
            {
                table[j] = table[j - 1];    // przesuwamy elementy w prawo w celu zrobienia miejsca na temp
                j--;                       // przesuwamy się w lewo
            }
            table[j] = e;   // wstawiamy wyróżniony element w nowym miejscu
            
            System.out.print(" Po: ");
            for (j=0; j<nElems; j++)                
            {
                System.out.print(table[j]+" ");
            }
            System.out.println();            
        }
    }

    //-----------------------------------------------------------------


    public void quickSort(int left,int right) //Sortowanie metoda szybka
    {
        if (left<right)
        {
            int pivot = table[left]; //Ustalenie klucza osiowego - PIVOT
            int s=left;
            for (int i=left+1; i<=right; i++)//Zbieranie elementow mniejszych od klucza osiowego po lewej stronie tablicy
            {
                if (table[i]<pivot)
                {
                    s=s+1;
                    swap(s,i);
                }
            }

            swap(left,s); //Zamiana klucza osiowego z elementem najbardziej wysunietym na prawo, mniejszym od klucza osiowego

            quickSort(left,s-1); //Posortowanie elementow mniejszych od klucza osiowego
            quickSort(s+1,right); //Posortowanie elementow wiekszych od klucza osiowego
        }
    }
    
    //-------------------------------
    
    private void merge(int left,int mid,int right) //łącz fragment od l do mid z fragmentem od mid+1 do r
    {
        int [] tab = new int[right-left+1]; //Tworz tablice pomocnicza

        int k = 0; //Indeks w scalanej tablicy
        int i = left; //Indeks w pierwszym fragmencie do scalenia
        int j = mid+1; //Indeks w drugim fragmencie do scalenia

        while ((i<mid+1) || (j<right+1)) //...az do konca obydwu scalanych fragmentow
        {
            if (i==mid+1) //Jesli pierwszy fragment juz jest scalony...
            {     
                tab[k] = table[j]; k++; j++; //...kopiuj kolejna liczbe z drugiego fragmentu

            }
            else if (j == right + 1) //Jesli drugi fragment juz jest scalony...
            {             
                tab[k] = table[i]; k++; i++; //...kopiuj kolejna liczbe z pierwszego fragmentu
            }
            else //Scalanie elementow z obydwu fragmentow
            {
                if (table[i] <= table[j]) //Element z pierwszego fragmentu jest mniejszy i ma byc scalony jako pierwszy
                {             
                    tab[k] = table[i]; i++; //... i jest scalany jako pierwszy
                }
                else // table[j]<table[i], czyli element z drugiego fragmentu jest mniejszy
                {                 
                    tab[k] = table[j];  j++; //... i jest scalany jako pierwszy
                }

                k++; //Przechodzimy do nastepnej pozycji scalanej tablicy
            }
        }

        //Przepisanie zawartosci tablicy pomocniczej do tablicy table
        int l = left;        
        for (i=0; i<tab.length; i++) 
        {
            table[l] = tab[i]; l++;
        }        
    }
    
    public void mergeSort(int left, int right) //Sortowanie przez scalanie
    {
        if (left < right)
        {
            int mid = (left + right) / 2;  //Wyliczenie srodka
            mergeSort(left, mid); //Sortowanie lewej czesci
            mergeSort(mid + 1, right); //Sortowanie prawej czesci
            merge(left, mid, right); //Sacalnie posortowanych czesci
        }
    }
//--------------------------------------------------------------
    private void swap(int one, int two) //Zamiana elementow tablicy
    {
        int temp = table[one];
        table[one] = table[two];
        table[two] = temp;
    }
//--------------------------------------------------------------

    public void print()
    {
        for (int i = 0; i < nElems; i++)
        {
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        int maxSize = 2;

        IntDynArrayWithSort array = new IntDynArrayWithSort(maxSize); 	// tworzymy tablice
    
        //15 22 13 27 12 10 20 25 - dane dla metod sortowania
        array.add(15);
        array.add(22);
        array.add(13);
        array.add(27);
        array.add(12);
        array.add(10);
        array.add(20);
        array.add(25);

        array.bubbleSort();
//        array.insertionSort();
//        array.selectionSort();

//        array.quickSort(0,array.size()-1);
//        array.mergeSort(0,array.size()-1);

        array.print();
    }
}
