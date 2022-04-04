package Sorts;
import java.util.ArrayList;

public class BubbleSort extends Sorts{

    public BubbleSort(int size){
        super(size);
    }

    public ArrayList<Integer> mySort(){
        swaps = 0;
        int i = 0;
        for (int j = i+1; j<length; i++, j++){
            if (data.get(i) > data.get(j)){
                int temp = data.get(j);
                data.set(j, data.get(i));
                data.set(i,temp);
                swaps++;
            }
        }
        if (swaps > 0){
            this.mySort();
        }
        return data;
    }

    public String myName() { return "Bubble Sort"; }
}
