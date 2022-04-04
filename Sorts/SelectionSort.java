package Sorts;
import java.util.ArrayList;

public class SelectionSort extends Sorts{
    public SelectionSort(int size){
        super(size);
    }

    public ArrayList<Integer> mySort(){
        swaps = 0;
        //Iterating through the ArrayList and setting lowest to i (first comparator)
        for (int i=0; i<length; i++){
            int lowest = i;
            int j=i+1;
            //Iterating through the ArrayList starting at j, which is i+1 (second comparator)
            //While for each increment of i, j iterates through the rest of the ArrayList
            while (j<length) {
                //Checks to see if data at index j is less than data at index i (second comparator < first comparator)
                if (data.get(j) < data.get(lowest)) {
                    //Sets lowest as j, so that index of second comparator will be the index of first comparator
                    lowest = j;
                    swaps++;
                }
                j++;
            }
            //Swaps the data at index lowest and index i
            int temp = data.get(lowest);
            data.set(lowest, data.get(i));
            data.set(i, temp);
        }
        return data;
    }

    public String myName() { return "Selection Sort";  }
}
