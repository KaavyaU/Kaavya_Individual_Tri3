package FRQ2015;

public class DiverseArray {

    /*
    Part a: Returns the sum of all values in the array (basic array traversal)
     */
    public static int arraySum (int[]arr){
        //initializes sum
        int sum = 0;
        //traversing array and adding to sum to get total sum of arr
        for (int i = 0; i < arr.length; i++){
            sum = sum + arr[i];
        }
        return sum;
    }

    /*
    Part b: Traverses 2D array and returns 1D array as sums. The 1D is the entry at a particular row in the 2D array
     */
    public static int[] rowSums (int [][] arr2D) {
        //declares 1D array of same length as 2D array (the rows)
        int [] sums = new int [arr2D.length];
        //Iterates through each row by iterating through each of the rows. Building a list of sums
        for (int i = 0; i < arr2D.length; i++){
            sums[i] = arraySum(arr2D[i]);
        }
        return sums;
    }

    /*
    Part c: Uses nested for loops to iterate through the array and compare all terms. If duplicates are found, false is returned. Otherwise, true is returned
     */
    public static boolean isDiverse(int[][] arr2D){
        //Calling rowSums to split up new 2D array
        int[] sums = rowSums(arr2D);
        //Traversing array with nested for loops to compare all values
        for (int i = 0; i < sums.length; i++){
            for (int j = i + 1; j < sums.length; j++){
                //if values are duplicated, returns false
                if (sums[i] == sums[j]){
                    return false;
                }
            }
        }
        //if no duplicates are found, returns true
        return true;
    }

    public static void main(String[] args) {
        int[][] mat1 = {
                { 1, 3, 2, 7, 3 },                       // row 1
                { 10, 10, 4, 6, 2 },                     // row 2
                { 5, 3, 5, 9, 6 },                       // row 3
                { 7, 6, 4, 2, 1 }                        // row 4
        };
        int[][] mat2 = {
                { 1, 1, 5, 3, 4 },                       // row 1
                { 12, 7, 6, 1, 9 },                      // row 2
                { 8, 11, 10, 2, 5 },                     // row 3
                { 3, 2, 3, 0, 6 }                        // row 4
        };

        System.out.println("Mat1 Diverse: " + isDiverse(mat1));
        System.out.println();
        System.out.println("Mat2 Diverse: " + isDiverse(mat2));
    }
}
