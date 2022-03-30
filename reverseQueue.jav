public class reverseQueue{

  T current;
  Queue<T> inputQueue;

  public Stack reverse(Queue<T> inputQueue){
    Stack outputStack = new Stack();
    this.inputQueue = inputQueue;
    while (inputQueue.getHead() != null){
      current = inputQueue.delete();
      outputStack.push(current);
    }
    return outputStack;
  }

  public String toString(){
    return("Queue: " + this.inputQueue + "\n" + "Reversed Queue: " + this.reverse(this.inputQueue));
  }

  public static void main (String[]args){
    
  }

}