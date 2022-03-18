# Kaavya_Individual_Tri3

## Replit Link
[Kaavya Individual Repl](https://replit.com/@KaavyaUppala/KaavyaIndividualTri3#Main.java)

## Review Tickets
| Week # | Review Ticket Link |
| ---   | ---    |
| 0 | [TT0 Individual](https://github.com/dsblack0/stickers_for_charity/issues/9)<br>[Team Work](https://github.com/dsblack0/stickers_for_charity/issues/3 |
| 1 | [Team Work](https://github.com/dsblack0/stickers_for_charity/issues/21) |

## Data Structures Challenges 1-3 (Tech Talk 0)
### Menu
Use of the Scanner Class to take in user input using the System.in argument
```
//Scanner takes in input from the user. System.in refers to input
Scanner sc = new Scanner(System.in);
```

Used HashMap to create key-value pairs of Integers and Menu Objects. Each Menu object had a title and task. The task refered to the main method of whatever class was going to be run from that value. 
```
//Create a HashMap integer that has Integer key and Menu value.
//Each Menu has a title and task. The task is the program that will be run (main methods of other classes)
Map<Integer, Menu> menu = new HashMap<>();
menu.put(1, new Menu("IntByReference", () -> IntByReference.main(null) ) );
menu.put(2, new Menu("Matrix", () -> Matrix.main(null) ) );
```
Use of enhanced for loop, Map.Entry, and entrySet() to iterate through the entries of the HashMap. The for loop was used to format the HashMap through a print statement
```
//Printing the menu by iterating though HashMap menu
System.out.println("Please select a program to run:");
for (Map.Entry<Integer, Menu> entry : menu.entrySet()){
  System.out.println(entry.getKey() + " --> " + entry.getValue().getTitle());
}
```
Try-Catch used to run tasks based on user input. Catch used to print message if user inputs a Integer not included as a key in the HashMap
```
//Using try-catch to run programs. 
//Input acts as the key and the value that comes from the HashMap is the program that is run
int input = sc.nextInt();
try{
  Menu choice = menu.get(input);
  choice.getTask().run();
}
//Catch accounts for the instances in which user inputs a key that isn't present in the HashMap
catch (Exception e){
  System.out.println("Please select a number present on the menu");
}
```
Recursion used to rerun the menu after program is executed. Allows user to enter another value and run a different program
```
//recursion to reprint menu after action is performed
main(null);
```
### IntByReference
Uses if statment to check whether the first number is smaller than the second number. If so, it switches the two using a temp value
```
//swapToLowHighOrder method - Switches values so they are in low to high order
public void swapToLowHighOrder (IntByReference b) {
  if (this.value > b.value){
    int temp = b.value;
    b.value = this.value;
    this.value = temp;
  }
}
```
Override toString method to print out the first and second ints in the correct format
```
//Overriding existing toString method 
public String toString(IntByReference b){
  return this.value + " " + b.value;
}
```
swapper calls the toString method in its print statments to print out the correct output in the correct format
```
// static method that enables me to see numbers swapped by reference (before, after)
public static void swapper(int n0, int n1) {
  IntByReference a = new IntByReference(n0);
  IntByReference b = new IntByReference(n1);
  System.out.println("Before: "+ a.toString(b));
  a.swapToLowHighOrder(b);  // conditionally build swap method to change values of a, b
  System.out.println("After: " + a.toString(b));
  System.out.println();
}
```

### Matrix
String output that stores the formatted matrix. As of now, it is an empty string.
```
//create an String output that is changed depending on the values in the matrix
String output = "";
```
Using nested loops to iterate throught he 2D array. Fomratting based on the values. If the value is a -1, the if statment sets that spot in output as a space. Otherwise, the number is added to output. After each row, a break is used to create a new row in output. At the end, the final output value is returned by the toString
```
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
 ```
 The toString method is called from the main method. Tests whether the method performs the correct action on the keypad and numbers matrices
 ```
Matrix m0 = new Matrix(keypad());
System.out.println("Keypad:");
System.out.println(m0.toString());

Matrix m1 = new Matrix(numbers());
System.out.println("Numbers Systems:");
System.out.println(m1.toString());
```
