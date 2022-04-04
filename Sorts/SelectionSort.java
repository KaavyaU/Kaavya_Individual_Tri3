package Sorts;
import java.util.ArrayList;

public class SelectionSort extends Sorts{
    private int length;
    private ArrayList<Integer> data = new ArrayList<>();

    public SelectionSort(int size){
        super(size);
        length = size;
        data = getData();
    }

    public ArrayList<Integer> mySort(){
        int swaps = 0;
        for (int i=0; i<length; i++){
            int j=i;
            while (j<length){
                if (data.get(i) > data.get(j)){
                    int temp = data.get(i);
                    data.set(i, data.get(j));
                    data.set(j,temp);
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
