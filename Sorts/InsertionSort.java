package Sorts;
import java.util.ArrayList;

public class InsertionSort extends Sorts{

    public InsertionSort(int size){
        super(size);
    }

    public ArrayList<Integer> mySort(){
        swaps = 0;
        //like Selection Sort, iterates with i and j incrementing within for loops
        for (int i=0; i<length; i++){
            int j=i+1;
            while (j<length){
                //if comparator 1 is greater than comparator 2, will enter if statement
                if (data.get(i) > data.get(j)){
                    //swaps data and increments swaps
                    int temp = data.get(j);
                    data.remove(j);
                    data.add(i, temp);
                    swaps++;
                }
                //if it isn't greater, it increments j, so that different values are being compared
                else {
                    j++;
                }
            }
        }
        return data;
    }

    public String myName() { return "Insertion Sort "; }

}
