package FRQ2020;

public class Theater {

    private Seat[][] theaterSeats;

    public Theater(int seatsPerRow, int tier1Rows, int tier2Rows){
        theaterSeats = new Seat[tier1Rows + tier2Rows][seatsPerRow];
        for (int row = 0; row < theaterSeats.length; row++){
            for (int column = 0; column < theaterSeats[0].length; column++){
                if (row <= tier1Rows -1){
                    theaterSeats[row][column] = new Seat(true,1);
                }
                else{
                    theaterSeats[row][column] = new Seat(true, 2);
                }
            }
        }
    }

    public boolean reassignSeat(int fromRow, int fromCol, int toRow, int toCol){
        if (theaterSeats[fromRow][fromCol].getTier() <= theaterSeats[toRow][toCol].getTier()){
            if (theaterSeats[toRow][toCol].isAvailable() == true){
                theaterSeats[fromRow][fromCol].setAvailability(true);
                theaterSeats[toRow][toCol].setAvailability(false);
                System.out.println("row " + fromRow + ", column " + fromCol + " --> row " + toRow + ", column "+ toCol + " is an acceptable change");
                return true;
            }
        }
        System.out.println("row " + fromRow + ", column " + fromCol + " --> row " + toRow + ", column "+ toCol + " is not an acceptable change");
        return false;
    }

    public static void main (String [] args){
        Theater myTheater = new Theater(4, 2, 3);
        //should be acceptable
        myTheater.reassignSeat(1, 2, 1, 3);
        //shouldn't be acceptable
        myTheater.reassignSeat(1, 1, 1, 3);
    }

}
