import java.util.Iterator;

/**
 * Queue: custom implementation
 * @author John Mortensen, Kaavya Uppala
 *
 * 1. Uses custom LinkedList of Generic type T
 * 2. Implements Iterable
 * 3. "has a" LinkedList for head and tail
 */
public class Queue<T> implements Iterable<T> {
  LinkedList<T> head, tail;
  
  /**
    *  Add a new object at the end of the Queue,
    *
    * @param  data,  is the data to be inserted in the Queue.
    */

  public void add(T data) {
    // add new object to end of Queue
    LinkedList<T> tail = new LinkedList<>(data, null);
    if (head == null)  // initial condition
      this.head = this.tail = tail;
    else {  // nodes in queue
      this.tail.setNextNode(tail); // current tail points to new tail
      this.tail = tail;  // update tail
    }
  }

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

  /**
    *  Returns the head object.
    *
    * @return  this.head, the head object in Queue.
    */
  public LinkedList<T> getHead() {
    return this.head;
  }

  /**
    *  Returns the tail object.
    *
    * @return  this.tail, the last object in Queue
    */
  public LinkedList<T> getTail() {
    return this.tail;
  }

  public T getData() {
    return head.getData();
  }

  /**
    *  Returns the iterator object.
    *
    * @return  this, instance of object
    */
  public Iterator<T> iterator() {
    return new QueueIterator<>(this);
  }
}

/**
 * Queue Iterator
 *
 * 1. "has a" current reference in Queue
 * 2. supports iterable required methods for next that returns a data object
 */
class QueueIterator<T> implements Iterator<T> {
  LinkedList<T> current;  // current element in iteration

  // QueueIterator is intended to the head of the list for iteration
  public QueueIterator(Queue<T> q) {
    current = q.getHead();
  }

  // hasNext informs if next element exists
  public boolean hasNext() {
    return current != null;
  }

  //created new getData() to return data as type T
  public T getData(){
    T data = current.getData();
    return data;
  }

  // next returns data object and advances to next position in queue
  public T next() {
    T data = current.getData();
    current = current.getNext();
    return data;
  }
}

/**
 * Queue Manager
 * 1. "has a" Queue
 * 2. support management of Queue tasks (aka: titling, adding a list, printing)
 */
class QueueManager<T> {
  // queue data
  private final String name; // name of queue
  private int count = 0; // number of objects in queue
  public final Queue<T> queue = new Queue<>(); // queue object

  /**
    *  Queue constructor
    *  Title with empty queue. No data passed in
    */
  public QueueManager(String name) {
    this.name = name;
  }

  /**
    *  Queue constructor
    *  Title with series of Arrays of Objects
    */
  public QueueManager(String name, T[]... seriesOfObjects) {
    this.name = name;
    this.addList(seriesOfObjects);
  }

  /**
    * Add a list of objects to queue
    */
  public void addList(T[]... seriesOfObjects) {
    for (T[] objects: seriesOfObjects)
      for (T data : objects) {
        this.queue.add(data);
        this.count++;
      }
    }

  // remove a list of objects to queue
  public void removeList(T[]... seriesOfObjects) {
    for (T[] objects: seriesOfObjects)
      for (T data : objects) {
        this.queue.delete();
        this.count--;
      }
    }

    /**
     * Print any array objects from queue
     */
    public void printQueue() {
      System.out.print(this.name + " count: " + count + ", data: ");
      for (T data : queue)
        System.out.print(data + " ");
      System.out.println();
    }
}

class MergeQueue {

  QueueManager mergeQueue = new QueueManager("Queue 3");
  
  public QueueManager mergeList(QueueManager qNums1, QueueManager qNums2 ){
    //creates QueueIterator objects to have access to hasNext() and next()
    QueueIterator iterator1 = (QueueIterator)qNums1.queue.iterator();
    QueueIterator iterator2 = (QueueIterator)qNums2.queue.iterator();
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
    return mergeQueue;
  }

  public void printQueue() {
      mergeQueue.printQueue();
    }
}

/**
 * Driver Class
 * Tests queue with string, integers, and mixes of Classes and types
 */
class QueueTester {
  public static void main(String[] args){
    // Create iterable Queue of Words
    Object[] words = new String[] { "seven", "slimy", "snakes", "sallying", "slowly", "slithered", "southward"};
    QueueManager qWords = new QueueManager("Words");
    //Iterates through the array and enques each value in array as new data to queue
    for (Object word : words){
      Object[] singleWord = new Object[] {word};
      qWords.addList(singleWord);
      System.out.println ("Enqueued data: " + word);
      qWords.printQueue();
    }
    //Same concept, but dequeing from head
    for (Object word : words){
      Object[] singleWord = new Object[] {word};
      qWords.removeList(singleWord);
      System.out.println ("Dequeued data: " + word);
      qWords.printQueue();
    }

    System.out.println();
    
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
  }
}