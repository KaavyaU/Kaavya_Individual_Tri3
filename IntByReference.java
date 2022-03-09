public class IntByReference {
    private int value;
  
    // Hack: create IntByReference, swapToLowHighOrder and toString methods

    //IntByReference Constructor
    public IntByReference(int value){
      this.value = value;
    }

    //swapToLowHighOrder method - Switches values so they are in low to high order
    public void swapToLowHighOrder (IntByReference b) {
      if (this.value > b.value){
        int temp = b.value;
        b.value = this.value;
        this.value = temp;
      }
    }

    //Overriding existing toString method 
    public String toString(IntByReference b){
      return this.value + " " + b.value;
    }
  
    // static method that enables me to see numbers swapped by reference (before, after)
    public static void swapper(int n0, int n1) {
        IntByReference a = new IntByReference(n0);
        IntByReference b = new IntByReference(n1);
        System.out.println("Before: "+ a.toString(b));
        a.swapToLowHighOrder(b);  // conditionally build swap method to change values of a, b
        System.out.println("After: " + a.toString(b));
        System.out.println();
    }

    // static main method that provides some simple test cases
    public static void main(String[] ags) {
        IntByReference.swapper(21, 16);
        IntByReference.swapper(16, 21);
        IntByReference.swapper(16, -1);
    }
}