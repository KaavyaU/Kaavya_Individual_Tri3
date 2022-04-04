package Sorts;
import java.util.ArrayList;

public class BubbleSort extends Sorts{

    public BubbleSort(int size){
        super(size);
    }

    public ArrayList<Integer> mySort(){
        swaps = 0;
        int i = 0;
        //Iterates through the ArrayList, incrementing i and j so that they are always consecutive indices
        for (int j = i+1; j<length; i++, j++){
            //if data at index j is greater than data at index i, enters if statement
            if (data.get(i) > data.get(j)){
                //Uses basic swap logic to switch the data values in index i and index j
                int temp = data.get(j);
                data.set(j, data.get(i));
                data.set(i,temp);
                //Increments swaps
                swaps++;
            }
        }
        //If no swaps are made, exits if statement. If swaps were made, uses recursion to call mySort again (passes through ArrayList again)
        if (swaps > 0){
            this.mySort();
        }
        return data;
    }

    public String myName() { return "Bubble Sort"; }
}
