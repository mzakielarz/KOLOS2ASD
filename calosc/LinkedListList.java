import java.util.LinkedList;

public class LinkedListList {
   private LinkedList<Double> dlist;
   public LinkedListList(){
       dlist = new LinkedList<Double>();
   }
   public int size(){return dlist.size();}

    public boolean isEmpty(){return dlist.isEmpty();}

    public void insertFirst(Double elem){ dlist.addFirst(elem);}

    public void insertLast(Double elem){dlist.addLast(elem);}

    public Double removeFirst(){return dlist.removeFirst();}

    public Double removeLast(){return dlist.removeLast();}

    public Double getFirst(){return dlist.getFirst();}

    public Double getLast(){return dlist.getLast();}

    public void print(){
        for (int i = 0; i < dlist.size(); i++) {
            System.out.print(dlist.get(i)+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedListList theList = new LinkedListList();
        theList.insertFirst(15.45);
        theList.insertFirst(11231.45);
        theList.insertFirst(1245.45);
        theList.insertLast(2144.35);
        theList.insertLast(214123.1);
        theList.print();
        theList.removeFirst();         // usuwamy pierwsze dwa elementy
        theList.removeLast();

        theList.print();         // wypisujemy ponownie

        theList.removeLast(); //usuwamy ostatni element

        theList.print();
    }


}
