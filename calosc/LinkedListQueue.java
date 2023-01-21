import java.util.LinkedList;

public class LinkedListQueue {
   LinkedList<Double> dlist;
   public LinkedListQueue(){
       dlist = new LinkedList<Double>();
   }
   public boolean isEmpty(){
       return dlist.isEmpty();
   }
   public int size(){return dlist.size();}

    public void insert(Double elem){dlist.add(elem); }

    public Double remove(){ return dlist.remove(0);}

    public Double peek(){ return  dlist.peekFirst();}

    public static void main(String[] args) {
        LinkedListQueue theQueue = new LinkedListQueue();  // kolejka

        System.out.println("Wstawiam: 10");
        theQueue.insert(10.00);
        System.out.println("Wstawiam: 20");
        theQueue.insert(20.00);
        System.out.println("Wstawiam: 30");
        theQueue.insert(30.00);
        System.out.println("Wstawiam: 40");
        theQueue.insert(40.00);



        while (!theQueue.isEmpty()){
            Double value = theQueue.remove();
            System.out.println(value);
        }
    }




}
