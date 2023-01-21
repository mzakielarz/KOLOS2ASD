import java.util.ArrayList;

public class ArrayListQueue {
   private ArrayList<Double> dlist;
   public ArrayListQueue(){
       dlist = new ArrayList<Double>();
   }
   public boolean isEmpty(){
       return dlist.isEmpty();
   }
   public void insert(Double elem){
       dlist.add(elem);
   }
   public Double remove(){
      return dlist.remove(0);
   }
   public int size(){
       return dlist.size();
   }
   public Double peek(){
       return dlist.get(0);
   }

    public static void main(String[] args) {
        ArrayListQueue theQueue = new ArrayListQueue();  // kolejka pięcioelementowa z relokacja

        System.out.println("Wstawiam: 10");
        theQueue.insert(10.00);
        System.out.println("Wstawiam: 20");
        theQueue.insert(20.00);
        System.out.println("Wstawiam: 30");
        theQueue.insert(30.00);
        System.out.println("Wstawiam: 40");
        theQueue.insert(40.00);
        System.out.println(theQueue.peek()+"///");

        while (!theQueue.isEmpty()){
            Double value = theQueue.remove();
            System.out.println(value);
        }

    }


}
