import java.util.List;

public class LinkedList {
  private ListElem first;

  public LinkedList(){
    first=null;
  }
  public boolean isEmpty(){
    return (first==null);
  }
  public ListElem getFirst(){
    return first;
  }

  public void insertFirst(int value){
    ListElem newElem = new ListElem(value);
    if (!isEmpty())
      newElem.next=first;
    first = newElem;
  }
  public ListElem deleteFirst(){
    if(isEmpty()) return null;
    ListElem temp = first;
    first = first.next;
    return temp;
  }
  public ListElem delete(int value){
    if (isEmpty()) return null;
    ListElem current = first;
    ListElem previous = null;
    while (current.iData!=value){
      if (current.next==null) return null;
      else{
        previous = current;
        current = current.next;
      }
    }
    if(previous==null)
      first = first.next;
    else
      previous.next = current.next;
    return current;
  }
  public boolean find(int value){
    if (isEmpty()) return false;
    ListElem current = first;
    while (current.iData != value){
      if (current.next==null) return false;
      else{
        current= current.next;
      }
    }
    return true;
  }

  public void print(){
    ListElem current = first;
    while (current !=null){
      System.out.print(current.toString()+" ");
      current = current.next;
    }
    System.out.println();
  }




    public static void main(String[] args) {
      LinkedList theList = new LinkedList();
      theList.insertFirst(21);
      theList.insertFirst(15);
      theList.insertFirst(14);
      theList.insertFirst(29);
      theList.print();

      theList.delete(15);
      theList.delete(14);
      theList.print();

      System.out.println(theList.find(21));
    }
}
