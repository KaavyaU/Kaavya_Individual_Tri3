package FRQ2020;

public class Hailstone {

    public static int hailstoneLength(int n){
        int terms = 1;
        while (n > 1){
            if (n % 2 == 0){
                n = n / 2;
                terms ++;
            }
            else{
                n = (3 * n) + 1;
                terms++;
            }
        }
        return terms;
    }

    public static boolean isLongSeq (int n){
        if (hailstoneLength(n) > n){
            return true;
        }
        else{
            return false;
        }
    }

    public static double propLong (int n){
        int counter = 0;
        for (int x = 1; x<=n; x++){
            if (isLongSeq(x) == true){
                counter++;
            }
        }
        System.out.println("Percent of sequences from 1 to " + n + ": " + ((double)counter/n));
        return (double)counter / n;
    }

    public static void main (String[]args){
        Hailstone seq10 = new Hailstone();
        seq10.propLong(10);
        Hailstone seq15 = new Hailstone();
        seq15.propLong(15);
    }
}
