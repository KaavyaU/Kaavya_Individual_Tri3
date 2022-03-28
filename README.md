# Kaavya_Individual_Tri3

## Replit Link
[Kaavya Individual Repl](https://replit.com/@KaavyaUppala/KaavyaIndividualTri3#Main.java)

## Table of Contents
* TOC
{:toc}

## Review Tickets

| Week # | Review Ticket Link |
| ---   | ---    |
| 0 | [TT0 Individual](https://github.com/dsblack0/stickers_for_charity/issues/9)<br>[Team Work](https://github.com/dsblack0/stickers_for_charity/issues/3) |
| 1 | [TT1 Individual](https://github.com/dsblack0/stickers_for_charity/issues/24)<br>[Team Work](https://github.com/dsblack0/stickers_for_charity/issues/21) |

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
## TT1 Challenges
### Queue
Changed code in QueueTester to iterate through Array and add each value as its own array into add(). This allows addList() and add() function to stay the same and set new value to tail
```
Object[] words = new String[] { "seven", "slimy", "snakes", "sallying", "slowly", "slithered", "southward"};
QueueManager qWords = new QueueManager("Words");
//Iterates through the array and enques each value in array as new data to queue
  for (Object word : words){
    Object[] singleWord = new Object[] {word};
    qWords.addList(singleWord);
    System.out.println ("Enqueued data: " + word);
    qWords.printQueue();
  }
```
Defined deltete() in Queue. Doesn't take in value b/c only has to remove and change head, not working with data. Similar concept to add() in funcitonality. Sets new head and removes old head.
```
//Doesn't need to take in data, because always removes the first value b/c it is the head. Returns the head value to indicate which one to delete
public T delete() {
  T data = null;
  if (head == null)  // initial condition
    this.tail = this.head = head;
  else {  // nodes in queue
    data = head.getData();
    head = head.getNext(); // current head points to new head
  }
  return data;
}
```
removeList() that calls the delete() on the new Array
```
// remove a list of objects to queue
public void removeList(T[]... seriesOfObjects) {
  for (T[] objects: seriesOfObjects)
    for (T data : objects) {
      this.queue.delete();
      this.count--;
    }
  }
```
Calling the printQueue() while iterating through Array again in QueueTester. Reverses process of add()
```
//Same concept, but dequeing from head
  for (Object word : words){
    Object[] singleWord = new Object[] {word};
    qWords.removeList(singleWord);
    System.out.println ("Dequeued data: " + word);
    qWords.printQueue();
  }
```
Editing printQueue() to reformat print statments.
```
public void printQueue() {
  System.out.print(this.name + " count: " + count + ", data: ");
    System.out.print(data + " ");
    System.out.println();
  }
```
### MergeQueue
Creating QueueIterator objects iterator1 and iterator2 to gain acces to hasNext() and next()
```
//creates QueueIterator objects to have access to hasNext() and next()
QueueIterator iterator1 = (QueueIterator)qNums1.queue.iterator();
QueueIterator iterator2 = (QueueIterator)qNums2.queue.iterator();
```
Comparing the values in each queue as long as values are still present in both queues (not null). Using if-else statments, checking order of values and iterating to next value if current value is set as new head to Queue 3
```
//comparing both Queues as long as there are elements in both queues.
while (iterator1.hasNext() && iterator2.hasNext()) {
  if ((Integer)iterator1.getData() < (Integer)iterator2.getData()){
    mergeQueue.queue.add(iterator1.getData());
    iterator1.next();
  }
  else{
    mergeQueue.queue.add(iterator2.getData());
    iterator2.next();
  }
}
```
Iterating through the remaining values in the leftover array if one array is completely used up. Done through use of if-else statments.
```
// In all values in a queue are already ordered, continues ordering values in unfinished queue
if(qNums1.queue.getHead() == null){
  while (iterator2.hasNext()){
    mergeQueue.queue.add(iterator2.getData());
    iterator2.next();
  }
}
else {
  while (iterator1.hasNext()){
    mergeQueue.queue.add(iterator1.getData());
    iterator1.next();
  }
}
```
The getData() function defined in Queue to return data as type T. This is necessary for comparison in if-else statements of MergeList()
```
//created new getData() to return data as type T
public T getData(){
  T data = current.getData();
  return data;
}
```
Tester Method for MergeQueue. Passes in two QueueManagers to mergeList(), which outputs a Queue which is then printed out.
```
// Create 2 seperate iterable Queues of Integers
Object[] nums1 = new Integer[] { 1, 4, 5, 8 };
Object[] nums2 = new Integer[] { 2, 3, 6, 7 };
QueueManager qNums1 = new QueueManager("Queue 1", nums1);
QueueManager qNums2 = new QueueManager("Queue 2", nums2);
qNums1.printQueue();
qNums2.printQueue();
MergeQueue mergeQueue = new MergeQueue();
mergeQueue.mergeList(qNums1, qNums2);
mergeQueue.printQueue();
```

## TT2 Challenges
### Calculator
Added power operator to OPERATORS HashMap. Assigned to highest order of presendence (lowest value)
```
OPERATORS.put ("^", 2);
```
Added power operator case to tokenToReversePolishNotation(). 
```
case "^":
```
If the token is not an Operator (a number), it is pushed into the stack. In order to get String to Double, Double.parseDouble(token) is used
```
if (!isOperator(token)){
  // Push number to stack
  Double num = Double.parseDouble(token);
  calculation.push(num);
}
```
Pop the first two numbers of the stack and cast to double. Then define an output variable. Use series of if statments to calculate ouput depending on the Operator value. THe final output value is pushed onto the stack. This is within a for loop, so will continue this until output is the final result of the expression. The final output value will be pushed into the stack and the for loop will terminate
```
else {
  // Pop the two top entries
  Double token1 = (Double)calculation.pop();
  Double token2 = (Double)calculation.pop();
  Double output = 0.0;
  // Based off of Token operator calculate result
  if (token.equals("^")){
    output = Math.pow(token2, token1);
  }
  if (token.equals("%")){
    output = token2 % token1;
  }
  if (token.equals("*")){
    output = token2 * token1;
  }
  if (token.equals("/")){
    output = token2 / token1;
  }
  if (token.equals("-")){
    output = token2 - token1;
  }
  if (token.equals("+")){
    output = token2 + token1;
  }
  // Push result back onto the stack
  calculation.push(output);
}
```
Once the for loop is terminated, the output value is the only on in the Stack, so it is popped and set as result. 
```
// Pop final result and set as final result for expression
result = (Double)calculation.pop();
```
Defines test cases in mai method. The main method is called by Menu in order to run method. Scanner used to allow user input of expression and returns output to user. 
```
public static void main (String [] args){
    Calculator simpleMath = new Calculator("100 + 200  * 3");
    System.out.println("Simple Math\n" + simpleMath);

    Calculator parenthesisMath = new Calculator("(100 + 200)  * 3");
    System.out.println("Parenthesis Math\n" + parenthesisMath);

    Calculator fractionMath = new Calculator("100.2 - 99.3");
    System.out.println("Fraction Math\n" + fractionMath);

    Calculator moduloMath = new Calculator("300 % 200");
    System.out.println("Modulo Math\n" + moduloMath); 

    Calculator divisionMath = new Calculator("300 / 200");
    System.out.println("Division Math\n" + divisionMath); 

    Calculator multiplicationMath = new Calculator("300 * 200");
    System.out.println("Multiplication Math\n" + multiplicationMath);
    
    Calculator allMath = new Calculator("200 % 300 + 5 + 300 / 200 + 1 * 100");
    System.out.println("All Math\n" + allMath);

    Calculator allMath2 = new Calculator("200 % (300 + 5 + 300) / 200 + 1 * 100");
    System.out.println("All Math2\n" + allMath2);

    Calculator powerMath = new Calculator("2 ^ 3 * 4");
    System.out.println("Power Math\n" + powerMath);

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter custom expression to calculate: ");
    String original = sc.nextLine();
    Calculator input = new Calculator(original);
    System.out.println("Result: " + input);
  }
}
```
