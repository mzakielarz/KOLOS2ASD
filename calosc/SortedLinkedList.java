import java.util.List;
import java.util.Random;
//z4
public class SortedLinkedList {
   private ListElem first;

   public SortedLinkedList(){
       first = null;
   }
   public boolean isEmpty(){ return (first==null);}
    public void insertFirst(int value){
       ListElem newElem = new ListElem(value);
       newElem.next = first;
       first = newElem;
    }
    public void insert(int value){
       ListElem newElem = new ListElem(value);
       ListElem current = first;
       ListElem previous = null;

       while (current != null && newElem.iData>current.iData){
           previous = current;
           current = current.next;
       }
       if (previous==null)
           first = newElem;
       else
           previous.next = newElem;
       newElem.next = current;
    }
    public ListElem deleteFirst(){
       if (isEmpty()) return null;
       ListElem temp = first;
       first = first.next;
       return temp;
    }
    public ListElem delete(int value){
       if (isEmpty()) return null;
       ListElem current = first;
       ListElem prevoius = null;

       while (current.iData != value){
           if (current.next==null) return null;
           else{
               prevoius = current;
               current= current.next;
           }
       }
       if(prevoius==null) first = first.next;
       else
           prevoius.next = current.next;
       return current;
    }
    public boolean find(int value){
       if (isEmpty()) return false;
       ListElem current = first;
       ListElem previous = null;
       while (current.iData!=value){
          if (current.next==null) return false;
           else{
               current = current.next;
           }
       }
       return true;
    }
    public void print(){
       ListElem current = first;
       while (current != null){
           System.out.print(current.toString()+" ");
           current = current.next;
       }
        System.out.println();
    }




    public static void main(String[] args) {
        SortedLinkedList theSortedList = new SortedLinkedList();
        theSortedList.insert(15);
        theSortedList.insert(30);
        theSortedList.insert(12);
        theSortedList.insert(5);
        theSortedList.print();

        System.out.println(theSortedList.find(15));
        theSortedList.delete(30);
        theSortedList.delete(12);
        theSortedList.print();


    }
}
