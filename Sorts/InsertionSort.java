package Sorts;
import java.util.ArrayList;

public class InsertionSort extends Sorts{
    private int length;
    private ArrayList<Integer> data;

    public InsertionSort(int size){
        super(size);
        length = size;
        data = getData();
    }

    public ArrayList<Integer> mySort(){
        int swaps = 0;
        for (int i=0; i<length; i++){
            int j=i+1;
            while (j<length){
                if (data.get(i) > data.get(j)){
                    int temp = data.get(j);
                    data.remove(j);
                    data.set(i, temp);
                    swaps++;
                    break;
                }
                else {
                    j++;
                }
            }
        }
        return data;
    }
}
