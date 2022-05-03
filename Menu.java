import FRQ2015.DiverseArray;
import FRQ2015.HiddenWord;
import FRQ2015.Range;
import FRQ2015.SparseArray;
import FRQ2020.GameSpinner;
import FRQ2020.Hailstone;
import FRQ2020.ReviewCollector;
import FRQ2020.Theater;

import java.util.*;

public class Menu {
  String title;
  Runnable task;

  //attributes of the value part of the Hashmap. Info abt each of the programs that will be run
  public Menu(String title, Runnable task){
    this.title = title;
    this.task = task;
  }

  //getters
  public String getTitle(){
    return title;
  }

  public Runnable getTask(){
    return task;
  }

  //main method that creates, prints, and runs programs based on the HashMap
  public static void main(String[] ags) {
    //Scanner takes in input from the user. System.in refers to input
    Scanner sc = new Scanner(System.in);
    //Create a HashMap integer that has Integer key and Menu value.
    //Each Menu has a title and task. The task is the program that will be run (main methods of other classes)
    Map<Integer, Menu> menu = new HashMap<>();
    menu.put(1, new Menu("IntByReference", () -> IntByReference.main(null)));
    menu.put(2, new Menu("Matrix", () -> Matrix.main(null)));
    menu.put(3, new Menu("Queue & MergeQueue", () -> QueueTester.main(null)));
    menu.put(4, new Menu("Reverse Queue w/ Stack", () -> reverseQueue.main(null)));
    menu.put(5, new Menu("Calculator", () -> Calculator.main(null)));
    menu.put(6, new Menu("Sorts", () -> Sorts.Sorts.main(null)));
    menu.put(7, new Menu("DiverseArray", () -> DiverseArray.main(null)));
    menu.put(8, new Menu("HiddenWord", () -> HiddenWord.main(null)));
    menu.put(9, new Menu("SparseArray", () -> SparseArray.main(null)));
    menu.put(10, new Menu("Range", () -> Range.main(null)));
    menu.put(11, new Menu("Hailstone", () -> Hailstone.main(null)));
    menu.put(12, new Menu("GameSpinner", () -> GameSpinner.main(null)));
    menu.put(13, new Menu("ReviewCollector", () -> ReviewCollector.main(null)));
    menu.put(14, new Menu("Theater", () -> Theater.main(null)));
    
    //Printing the menu by iterating though HashMap menu
    System.out.println("Please select a program to run:");
    for (Map.Entry<Integer, Menu> entry : menu.entrySet()){
      System.out.println(entry.getKey() + " --> " + entry.getValue().getTitle());
    }

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
    //recursion to reprint menu after action is performed
    main(null);
  }
}