import java.util.LinkedList;

//Implementacja stosu liczb calkowitych za pomoca listy powiazanej LinkedList przez OSADZANIE


public class LinkedListStack
{
 LinkedList<Double> dList;
 public LinkedListStack(){
     dList = new LinkedList<Double>();
 }
 public boolean isEmpty(){
     return dList.isEmpty();
 }
 public void push(Double elem){
     dList.push(elem);
 }
 public Double pop(){
     return dList.pop();
 }
 public Double peek(){
   return   dList.peek();
 }
 public int size(){
     return dList.size();
 }

    public static void main(String[] args) {
        LinkedListStack lStack = new LinkedListStack();
        lStack.push(21.45);
        lStack.push(2123.45);
        lStack.push(24.45);
        System.out.println(lStack.peek());

        while (!lStack.isEmpty()){
            Double value = lStack.pop();
            System.out.println(value);
        }
    }

}
