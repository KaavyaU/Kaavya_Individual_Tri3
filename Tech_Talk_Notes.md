{% include navigation.html %}

# Tech Talk Notes

## Table of Contents
* TOC
{:toc}

## Tech Talk 0
### Data Structures
- Algorithms interact with data structures
- Some examples: String, Integer, Float, HashMap, etc.

### Imperative Paradigm
- Focues more on "how" the program works
- Also called "Procedural Paradigm"
- The "Procedural Paradigm" is used in Python

### Object Oriented Paradigm
- Relies on objects and classes to manipulate data
- Think of structuring programs as readable code blueprints
- Java uses an Object Oriented paradigm

### Data Structures Examples
Arrays / Lists
```
public static Animal[] animalData() {
	return new Animal[]{
	        new Animal("Lion", 8, "Gold"),
	        new Animal("Pig", 3, "Pink"),
		new Animal("Robin", 7, "Red"),
		new Animal("Cat", 10, "Black"),
		new Animal("Kitty", 1, "Calico"),
		new Animal("Dog", 14, "Brown")
	};
}
```
Dictionaries / Hashmaps
```
private final Map<String, Integer> OPERATORS = new HashMap<>();
    {
        // Map<"token", precedence>
        OPERATORS.put("*", 3);
        OPERATORS.put("/", 3);
        OPERATORS.put("%", 3);
        OPERATORS.put("+", 4);
        OPERATORS.put("-", 4);
    }
```
### Challenges Plan
- Menu:
    - Use HashMap to store class data
    - Use try-catch to catch any exceptions to user input
    - Recursion to reprint the menu
    - Need to figure out a way to get input from User. Maybe collaborate w/ group members to see if they have any ideas
- Int By Reference: 
    - If-statment to check order of numbers
    - Override toString in order to format correctly
- Matrix:
    -  Nested for loops to iterate through 2D Array
    -  if/else statments to check whether a space of a value should be added to the string
    -  Try to return output as a single string, rather than having a sepreate string printed for each line in the matrix
    -  Find a way to add new lines within a single string

## Tech Talk 1
### What are Linked Lists?
- A way of keeping / managing Objects
- Each object has data and a next pointer
- Are the basis for understanding Queues and Stacks
- Is a dependency for Queues and Stacks
   - A queue has a linked list that stores the head and tail. The linked list is changed based on the dequeueing and enqueuing of the Queue
 
