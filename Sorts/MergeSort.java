package Sorts;
import java.util.ArrayList;

public class MergeSort extends Sorts{

    public MergeSort(int size){
        super(size);
    }

    public ArrayList<Integer> mySort(){
        sortRecursive(0,length-1);
        return data;
    }

    public void sortRecursive(int start, int end){
        int middle = start + (end-start)/2;

        if (end == start) return;

        if ((end-start) < 2) {
            if (data.get(end) < data.get(start)){
                int temp = start;
                start = end;
                end = temp;
                swaps++;
            }
        }
        else{
            //System.out.println("sort from " + start + " to " + middle);
            sortRecursive(start, middle);
            //System.out.println("sort from " + (middle+1) + " to " + end);
            sortRecursive(middle + 1, end);
            //use Selection Sort logic as the sorted comparison
            //System.out.println("merge " + start + " to " + end);
            int len = end-start + 1;
            for (int i=0; i<len; i++){
                int lowest = i;
                int j=i+1;
                while (j<len) {
                    if (data.get(j) < data.get(lowest)) {
                        lowest = j;
                    }
                    j++;
                }
                int temp = data.get(lowest);
                data.set(lowest, data.get(i));
                data.set(i, temp);
                swaps++;
            }
            //System.out.println(data);
        }
    }

    public String myName() { return "Merge Sort"; }
}
