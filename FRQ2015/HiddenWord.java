package FRQ2015;

public class HiddenWord {

    private String word;

    public HiddenWord(String word){
        //basic constructor
        this.word = word;
    }

    public String getHint(String guess){
        /*
        For loops to iterate through a String
        if, else if, and else to compare characters in a String
        String methods, such as charAt()
         */
        String hint = "";
        for (int i = 0; i < word.length(); i++){
            if (word.charAt(i) == guess.charAt(i)){
                hint += guess.charAt(i);
            }
            //checks to see if the value at index i of guess is present in word
            else if (word.indexOf(guess.charAt(i)) != -1){
                hint += "+";
            }
            else{
                hint += "*";
            }
        }
        System.out.println(hint);
        return hint;
    }

    public static void main(String[] args) {

        HiddenWord puzzle = new HiddenWord("HARPS");

        puzzle.getHint("AAAAA");
        puzzle.getHint("HELLO");
        puzzle.getHint("HEART");
        puzzle.getHint("HARMS");
        puzzle.getHint("HARPS");

    }
}
