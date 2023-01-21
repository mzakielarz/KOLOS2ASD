public class BubbleSort {
    public static int[] table = {1,10,3,5,6,-5,2,78,13};

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
        for (int i = 0; i < table.length; i++) {
            System.out.print(table[i]+" ");
        }
    }
    public static void main(String[] args) {
        bubbleSort();
    }
}
