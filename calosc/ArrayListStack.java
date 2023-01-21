import java.security.PublicKey;
import java.util.ArrayList;

public class ArrayListStack {
   private ArrayList<Double> dList;
   public ArrayListStack(){
       dList = new ArrayList<Double>();
   }
   public void push(Double elem){
       dList.add(elem);
   }
   public boolean isEmpty(){
       return dList.isEmpty();
   }
   public Double pop(){
       return dList.remove(dList.size()-1);
   }
   public Double peek(){
       return dList.get(dList.size()-1);
   }

    public static void main(String[] args) {
        ArrayListStack stack = new ArrayListStack();
        stack.push(18.5);
        stack.push(13.23);
        stack.push(1213.213);
        stack.push(133.23);
        System.out.println(stack.peek());
        while (!stack.isEmpty()){
            Double value = stack.pop();
            System.out.print(value+" ");
        }
    }
}

