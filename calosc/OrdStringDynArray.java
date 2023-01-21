    //zadanie 2
public class OrdStringDynArray {
    private String[] table;
    private int nElems;

    public OrdStringDynArray(int maxSize){
        table = new String[maxSize];
        nElems = 0;
    }
    public void add(String value){
        if(nElems>= table.length){
            String[] loctable = new String[table.length*2];
            for (int i = 0; i < table.length; i++) {
                loctable[i] = table[i];
            }
            table=loctable;
        }
        int j;
        for ( j = 0; j < nElems; j++) {
            if(table[j].compareTo(value)>0) break;
        }
        for(int k = nElems;k>j;k--){
            table[k]= table[k-1];
        }
        table[j] = value;
        nElems++;
    }
    public boolean remove(int index){
        if(index<0 || nElems==0 || index>=nElems){
            return false;
        }
        for (int i = index; i < nElems-1; i++) {
            table[i] = table[i+1];
        }
        nElems--;
        return true;
  }
  public int find(String searchElem){
      for (int i = 0; i < nElems; i++) {
          if(table[i].equals(searchElem)) return i;
      }
      return -1;
  }
  public int size(){
        return nElems;
  }
  public String get(int index){
        return table[index];
  }

  public void print(){
      for (int i = 0; i < nElems; i++) {
          System.out.print(get(i)+" ");
      }
      System.out.println();
  }

  public static void main(String[] args) {
        OrdStringDynArray table = new OrdStringDynArray(2);
        table.add("Ala");
        table.add("Ola");
        table.add("Tola");
        table.print();
      System.out.println(table.find("Tola"));
      table.print();
      table.remove(0);
      table.print();

  }
}
