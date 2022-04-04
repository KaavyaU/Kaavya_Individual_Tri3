package Sorts;
import java.util.ArrayList;

public class InsertionSort extends Sorts{

    public InsertionSort(int size){
        super(size);
    }

    public ArrayList<Integer> mySort(){
        swaps = 0;
        for (int i=0; i<length; i++){
            int j=i+1;
            while (j<length){
                if (data.get(i) > data.get(j)){
                    int temp = data.get(j);
                    data.remove(j);
                    data.add(i, temp);
                    swaps++;
                }
                else {
                    j++;
                }
            }
        }
        return data;
    }

    public String myName() { return "Insertion Sort "; }

}
