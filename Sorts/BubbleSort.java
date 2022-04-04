package Sorts;
import java.util.ArrayList;

public class BubbleSort extends Sorts{
    private int length;
    private ArrayList<Integer> data = new ArrayList<>();

    public BubbleSort(int size){
        super(size);
        length = size;
        data = getData();
    }

    public ArrayList<Integer> mySort(){
        int swaps = 0;
        int i = 0;
        for (int j = i+1; j<length; j++){
            if (data.get(i) > data.get(j)){
                int temp = data.get(i);
                data.set(i, data.get(j));
                data.set(j,temp);
                swaps++;
                i++;
            }
        }
        if (swaps > 0){
            mySort();
        }
        return data;
    }
}
