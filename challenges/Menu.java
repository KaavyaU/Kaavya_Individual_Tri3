import java.util.*;

public class Menu {
  String title;
  Runnable task;

  public Menu(String title, Runnable task){
    this.title = title;
    this.task = task;
  }

  public String getTitle(){
    return title;
  }

  public Runnable getTask(){
    return task;
  }

  public static void main(String[] ags) {
    Scanner sc = new Scanner(System.in);
    Map<Integer, Menu> menu = new HashMap<>();
    menu.put(1, new Menu("IntByReference", () -> IntByReference.main(null) ) );
    menu.put(2, new Menu("Matrix", () -> Matrix.main(null) ) );
    
    //Printing the menu by iterating though HashMap menu
    System.out.println("Please select a program to run:");
    for (Map.Entry<Integer, Menu> entry : menu.entrySet()){
      System.out.println(entry.getKey() + " --> " + entry.getValue().getTitle());
    }

    int input = sc.nextInt();
    try{
      Menu choice = menu.get(input);
      choice.getTask().run();
    }
    catch (Exception e){
      System.out.println("Please select a number present on the menu");
    }
    //recursion to reprint menu after action is performed
    main(null);
  }
}