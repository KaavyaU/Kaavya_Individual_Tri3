{% include navigation.html %}

# Tech Talk Notes

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
## Tech Talk 1
### What are Linked Lists?
- A way of keeping / managing Objects
- Each object has data and a next pointer
- Are the basis for understanding Queues and Stacks
- Is a dependency for Queues and Stacks
   - A queue has a linked list that stores the head and tail. The linked list is changed based on the dequeueing and enqueuing of the Queue
   - 

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
    - Generic T --> Is able to handle many types of data types. Enables something to be applicable to any types of objects. Used in the class declaraation
    ```
    public class LinkedList <T> {
    }
    ```
    - Iterable Interface --> Defining a way to iterate through a data structure (ex: enhannced for loop to iterate through an array)
- Add LinkedList Code to Repl so that the Queue and Stack have the necessary dependency
- Make tester methods to test the code