![image](https://user-images.githubusercontent.com/72475036/158444247-5040561b-5c23-42c5-89b0-bc733cba5a1b.png)

### Queue
- Head: First item in the queue; Tail: Last item in the queue
- Enqueue: Add to a queue
    - Head stays constant, tail is changing
- Dequeue: Remove form queue
    - Tail stays constant, head is changing
- First in, first out

### Stack
- Only going to work with the head
- Push: Add values - become the head
- Pop: remove values
- Last in, first out
- Stacks work in a reverse order to Queues

### Challenges Plans
- Must Use:
    - Generic T --> Is able to handle many types of data types. Enables something to be applicable to any types of objects. Used in the class declaration. Helpful b/c don't have to recast it afterwards. Generic T handles all of that.
    ```
    public class LinkedList <T> {
    }
    ```
    - Iterable Interface --> Defining a way to iterate through a data structure (ex: enhannced for loop to iterate through an array)
- Add LinkedList Code to Repl so that the Queue and Stack have the necessary dependency
- Make tester methods to test the code

## Tech Talk 2
### Tokenizaiton
- Breaks up a String input into individual tokens, based on where the spaces and other seperators are
- These tokens are each placed into an ArrayList, so it's an ArrayList of smaller Strings

### Reverse Polish Notation
- Takes the tokenized ArrayList and reorders it so that it's follows the order of operations
- Iterates through the Tokenized ArrayList and pushes to and from stacks accordingly, based on whether they are numbers or operators. Is ordered so that there are 2 number terms and a operator that follows. The operators go in order of highest to lowest precendence
- RPN needs a way to determine the precedence of its Operators, so using a HashMap and assigning ints to represent presendence orders is helpful. Those with the same order of precendence will have the same int value for the key-value pairs.

### RPN to Answer
- Needs to calculate the output using the numbers and operators as ordered by the RPN
- Iterate through the ArrayList and perform functions in order to result in final output. Involves pushing and popping elements to and from stack.

### Challenges Plan
- Define a stack that will have values added and removed from it (will be a stack of doubles)
- Put all the code within a for loop so that it can be iterated until there are no more tokens left
	- Have a if statement that checks for whether the first token is an operator or not. If not an operator, then it must be a number, so cast to a double and push to Stack. Because of this, the ArrayList will no longer hold any numbers, only operators in order of precedence
	- Have an else statmement that handles the instance when the token is an operator. Pop the first two elements off the stack and cast the tokens to doubles. Then make a double for the result of the calculations
		- Have if statments that perform the calculation of the popped numbers based on the operator. Remember to do the second number, operator, then first number, because Stacks are LIFO (Last in First Out), so the 2nd number popped off was actually pushed in first
		- Store the result of the calculation in the result value and push that value back into the stack, so it can be used with the next operator
- The for loop should continue until there is only 1 value left, that is put in the Stack. This final value in the Stack is the final output
- Pop the value off the Stack and set result equal to it

## Tech Talk 3
### Big O Notation
**Selection Sort**: O(n^2)
- Has a nested for loop. 
- In worse case scenario, the elements must loop from beginning of the array in the outer loop (n) and for each iteration, do the same in the inside loop (n), so the Big O Notation would be n^2

**Insertion Sort**: O(n^2)
- Like Selection Sort, it has a nested for loop
- In the worst case scenario, it must iterate throuh both outside (n) and inside (n), making the Big O Notation n^2

**Merge Sort**: O(nlog(n))
- log(n) refers to the binary log (base 2). In this case, this refers to how the Array is split into 2 parts
- It is multiplied by n, becasue the number of times this spliting happens is dependent on the number of terms in the ArrayList

**Bubble Sort**: O(n^2)
- Iterates through the entire ArrayList (n). Passes through the ArrayList multiple times until no sorts are made (n)
- In the worst case scenario, swaps will be needed on all elemtns, causing the number of passes to be equal to the number of terms, making a Big O complexity of n^2

### Final Analysis:
#### Big O Notation
- O(nlog(n)) is much simpler than (n^2), meaning it takes less time in the long run than the other kinds of sorts
![image](https://user-images.githubusercontent.com/72475036/162483320-8fb2b8ae-ecb4-4b71-ba62-753d052661c4.png)
- As the number of elements increases, the time it takes for Selection Sort, Insertion Sort, and Bubble Sort increases much faster than the time for Merge Sort

#### Time Analysis
- Furthermore, this is supported by the runtime, with MergeSort having much smaller runtime than the other 3 sorts. Therefore, MergeSort is more time-efficient than the other types of sorts

Average Times (nano) | Selection | Insertion | Bubble   | Merge
---------------------|-----------|-----------|----------|--------
1                    |73711975   |76290241   |673162141 |44975391
2                    |50551958   |55961716   |455635750 |29819400
3                    |32031366   |49448708   |375128516 |21487291
4                    |28733408   |43140758   |344080558 |19156533
5                    |32698216   |44894375   |380757516 |21663183
6                    |36692383   |54302816   |420110508 |24733408
7                    |48484075   |64888908   |491537100 |28818716
8                    |31897466   |69928875   |380452708 |22488066
9                    |31241758   |47903816   |357629658 |20075500
10                   |34316441   |51299991   |393361433 |21910416

- Mostly, MergeSort has much shorter runtimes than the other sorts, consistant with what the Big O Notation predicted about this form of sort

#### Swaps/Comaparisons Analysis
- Merge Sort performs more swaps in a smaller amount of time, meaning it is overall more efficient than the other kinds of sorts

Average Swaps | Selection | Insertion | Merge
--------------|-----------|-----------|--------
1             |35244      |4988       |58743
2             |35074      |4990       |58736
3             |35233      |4991       |58729
4             |35343      |4992       |58736
5             |35434      |4991       |58728
6             |35393      |4990       |58742
7             |35288      |4991       |58731
8             |35173      |4990       |58743
9             |35440      |4991       |58735
10            |35163      |4990       |58744

#### Final Comparison
- MergeSort has the most number of swaps, with a smaller runtime. This means that the sorting is happening mroe efficintly.
- Big O Notation demonstreates that with less data, Insertion, Selection, and Bubble sorts would be more efficient. But with larger data samples (like 5000 elements), Merge Sort would be more efficient

**Merge Sort is most efficient for large data samples**
