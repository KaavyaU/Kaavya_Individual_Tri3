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
