
//Implementacja zbioru liczb calkowitych za pomoca klasy TreeSet

import java.util.Iterator;
import java.util.TreeSet;


public class TreeSetSet
{
    private TreeSet<Double> treeSet;

    public TreeSetSet()    // konstruktor
    {
        treeSet = new TreeSet<Double>();
    }

    public TreeSet<Double> getTreeSet()
    {
        return treeSet;
    }

    public int size() //Zwraca liczbe elementow w zbiorze
    {
        return treeSet.size();
    }

    public void insert(Double elem)    // wstawia element do zbioru
    {
        if (!member(elem)) // sprawdza, czy dany element nalezy do zbioru
            treeSet.add( (elem));
    }

    public boolean member(Double elem)  // sprawdza, czy dany element nalezy do zbioru
    {
        return treeSet.contains((elem));
    }

    public boolean delete(Double elem)  // usuwa element ze zbioru
    {
        if (member(elem)) // sprawdza, czy dany element nalezy do zbioru
        {
            treeSet.remove((elem));
            return true;
        }
        else return false;
    }


    public TreeSetSet union(TreeSetSet secondSet) //Oblicza sume zbioru biezacego ze zbiorem z parametru metody
    {
        TreeSetSet unionSet = new TreeSetSet();
        Iterator<Double> iterator = treeSet.iterator();
        while (iterator.hasNext())
        {
            Double locElem = iterator.next().doubleValue();
            unionSet.insert(locElem);
        }

        Iterator<Double> iteratorS = secondSet.getTreeSet().iterator();
        while (iteratorS.hasNext())
        {
            Double locElem = iteratorS.next().doubleValue();
            unionSet.insert(locElem);
        }

        return unionSet;
    }

    public TreeSetSet intersection(TreeSetSet secondSet) //Oblicza iloczyn zbioru biezacego ze zbiorem z parametru metody
    {
        TreeSetSet intersectionSet = new TreeSetSet();

        Iterator<Double> iterator = treeSet.iterator();
        while (iterator.hasNext())
        {
            Double locElem = iterator.next().doubleValue();
            if (secondSet.member(locElem))
                intersectionSet.insert(locElem);
        }

        return intersectionSet;
    }

    public TreeSetSet difference(TreeSetSet secondSet) //Oblicza roznice zbioru biezacego ze zbiorem z parametru metody
    {
        TreeSetSet differenceSet = new TreeSetSet();

        Iterator<Double> iterator = treeSet.iterator();

        while (iterator.hasNext())
        {
            Double locElem = iterator.next().doubleValue();
            if (!secondSet.member(locElem))
                differenceSet.insert(locElem);
        }

        return differenceSet;
    }

    public void print()
    {
        Iterator<Double> iterator = treeSet.iterator();
        while (iterator.hasNext())
        {
            int locElem = iterator.next().intValue();
            System.out.print(locElem+" ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        TreeSetSet theSetA = new TreeSetSet();  // tworzymy nowy zbior A
        theSetA.insert(60.00);     // dodajemy elementy do zbioru
        theSetA.insert(20.00);
        theSetA.insert(40.00);

        theSetA.print();

        boolean test20 = theSetA.member(20.00);
        System.out.println("Wynik testu w zbiorze A dla 20: "+test20);

        theSetA.print();

        boolean test30 = theSetA.member(30.00);
        System.out.println("Wynik w zbiorze A pierwszego testu dla 30: "+test30);

        theSetA.insert(30.00);

        theSetA.print();

        test30 = theSetA.member(30.00);
        System.out.println("Wynik w zbiorze A drugiego testu dla 30: "+test30);

        theSetA.delete(30.00);

        theSetA.print();

        test30 = theSetA.member(30.00);
        System.out.println("Wynik w zbiorze A trzeciego testu dla 30: "+test30);

        theSetA.insert(10.00); //Dodanie jeszcze dwoch elementow
        theSetA.insert(90.00);

        System.out.println("--------------------------------------------");

        System.out.println("Zbior A:");
        theSetA.print();

        TreeSetSet theSetB = new TreeSetSet();  // tworzymy nowy zbior B
        theSetB.insert(40.00);     // dodajemy elementy do zbioru
        theSetB.insert(70.00);
        theSetB.insert(60.00);
        theSetB.insert(80.00);

        System.out.println("Zbior B:");
        theSetB.print();


        TreeSetSet unionSet = theSetA.union(theSetB); //Obliczenie sumy zbiorow
        System.out.println("Suma A i B:");
        unionSet.print();

        TreeSetSet intersectionSet = theSetA.intersection(theSetB); //Obliczenie iloczynu zbiorow
        System.out.println("Iloczyn A i B:");
        intersectionSet.print();

        TreeSetSet differenceSet = theSetA.difference(theSetB); //Obliczenie roznicy zbiorow
        System.out.println("Roznica A-B:");
        differenceSet.print();

    }
}





/*
    public TreeSetSet union(TreeSetSet secondSet) {
        TreeSetSet unionSet = new TreeSetSet();
        for (int i = 0; i < treeSet.size(); i++) {
            unionSet.insert(treeSet.first());
            treeSet.remove(treeSet.first());
        }
        for (int i = 0; i < secondSet.treeSet.size(); i++) {
            unionSet.insert(secondSet.treeSet.first());
            secondSet.treeSet.remove(secondSet.treeSet.first());
        }
        return unionSet;
    }

    public TreeSetSet intersection(TreeSetSet secondSet) {
        TreeSetSet intersectionSet = new TreeSetSet();
        for (int i = 0; i < treeSet.size(); i++) {
            int elem = treeSet.first();
            if (secondSet.member(elem)) {
                intersectionSet.insert(elem);
            }
            treeSet.remove(elem);
        }
        return intersectionSet;
    }

    public TreeSetSet difference(TreeSetSet secondSet) {
        TreeSetSet differenceSet = new TreeSetSet();
        for (int i = 0; i < treeSet.size(); i++) {
            int elem = treeSet.first();
            if (!secondSet.member(elem)) {
        differenceSet.insert(elem);
    }
    treeSet.remove(elem);
    }
    return differenceSet;
}

 */






    /*
     public void print()
    {
        for (int i = 0; i < treeSet.size(); i++) {
            System.out.print(treeSet.first()+" ");
            treeSet.remove(treeSet.first());
        }
        System.out.println();
    }
     */


