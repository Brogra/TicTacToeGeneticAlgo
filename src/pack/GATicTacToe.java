package pack;
import java.util.*;

/**
 * Write a description of class GATicTacToe here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GATicTacToe{
    boolean turn = true;
    int turns = 0;
    String x1 = "1", x2 = "2", x3 = "3", x4 = "4", x5 = "5", x6 = "6", x7 = "7", x8 = "8", x9 = "9";
    String[] spotes = {x1, x2, x3, x4, x5, x6, x7, x8, x9};
    boolean on = true;
    public void reset() {
        spotes[0] = x1;
        spotes[1] = x2;
        spotes[2] = x3;
        spotes[3] = x4;
        spotes[4] = x5;
        spotes[5] = x6;
        spotes[6] = x7;
        spotes[7] = x8;
        spotes[8] = x9;
        turns = 0;
        on = true;
    }
    public String whoWon() {
        for(int i = 0; i < 3; i++) {
            if(spotes[(3 * i) + 0].equals(spotes[(3 * i) + 1]) && spotes[(3 * i) + 1].equals(spotes[(3 * i) + 2])){
                //createBoard();
                if(spotes[(3 * i) + 1] == "X") {
                    //System.out.println("x won"); 
                    return("X");
                } else {
                    //System.out.println("Y won"); 
                    return "O";
                }
            } else if(spotes[(3 * i) + 0].equals(spotes[(i) + 3]) && spotes[(i) + 3].equals(spotes[(i) + 6])) {
                //createBoard();
                if(spotes[i + 3] == "X") {
                    //System.out.println("x won"); 
                    return("X");
                } else {
                    //System.out.println("Y won"); 
                    return "O";
                }
            }else if(spotes[i + 0].equals(spotes[4]) && spotes[4].equals(spotes[8 - i])) {
               //createBoard();
                if(spotes[4] == "X") {
                    //System.out.println("x won");  
                    return("X");
               } else {
                    //System.out.println("Y won");
                    return "O";
               }
            }
        }
        if(turns == 9) {
            return("C");
        }
        return "C";
    }
    public boolean didWin() {
        for(int i = 0; i < 3; i++) {
            if(spotes[(3 * i) + 0].equals(spotes[(3 * i) + 1]) && spotes[(3 * i) + 1].equals(spotes[(3 * i) + 2])){
                //createBoard();
                if(spotes[(3 * i) + 1] == "X") {
                    //System.out.println("x won");             
                } else {
                    //System.out.println("Y won");      
                }
                return(false);
            } else if(spotes[(3 * i) + 0].equals(spotes[(i) + 3]) && spotes[(i) + 3].equals(spotes[(i) + 6])) {
                //createBoard();
                if(spotes[(i) + 3] == "X") {
                    //System.out.println("x won");             
                } else {
                    //System.out.println("Y won");      
                }
                return(false);
            }else if(spotes[i + 0].equals(spotes[4]) && spotes[4].equals(spotes[8 - i])) {
               //createBoard();
                if(spotes[4] == "X") {
                    //System.out.println("x won");             
               } else {
                    //System.out.println("Y won");      
               }
               return(false);  
            }
            if(turns == 9) {
                    return false;
                }
        }
        return true;
    }
    public void createBoard() { 
        System.out.println();
        System.out.println(spotes[0] + " | " + spotes[1] + " | " + spotes[2]);
        System.out.println("----------");
        System.out.println(spotes[3] + " | " + spotes[4] + " | " + spotes[5]);
        System.out.println("----------");
        System.out.println(spotes[6] + " | " + spotes[7] + " | " + spotes[8]);
        System.out.println();
    }
    public int getStatus(int place) {
        int at = place - 1;
        if(spotes[at] == "X" || spotes[at] == "O"){
            return 1;  
        } else {
      
            return 0;
        }
    }
    public String boardStat(){
       String b = "";
       for(int i = 0; i < spotes.length; i++) {
           b += spotes[i];
       }
       return b;
    }
    public String mainClass(String[][] ind1, String[][] ind2) {
        
        boolean on = true;
        boolean winner = false;
        GAMAIN mainF = new GAMAIN();
        while(!winner){
            reset();
            turns  = 0;
            while(on) {
                String board = boardStat();
                //System.out.println(board);
                //createBoard();
                if(turn) {//Xs turn
                    int spot = mainF.Turn(ind1, board);
                    int result = getStatus(spot);
                    if(result == 0) {
                        turns++;
                        spotes[(spot - 1)] = "X";
                        turn = false;
                    }
                }else if(turn == false){//Ys turn
                    int spot = mainF.Turn(ind2, board);
                    int result = getStatus(spot);
                    if(result == 0) {
                        turns++;
                        spotes[(spot - 1)] = "O";
                        turn = true;
                    }            
                }
                
                on = didWin();
                //winner = !on;
                if(on == false) {
                 
                    //createBoard();
                    return(whoWon());
                }
            } 
        }
        //createBoard();
        return("C");
    }
}
