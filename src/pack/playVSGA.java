package pack;

import java.util.*;
/**
 * Write a description of class playVSGA here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class playVSGA
{
    Scanner reader = new Scanner(System.in);
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
    public boolean playAgain(){
        boolean unfound = true;
        while(unfound) {
            System.out.println("Play Again? y/n");
            String yOrN = reader.next();
            if(yOrN.equals("y")){
                unfound = false;
                reset();
                return true;
               
            }else if (yOrN.equals("n")) { 
                System.out.println("Thanks For Playing");
                unfound = false;
                return false;
            } 
        }
        return(false);
    }
    public int getNum(boolean turn) {
        
        if(turn) {
            System.out.println("Xs turn");
        } else {
            System.out.println("Os turn");
        }
        System.out.println("Enter a Squares Number: ");
        return(reader.nextInt());
    }
    public boolean didWin() {
        for(int i = 0; i < 3; i++) {
            if(spotes[(3 * i) + 0].equals(spotes[(3 * i) + 1]) && spotes[(3 * i) + 1].equals(spotes[(3 * i) + 2])){
                createBoard();
                if(spotes[(3 * i) + 1] == "X") {
                    System.out.println("X won");             
                } else {
                    System.out.println("O won");      
                }
                return(false);
            } else if(spotes[(3 * i) + 0].equals(spotes[(i) + 3]) && spotes[(i) + 3].equals(spotes[(i) + 6])) {
                createBoard();
                if(spotes[(i) + 3] == "X") {
                    System.out.println("X won");             
                } else {
                    System.out.println("O won");      
                }
                return(false);
            }else if(spotes[i + 0].equals(spotes[4]) && spotes[4].equals(spotes[8 - i])) {
               createBoard();
                if(spotes[4] == "X") {
                    System.out.println("X won");             
               } else {
                    System.out.println("O won");      
               }
               return(false);  
            }
        }
        if(turns == 9) {
            System.out.println("Cats Game");
            return(false);
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
    }
    public int getStatus(int place) {
        int at = place - 1;
        if(spotes[at] == "X" || spotes[at] == "O"){
            return 1;  
        } else {
            turns++;
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
    public void mainClass(String[][] ind1) {
        boolean on = true;
        boolean playAgain = false;
        reset();
        GAMAIN mainF = new GAMAIN();
        while(on) {
            createBoard();
            String board = boardStat();
            if(turn) {//Xs turn
                int spot = getNum(turn);
                int result = getStatus(spot);
                if(result == 0) {
                    spotes[(spot - 1)] = "X";
                    turn = false;
                    turns++;
                } 
            }else if(turn == false){//Ys turn
                int spot = mainF.Turn(ind1, board);
                int result = getStatus(spot);
                if(result == 0) {
                    turns++;
                    spotes[(spot - 1)] = "O";
                    turn = true;
                }            
            }
            on = didWin();
        }  
    }
}



