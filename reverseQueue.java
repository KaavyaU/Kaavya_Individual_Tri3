public class reverseQueue {

    QueueManager inputQueue;

    public Stack reverse(QueueManager inputQueue){
        //Defining a Stack that will be returned
        Stack outputStack = new Stack();
        this.inputQueue = inputQueue;
        //Keep looking until there are no more values in the Queue. Use head because Queues are first in, first out (FIFO)
        while (inputQueue.queue.getHead() != null){
            //Pushes the head value to the Stack as data
            outputStack.push(inputQueue.queue.getHead().getData());
            //Uses delete to move head to next value in head (ensures that the while loop isn't infinite)
            inputQueue.queue.delete();
        }
        //return Stack
        return outputStack;
    }


    public static void main (String[]args){
        //Defines a Queue and prints it
        Object[] nums = new Integer[] { 1, 4, 5, 8 };
        QueueManager inputNums = new QueueManager("Queue 1", nums);
        inputNums.printQueue();
        //Defines a Stack and sets it equal to the ouput of reverse(inputQueue). Prints the Stack using Stack toString() method.
        reverseQueue output = new reverseQueue();
        Stack outputStack;
        outputStack = output.reverse(inputNums);
        System.out.println("Reversed Queue: " + outputStack);
    }
}
