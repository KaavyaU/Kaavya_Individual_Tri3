import java.util.*;

public class Matrix{
  private final int[][] matrix;

  // store matrix
  public Matrix(int[][] matrix) {
    this.matrix = matrix;
  }

  // Hack: create toString method using nested for loops to format output of a matrix
  public String toString(){
    //create an String output that is changed depending on the values in the matrix
    String output = "";
    //nested for loops to interate through the 2D array and format. If there is a -1, it is formatted as a space
    for (int row = 0; row < matrix.length; row++){
      for (int column = 0; column < matrix[row].length; column++){
        if (matrix[row][column] == -1){
          output += " ";
        }
        else {
          output += matrix[row][column];
        }
      }
      //add break after each row
      output += "\n";
    }
    //add space after entire matrix for easier readability
    output += "\n";
    return output;
  } 

  // declare and initialize a matrix for a keypad
  static int[][] keypad() {
    return new int[][]{ { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, {-1, 0, -1} };
  }

  // declare and initialize a random length arrays
  static int[][] numbers() {
    return new int[][]{ { 0, 1 },
      { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 },
      { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 } };
  }

  // tester method for matrix formatting
  //Added my toString method in the print statment
  public static void main(String[] args) {
    Matrix m0 = new Matrix(keypad());
    System.out.println("Keypad:");
    System.out.println(m0.toString());

    Matrix m1 = new Matrix(numbers());
    System.out.println("Numbers Systems:");
    System.out.println(m1.toString());
  }
}