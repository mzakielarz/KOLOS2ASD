/*
 * Sortowanie babelkowe intow i zlozonych obiektow klasy Person
 */
package sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Adam
 */
public class BubbleSortPerson {
    private static int[] table = {7, 6, 2, 4, 5, -1, 0, -9, -123, -92};
    public static void main(String[] args) {
        
//        bubbleSort();        
//        for (int elem : table) {
//            System.out.print(elem+", ");
//        }
        
////         sortowanie przy wykorzystaniu metody sort z Arrays
//        System.out.println("");
//        Arrays.sort(table);
//        for (int elem : table) {
//            System.out.print(elem+", ");
//        }
        
        ArrayList<Person> a = new ArrayList<>();
        a.add(new Person("Ola", 10));
        a.add(new Person("Iza", 10));
        a.add(new Person("Ola", 11));
        a.add(new Person("Wiola", 13));
        a.add(new Person("Ola", 11));
        a.add(new Person("Wiola", 13));
        a.add(new Person("Ola", 8));
        a.add(new Person("Zuzia", 8));
        a.add(new Person("Ada", 10));
        a.add(new Person("Iza", 10));
        a.add(new Person("Ola", 11));
        a.add(new Person("Wiola", 13));
        a.add(new Person("Ola", 8));
        a.add(new Person("Ada", 4));
        
        bubbleSort2(a);
        for (Person person : a) {
            System.out.println(person.imie+" "+person.wiek);
        }
    }
    public static void bubbleSort() {
        for (int i = table.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (table[j] > table[j + 1]) {
                    int temp = table[j];
                    table[j] = table[j+1];
                    table[j+1] = temp;
                }
            }
        }
    }
    
    public static void bubbleSort2(ArrayList<Person> p) {
        for (int i = p.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (p.get(j).compareTo(p.get(j + 1)) > 0) {
                    Person temp = p.get(j);
                    p.set(j, p.get(j + 1));
                    p.set(j+1, temp);
                }
            }
        }
    }
}


class Person implements Comparable<Person>
{
    String imie;
    int wiek;

    public Person(String imie, int wiek) {
        this.imie = imie;
        this.wiek = wiek;
    }

    @Override
    public int compareTo(Person p) {
        if((this.wiek>p.wiek) || (this.wiek==p.wiek && this.imie.compareTo(p.imie)>0))
            return 1;
        if(this.wiek==p.wiek && this.imie.compareTo(p.imie)==0)
            return 0;
        else
            return -1;
    }
    
}