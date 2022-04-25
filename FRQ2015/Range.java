package FRQ2015;

public class Range implements NumberGroup{

    private int max;
    private int min;

    public Range (int low, int high){
        min = low;
        max = high;
    }

    /*
    Implementation for contains method that was defined in Interface
    Uses if and else statements to check if number is within range
     */
    public boolean contains (int number){
        if ( min <= number && number <= max){
            System.out.println(number + " is within range");
            return true;
        }
        else{
            System.out.println(number + " is not within range");
            return false;
        }
    }

    public static void main(String[]args){
        NumberGroup range = new Range(-3, 2);

        range.contains(-3);
        range.contains(-2);
        range.contains(-1);
        range.contains(0);
        range.contains(1);
        range.contains(2);

        range.contains(-4);
        range.contains(3);
    }
}
