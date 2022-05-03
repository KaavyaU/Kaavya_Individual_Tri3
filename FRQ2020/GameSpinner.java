package FRQ2020;

public class GameSpinner {

    private int sectors;
    private int result;

    public GameSpinner(int sectors){
        this.sectors = sectors;
        this.result = 0;
    }

    public int spin(){
        result = 1 + (int)(Math.random() * sectors);
        System.out.println("Spun: " + result);
        return result;
    }

    public int currentRun(){
        int length = 0;
        if (result == 0){
            length = 0;
        }
        else if (result == spin()){
            length++;
        }
        System.out.println("Current Run Length: " + length);
        return length;
    }

    public static void main (String[]args){
        GameSpinner g = new GameSpinner(4);
        g.currentRun();
        g.spin();
        g.currentRun();
        g.spin();
        g.currentRun();
        g.spin();
        g.spin();
        g.spin();
        g.currentRun();
    }
}
