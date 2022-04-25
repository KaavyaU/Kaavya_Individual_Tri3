package FRQ2015;

import java.util.ArrayList;
import java.util.List;

public class SparseArray {

    private int numRows;
    private int numCols;
    private List<SparseArrayEntry> entries;

    public SparseArray() {
        entries = new ArrayList<SparseArrayEntry>();
    }

    public SparseArray(int r, int c, List<SparseArrayEntry> list) {
        numRows = r;
        numCols = c;
        entries = list;
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public int getValueAt (int row, int col){
        /*
        Use of if statements to navigate an ArrayList of objects
        Command of ArrayList methods, such as size() and get()
         */
        int value = 0;
        for (int i = 0; i < entries.size(); i++){
            if (entries.get(i).getRow() == row) {
                if (entries.get(i).getCol() == col){
                    value = entries.get(i).getValue();
                }
            }
            else {
                value = 0;
            }
        }
        System.out.println("Value is: " + value);
        return value;
    }

    public void removeColumn (int col){
        /*
        Use of if and else if to change values in an ArrayList
        Use of ArrayList methods to change and edit size and values stored in said ArrayList
         */
        List <SparseArrayEntry> list = new ArrayList<SparseArrayEntry>();
        for (int i = 0; i < entries.size(); i++){
            int c = entries.get(i).getCol();
            SparseArrayEntry entry = entries.get(i);
            if (c > col){
                list.add(new SparseArrayEntry(entry.getRow(), c - 1, entry.getValue()));
            }
            else if (c < col){
                list.add(entry);
            }
        }
        numCols--;
        entries = list;
        System.out.println("Column " + col + " has been removed");
    }

    public static void main(String[]args){
        /*
        Part a tester
         */
        SparseArrayEntry input = new SparseArrayEntry(2,3,4);
        ArrayList<SparseArrayEntry> values = new ArrayList<SparseArrayEntry>();
        values.add(input);
        SparseArray array = new SparseArray(4,4, values);

        array.getValueAt(1,1);
        array.getValueAt(3,3);
        array.getValueAt(2,3);

        /*
        Part b tester
         */
        SparseArrayEntry input1 = new SparseArrayEntry(4, 1, 5);
        SparseArrayEntry input2 = new SparseArrayEntry(2, 2, 3);
        SparseArrayEntry input3 = new SparseArrayEntry(1, 3, 8);
        ArrayList<SparseArrayEntry> data = new ArrayList<SparseArrayEntry>();
        data.add(input1);
        data.add(input2);
        data.add(input3);

        SparseArray mat = new SparseArray(5,5, data);
        mat.getNumCols();
        mat.getValueAt(2,2);
        mat.getValueAt(1,3);
        mat.getValueAt(1,2);

        mat.removeColumn(2);

        //number of columns should reduce by 1
        mat.getNumCols();
        //value no longer exists
        mat.getValueAt(2,2);
        //Should be shifted
        mat.getValueAt(1,3);
        mat.getValueAt(1,2);

    }

}
