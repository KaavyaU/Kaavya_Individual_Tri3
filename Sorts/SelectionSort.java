package Sorts;
import java.util.ArrayList;

public class SelectionSort extends Sorts{
    public SelectionSort(int size){
        super(size);
    }

    public ArrayList<Integer> mySort(){
        swaps = 0;
        for (int i=0; i<length; i++){
            int lowest = i;
            int j=i+1;
            while (j<length) {
                if (data.get(j) < data.get(lowest)) {
                    lowest = j;
                    swaps++;
                }
                j++;
            }
            int temp = data.get(lowest);
            data.set(lowest, data.get(i));
            data.set(i, temp);
        }
        return data;
    }

    public String myName() { return "Selection Sort";  }
}
